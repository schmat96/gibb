var bilderAnzahl = [];
var diashow = [];

function initializeSlideShow() {
	i = -1;
	j = 0;
	$('.kachelContent img').each(function(){
		console.log($(this).attr('class'));
		if ($(this).attr('class')=="hauptBild") {
			if (i!=-1) {
				bilderAnzahl[i] = j;
			}
			j = 0;
			i++;
		}
		$(this).attr("id","slideshow"+i+j);
		j++;
		$(this).click({param1: $(this).attr('id')}, cool_function);
		diashow[i] = true;
	});
	bilderAnzahl[i] = j;
	//slideShowNextPicture();
	
}


function cool_function(event){
    var name = event.data.param1;
    diashow[name[name.length - 2]] = false;
	changePicture(name);
}

function changePicture(name){

    var done = true;
    	var element = name[name.length - 2];
  
    	var pattern2 = "slideshow"+element+"[0-9]{1}";
        var pattern = "slideshow"+element+"0";

    	$('.kachelContent img').each(function(){
    		if ($(this).attr('id').match(pattern) && done) {
    			done = false;
    			$(this).attr('class', 'nebenBild');
    			$(this).attr("id",name);
    			$(this).click({param1: $(this).attr('id')}, cool_function);
    		}
    		else if ($(this).attr('id')==name) {
    			$(this).attr('class', 'hauptBild');
    			$(this).attr("id","slideshow"+element+"0");
    			$(this).click({param1: $(this).attr('id')}, cool_function);
    		}
    		
    	});
    	
    	

    //initializeSlideShow();
    
}


function slideShowNextPicture() {
	setTimeout(function () {
		var i = 0;
		bilderAnzahl.forEach(function(entry) {
			if (diashow[i]) {
			    console.log(entry);
			    var ele = Math.floor((Math.random() * (entry-1))+1);
			    var name = "slideshow"+i+ele;
			    changePicture(name);
			    
			}
			i++;
		});
		slideShowNextPicture();	
	}, 3000)
	

}

