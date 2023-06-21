/**
 *
 */
"use strict"

function previewImage1(event) {
	         var reader = new FileReader();
	         reader.onload = function() {
	             var preview = document.getElementById('img1-preview');
	             preview.src = reader.result;
	         };
	         reader.readAsDataURL(event.target.files[0]);
	     }
		function previewImage2(event) {
	         var reader = new FileReader();
	         reader.onload = function() {
	             var preview = document.getElementById('img2-preview');
	             preview.src = reader.result;
	         };
	         reader.readAsDataURL(event.target.files[0]);
	     }
		function previewImage3(event) {
	         var reader = new FileReader();
	         reader.onload = function() {
	             var preview = document.getElementById('img3-preview');
	             preview.src = reader.result;
	         };
	         reader.readAsDataURL(event.target.files[0]);
	     }
 document.getElementById("addimg2").onclick=function(){
 	document.getElementById("img2").setAttribute("type","file");
 	document.getElementById("addimg3").setAttribute("type","button");
 }

 document.getElementById("addimg3").onclick=function(){
 	document.getElementById("img3").setAttribute("type","file");
 }


/**文字数カウント */
function counter (target, result) {
  var len = document.getElementById(target).value.length;
  document.getElementById(result).innerText = len;
}

/*以下、post用に直す必要あり*/

/**テキスト処理用変数*/
let name='';
let text='';
let name_red;
let text_red;
/** タグ処理用変数*/
let checkbox=document.getElementsByClassName("tag");
let count=0;
let pulldown='';

	document.getElementById('form').onsubmit=function(event){
	/**テキスト未入力処理 */
	name=document.getElementById('form').article_title.value;
	text=document.getElementById('form').article_text.value;
	if(name===''){
        document.getElementById('output1').textContent='記事のタイトルを入力してください';
        name_red=document.getElementById('article_title');
		name_red.style.outline="3px red solid";
		event.preventDefault();
	}
	if(text===''){
		document.getElementById('output2').textContent='記事の本文を入力してください';
		text_red=document.getElementById('article_text');
		text_red.style.outline="3px red solid";
		event.preventDefault();
	}
	/**再度ボタンを押したときに注意書きと外の枠線が消える */
	if(name!==''){
		document.getElementById('output1').textContent=null;
		name_red.style.outline="none";
	}
	if(text!==''){
		document.getElementById('output2').textContent=null;
		text_red.style.outline="none";
	}


	/** 全てのタグから1個以上選択*/
	pulldown=document.getElementById('tag').value;
	for (let i = 0; i < checkbox.length; i++) {
		if (checkbox[i].checked) {
			count++;
		}
	}
	if(pulldown!==''){
		count++;
	}
	if(count===0){
		document.getElementById('outputTag').textContent='タグを一つ以上選択してください';
		event.preventDefault();
	}
}