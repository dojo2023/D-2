
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

