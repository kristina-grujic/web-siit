function load(){
	const object = JSON.parse(localStorage.getItem("selectedObject"));
	const user = JSON.parse(localStorage.getItem('loggedIn'));	
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/Reviewer/EventServlet",
		data: { objectID : object.tin},
		success: function(response){ 
			if (user.username===object.manager){
				$("#listEvents").append('<a href="createEvent.html">Create Event</a>');
			}
			$("#events").append('<h1>' + object.name + "'s events</h1>");
			
			console.log(response.data);
			if (response.data.length===0){
				$("#listEvents").append('<div class="event">No events.</div>');
			}
			response.data.forEach((event) => {
				$("#listEvents").append('<div class="event"><p>Date : ' + event.checkinDate +'</p>'
					+ '<p>Description : ' + event.description +  '</p>'
					+ '<img src="'+event.icon+'" /></div>');
			});
		},
		error: function(error, status){
			//console.log(JSON.parse(error.responseText));
			console.log(error);
		}
	})
}

$('document').ready(function(){
	load()
});