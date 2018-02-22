function setTextFromAtt() {
	texts = document.getElementsByClassName("kachelBeschreibung");
	for (var i=0; i<texts.length; i++) {
		texts[i].dataset.vollertext = texts[i].innerHTML;
	}
	elemente = document.getElementsByClassName("kachelH2");
	for (var i=0; i<elemente.length; i++) {
		elemente[i].dataset.vollerName = elemente[i].innerHTML;
	}
}


function changedValue() {
	var size = document.getElementById("sizeKacheln").value;
	var element = document.getElementsByClassName("kachel");

	
	if (size>0 && size <= 12) {
		margin=12;
		setAnmeldenButton("anmeldenButton", "<img src=\"bilder/anmelden.png\" style=\"width:30px;height:30px\">");
		setAbkuerzungGruppenNamen("true");
		
	}
	
	if (size>12 && size <= 25) {
		margin=23;
		setMargins("kachelH2", 0);
		showAndHide("none", "kachelIcons");
		showAndHide("none", "kachelIcons");
		setAnmeldenButton("anmeldenButton", "anmelden")
		setAbkuerzungGruppenNamen("false");
		
	}
	
	if (size>25 && size <= 50) {
		margin=48.5;
		setMargins("kachelH2", 15);
		setMargins("kachelBeschreibung", 0);
		showAndHide("none", "kachelTable");
		showAndHide("inline", "kachelIcons");
		showAndHide("inline", "kachelIcons");
		setAbkuerzungGruppenNamen("true");
		
	}
	
	if (size>50 && size <= 100) {
		margin=100;
		setMargins("kachelBeschreibung", 15);
		showAndHide("inline", "kachelTable");
		setAbkuerzungGruppenNamen("false");
	}
	
	if (size < 75) {
		if (size>0 && size <= 25) {
			hideText(0);
		} else {
			hideText(size/1.4);
		}
		
	} else {
		hideText(3000);
	}
	
	
	
	
	for (var i=0; i<element.length; i++) {
	    element[i].style.width = size+"%";
	    element[i].style.marginLeft = ((margin-size)/2)+"%";
	    element[i].style.marginRight = ((margin-size)/2)+"%";
	}
	
	
}

function setAbkuerzungGruppenNamen(wert) {
	elementeh2 = document.getElementsByClassName("kachelH2");
	if (wert=="true") {
		for (var i=0; i<elementeh2.length; i++) {
			elementeh2[i].innerHTML=elementeh2[i].dataset.abkuerzung;
		}
	} else {
		for (var i=0; i<texts.length; i++) {
			elementeh2[i].innerHTML=elementeh2[i].dataset.vollerName;
			
			
		}
	}
}

function setMargins(klasse, hoehe) {
	elementeh2 = document.getElementsByClassName(klasse);
	for (var i=0; i<elementeh2.length; i++) {
		elementeh2[i].style.marginTop = hoehe+"px";
		elementeh2[i].style.marginBottom = hoehe+"px";
		if (klasse=="kachelH2") {
			elementeh2[i].style.fontSize = (hoehe+20)+"px";
		}
		
	}
}

function setAnmeldenButton(name, wert) {
	elementeh2 = document.getElementsByClassName(name);
	for (var i=0; i<elementeh2.length; i++) {
		elementeh2[i].innerHTML = wert;

	}
}

function hideText(anzahl) {
	texts = document.getElementsByClassName("kachelBeschreibung");
	for (var i=0; i<texts.length; i++) {
		var text = texts[i].dataset.vollertext.substring(0, anzahl);
		if (text.length < texts[i].dataset.vollertext.length) {
			text = text + "<p class=\"tooltips\" data-vollerText=\""+texts[i].dataset.vollertext+"\"> (...)</p>";
		}
		texts[i].innerHTML = text;
	}
}

function showAndHide(bool, was) {
	var elemente = document.getElementsByClassName(was);
	for (var i=0; i<elemente.length; i++) {
		elemente[i].style.display = bool;
	}
}
