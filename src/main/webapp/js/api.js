/**
 * 
 */

let centerAll = [];

const url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=TRR5y395xh7C4tz1zgx4YQR8bFDbOMlGtv9HrKTeyd0oUhVdOsc13iCgGXITk9G5iwv%2B%2FB8w4DNoL9E5%2FHe8Fw%3D%3D';

fetch(url)
	.then((result) => result.json())
	.then((result) => {

		centerAll = result.data;

		console.log(centerAll);

		makeSidoList();

		makeCenterList(centerAll);

	})
	.catch((error) => console.log(error))

function makeSidoList() {

	let sidoList = centerAll.reduce((acc, item) => {
		//indexOf()?
		if (!acc.includes(item.sido)) {
			acc.push(item.sido);
		}
		return acc;
	}, []);

	sidoList.reduce((acc, item) => {
		let option = document.createElement('option');
		option.innerHTML = item;
		acc.appendChild(option);
		return acc;
	}, document.getElementById('centerList'));
}

document.getElementById('centerList').addEventListener('change', (event) => {
	console.log(event.target.value);

	let sido = event.target.value;

	if (sido == '선택하세요') {
		makeCenterList(centerAll);
	} else {
		let filterSido = centerAll.filter((item) => {
			if (item.sido == sido) {
				return true;
			} else {
				return false;
			}
		})

		makeCenterList(filterSido);

		console.log(filterSido);
	}
})

function makeCenterList(centerList = []) {
	document.getElementById('list').innerHTML = '';
	
	let field = ['id', 'centerName', 'phoneNumber', 'sido'];

	centerList.forEach((item) => {
		let tr = document.createElement('tr');
		
		for (let i = 0; i < field.length; i++) {
			let td = document.createElement('td');
			td.innerHTML = item[field[i]];
			tr.appendChild(td);
		}

		tr.addEventListener('click', (event) => {
			console.log(item.lat, item.lng);
			
			window.open('map.do?lat=' 
				+ item.lat + '&lng=' 
				+ item.lng + '&centerName=' 
				+ item.centerName.substring(6).replace('예방접종', ''));
		});
		
		document.getElementById('list').appendChild(tr);
	})
}