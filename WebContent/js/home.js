function loadObjects(){
  const result = $.ajax({
		method: 'GET',
		url: 'http://localhost:8080/Reviewer/ObjectServlet',
		success: function(data){
			console.log(data);
			alert('SUCCESS');
			return false;
		}
	})
}

window.onload = loadObjects()
