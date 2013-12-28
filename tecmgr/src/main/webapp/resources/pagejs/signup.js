$(function() {
	initSelDepartment();
	var h = parseInt(document.body.clientHeight);
	$('#contact').css('top',h);
});

function sign() {
	if(checkform()) {
		document.forms['signup'].submit();
	}else {
		alert('信息填写不正确，请重新填写');
	}
}

function reset() {
	document.forms['signup'].reset();
}

function checkform() {
	var teacherid  = document.getElementById('teacherid').value;
	var teachername  = document.getElementById('teachername').value;
	var departmentname  = document.getElementById('departmentname').value;
	var p1 = document.getElementById('p1').value;
	var p2 = document.getElementById('p2').value;
	if(teacherid&&teachername&&departmentname!=-1&&p1&&p2&&p1==p2) {
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
				if(data) {
					alert(teacherid+'已经注册过，可直接登录');
					document.location=basepath+'/sign/signin?teacherid='+teacherid;
				}
			},'json'
	);
}

function initSelDepartment() {
	$.post(
			basepath+'/department/all',
			{},
			function(data,status) {
				if(data) {
					renderDepartment(data);
				}else {
					alert('部门读取失败');
				}
			},'json'
	);
}

function renderDepartment(data) {
	var html = '<option value="-1">请选择部门</option>';
	for(var i=0;i<data.length;i+=1) {
		html += '<option value="'+data[i].departmentName+'">'+data[i].departmentName+'</option>';
	}
	$('#departmentname').html(html);
}