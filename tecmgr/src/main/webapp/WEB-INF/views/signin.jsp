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
<div style="text-align: center;">
<h6><font face="楷体" color="pink" >如有问题请先查看<a target="_blank" href="<%=request.getContextPath()%>/resources/page/help.htm" style="color:red;text-decoration: underline;">帮助文档</a></font></h6>

</div>

	<div style="width: 30%;height:auto;margin: 9% auto;">
	<div class="row">
	<div class="large-12 columns" style="text-align: center;">
	<h1><font face="楷体" color="white">太原成成中学</font></h1>
	<h2><font face="楷体" color="white">教师成长记录系统</font></h2>
	</div>
	</div>
		<form action="<%=request.getContextPath() %>/signin" method="post" name="signin">
	        <font style="color: red;"><%=request.getAttribute("tips")==null?"": request.getAttribute("tips")%></font>
	        <div class="row">
	            <label class="label">身份证号码</label>
	            <input type="text" placeholder="请输入身份证号码" name="teacherid" id="teacherid" onchange="isExist(this.value)" value="<%= request.getParameter("teacherid")==null?"":request.getParameter("teacherid")%>">
	        </div>
	        <div class="row">
	            <label class="label">密码</label>
	            <input type="password" placeholder="请输入密码" name="password" id="p1" onkeydown="javascript: if(event.keyCode==13) sign();">
	        </div>
	        <div class="row">
	            <a class="small button large-4 columns" onclick="sign()">登录</a>
	            <a class="small button large-4 columns" onclick="reset()">清空</a>
	            <a class="small button large-4 columns" href="<%=request.getContextPath()%>/sign/signup">注册</a>
	        </div>
	</form>
</div>
<div style="text-align: center;">
<h6><font face="楷体" color="pink" >如果还有问题无法解决请及时联系信息中心 ！申老师   TEL：15536660688 小袁  QQ：2022593664 TEL：15619388806</font></h6>
 </div>
 <script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
  <script type="text/javascript">var basepath="<%=request.getContextPath()%>";</script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/pagejs/signin.js"></script>
</body>
</html>