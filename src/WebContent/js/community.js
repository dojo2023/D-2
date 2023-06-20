
'use strict'
/** ボタンをクリックして参加者メンバーを表示*/
$(function() {
    $("button").click(function() {
        $(".E").fadeToggle("");
    });
});
/** テキスト未入力の場合、送信不可　*/
 const messageText = document.getElementById('messagetext');
    const messageSubmit = document.getElementById('messagesubmit');
    messageText.addEventListener('keyup', (e) => {
      if (1 <= e.target.value.length) {
        messageSubmit.disabled = false;
      }
})

 const applyTextLimit = () => {
  let maxLength = 55; //上限文字数
  let limitedText = document.getElementById('limited-text');
  let originalText = limitedText.innerText;
  if (originalText.length > maxLength) {
    limitedText.innerText = originalText.substr(0, maxLength) + '...';
  }
}
applyTextLimit();