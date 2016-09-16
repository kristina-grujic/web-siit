function loadProfile(){

	const user = localStorage.getItem('loggedIn');
	if(!user){
		window.location = "http://localhost:8080/Reviewer/login.html";
		return;
	}
	parsed = JSON.parse(user);
	console.log(parsed)

	var div = document.getElementById('profile_logged');
	div.innerHTML = '<img src="' + parsed.icon
								+ '"/><a>' + parsed.username + '</a>';
	
	var picture = document.getElementById('profilePic');
	picture.src = parsed.icon;

	var name = document.getElementById('name');
	name.value = parsed.name;

	var surname = document.getElementById('surname');
	surname.value = parsed.surname;
	
	var phone = document.getElementById('phone');
	phone.value = parsed.phone;
	
	var email = document.getElementById('email');
	email.value = parsed.email;
}
$('document').ready(function(){
	loadProfile()
});