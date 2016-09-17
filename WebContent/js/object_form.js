function validateObject(name, address, town, tin, bank_account){
	var result = '';
	const einRegex = /^[1-9]\d?-\d{7}$/;
	const bankRegex = /^([0-9]{3}-[0-9]{13}-[0-9]{2})$/
    if (name == null || name == "") {
    	document.getElementById("nameError").style.display = "block";
        result = 'username';
    }
    else{
        document.getElementById("nameError").style.display = "none";
    }
    if(address== null || address == "") {
        document.getElementById("addressError").style.display = "block";
        result = 'email';
    }
    else{
        document.getElementById("addressError").style.display = "none";
    }
    if(town == null || town == ""){
        document.getElementById("townError").style.display = "block";
        result = 'password';
    }
    else{
        document.getElementById("townError").style.display = "none";
    }
    if (tin == null || tin == "" || !einRegex.test(tin)) {
        document.getElementById("tinError").style.display = "block";
        result = 'confirm';
    }
    else{
    	document.getElementById("tinError").style.display = "none";
    }
    if (bank_account == null || bank_account == "" || !bankRegex.test(bank_account)) {
        document.getElementById("bankError").style.display = "block";
        result = 'confirm';
    }
    else{
    	document.getElementById("bankError").style.display = "none";
    }
	return result==='';
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
    const manager = JSON.parse(localStorage.getItem('loggedIn')).username;
    
    const validated = validateObject(name, address, town, tin, bank_account);
    if (validated){
		const ajaxCall = {
				type: "POST",
				url: "http://localhost:8080/Reviewer/ObjectServlet",
				data : { manager, name, address, town, phone, email, website, tin, bank_account },
				success : function (response) {
					if (response.errors){
						alert("Unable to create");
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

function deleteObject(){
	const result = confirm("Are you sure you want to delete this object?");
	if(result){
		const object = JSON.parse(localStorage.getItem("selectedObject"));
		const tin = object.tin;
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


$("#upload").change(function(event) {
	 var tmppath = URL.createObjectURL(event.target.files[0]);
	document.getElementById('objectPicture').src = tmppath
});

$('#save').live('click', () => {createObject()});
