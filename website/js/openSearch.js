var valueSuchen = 0;

function openSearch() {
	var searchButton = document.getElementById("navbarIconSuchen");
	
	if (searchButton.dataset.triggered == "true") {
		searchButton.dataset.triggered = "false";
		if (document.getElementById("inputFormSearch").value=="") {
			if (window.innderWidth>1024) {
				return;
			} else {
				document.getElementById("searchDiv").style.display = "inline";
				document.getElementById("searchDiv").style.opacity = "0.0";
				
				
				
				showSearch(true);
				searchButton.dataset.triggered = "false";
			}
			
		} else {
		
		}
		
	
	} else {
		
		
		searchButton.dataset.triggered = "true";
		document.getElementById("inputFormSearch").value="";
		showSearch(false);
	}
}

function showSearch(richtung) {
		setTimeout(function () {
			
			wert = "searchDiv";
			document.getElementById(wert).style.opacity = valueSuchen/100;
			document.getElementById("navbarIconSuchen").style.transform = "skewY("+(valueSuchen*1.8)+"deg)";
			
			if (valueSuchen==50 && richtung==true) {
				document.getElementById("navbarIconSuchenImg").src = "bilder/abbrechen.png";
			}
			
			if (valueSuchen==50 && richtung==false) {
				document.getElementById("navbarIconSuchenImg").src = "bilder/suchen.png";
			}
			
		
		
	if (richtung) {
		valueSuchen++;
		 if (valueSuchen <= 100) {       
			 showSearch(richtung);             
	     }
	} else {
		valueSuchen--;
		 if (valueSuchen >= 0) {       
			 showSearch(richtung);    
	      } else {
	    	  document.getElementById("searchDiv").style.display = "none";
	      }
	}
		
	}, 5)
	
}
