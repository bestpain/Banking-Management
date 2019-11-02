if(screen.availWidth<700 && screen.availHeight<700){
	alert("You should have resolution of atleast 700 X 700");
}
function checkLoginas(){
	let loginas1 = document.getElementById("custexec").value;
	let loginas2 = document.getElementById("cashier").value;
	
		if(loginas1!=null || loginas2!=null){
			document.getElementById("idno").removeAttribute("disabled");
			document.getElementById("idno").setAttribute("required", true);
		}
}

function idcheck(){

	let idno = document.getElementById("idno").value;
	
	if(idno==null || idno==""){
		document.getElementById("login-alert").innerHTML = "Please Enter Your ID No.";
	}
	
	if(idno!="" && idno!=null){
		document.getElementById("pswd").removeAttribute("Disabled");
		document.getElementById("pswd").setAttribute("required", true);
		document.getElementById("submit-button-login").removeAttribute("Disabled");
	}

}


function confirm(){
	confirm("Do you want to Delete?");
	prompt("Do you want to Delete?");
}


