/**
 community_createで使用
 */
/**文字数カウント */
function counter (target, result) {
  var len = document.getElementById(target).value.length;
  document.getElementById(result).innerText = len;
}


/**テキスト処理用変数*/
let name='';
let summary='';
let name_red;
let summary_red;
/** タグ処理用変数*/
let checkbox=document.getElementsByClassName("tag");
let count=0;
let pulldown='';

	document.getElementById('form').onsubmit=function(event){
	/**テキスト未入力処理 */
	name=document.getElementById('form').community_name.value;
	summary=document.getElementById('form').community_summary.value;
	if(name===''){
        document.getElementById('output1').textContent='コミュニティ名を入力してください';
        name_red=document.getElementById('community_name');
		name_red.style.outline="3px red solid";
		event.preventDefault();
	}
	if(summary===''){
		document.getElementById('output2').textContent='概要を入力してください';
		summary_red=document.getElementById('community_summary');
		summary_red.style.outline="3px red solid";
		event.preventDefault();
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


