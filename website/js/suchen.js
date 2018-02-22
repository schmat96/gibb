function suchen() {
	
	var suchtext = document.getElementById("inputFormSearchGruppe").value;
	
	var regex = new RegExp(suchtext, 'i');
	
	var oldSpan = "<span class=\"important\">";
	var span = "<\span>";
	
	var kachel = document.getElementsByClassName("kachel");
	for (var i=0; i<kachel.length; i++) {
		kachel[i].style.display = "none";
	}
	
	var titel = document.getElementsByClassName("kachelH2");
	for (var i=0; i<titel.length; i++) {
		titel[i].innerHTML = titel[i].innerHTML.replace(oldSpan, "");
		titel[i].innerHTML = titel[i].innerHTML.replace(span, "");
		if (titel[i].dataset.vollerName.match(regex)!=null) {
			kachel[i].style.display = "inline-block";
			titel[i].innerHTML = titel[i].innerHTML.replace(suchtext, "<span class=\"important\">"+suchtext+" </span>");
		}
		
	}
	
	var beschreibung = document.getElementsByClassName("kachelBeschreibung");
	for (var i=0; i<kachel.length; i++) {
		beschreibung[i].innerHTML = beschreibung[i].innerHTML.replace(oldSpan, "");
		beschreibung[i].innerHTML = beschreibung[i].innerHTML.replace(span, "");
		if (beschreibung[i].dataset.vollerText==undefined) {
			if (beschreibung[i].innerHTML.match(regex)!=null) {
				beschreibung[i].innerHTML = beschreibung[i].innerHTML.replace(suchtext, "<span class=\"important\">"+suchtext+" </span>");
				kachel[i].style.display = "inline-block";
			}
		} else {
			if (beschreibung[i].dataset.vollerText.match(regex)!=null) {
				beschreibung[i].dataset.vollerText = beschreibung[i].dataset.vollerText.replace(suchtext, "<span class=\"important\">"+suchtext+" </span>");
				kachel[i].style.display = "inline-block";
			}
		}
	
	}
	
	var table = document.getElementsByClassName("kachelTable");
	for (var i=0; i<kachel.length; i++) {
		table[i].innerHTML = table[i].innerHTML.replace(oldSpan, "");
		table[i].innerHTML = table[i].innerHTML.replace(span, "");
		if (table[i].innerHTML.match(regex)!=null) {
			table[i].innerHTML = table[i].innerHTML.replace(suchtext, "<span class=\"important\">"+suchtext+" </span>");
			kachel[i].style.display = "inline-block";
		}
	}
	
	
	
}