/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {

	fetch('fullData.do').then((result) => result.json())
		.then((result) => {
			console.log(result);

			drawCalendar(result);
		}).catch((error) => console.log(error));
});

function drawCalendar(eventAll = []) {
	var calendarEl = document.getElementById('calendar');

	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		initialDate: new Date(),
		navLinks: true, // can click day/week names to navigate views
		selectable: true,
		selectMirror: true,
		select: function(arg) {
			var title = prompt('Event Title:');
			if (title) {

				console.log(arg);

				fetch('addFullData.do?title=' + title +
					'&startDate=' + arg.startStr +
					'&endDate=' + arg.endStr)
					.then((result) => result.json())
					.then((result) => {
						if (result.retCode == "OK") {
							calendar.addEvent({
								title: title,
								start: arg.start,
								end: arg.end,
								allDay: arg.allDay
							})
						} else {
							alert('등록 오류');
						}

					}).catch((error) => console.log(error));

			}
			calendar.unselect();
		},
		eventClick: function(arg) {
			if (confirm('Are you sure you want to delete this event?')) {
				console.log(arg);

				fetch('removeFullData.do', {
					method: "POST",
					headers: {
						"Content-Type": "application/x-www-form-urlencoded",
					},
					body: new URLSearchParams({
						title: arg.event.title
						, startDate: arg.event.startStr
						, endDate: arg.event.endStr
					})
				}).then((result) => result.json())
					.then((result) => {
						if (result.retCode == "OK") {
							arg.event.remove();
						} else {
							alert('삭제 오류');
						}
					}).catch((error) => {
						console.log(error);
					});

/*
				fetch('removeFullData.do?title=' + arg.event.title +
					"&startDate=" + arg.event.startStr +
					"&endDate=" + arg.event.endStr
				).then((result) => result.json())
					.then((result) => {
						if (result.retCode == "OK") {
							arg.event.remove();
						} else {
							alert('삭제 오류');
						}
					}).catch((error) => {
						console.log(error);
					});
*/
			}
		},
		editable: true,
		dayMaxEvents: true, // allow "more" link when too many events
		events: eventAll
	});

	calendar.render();
}