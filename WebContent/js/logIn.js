function validateForm() {
    var x = document.forms["myForm"]["username"].value;
    var password = document.forms["myForm"]["password"].value;
    var result = '';
    if (x == null || x == "") {
        document.getElementById("usernameError").style.display = "block";
        result = 'username';
    }
    else{
        document.getElementById("usernameError").style.display = "none";
    }
    if (password == null || password == "") {
        document.getElementById("passwordError").style.display = "block";
        result = 'password';
    }
    else{
        document.getElementById("passwordError").style.display = "none";
    }
    return result==='';
  }

function authenticate(){
	const validated = validateForm();
    var username = document.forms["myForm"]["username"].value;
    var password = document.forms["myForm"]["password"].value;
	if (validated){
		const result = $.ajax({
			method: 'POST',
			url: 'http://localhost:8080/Reviewer/AuthServlet',
			data : { username:username, password: password},
			success: function(data){
				console.log(data);
				alert('SUCCESS');
				return false;
			}
		})
		
		result.success(function (data){
			console.log(data);
		});		
		
		result.error(function (data){
			console.log(data);
		});
		return false;
	}
	else{
		return false;
	}
	return false;
}
