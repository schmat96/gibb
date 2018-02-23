
var pattName = "[a-zA-Z]{5}";
var pattMail = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2}";

var pwHelpText = " Bitte gib ein gültiges PW ein. (Regex: "+pattPW+")";
var pw2HelpText = " Das Zweite Passwort stimmt noch nicht mit dem ersten überein"
var	emailHelpText = " Bitte gib eine gültige EMail ein. (Regex: "+pattMail+")";
var checkboxHelpText = " Bei den Checkboxen mindestens etwas auswählen";

function initializeRegister() {
	$("#regForm span").css('color', colorWrong);
	document.getElementById("regPasswort1").style.border  = "thick solid "+ colorWrong;
	document.getElementById("regPasswort2").style.border  = "thick solid "+ colorWrong;
	document.getElementById("regEmail").style.border  = "thick solid "+ colorWrong;
	$("#helpText").css('color', colorWrong);
	$("#helpText").css('font-size', "0.7em");

}

function showHelp() {
	var pw1 = document.getElementById("regPasswort1");
	var pw2 = document.getElementById("regPasswort2");
	var email = document.getElementById("regEmail");
	var helpArray = [];
	var checked = 0;
	
	if (pw1.value.match(pattPW)) {
		
	} else {
		helpArray.push(pwHelpText);
	}
	
	if (pw1.value==pw2.value && pw2.value!="") {
		
	} else {
		helpArray.push(pw2HelpText);
	}
	
	if (email.value.match(pattMail)) {
		
	} else {
		helpArray.push(emailHelpText);
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

	} else {
		helpArray.push(checkboxHelpText);
	}
	var text = "";
	 for(var i=0; i < helpArray.length; i++) {
	        text = text + "<br>" + helpArray[i];
	 }
	 
	 document.getElementById("helpText").innerHTML = text;

}

function checkRegister() {
	document.getElementById("helpText").innerHTML = "";
	var pw1 = document.getElementById("regPasswort1");
	var pw2 = document.getElementById("regPasswort2");
	var email = document.getElementById("regEmail");
	
	var checked = 0;

	if (pw1.value.match(pattPW)) {
		pw1.style.border  = "thick solid "+ colorCorrect;
		checked++;
		document.getElementById("passwort1FormHinweis").style.display = "none";
	} else {
		pw1.style.border  = "thick solid "+ colorWrong;
		if ($("#regPasswort1").is(':focus')) {
			document.getElementById("passwort1FormHinweis").innerHTML = pwHelpText;
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
			document.getElementById("passwort2FormHinweis").innerHTML = pw2HelpText;
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
			document.getElementById("emailFormHinweis").innerHTML = emailHelpText;
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
		$('#registerLogo').removeClass();
		$('#registerLogo').prop('onclick',null).off('click');
		$( "#registerLogo" ).click(function() {
			  alert( "Registrierung Erfolgreich. Melde dich jetzt oben Rechts an!" );
		});
	} else {
		$("#registerLogo").addClass( "disabled" );
		$('#registerLogo').prop('onclick',null).off('click');
		$( "#registerLogo" ).click(function() {
			  showHelp();
		});
	}
	
	
}

function register() {
	var info = document.getElementById("Reginformation");
	info.innerHTML = "Ich mache noch nichts";	
}