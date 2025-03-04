/**
 * 
 */

let ary = [{ id: "01", name: "Sam", score: 100 }
	, { id: "02", name: "Tom", score: 120 }
	, { id: "03", name: "David", score: 200 }
]

ary.forEach((item, idx, ary) => {
	console.log(item, idx, ary);

});

let filAry = ary.filter((item) => {
	if (item.score > 100) {
		return true;
	} else {
		return false;
	}
});

console.log(filAry)

let mapAry = ary.map((item) => {

	if (item.score > 150) {
		item.group = 'A';
	} else if (item.score > 100) {
		item.group = 'B';
	} else {
		item.group = 'C';
	}
	return item;
});

console.log(mapAry);

let result = ary.reduce((acc, item, idx, ary) => {
	console.log(acc);

	return acc + item.score;
}, 0);

console.log(result);

result = ary.reduce((acc, item) => {
	
	return acc > item.score ? acc : item.score; 
}, 0);

console.log(result);

result = ary.reduce((acc, item) => {
	
	return acc < item.score ? acc : item.score; 
}, 300);

console.log(result);

result = ary.reduce((acc, item) => {
	if (item.score > 100) {
		acc.push(item);	
	}
	
	return acc;
}, []);

console.log(result);

result = ary.reduce((acc, item) => {
	let li = document.createElement('li');
	li.innerHTML = 'id: ' + item.id + ', name: ' + item.name;
	acc.appendChild(li);
	
	return acc;
}, document.getElementById('list'));

