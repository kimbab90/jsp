<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
		let aryData = [];

		fetch('chartData.do')
			.then((result) => result.json())
			.then((result) => {
				
				console.log(result);
				aryData.push(['부서명', '인원']);
				result.forEach((item) => {
					aryData.push([item.DEPARTMENT_NAME, item.CNT]);
				});
				console.log(aryData);
				google.charts.load('current', {
					'packages': ['corechart']
				});
				google.charts.setOnLoadCallback(drawChart);
				google.charts.setOnLoadCallback(drawChart2);
				google.charts.setOnLoadCallback(drawChart3);
			})
			.catch((error) => {});

		function drawChart() {


			var data = google.visualization.arrayToDataTable(aryData);

			var options = {
				title: 'Percentage of Employees in Department'
			};

			var chart = new google.visualization.PieChart(document.getElementById('piechart'));

			chart.draw(data, options);
		}
		
		function drawChart2() {


			var data = google.visualization.arrayToDataTable(aryData);

			var options = {
				title: 'Percentage of Employees in Department',
				is3D: true
			};

			var chart = new google.visualization.PieChart(document.getElementById('piechart2'));

			chart.draw(data, options);
		}
		function drawChart3() {


			var data = google.visualization.arrayToDataTable(aryData);

			var options = {
				title: 'Percentage of Employees in Department',
				pieHole: 0.4
			};

			var chart = new google.visualization.PieChart(document.getElementById('piechart3'));

			chart.draw(data, options);
		}
	</script>
</head>

<body>
	<div id="piechart" style="width: 900px; height: 500px;"></div>
	<div id="piechart2" style="width: 900px; height: 500px;"></div>
	<div id="piechart3" style="width: 900px; height: 500px;"></div>
</body>

</html>