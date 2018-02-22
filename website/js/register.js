




function checkRegister() {
	var pw1 = document.getElementById("regPasswort1");
	var pw2 = document.getElementById("regPasswort2");
	var email = document.getElementById("regEmail");
	var pattName = "[a-zA-Z]{5}";

	var pattMail = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2}";
	var checked = 0;
	
	
	
	if (pw1.value.match(pattName)) {
		pw1.style.border  = "thick solid "+ colorCorrect;
		checked++;
		document.getElementById("passwort1FormHinweis").style.display = "none";
	} else {
		pw1.style.border  = "thick solid "+ colorWrong;
		if ($("#regPasswort1").is(':focus')) {
			document.getElementById("passwort1FormHinweis").innerHTML = " Bitte gib ein gültiges PW ein. (Regex: "+pattPW+")";
			document.getElementById("passwort1FormHinweis").style.display = "inline";
		} else {
			document.getElementById("passwort1FormHinweis").style.display = "none";
		}
	}
	
	if (pw1.value==pw2.value && pw2.value!="") {
		pw2.style.border  = "thick solid "+ colorCorrect;
		document.getElementById("passwort2FormHinweis").style.display = "none";
		checked++;
	} else {
		pw2.style.border  = "thick solid "+ colorWrong;
		if ($("#regPasswort2").is(':focus')) {
			document.getElementById("passwort2FormHinweis").innerHTML = " Das stimmt leider noch nicht überein";
			document.getElementById("passwort2FormHinweis").style.display = "inline";
		} else {
			document.getElementById("passwort2FormHinweis").style.display = "none";
		}
	}
	
	if (email.value.match(pattMail)) {
		email.style.border  = "thick solid "+ colorCorrect;
		document.getElementById("emailFormHinweis").style.display = "none";
		checked++;
	} else {
		email.style.border  = "thick solid "+ colorWrong;
		if ($("#regEmail").is(':focus')) {
			document.getElementById("emailFormHinweis").innerHTML = " Bitte gib eine gültige EMail ein. (Regex: "+pattMail+")";
			document.getElementById("emailFormHinweis").style.display = "inline";
		} else {
			document.getElementById("emailFormHinweis").style.display = "none";
		}
	}
	
	var checkedCheckbox = 0;
	
	if($("#FormFussball").is(':checked')) {
		checkedCheckbox++;
	}	
	
	if($("#FormGolf").is(':checked')) {
		checkedCheckbox++;
	}
	
	if($("#FormTennis").is(':checked')) {
		checkedCheckbox++;
	}

	if (checkedCheckbox>=1) {
		checked++;
		document.getElementById("selectFormHinweis").style.display = "none";
	} else {
		document.getElementById("selectFormHinweis").style.display = "inline";
	}
	
	if (checked == 4) {
		document.getElementById("registerLogo").style.display = "inline";
		document.getElementById("registerButtonHinweis").style.display = "none";
	} else {
		document.getElementById("registerButtonHinweis").style.display = "inline";
		document.getElementById("registerLogo").style.display = "none";
	}
	
}

function register() {
	var info = document.getElementById("Reginformation");
	info.innerHTML = "Ich mache noch nichts";
	
}