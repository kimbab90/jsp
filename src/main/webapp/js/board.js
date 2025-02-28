/**
 * 
 */

let pageNo = 1;

showReply();

showPage();

function showPage() {

	service.makePaging(boardNo,
		(result) => {
			const totalCnt = result.totalCnt;
			let endPage = Math.ceil(pageNo / 10) * 10;
			let startPage = endPage - 9;
			let maxPage = Math.ceil(totalCnt / 5);
			endPage = endPage > maxPage ? maxPage : endPage;
			let prev = startPage == 1 ? false : true;
			let next = endPage == maxPage ? false : true;

			const target = document.querySelector('div.footer>nav>ul');

			target.innerHTML = '';
			let html = '';

			if (prev) {
				html = `<li class="page-item"><a class="page-link" data-page="${startPage - 1}">Prev</a></li>`;
			} else {
				html = `<li class="page-item disabled"><a class="page-link">Prev</a></li>`;
			}
			target.insertAdjacentHTML('beforeend', html);

			for (let p = startPage; p <= endPage; p++) {
				if (p == pageNo) {
					html = `<li class="page-item active" aria-current="page"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
				} else {
					html = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
				}
				target.insertAdjacentHTML('beforeend', html);
			}

			if (next) {
				html = `<li class="page-item"><a class="page-link" data-page="${endPage + 1}">Next</a></li>`;
			} else {
				html = `<li class="page-item disabled"><a class="page-link">Next</a></li>`;
			}

			target.insertAdjacentHTML('beforeend', html);

			addPageEvent();
		}, (error) => {
			console.log(error);
		});
}

function drawReply(reply) {
	html = `<li class="list-group-item" data-id="${reply.replyNo}">
			<span class="col-sm-2">${reply.replyNo}</span>
			<span class="col-sm-5">${reply.reply}</span>
			<span class="col-sm-2">${reply.replyer}</span>
			<span class="col-sm-2"><button type="button" class="btn btn-danger" onclick="removeReply(${reply.replyNo}, '${reply.replyer}', this)">삭제</button></span>
			</li>`;
	return html;
}

function addReply() {

	const boardNo = document.querySelector('input[name="board_no"]').value;
	const reply = document.querySelector('input[name="reply"]').value;
	const replyer = loginId;
	const param = { boardNo, reply, replyer };

	if (!reply) {
		alert('댓글 내용 없음');
		return;
	} else if (!replyer) {
		alert('로그인 정보 없음');
		return;
	}

	service.addReply(param,
		(result) => {
			if (result.retCode == "OK") {

				pageNo = 1;

				showReply();
				
				showPage();

				document.querySelector('input[name="reply"]').value = '';
			} else if (result.retCode == "NG") {
				alert('등록 오류');
			}
		},
		(error) => {
			console.log(error);
		}
	);
}

function removeReply(replyNo, replyer, btn) {

	//if (loginId != replyer) {
	//	alert('너 누구?');
	//	return;
	//}

	//if (!confirm('Do you wanna DELETE reply?')) {
	//	return;
	//}

	service.removeReply(replyNo,
		(result) => {
			if (result.retCode == "OK") {
				console.log(replyCount);
				if (replyCount == 1 && pageNo > 1) {
					pageNo = pageNo - 1;
				}

				showPage();

				showReply();

			} else if (result.retCode == "NG") {
				alert('삭제 오류');
			} else {
				alert('?????????');
			}
		},
		(error) => {
			console.log(error);
		}
	);
}

let replyCount = 0;

function showReply() {
	service.replyList({ boardNo, pageNo }, (result) => {

		replyCount = result.length;

		document.querySelectorAll('li[data-id]').forEach((item) => {
			item.remove();
		})

		const target = document.querySelector('div.content>ul');
		result.forEach((item) => {
			html = drawReply(item);
			target.insertAdjacentHTML('beforeend', html);
		})
	}, (error) => console.log(error))
}

function addPageEvent() {
	document.querySelectorAll('div.footer>nav a').forEach((item) => {
		item.addEventListener('click', (event) => {
			event.preventDefault();

			let pageInfo = event.target.getAttribute('data-page');

			pageNo = pageInfo;

			showReply();

			showPage();
		});
	})
}

document.querySelector('button.btn-danger').addEventListener('click', function(e) {

	if ('${board.writer }' == '${loginId}') {
		location.href = 'removeBoard.do?board_no=${board.boardNo}';
	} else {
		alert('권한을 확인하세요');
	}

	//writer = document.querySelector('table.table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)').innerText;
	//console.log(writer);

});