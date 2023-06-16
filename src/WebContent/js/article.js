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


/** ログイン状態でコメント欄の活性、非活性*/
/** jspでログイン状態を判別してvalueの値を変える、EL式でif文作って分岐、
	valueにはユーザー名が入る、ログインしてなければnull*/
var log=document.getElementById('comment').value;
if(log===null){
	document.getElementById('comment').setAttribute("disabled");
	document.getElementById('comment').placeholder="ログインしてください";
}else{
	document.getElementById('comment').removeAttribute("disabled");
}