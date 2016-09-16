function loadProfile(){

	const user = localStorage.getItem('loggedIn');
	if(!user){
		window.location = "http://localhost:8080/Reviewer/login.html";
		return;
	}
	parsed = JSON.parse(user);

	var div = document.getElementById('profile_logged');
	div.innerHTML = '<img src="' + parsed.icon
								+ '"/><a>' + parsed.username + '</a>';
}
$('document').ready(function(){
	loadProfile()
});