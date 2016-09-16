function load(){
	const object = JSON.parse(localStorage.getItem("selectedObject"));
	console.log(object)
	$("#objectName").append(object.name);
	 document.getElementById('objectPicture').src = object.icon;
	$("#objectAddress").append(object.address + ", " + object.town)
	object.email!=='' ? $("#objectEmail").append(object.email) : $("#objectEmail").append("No email")
	object.phone!=='' ? $("#objectPhone").append(object.phone) : $("#objectPhone").append("No phone number")
	object.website!=='' ? $("#objectWebsite").append(object.website) : $("#objectWebsite").append("No website")
	$("#objectCategory").append(object.category);
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/Reviewer/ReviewServlet",
		data: { objectID : object.tin},
		success: function(response){
			$("#review-list").empty();
			//										<img src="star.png"/>
//                        <img src="star.png"/>
//                        <img src="star.png"/>
//                        <img src="star1.png"/>
										+ '</div>'
			response.data.forEach((review) => {
				
				console.log(review.date);
				$("#review-list").append('<div class="review"><div class="user-data"><div class="user-pic">'
										+ '<img src="css/images/party.jpg"/></div>'
										+ '<div class="userActivity">  <p>2 days ago</p> </div>'
										+ '<h4>Rater 1</h4><div class="star">'
										+ '<img src="star.png"/>'

										+ '<p>'+ review.reviewText + '</p></div></div>');
			});
		}
	})
}

window.onload = load()