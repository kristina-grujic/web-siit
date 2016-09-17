function validateEvent(datetime, description){
	var result = '';
	if(datetime==='' || !moment(datetime, "DD-MM-YYYY").isValid() || moment(datetime, "DD-MM-YYYY")<moment()){
		alert("Invalid date!");
		return false;
	}
	else if(description===''){
		alert("No description set!");
		return false
	}
	return true
}

function createObject(){
	const object = JSON.parse(localStorage.getItem("selectedObject"));
    var date = document.forms["createEvent"]["date"].value;
    var description = document.forms["createEvent"]["description"].value;
    const validated = validateEvent(date, description);
    if (validated){
		const ajaxCall = {
				type: "POST",
				url: "http://localhost:8080/Reviewer/EventServlet",
				data : { object: object.tin, date, description },
				success : function (response) {
					if (response.errors){
						alert("Unable to create");
						return false;
					}
					window.location = "http://localhost:8080/Reviewer/viewEvents.html";
					return false;
				}
		};
		const result =$.ajax(ajaxCall);
    	return false;
    }
    return false;
}

$('#save').live('click', () => {createObject()});
