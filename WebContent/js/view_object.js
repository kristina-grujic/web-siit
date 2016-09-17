function load(){
	const object = JSON.parse(localStorage.getItem("selectedObject"));
	const user = JSON.parse(localStorage.getItem('loggedIn'));
	if (user.username===object.manager){
		$("#userLinks").append('<a href="editObject.html" id="editObject">Edit object</a>')
	}
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
			
			var alreadyRated = false;
			if (response.data.length===0){
				$("#review-list").append('<div class="review"><p>No objects match this query.<p></div>');
			}
			else{
			const users = [];
			response.data.forEach((review) => {
				var del ='';
				if (user.username === review.user.username ) {
					alreadyRated=true;
					del = '<button id="'+user.username+'">delete</button>';

	    			$("#"+user.username).live('click', () => {deleteReview(user, object)});
				}
				var rating = '<div class="star">';
				for (var i = 0; i< 5; i++){
					if (i<parseInt(review.rate)){
						rating += '<img src="css/images/star.png"/>'
					}
					else{
						rating += '<img src="css/images/star1.png"/>'
					}
				}
				rating += '</div>'
				
				$("#review-list").append('<div class="review"><div class="user-data"><div class="user-pic">'
										+ '<img src="' + review.user.icon + '"/></div>'
										+ '<div class="userActivity">'+ del+ '</div>'
										+ '<h4>' + review.user.username + '</h4>'
										+rating
										+ '<p>'+ review.reviewText + '</p></div></div>');
			});
			}
			if (user.username!==object.manager && !alreadyRated){
				document.getElementById('postReview').style.display = 'block';
			}
		},
		error: function(error){
			console.log(error);
		}
	})
}

function deleteReview(user, object){
	const result = confirm("Are you sure you want to delete this object?");
	if(result){
		const ajaxCall = {
				type: "DELETE",
				url: "http://localhost:8080/Reviewer/ReviewServlet?object="+object.tin+"&user="+user.username,
				success : function (response) {
					if (response.errors){
						alert("Unable to delete");
						return false;
					}
					window.location = "http://localhost:8080/Reviewer/view_object.html";
					return false;
				}
				};
		const result =$.ajax(ajaxCall);
		return false;
	}
	return false;
	return false
}

function review(){
	const object = JSON.parse(localStorage.getItem("selectedObject"));
	const user = JSON.parse(localStorage.getItem('loggedIn'));
    var rate = document.forms["review-form"]["rating"].value;
    var reviewText = document.forms["review-form"]["rewiew"].value;
    const date = moment().format()
    if (reviewText!==''){
    	$.ajax({
    		type: "POST",
    		url: "http://localhost:8080/Reviewer/ReviewServlet",
    		data: { object : object.tin, user: user.username, reviewText, rate, date},
    		success: function(response){
    			if (response.errors){
					alert("Unable to create");
					return false;
				}
    			var rating = '<div class="star">';
				for (var i = 0; i< 5; i++){
					if (i<parseInt(rate)){
						rating += '<img src="css/images/star.png"/>'
					}
					else{
						rating += '<img src="css/images/star1.png"/>'
					}
				}
				rating += '</div>'
    			$("#review-list").append('<div class="review"><div class="user-data"><div class="user-pic">'
						+ '<img src="' + user.icon + '"/></div>'
						+ '<div class="userActivity">  <button id="'+user.username+'"  href="home.html">delete</button></div>'
						+ '<h4>' + user.username + '</h4>'
						+ rating
						+ '<p>'+ reviewText + '</p></div></div>');
    			$("#"+user.username).live('click', () => {deleteReview(user, object)});
				return false;
    		},
    		error: function(error){
    			console.log(error);
    		}
    	});
    }
    return false;
}

window.onload = load()

$('#review-button').live('click', () => {review()});
