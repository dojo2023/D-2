function check() {
	document.getElementById('id').style.backgroundColor = '#ffffff';
	document.getElementById('pw').style.backgroundColor = '#ffffff';
	if (auth.id.value == '' || auth.pw.value == '') {
		if (auth.id.value == '') {
			document.getElementById('id').style.backgroundColor = '#eebbcb';
		}
		if(auth.pw.value == '') {
			document.getElementById('pw').style.backgroundColor = '#eebbcb';
		}
		return false;
	} else {
		return true;
	}
}