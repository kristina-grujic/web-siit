function load(){
	const object = JSON.parse(localStorage.getItem("selectedObject"));
	const user = JSON.parse(localStorage.getItem('loggedIn'));
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
				$("#review-list").append('<div class="review"><div class="user-data"><div class="user-pic">'
										+ '<img src=' + review.user.icon + '/></div>'
										+ '<div class="userActivity">'+ del+ '</div>'
										+ '<h4>' + review.user.username + '</h4><div class="star">'
										+ '<img src="star.png"/></div>'

										+ '<p>'+ review.reviewText + '</p></div></div>');
			});
			}
			if (user.username!==object.manager && !alreadyRated){
				document.getElementById('postReview').style.display = 'block';
			}

//		    <div class="review-post">
//		      <div id="review-input" >
//		      <h4 id="rate">Rate:</h4>
//		      <div id="rating">
//
//		          <input class="si" id="s1" type="radio" name="rating" checked="checked" onclick="Rate()" value=""/><label class="sl" for="s1"></label>
//		          <input class="si" id="s2" type="radio" name="rating" value=""/><label class="sl" for="s2"></label>
//		          <input class="si" id="s3" type="radio" name="rating" value=""/><label class="sl" for="s3"></label>
//		          <input class="si" id="s4" type="radio" name="rating" value=""/><label class="sl" for="s4"></label>
//		          <input class="si" id="s5" type="radio" name="rating" value=""/><label class="sl" for="s5"></label>
//		      </div></div>
//		        <textarea type="text" name="rewiew" placeholder="Text of review..." /></textarea>
//		        <button>Post</button>
//		    </div>
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
    			$("#review-list").append('<div class="review"><div class="user-data"><div class="user-pic">'
						+ '<img src="' + user.icon + '"/></div>'
						+ '<div class="userActivity">  <button id="'+user.username+'"  href="home.html">delete</button></div>'
						+ '<h4>' + user.username + '</h4><div class="star">'
						+ '<img src="star.png"/></div>'
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
