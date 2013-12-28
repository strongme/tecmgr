$(function() {
	var h = parseInt(document.body.clientHeight);
	$('#contact').css('top',h);
});

function sign() {
	if(checkform()) {
		document.forms['signin'].submit();
	}else {
		alert('请填写编号和密码');
	}
}

function reset() {
	document.forms['signin'].reset();
}

function checkform() {
	var teacherid  = document.getElementById('teacherid').value;
	var p1 = document.getElementById('p1').value;
	if(teacherid&&p1) {
		return true;
	}else{
		return false;
	}
}

function isExist(teacherid) {
	if(!teacherid)return;
	$.post(
			basepath+'/isExist',
			{teacherid:teacherid},
			function(data,status) {
				if(!data) {
					alert('教职工编号"'+teacherid+'"不存在');
					document.getElementById('teacherid').value = '';
					$('#teacherid').focus();
				}
			},'json'
	);
}