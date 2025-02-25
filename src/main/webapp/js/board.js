/**
 * 
 */

document.querySelector('button.btn-danger').addEventListener('click', function(e) {

	if ('${board.writer }' == '${loginId}') {
		location.href = 'removeBoard.do?board_no=${board.boardNo}';
	} else {
		alert('권한을 확인하세요');
	}

	//writer = document.querySelector('table.table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)').innerText;
	//console.log(writer);

});

//function removeBoard(boardNo = int) {
//	console.log(bno);
//	location.href = "removeBoard.do?board_no=" + boardNo;
//}


service.replyList(boardNo, (result) => {
	const target = document.querySelector('div.content>ul');
	result.forEach((item) => {
		html = drawReply(item);
		target.insertAdjacentHTML('afterbegin', html);
	})
}, (error) => console.log(error))

function drawReply(reply) {
	html = `<li>
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
				const target = document.querySelector('div.content>ul');
				const html = drawReply(result.retVal);
				target.insertAdjacentHTML('afterbegin', html);
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
	
	if (loginId != replyer) {
		alert('너 누구?');
		return;
	}
	
	if (!confirm('Do you wanna DELETE reply?')) {
		return;
	}
	
	service.removeReply(replyNo,
		(result) => {
			if (result.retCode == "OK") {
				btn.parentElement.parentElement.remove();
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