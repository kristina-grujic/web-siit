function validateForm(username, email, password, confirm_password) {
    var result = '';
    if (username == null || username == "") {
    	console.log(username)
        document.getElementById("usernameError").style.display = "block";
        result = 'username';
    }
    else{
        document.getElementById("usernameError").style.display = "none";
    }
    if(email== null || email == "") {
        document.getElementById("emailError").style.display = "block";
        result = 'email';
    }
    else{
        document.getElementById("emailError").style.display = "none";
    }
    if(password == null || password == ""){
        document.getElementById("passwordError").style.display = "block";
        result = 'password';
    }
    else{
        document.getElementById("passwordError").style.display = "none";
    }
    if (confirm_password == null || confirm_password == "") {
        document.getElementById("confirmError").style.display = "block";
        result = 'confirm';
    }
    else{
    	if (password!== confirm_password){
    	      document.getElementById("confirmError").style.display = "block";
    	      result = 'confirm';
    	}
    	else{
    		document.getElementById("confirmError").style.display = "none";
    	}
    }
    return result==='';
  }


function signup(){
    var username = document.forms["myForm"]["username"].value;
    var email = document.forms["myForm"]["email"].value;
    var password = document.forms["myForm"]["password"].value;
    var confirm_password = document.forms["myForm"]["confirm_password"].value;
	const validated = validateForm(username, email, password, confirm_password);
	console.log(validated);
	if (validated){
		const result = $.ajax({
			type: "POST",
			url: 'http://localhost:8080/Reviewer/SignupServlet',
			data : { username: username,
					 email: email,
					 password: password},
			success: function(data){
				console.log(data);
				alert('SUCCESS');
				window.location = "http://localhost:8080/Reviewer/home.html";
				return false;
			}
		})
		return false;
	}
	return false;
}
