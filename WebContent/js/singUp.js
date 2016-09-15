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
    if (x == null || x == "") {
        document.getElementById("emailError").style.display = "block";
        result = 'email';
    }
    else{
        document.getElementById("emailError").style.display = "none";
    }
    if (password == null || password == "") {
        document.getElementById("passwordError").style.display = "block";
        result = 'password';
    }
    else{
        document.getElementById("passwordError").style.display = "none";
    }
    if (password == null || password == "") {
        document.getElementById("confirmError").style.display = "block";
        result = 'confirm';
    }
    else{
        document.getElementById("passwordError").style.display = "none";
    }
    return result==='';
  }
