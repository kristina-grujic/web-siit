function loadProfile(){

	const user = localStorage.getItem('loggedIn');
	if(!user){
		window.location = "http://localhost:8080/Reviewer/login.html";
		return;
	}
	parsed = JSON.parse(user);

	var menu = document.getElementById('menu');
	if (parsed.role==='manager'){
		menu.innerHTML = menu.innerHTML + '<li><a href="objectForm.html">Create new object</a></li>'
	}
	var div = document.getElementById('profile_logged');
	div.innerHTML = '<img src="' + parsed.icon
								+ '"/><a>' + parsed.username + '</a>';
}

function logout(){
	localStorage.clear();
	return true;
}

$('document').ready(function(){
	loadProfile()
});