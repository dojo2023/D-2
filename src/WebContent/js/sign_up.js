window.onload = function (){
document.getElementById('su_form').onsubmit = function(event) {
	var langCheck = document.getElementsByName('language');
	var langChecked = false;
	for (let i=0; i<langCheck.length; i++) {
		if (langCheck[i].checked) {
			langChecked = true;
			break;
		}
	}
	var purpCheck = document.getElementsByName('purpose');
	var purpChecked = false;
	for (let i=0; i<purpCheck.length; i++) {
		if (purpCheck[i].checked) {
			purpChecked = true;
			break;
		}
	}
	var certCheck = document.getElementsByName('certification');
	var certChecked = false;
	for (let i=0; i<certCheck.length; i++) {
		if (certCheck[i].checked) {
			certChecked = true;
			break;
		}
	}
	document.getElementById('user_id').style.outline = 'none';
	document.getElementById('userid_error').textContent = '';
	document.getElementById('pw_first').style.outline = 'none';
	document.getElementById('password_error').textContent = '';
	document.getElementById('password').style.outline = 'none';
	document.getElementById('password_confirm_error').textContent = '';
	document.getElementById('user_name').style.outline = 'none';
	document.getElementById('username_error').textContent = '';
	document.getElementById('language_error').textContent = '';
	document.getElementById('purpose_error').textContent = '';
	document.getElementById('certification_error').textContent = '';
	if (!Boolean(suForm.userid.value && suForm.pw_first.value && suForm.password.value &&
		suForm.username.value && langChecked && purpChecked && certChecked)) {
		if (!suForm.userid.value) {
			document.getElementById('user_id').style.outline = '3px solid red';
			document.getElementById('userid_error').textContent = '必須項目です';
		}
		if (!suForm.pw_first.value) {
			document.getElementById('pw_first').style.outline = '3px solid red';
			document.getElementById('password_error').textContent = '必須項目です';
		}
		if (!suForm.password.value) {
			document.getElementById('password').style.outline = '3px solid red';
			document.getElementById('password_confirm_error').textContent = '必須項目です';
		}
		if (!suForm.username.value) {
			document.getElementById('user_name').style.outline = '3px solid red';
			document.getElementById('username_error').textContent = '必須項目です';
		}
		if (!langChecked) {
			document.getElementById('language_error').textContent = '1つ以上選択してください';
		}
		if (!purpChecked) {
			document.getElementById('purpose_error').textContent = '1つ以上選択してください';
		}
		if (!certChecked) {
			document.getElementById('certification_error').textContent = '1つ以上選択してください';
		}
		return false;

	} else if (suForm.pw_first.value != suForm.password.value) {
		document.getElementById('password').style.outline = '3px solid red';
		document.getElementById('password_confirm_error').textContent = 'パスワードが一致していません';
		return false;
	} else {
		return true;
	}
}
}