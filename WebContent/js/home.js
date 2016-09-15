function searchClick(){
    var search = document.forms["searchObjects"]["search"].value;
	searchObjects(search)
}

function logout(){
	localStorage.clear();
	return true;
}

function searchObjects(query){
	console.log(query);
	const ajaxCall = {
			method: "GET",
			url: "http://localhost:8080/Reviewer/ObjectServlet",
			data : { query: query },
			success : function (data) {
				console.log(data);
				renderData(data);}
			};
	const result =$.ajax(ajaxCall);
	console.log(result)
	return false;
}
				
//				<div class="star"><img src="css/images/star.png"/>
//                    <img src="css/images/star.png"/>
//                    <img src="css/images/star1.png"/>
//                    <img src="css/images/star1.png"/>
//                    <img src="css/images/star1.png"/>
//                  </div>

function renderData(data){
	const response = JSON.parse(data);
	$("#results").empty()
	response.data.forEach((object) => {
		var string = '<div class="result"><h3>';
		string += object.name;
	$("#results").append('<div class="result"><h3>'
						+ object.name + '</h3><p>'
						+ object.address + ', ' + object.city
						+ '</p><a href="New.html"><img src="css/images/party.jpg" width=300px height=200px/></a></div>')
	});
}

window.onload = searchObjects('')
