<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  
	<link rel=”icon” href=”/favicon.ico” />
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
				<li><a href="Logout.do">退出</a></li>
			</ul>
			</c:when>
			<c:otherwise>
			<ul id="userinfo">
				<li>您好，</li>
				<li id="h_username"> 游客</li>
				<li><a  title="Login" id="tologin">请登录</a></li>
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
			<h2>比赛简介</h2>
		</div>
		<div id="main">
			<ul id="show">
			
			<li>
			<h3><b>一、比赛背景：</b></h3>
			　　随着智能手机的普及，移动互联网以摧古拉朽之势冲进人们的生活。
			 在可预见的未来，移动互联网和基于智能移动平台的应用将会成为人们最日常生活的一部分。
			 同时，已有大量的精英人才进入移动互联网行业带来一波又一波创新狂潮。
			 各种研发以及设计工具的普及大大降低了开发应用的门槛。只要你有想法，爱生活，
			 各位也能在这个舞台上大显身手。 
			</li>
			
			<li>
			<h3><b>二、比赛意义：</b></h3>
			　　本次“正点杯”移动应用创新大赛分为APP类和设计类两大板块。APP类主要面向安卓平台的应用或插件，
			你可以组队，当然如果你够正点，也可以一个人兼任产品，开发，UI设计。期待你的大作哦~
			如果你热爱设计，是应用发烧友，可惜不会写代码，没关系！
			设计类比赛看过来：主要内容为正点闹钟插件的皮肤创意设计，一经采纳，
			你的皮肤就会被录入用户过千万的正点闹钟的插件皮肤库呢！
			正点给出一片土壤，你用行动来浇灌，让各位的思想在之上开出花！ 
			</li>
			
			<li>
			<table>
			<tr><td><b>三、</b></td><td><b>比赛承办方：</b>武汉大学正点俱乐部、湖南大学正点俱乐部</td></tr>
			<tr><td></td><td><b>赞助商：</b>珠海正点科技有限公司</td></tr>
			</table>
			</li>
			
			<li>
		    <b>四、参赛对象：</b>华中及华南地区高校全体在校学生			 
			</li>
				<!--<c:forEach var="work" varStatus="i" items="${sessionScope.allWorks}">
				<li>
					<a href="WorkDetail.do?work_id=${work.work_id} " title="">
						<img src="${work.logo} " alt="" />
						<p>${work.work_name}  </p>
					</a>
				</li>
				</c:forEach>-->
			</ul>
		</div>
		<div id="footer" class="clear">
			<p>珠海正点科技有限公司©2012 zdworks.com</p>
			<p>粤ICP备11042499号</p>
		</div>
	</div>
	<div id="login">
		<a id="close" title="close">关闭</a>
		<form method="post" action="Login.do">
			<ul>
				<li>
				<input type="hidden" name="before_page" value="Index.jsp"/>
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