/**
 community_createで使用
 */
/**文字数カウント */
function counter (target, result) {
  var len = document.getElementById(target).value.length;
  document.getElementById(result).innerText = len;
}

/**テキスト未入力処理 */
let name='';
let summary='';
let name_red;
let summary_red;

document.getElementById('form').onsubmit=function(event){
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

}

/** */
