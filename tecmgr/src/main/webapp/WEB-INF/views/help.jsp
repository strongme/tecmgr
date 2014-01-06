<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> 				 <html class="no-js lt-ie9" data-ng-app="tecmgrApp"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" data-ng-app="tecmgrApp"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>帮助页面</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation-datepicker.css">
  <script src="<%=request.getContextPath() %>/resources/vendor/custom.modernizr.js"></script>
  <style type="text/css">
  body{
  background-image: url("<%=request.getContextPath()%>/resources/images/ecailles.png");
  	background-color: rgba(0,0,0,0.05);
  }
  </style>
</head>
<body>
<div style="width: 80%;margin: 30px auto;">
	<h2 style="text-align: center;">太原成成中学“教师成长记录系统”使用说明</h2>
	<h5 style="text-align: center;">如果有问题无法解决请及时联系信息中心 ！申建强老师 TEL：15536660688 袁子茜 QQ：2022593664 TEL：15619388806</h5>
	<hr/>
	<div style="position: inherit;width: 90%;margin: 10px auto;">
		<ul style="list-style: none;">
			<li><b>第一步：注册登陆</b></li>
			<li>注册成功后自动登入“教师成长记录系统”。再次登陆只需输入身份证号码和密码即可。</li>
			<li><b>第二步：信息录入</b></li>
			<li>点击 --> 基本情况-->基本信息后，呈现的是预览界面，点击页面右上角的“编辑”即可进行信息的录入与修改。</li>
			<li><b>第三步：预览</b></li>
			<li>[特别注意]需要任意点击一下其他项目再点击刚录入信息的那个项目才可以正常预览，否则刚录入的信息不予显示。如果总体预览中有未显示的项目，请重新填写，直至预览显示完整即可。</li>
			
		</ul>
	</div>
	
</div>

    
    
  <script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script type="text/javascript">var basepath="<%=request.getContextPath()%>";</script>
  <script type="text/javascript">
  $(document).foundation();
  </script>
</body>
</html>

