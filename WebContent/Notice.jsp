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
			<h2>比赛结果</h2>
		</div>
		<br />
		<div id="result">
		<table border="1">
		
		<thead>
		<tr>
		<th>排名</th>
		<th>团队</th>
		<th>队长</th>
		<th>研发</th>
		<th>UI</th>
		<th>学校</th>
		<th>作品</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<th>第一名</th>
		<th>L.T.L</th>	
		<th>梁锐军</th>
		<th colspan=2>梁明礼 唐嘉琦</th>
		<th>北京师范大学珠海分校</th>
		<th><a href="Compshow.jsp#1st">小小工具箱</a></th>
		
		</tr>
		<tr>
		<th>第二名</th>
		<th>D&amp;C</th>
		<th>蒋晶政</th>
		<th>李熊志 李瑞辉</th>
		<th>李晓阳 周静</th>
		<th>湖南大学</th>
		<th><a href="Compshow.jsp#2nd">城市剪影</a></th>
		</tr>
		<tr>
		<th rowspan=3>第三名</th>
		<th>河西style</th>
		<th>肖欢</th>
		<th>杨文理、王博</th>
		<th>闫伟丹、徐轶钦</th>
		<th>湖南大学</th>
		<th><a href="Compshow.jsp#3rd">海绵里的水</a></th>
		</tr>
		<tr>
		<th>The Team</th>
		<th>王文品</th>
		<th>熊光裕</th>
		<th>李自奋</th>
		<th>武汉大学</th>
		<th><a href="Compshow.jsp#4th">课程表</a></th>
		</tr>
		<tr>
		<th>Insomnia</th>
		<th>文俊杰</th>
		<th colspan=2>高萌 姚亚宇 王程歆</th>
		<th>武汉大学</th>
		<th><a href="Compshow.jsp#5th">武大讲座通</a></th>
		</tr>
		<tr>
		<th rowspan=3>优秀奖</th>
		<th>Sidt</th>
		<th>王德浩 </th>
		<th colspan=2>王军 秦可晨 </th>
		<th>武汉大学</th>
		<th><a href="Compshow.jsp#6th">微点评</a></th>
		</tr>
		<tr>
		<th>SHMILY团队</th>
		<th>贾燚超 </th>
		<th colspan=2>李思琦 戴忆如 陈泽昊</th>
		<th>武汉大学</th>
		<th><a href="Compshow.jsp#7th">猪猪存钱提醒</a></th>
		</tr>
		<tr>
		<th>中国好正点</th>
		<th>陈玉玲 </th>
		<th colspan=2>吴国邦，周贺，汤文兵</th>
		<th>武汉大学</th>
		<th><a href="Compshow.jsp#8th">上课啦闹钟</a></th>
		
		</tr>
		</tbody>
		<tfoot>
		<tr>
		<th>备注:</th>
		<th colspan=6>察看作品详情，请点击右侧作品名称</th>
		</tr>
		</tfoot>
		</table>
		<br />
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