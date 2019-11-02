function validateCustId(){
	let x= document.getElementById("custid").value;
	let y = document.getElementById("accType").value;
	let z = document.getElementById("damount").value;
		
	if((x!=null && x.length!=0) && (y!=null && y.length!=0) && (z!=null && z.length!=0)){
		console.log(x);
		console.log(y);
		console.log(z);
		document.getElementById("btn-create-acc").removeAttribute("disabled");
	}else{
		document.getElementById("btn-create-acc").setAttribute("disabled", true);
	}
}