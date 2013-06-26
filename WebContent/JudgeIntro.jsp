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
	<script type="text/javascript" src="js/cufon-yui.js"></script>  
	<script type="text/javascript" src="js/Vegur_400-Vegur_700.font.js"></script>  
	<script type="text/javascript">  
		Cufon.replace('h1');  
		Cufon.replace('h2'); 
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
			<h2>评委信息</h2>
		</div>
		<div id="main">
			<ul id="judges">
				<li class="judeges">
					<img src="images/judges/ChuYongjin.JPG" alt="邹勇进" />
					<ul>
						<li>姓名：邹勇进</li>
						<li>公司职位：技术总监（服务端）</li>
						<li>邮箱：zouyongjin@zdworks.com</li>
					</ul>
				</li>
				<li class="judeges">
					<img src="images/judges/DuShengjun.JPG" alt="杜生军" />
					<ul>
						<li>姓名：杜生军</li>
						<li>公司职位：技术总监（Android）</li>
						<li>邮箱：dushengjun@zdworks.com</li>
					</ul>
				</li>
				<li class="judeges">
					<img src="images/judges/FengBin.JPG" alt="冯斌" />
					<ul>
						<li>姓名：冯斌</li>
						<li>公司职位：项目经理（ios）</li>
						<li>邮箱：fengbin@zdworks.com</li>
					</ul>
				</li>
				<li class="judeges">
					<img src="images/judges/TaoShaoning.JPG" alt="陶少宁" />
					<ul>
						<li>姓名：陶少宁</li>
						<li>公司职位：设计总监</li>
						<li>邮箱：taoshaoning@zdworks.com</li>
					</ul>
				</li>
			</ul>
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
					<input type="hidden" name="before_page" value="JudgeIntro.do"/>
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