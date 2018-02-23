var i = 0;
var colorCorrect =  "rgba(0, 255, 0, .3)";
var colorWrong = "rgba(255, 50, 0, .5)";
var pattPW = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
var pattMail = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2}";

function checkRegex() {
	var name = document.getElementById("inputFormLoginID").value;
	var pw = document.getElementById("inputFormLoginPW").value;
	var checked = 0;
	if (name.match(pattMail)) {
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
		$('#login_laden').removeClass();
		$('#login_laden').prop('onclick',null).off('click');
		$( "#login_laden" ).click(function() {
			login();
		});
	} else {
		$("#login_laden").addClass( "disabled" );
		$('#login_laden').prop('onclick',null).off('click');
		$( "#login_laden" ).click(function() {
			  
		});
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
	alert("Passwort und Benutzernamen stimmen nicht überein");
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