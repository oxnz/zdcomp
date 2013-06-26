<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
	<title>“正点杯”移动互联网创新应用大赛</title>
	<meta name="keywords" content="“正点杯”移动互联网创新应用大赛，正点杯，正点，开发比赛，软件开发"/>
	<meta name="description" content="“正点杯”移动互联网创新应用大赛"/>
	<link href="css/reset.css" rel="stylesheet" type="text/css"/>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/index.js"></script>
	
		<script type="text/javascript">
							function refresh(){
								var img=document.getElementById("img_validation");
								img.src="Validation.do?"+Math.random();
							}
		</script>	
		
		
		
		<script type="text/javascript">

	function register(){
		var username = $('#username').val();//用户名	
		var patusername=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;//用户名的正则表达式
		
		var email = $('#email').val();//邮箱
		var patemail=/^[a-z0-9]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$/i;//邮箱的正则表达式
		
		var password = $('#password').val();//密码
		var repassword = $('#repassword').val();//确认密码
		var patpassword=/^(\w){6,20}$/; //密码的正则表达式
		
		
		var qq = $('#qq').val();//qq号
		var patqq = /^\d{5,10}$/; //qq号的正则表达式

		
		if(username==""){
			alert('用户名不能为空!');
		}else if (!patusername.exec(username)){
			alert('用户名只能输入5-20个以字母开头、可带数字、“_”、“.”的字串！');
		}else if(email==""){
			alert('邮箱不能为空!');
		}else if(!patemail.exec(email)){
			alert('输入的邮箱地址无效！');
		}else if(password==""){
			alert('密码不能为空!');
		}else if(!patpassword.exec(password)){
			alert('密码只能输入6-20个字母、数字、下划线 ！');
		}else if(password!=repassword){
			alert('两次输入的密码不一致！');
		}else if(qq==""){
			alert('QQ不能为空!');
		}else if(!patqq.exec(qq)){
			alert('你输入的qq号错误！');
		}else{
			$("#reg_form").submit();
		}
	}
	
	
	
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<h1>“正点杯”移动互联网创新应用大赛</h1>
			<c:set var="user" value="${sessionScope.login_user}"></c:set>
			<c:choose> 
			<c:when test="${user!=null}">
			<ul id="userinfo">
				<li>欢迎您，</li>
				<li id="h_username">${user.nickname } </li>
				<li><a href="Logout.do" title="Logout">退出</a></li>
			</ul>
			</c:when>
			<c:otherwise>
			<ul id="userinfo">
				<li>您好，</li>
				<li id="h_username"> 游客</li>
				<li><a title="Login" id="tologin">请登录</a></li>
			</ul>
			</c:otherwise>
			</c:choose>
			<ul id="nav">
			<c:choose> 
			<c:when test="${user==null}">
				<li><a href="Register.jsp" title="Register">注册</a></li>
			</c:when>
			</c:choose>
				<li><a href="Index.jsp" title="Homepage">首页</a></li>
				<li><a href="Compinfo.jsp" title="Compinfo">比赛详情</a></li>
				<li><a href="Compshow.jsp" title="Compshow">作品展示</a></li>
				<li><a href="JudgeIntro.jsp" title="JudgesInfo">评委信息</a></li>
				<li><a href="Notice.jsp" title="Notice">比赛结果</a></li>
				<li><a href="http://www.zdworks.com/" title="ZDworks">正点官网</a></li>
			</ul>
			<h2>注册</h2>
		</div>
		<div id="main">
			<form id="reg_form" method="post" action="Register.do">
				<ul>
					<li>
						<label for="username">昵称</label>
						<input type="text" name="username" id="username"/>
						
					</li>
					<li>
						<label for="email">常用邮箱</label>
						<input type="text" name="email" id="email"/>
					</li>
					<li>
						<label for="password">密码</label>
						<input type="password" name="password" id="password"/>
						
					</li>
					<li>
						<label for="repassword">密码确认</label>
						<input type="password" name="repassword" id="repassword"/>
					</li>
					<li>
						<label for="qq">QQ</label>
						<input type="text" name="qq" id="qq"/>
					</li>
					<!--  <li id="security">
						<label for="code">官方邀请码</label>
						<input type="text" name="code"/>
						<img src="images/loading.gif" alt="Checking" id="check" />
					</li>
					<li>
						<label for="security">验证码</label>
						<input type="text" name="security"/>
					</li>
					<li id="validate">
						<img alt="" src="Validation.do" id="img_validation" />
						<a onclick="refresh()">看不清换一个</a>
					</li>-->
					<li class="submit">
						<button type="button" onclick="register()">确认申请</button>
					</li>
				</ul>
			</form>
		</div>
		<div id="footer">
			<p>珠海正点科技有限公司©2012 zdworks.com</p>
			<p>粤ICP备11042499号</p>
		</div>
	</div>
	<div id="login">
		<a id="close" title="close">关闭</a>
		<form method="post" action="Login.do">
			<ul>
				<li>
				<input type="hidden" name="before_page" value="Register.jsp"/>
					<label for="email">邮箱</label>
					<input type="text" name="email" id="email"/>
				</li>
				<li>
					<label for="password">密码</label>
					<input type="password" name="password" id="password"/>
				</li>
				<li>
					<a href="Register.jsp" title="Register">注册</a>
					<button type="submit">确认</button>
				</li>
			</ul>
		</form>
	</div>
	<div class="cover"></div>
</body>
</html>
