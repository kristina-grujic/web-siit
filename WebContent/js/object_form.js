function validateObject(name, address, town, tin, bank_account){
	console.log(name);
}
function createObject(){
    var name = document.forms["createObject"]["name"].value;
    var address = document.forms["createObject"]["address"].value;
    var town = document.forms["createObject"]["town"].value;
    var phone = document.forms["createObject"]["phone"].value;
    var email = document.forms["createObject"]["email"].value;
    var website = document.forms["createObject"]["website"].value;
    var tin = document.forms["createObject"]["tin"].value;
    var bank_account = document.forms["createObject"]["bank_account"].value;
    
    const validated = validateObject(name, address, town, tin, bank_account);
}

function deleteObject(){
	const result = confirm("Are you sure you want to delete this object?");
	if(result){
		const object = JSON.parse(localStorage.getItem("selectedObject"));
		const tin = object.tin;
		console.log(tin);
		const ajaxCall = {
				type: "DELETE",
				url: "http://localhost:8080/Reviewer/ObjectServlet?tin="+tin,
				data : { tin: tin },
				success : function (response) {
					if (response.errors){
						alert("Unable to delete");
						return false;
					}
					window.location = "http://localhost:8080/Reviewer/home.html";
					return false;
				}
				};
		const result =$.ajax(ajaxCall);
		return false;
	}
	return false;
}