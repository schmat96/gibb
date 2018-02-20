var valueLogin = 0;

function openLogin() {
	var loginButton = document.getElementById("navbarIconLogin");
	
	var navbarButton = document.getElementById("navbarIconNavbar");
		if (navbarButton.dataset.triggered == "false") {
			openNavbar();
		}
	
	if (loginButton.dataset.triggered == "true") {
		loginButton.dataset.triggered = "false";
		document.getElementById("loginDiv").style.display = "inline";
		
		document.getElementById("loginDiv").style.top = 260+"px";
		animationLoginBar(true);
	} else {
		loginButton.dataset.triggered = "true";
		
		animationLoginBar(false);
	}
}


function animationLoginBar(richtung) {
	setTimeout(function () {
			
				wert = "loginDiv";
				document.getElementById(wert).style.top = (260-valueLogin*2)+"px";
				document.getElementById(wert).style.opacity = valueLogin/100;
				document.getElementById("navbarIconLogin").style.transform = "skewY("+(valueLogin*1.8)+"deg)";
				document.getElementById("navbarIconLogin").style.transform = "skewX("+(valueLogin*1.8)+"deg)";
				
				if (valueLogin==50 && richtung==true) {
					document.getElementById("navbarIconLoginImg").src = "bilder/abbrechen.png";
				}
				
				if (valueLogin==50 && richtung==false) {
					document.getElementById("navbarIconLoginImg").src = "bilder/login.png";
				}
				
			
			
		if (richtung) {
			valueLogin++;
			 if (valueLogin <= 100) {       
				 animationLoginBar(richtung);             
		     } else {
		    	 document.getElementById(wert).style.opacity = 1;
		     }
		} else {
			valueLogin--;
			 if (valueLogin >= 0) {       
				 animationLoginBar(richtung);    
		      } else {
		    	  wert = "loginDiv";
		    	  document.getElementById(wert).style.display = "none"; 
		      }
		}
			
	}, 5)
}