/**
 * 
 */

const table = new DataTable('#example', {
	ajax: 'dataTable.do?board_no=' + boardNo,
	order: [[0, 'desc']],
	lengthMenu: [
		[5, 10, 25, 50, -1],
		[5, 10, 25, 50, 'All']
	]
});

let selectedReplyNo = 0;

table.on('click', 'tbody tr', (e) => {
	let classList = e.currentTarget.classList;

	if (classList.contains('selected')) {
		classList.remove('selected');
		selectedReplyNo = 0;
	}
	else {
		table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
		classList.add('selected');
		console.log(e.currentTarget.children[0].innerText);
		selectedReplyNo = e.currentTarget.children[0].innerText;
	}
});

document.querySelector('#deleteRow').addEventListener('click', function() {

	if (selectedReplyNo != 0) {
		service.removeReply(selectedReplyNo, (result) => {
			if (result.retCode == "OK") {
				table.row('.selected').remove().draw(false);
			} else {
				alert('오류');
			}
		}, (error) => {
			console.log(error);
		});
	}
});

//document.querySelector('#add_button').addEventListener('click', function() {

//let reply = document.querySelector('#reply_input').value;
//let replyer = loginId;

//service.addReply({ boardNo, reply, replyer }, (result) => {
//	if (result.retCode == "OK") {
//		table.ajax.reload();
//	} else {
//		alert('오류');
//	}
//}, (error) => {
//	console.log(error);
//});
//});

function addNewRow() {

	let reply = document.querySelector('#reply_input').value;
	let replyer = loginId;

	service.addReply({ boardNo, reply, replyer}, (result) => {
		if (result.retCode == "OK") {
			let rvo = result.retVal;
			table.row.add([rvo.replyNo, rvo.reply, rvo.replyer, rvo.replyDate]).draw(false);
		} else {
			alert('오류');
		}
	}, (error) => {
		console.log(error);
	});
}

document.querySelector('#addRow').addEventListener('click', addNewRow);