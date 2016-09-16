function searchClick(){
    var search = document.forms["searchObjects"]["search"].value;
	searchObjects(search)
}

function logout(){
	localStorage.clear();
	return true;
}


function renderObject(object){
	console.log(object);
	if (object!==undefined){
		localStorage.setItem("selectedObject", JSON.stringify(object));
		window.location = "http://localhost:8080/Reviewer/view_object.html";
	}
	return false;
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
	if (response.data.length===0){
		$("#results").append('<div class="result"><h3>No objects match this query.</h3></div>');
		return;
	}
	response.data.forEach((object) => {
		$("#results").append('<div id="'+object.tin+ '" class="result"><h3>'
						+ object.name + '</h3><p>'
						+ object.address + ', ' + object.town
						+ '</p><div><img src="'+ object.icon +'" width=300px height=200px/></div></div>')
		$("#"+object.tin).live('click', () => {renderObject(object)});
	});
}

window.onload = searchObjects('')
