/**
 * 
 */

draw();

function addMember() {

	const memberId = document.querySelector("#member_id").value;
	const passwd = document.querySelector("#passwd").value;
	const memberName = document.querySelector("#member_name").value;

	fetch('addMember.do?member_id=' + memberId + "&passwd=" + passwd + "&member_name=" + memberName)
		.then(function(result) {

			console.log(result);

			return result.json();
		}).then(function(result) {
			console.log(result);

			if (result.retCode == "OK") {
				draw();
			} else if (result.retCode == "NG") {
				alert('삭제 오류');
			} else {
				alert('?????????');
			}

		})



}

function draw() {



	fetch('testData.do')
		.then(function(result) {

			return result.json();
		}).then(function(result) {

			const memberAry = result;

			const target = document.querySelector('#list');

			target.innerHTML = '';

			memberAry.forEach(function(result) {
				const html = `<tr id="tr_${result.memberId}">
				<td>${result.memberId}</td>
				<td>${result.passwd}</td>
				<td>${result.memberName}</td>
				<td>${result.responsibility}</td>
				<td><button type="button" onclick="deleteRow('${result.memberId}', this)" class="btn btn-danger">삭제</button></td>
				</tr>`

				target.insertAdjacentHTML('beforeend', html);

			});
		});
}



function deleteRow(memberId, btn) {

	fetch('removeMember.do?member_id=' + memberId)
		.then(function(result) {

			return result.json();
		}).then((result) => {

			if (result.retCode == "OK") {
				btn.parentElement.parentElement.remove();
			} else if (result.retCode == "NG") {
				alert('삭제 오류');
			} else {
				alert('?????????');
			}
		});

}