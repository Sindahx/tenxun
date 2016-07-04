window.onload = function(){
	var toTop_btn = document.getElementById('back_to_top');
	var clientHeight = document.documentElement.clientHeight;
	var timer = null;
	var isStop = true;
	var isClick = false;
	
	window.onscroll = function(){
		var osTop = document.documentElement.scrollTop||document.body.scrollTop;
		if(osTop>=clientHeight/2){
			toTop_btn.style.display = 'block';
		}else{
			toTop_btn.style.display = 'none';
		}
		if(!isStop){
			clearInterval(timer);
			isClick = false;
		}
		isStop = false;
	}

	toTop_btn.onclick = function(){
		if(!isClick){
			isClick = true;
      		timer = setInterval(function(){
	        var osTop = document.documentElement.scrollTop||document.body.scrollTop;
	        var iSpeed = Math.floor(-osTop/6);
		    document.documentElement.scrollTop = document.body.scrollTop = osTop+iSpeed;
		    isStop = true;
		    if(osTop == 0){
			   clearInterval(timer);
			   isClick = false;
		    }
	       },30);
	    }
	}
}		