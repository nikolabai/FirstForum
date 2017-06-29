<pre name="code" class="html"><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=basePath%>">
    
   <title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />	
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
    <script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>

	<h1>登录</h1>
	<div class="login-form">
		<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
		<div class="clear"> </div>
		<div class="avtar"><img src="images/avtar.png" /></div>
		<form>			
			<div id="tn"><input type="text"    id="tname" name="username" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入用户名';}"></div>
			<div id="key"><input type="password" id="password" name="password"  onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入密码';}"></div>
		</form>
		<div class="signin"><input type="submit" value="Login" id="btn"></div>
	</div>
	<div class="copy-rights">
		<p>Copyright &copy; 2015.Company name All rights reserved.</p>
	</div>
  </body>
</html>
