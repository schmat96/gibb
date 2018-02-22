var i = 0;
var colorCorrect =  "rgba(0, 255, 0, .3)";
var colorWrong = "rgba(255, 0, 0, .3)";
var pattPW = "^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$_!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$";


function checkRegex() {
	var name = document.getElementById("inputFormLoginID").value;
	var pw = document.getElementById("inputFormLoginPW").value;
	var pattName = "[a-zA-Z]{5}"
	var checked = 0;
	if (name.match(pattName)) {
		document.getElementById("inputFormLoginID").style.border  = "thick solid "+colorCorrect;
		checked++;
	} else {
		document.getElementById("inputFormLoginID").style.border  = "thick solid "+colorWrong;
	}
	if (pw.match(pattPW)) {
		document.getElementById("inputFormLoginPW").style.border  = "thick solid "+colorCorrect;
		
		checked++;
	} else {
		document.getElementById("inputFormLoginPW").style.border  = "thick solid "+colorWrong;
	}
	if (checked == 2) {
		document.getElementById("login_laden").style.display = "inline";
	} else {
		document.getElementById("login_laden").style.display = "none";
	}
}

function setShit() {
	document.getElementById("inputFormLoginID").style.border  = "thick solid "+colorWrong;
	document.getElementById("inputFormLoginPW").style.border  = "thick solid "+colorWrong;
}

function login() {
	var name = document.getElementById("inputFormLoginID").value;
	var pw = document.getElementById("inputFormLoginPW").value;
	if (name.length < 5 || pw.length < 5) {
		document.getElementById("inputFormLoginID").placeholder  = "PW und oder Name zu kurz";
	} else {
		
	
	document.getElementById("inputFormLoginID").value  = "";
	document.getElementById("inputFormLoginPW").value = "";
	document.getElementById("inputFormLoginID").placeholder  = "Checking your input.";
	document.getElementById("inputFormLoginPW").placeholder  = "";
	
	var d = document.getElementById("login_laden");
	d.src = "bilder/laden.png";
	d.style.background = "none";
	d.className += " EinfacheDrehAnimation";
	ladenSimulieren();
	}
}

function loginGoingOn() {
	var d = document.getElementById("login_laden");
	d.className = "";
	d.src = "bilder/navlogo2.png";
	document.getElementById("inputFormLoginID").placeholder  = "";
	document.getElementById("inputFormLoginPW").placeholder  = "nicht erfolgreich";
}

function openRegister() {
	document.location.href = "registrierung.html";
}



function ladenSimulieren() {
	setTimeout(function () {
		if (i < 1500) {
			
			i++;
			ladenSimulieren();
		} else {
			i = 0;
			loginGoingOn();
		}
	
}, 1)
}