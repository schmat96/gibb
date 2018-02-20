function checkRegister() {
	var name = document.getElementById("regName");
	var vorname = document.getElementById("regVorname");
	var pw1 = document.getElementById("regPasswort1");
	var pw2 = document.getElementById("regPasswort2");
	var email = document.getElementById("regEmail");
	var pattName = "[a-zA-Z]{5}"
	var pattPW = "[a-zA-Z]{5}"
	var pattMail = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2}"
	var checked = 0;
	
	var colorCorrect =  "rgba(0, 255, 0, .3)";
	var colorWrong = "rgba(255, 0, 0, .3)";
	
	if (name.value.match(pattName)) {
		name.style.border  = "thick solid "+ colorCorrect;
		checked++;
	} else {
		name.style.border  = "thick solid "+ colorWrong;
	}
	
	if (vorname.value.match(pattName)) {
		vorname.style.border  = "thick solid "+ colorCorrect;
		checked++;
	} else {
		vorname.style.border  = "thick solid "+ colorWrong;
	}
	
	if (pw1.value.match(pattName)) {
		pw1.style.border  = "thick solid "+ colorCorrect;
		checked++;
	} else {
		pw1.style.border  = "thick solid "+ colorWrong;
	}
	
	if (pw1.value==pw2.value && pw2.value!="") {
		pw2.style.border  = "thick solid "+ colorCorrect;
		checked++;
	} else {
		pw2.style.border  = "thick solid "+ colorWrong;
	}
	
	if (email.value.match(pattMail)) {
		email.style.border  = "thick solid "+ colorCorrect;
		checked++;
	} else {
		email.style.border  = "thick solid "+ colorWrong;
	}
	
	if (checked == 5) {
		document.getElementById("registerLogo").style.display = "inline";
	} else {
		document.getElementById("registerLogo").style.display = "none";
	}
	
}

function register() {
	var info = document.getElementById("Reginformation");
	info.innerHTML = "Ich mache noch nichts";
	
}