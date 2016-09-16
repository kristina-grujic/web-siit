function searchClick(){
    var search = document.forms["searchObjects"]["search"].value;
	searchObjects(search)
}

function logout(){
	localStorage.clear();
	return true;
}

function searchObjects(query){
	const ajaxCall = {
			type: "GET",
			url: "http://localhost:8080/Reviewer/ObjectServlet",
			data : { query: query },
			success : function (data) {
				renderData(data);}
			};
	const result =$.ajax(ajaxCall);
	return false;
}
				
//				<div class="star"><img src="css/images/star.png"/>
//                    <img src="css/images/star.png"/>
//                    <img src="css/images/star1.png"/>
//                    <img src="css/images/star1.png"/>
//                    <img src="css/images/star1.png"/>
//                  </div>

function renderData(response){
	$("#results").empty()
	response.data.forEach((object) => {
		$("#results").append('<div class="result"><h3>'
						+ object.name + '</h3><p>'
						+ object.address + ', ' + object.town
						+ '</p><a href="view_object.html"><img src="css/images/party.jpg" width=300px height=200px/></a></div>')
	});
}

window.onload = searchObjects('')
