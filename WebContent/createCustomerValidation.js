
function createCustomerValidation(){
	
	let ssnid = document.getElementById("ssnid").value;
	let cname = document.getElementById("cname").value;
	let age = document.getElementById("cage").value;
	let add1 = document.getElementById("add1").value;
	let city = document.getElementById("city").value;
	let state = document.getElementById("state").value;
	let btn = document.getElementById("btn-create-customer");
	if((ssnid!=null) && (cname!=null) && (age!=null) && (add1!=null) && (city!=null) && (state!=null) &&
			(ssnid!="") && (cname!="") && (age!="") && (add1!="") && (city!="") && (state!="")){			
				
		btn.removeAttribute("disabled", true);
	}
	else{
		btn.setAttribute("disabled", true);
	}
}

function checkssnid(){
	let ssnid = document.getElementById("ssnid").value;
	
	if(ssnid.length<9 || ssnid.length > 9){
		alert("You Should enter 9 digits only");
	}
	
}