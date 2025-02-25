/**
 * 
 */

fetch('testData.do')
	.then(function(result) {

		console.log(result);

		return result.json();
	}).then(function(result) {
		console.log(result);
		
		for (let member of result) {
			
		}
	});