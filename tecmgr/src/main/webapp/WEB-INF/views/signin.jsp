<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> 				 <html class="no-js lt-ie9" data-ng-app="tecmgrApp"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" data-ng-app="tecmgrApp"> <!--<![endif]-->
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
<title>登录</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation.css">
  <script src="<%=request.getContextPath() %>/resources/vendor/custom.modernizr.js"></script>
 <style type="text/css">
   body{
  	background-color: rgba(0,0,0,0.05);
  	background-image: url("<%=request.getContextPath()%>/resources/images/navy_blue.png");
  }
 </style>
</head>
<body>
	<div style="width: 30%;height: auto;margin: 15% auto;">
	<div class="row">
	<div class="large-12 columns">
	<h1><font face="楷体" color="white">成成中学教档系统</font></h1>
	</div>
	</div>
		<form action="<%=request.getContextPath() %>/signin" method="post" name="signin">
	        <font style="color: red;"><%=request.getAttribute("tips")==null?"": request.getAttribute("tips")%></font>
	        <div class="row">
	            <label class="label">教职工号</label>
	            <input type="text" placeholder="请输入教职工号码" name="teacherid" id="teacherid" onchange="isExist(this.value)" value="<%= request.getParameter("teacherid")==null?"":request.getParameter("teacherid")%>">
	        </div>
	        <div class="row">
	            <label class="label">密码</label>
	            <input type="password" placeholder="请输入密码" name="password" id="p1">
	        </div>
	        <div class="row">
	            <a class="small button large-4 columns" onclick="sign()">登录</a>
	            <a class="small button large-4 columns" onclick="reset()">清空</a>
	            <a class="small button large-4 columns" href="<%=request.getContextPath()%>/sign/signup">注册</a>
	        </div>
	</form>
</div>
<div style="position: absolute;right: 20px;color: white;filter:alpha(opacity=0.5);font-size: 1px;opacity:0.1;" id="contact">
<ul style="list-style: none;display: inline;">
<li>咨询:袁子茜</li>
<li>QQ:15619388806</li>
<li>手机:15619388806</li>
</ul>
</div>
 <script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
  <script type="text/javascript">var basepath="<%=request.getContextPath()%>";</script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/pagejs/signin.js"></script>
</body>
</html>