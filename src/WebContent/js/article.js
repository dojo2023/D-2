/**
 *
 */
/*いいねボタンを押したら色が変わる */

var judge=true;
var fav_pink;

document.getElementById('fav_form').onsubmit=function(){
	if(judge=true){
		fav_color=document.getElementById('fav');
		fav_color.style.backgroundColor="pink";
		judge=false;

	/** 色がピンクの状態でもう一度押すと白になる
	}else{
		fav_color=document.getElementById('fav');
		fav_color.style.backgroundColor=white;
		judge=true;
	*/
	}


}



var log=document.getElementById('comment').value;
if(log===null){
	document.getElementById('comment').setAttribute("disabled");
}else{
	document.getElementById('comment').removeAttribute("disabled");
}