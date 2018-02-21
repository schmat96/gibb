
function loadJqueryThings() {
	$( "#emailForm" ).hover(
			  function() {
				  $( "#regEmail" ).focus();
			  }
	);
	$( "#passwort1Form" ).hover(
			  function() {
				  $( "#regPasswort1" ).focus();
			  }
	);
	$( "#passwort2Form" ).hover(
			  function() {
				  $( "#regPasswort2" ).focus();
			  }
	);
	$( "#passwort2Form" ).hover(
			  function() {
				  $( "#regPasswort2" ).focus();
			  }
	);
}


function checkRegister() {
	var pw1 = document.getElementById("regPasswort1");
	var pw2 = document.getElementById("regPasswort2");
	var email = document.getElementById("regEmail");
	var pattName = "[a-zA-Z]{5}"
	var pattPW = "[a-zA-Z]{5}"
	var pattMail = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2}"
	var checked = 0;
	
	var colorCorrect =  "rgba(0, 255, 0, .3)";
	var colorWrong = "rgba(255, 0, 0, .3)";
	
	if (pw1.value.match(pattName)) {
		pw1.style.border  = "thick solid "+ colorCorrect;
		checked++;
		document.getElementById("passwort1FormHinweis").style.display = "none";
	} else {
		pw1.style.border  = "thick solid "+ colorWrong;
		if ($("#regPasswort1").is(':focus')) {
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
			document.getElementById("emailFormHinweis").style.display = "inline";
		} else {
			document.getElementById("emailFormHinweis").style.display = "none";
		}
	}
	
	if (checked == 3) {
		document.getElementById("registerLogo").style.display = "inline";
	} else {
		document.getElementById("registerLogo").style.display = "none";
	}
	
}

function register() {
	var info = document.getElementById("Reginformation");
	info.innerHTML = "Ich mache noch nichts";
	
}