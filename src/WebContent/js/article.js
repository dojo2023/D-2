/**
 *
 */
/*いいねボタンを押したら色が変わる */

var judge=true;
var fav_color;




/**document.getElementById('fav_form').onsubmit=function()  */
document.getElementById("btnfav").addEventListener("click", function(){

	var formD=document.getElementById("fav_form");
	var Data=new FromData(formD);

	var send=new XMLHttpRequest();

	if(judge===true){
		fav_color=document.getElementById('fav');
		fav_color.style.backgroundColor="pink";
		judge=false;

		Data.append("favs",1);
		send.send(Data);




		/**下を動かす場合この一文を削除 */
		document.getElementById('fav').setAttribute("disabled");

	/** 色がピンクの状態でもう一度押すと白になる
	}else{
		fav_color=document.getElementById('fav');
		fav_color.style.backgroundColor=white;
		judge=true;
		document.getElementById('fav').removeAttribute("disabled");
	*/
	}


})

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