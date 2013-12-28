<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> 				 <html class="no-js lt-ie9" data-ng-app="tecmgrApp"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" data-ng-app="tecmgrApp"> <!--<![endif]-->
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
<title>注册</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation.css">
  <script src="<%=request.getContextPath() %>/resources/vendor/custom.modernizr.js"></script>
    <style type="text/css">
   body{
  	background-image: url("<%=request.getContextPath()%>/resources/images/navy_blue.png");
  }
 </style>
</head>
<body>
<div style="text-align: center;">
<h6><font face="楷体" color="pink" >如有问题请及时联系信息中心 ！申老师   TEL：15536660688 小袁  QQ：2022593664 TEL：15619388806</font></h6>
</div>
<div style="width: 30%;height: auto;margin:5% auto;">
		<form action="<%=request.getContextPath() %>/signup" method="post" name="signup">
	        <div class="row">
	            <label class="label">身份证号码</label>
	            <input type="text" placeholder="输入后请仔细核对身份证号码" name="teacherid" id="teacherid" onchange="isExist(this.value)">
	        </div>
	        <div class="row">
	            <label class="label">密码</label>
	            <input type="password" placeholder="请输入密码" name="password" id="p1">
	            <input type="password" placeholder="请再次输入密码" id="p2">
	        </div>
	        <div class="row">
	            <label class="label">教职工姓名</label>
	            <input type="text" placeholder="请输入教职工姓名" name="teachername" id="teachername">
	        </div>
	        <div class="row">
	            <label class="label">部门名称</label>
	            <select name="departmentname" id="departmentname">
	            </select>
	        </div>
	        <h5><font face="楷体" color="red" >注册成功无法修改，请牢记您的身份证号和密码！</font></h5>
	        <div class="row">
	            <a class="small button large-4 columns" onclick="sign()">注册</a>
	            <a class="small button large-4 columns" onclick="reset()">清空</a>
	            <a class="small button large-4 columns" href="<%=request.getContextPath()%>/sign/signin">登录</a>
	        </div>
	</form>
</div>

   <script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
  <script type="text/javascript">var basepath="<%=request.getContextPath()%>";</script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/pagejs/signup.js"></script>
</body>
</html>