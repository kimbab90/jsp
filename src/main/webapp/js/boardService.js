/**
 * 
 */

const service = {
	replyList: function(param = {boardNo, pageNo}, successCallback, errorCallback) {
		fetch('replyList.do?board_no=' + param.boardNo + "&page_no=" + param.pageNo)
			.then((result) => result.json())
			.then(successCallback)
			.catch(errorCallback)

	},
	addReply(param = {boardNo, reply, replyer}, successCallback, errorCallback) {
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
	},
	makePaging(boardNo, successCallback, errorCallback) {
		fetch('getReplyCnt.do?board_no=' + boardNo)
		.then((result) => result.json())
		.then(successCallback)
		.catch(errorCallback);
	}
}