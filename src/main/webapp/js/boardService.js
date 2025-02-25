/**
 * 
 */

const service = {
	replyList: function(boardNo, successCallback, errorCallback) {
		fetch('replyList.do?board_no=' + boardNo)
			.then((result) => result.json())
			.then(successCallback)
			.catch(errorCallback)

	},
	addReply(param = {}, successCallback, errorCallback) {
		fetch('addReply.do?board_no=' + param.boardNo + "&reply=" + param.reply + "&replyer=" + param.replyer)
			.then((result) => result.json())
			.then(successCallback)
			.catch(errorCallback);

	},
	removeReply(replyNo, successCallback, errorCallback) {
		fetch('removeReply.do?reply_no=' + replyNo)
		.then((result) => result.json())
		.then(successCallback)
		.catch(errorCallback);
	}
}