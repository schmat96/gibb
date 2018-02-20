var value = 0;

function openNavbar() {
	var navbarButton = document.getElementById("navbarIconNavbar");
	if (navbarButton.dataset.triggered == "true") {
		navbarButton.dataset.triggered = "false";
		document.getElementById("navText1").style.display = "inline";
		document.getElementById("navText2").style.display = "inline";
		document.getElementById("navText3").style.display = "inline";
		document.getElementById("navText4").style.display = "inline";
		
		var loginButton = document.getElementById("navbarIconLogin");
		if (loginButton.dataset.triggered == "false") {
			openLogin();
		}
		animationNavbar(true);

		
	} else {
		
		navbarButton.dataset.triggered = "true";
		animationNavbar(false);
		
	}
}

function animationNavbar(richtung) {
	setTimeout(function () {
		for (i = 0; i < 4; i++) { 
				if (value-i*10<=100 || value-i*10<=0) {
					var wert = "navText"+(i+1);
					document.getElementById(wert).style.width = (value-i*10)+"%";
					document.getElementById(wert).style.opacity = value/100;
				
			} 
			
		}
		if (richtung) {
			value++;
			 if (value <= 140) {       
				 animationNavbar(richtung);             
		      }
		} else {
			value--;
			 if (value >= 0) {       
				 animationNavbar(richtung);   
				 
		      } else {
		    	  for (i = 0; i < 4; i++) { 
						var wert = "navText"+(i+1);
						document.getElementById(wert).style.display = "none";
		    	  }
		      }
		}
			
	}, 5)
	
}


