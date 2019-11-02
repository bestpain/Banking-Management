
function accdetailValidator(){
	var ssnid = document.getElementById("ssnid").value;
	var custid = document.getElementById("custid").value;
	
	if(((ssnid!=null || ssnid!="") && ssnid.length==9)){
		
		document.getElementById("submit-id").removeAttribute("disabled");
			
	}
	else{
		document.getElementById("submit-id").setAttribute("disabled", true);

	}
	
	 if((custid!=null || custid != "")&& custid.length==9){
			document.getElementById("submit-id").removeAttribute("disabled");

	 }
	
}

