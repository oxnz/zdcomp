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
			<h2>获奖作品一览</h2>
		</div>
		<div id="works">
		<br />
			
			<h2>第一名</h2>
			<a name="1st"></a>
			<img src="images/works/work1.png" alt="小小工具箱"></img>
			
			<ul>
				
				<li>小小工具箱</li>
				<li>团队：L.T.L</li>
				<li>队长：梁锐军</li> 
				<li>队员：梁明礼  唐嘉琦</li>
				<li>学校：北京师范大学珠海分校</li>
				<li><a href="Download.do?address=archives/toolbox.apk" title="小小工具箱">下载</a></li>
				
			</ul>
			<p style="clear:both;"></p>
			<h2>第二名</h2>
			<a name="2nd"></a>
			<img src="images/works/work2.png" alt="城市剪影"></img>
			<ul>
				<li>城市剪影</li>
				<li>团队：D&amp;C</li>
				<li>队长：蒋晶政</li> 
				<li>研发：李熊志  李瑞辉</li>
				<li>UI:李晓阳 周静 </li>
				<li>学校:湖南大学</li>
				<li><a href="Download.do?address=archives/ZDClock.apk" title="城市剪影">下载</a></li>
			</ul>
			<p style="clear:both;"></p>
			
			<h2>第三名</h2>
			<a name="3rd"></a>
			<img src="images/works/work3.png" alt="海绵里的水"></img>
			<ul>
				<li>海绵里的水</li>
				<li>团队：河西style</li>
				<li>队长：肖欢</li> 
				<li>研发：杨文理、王博</li>
				<li>ＵＩ：闫伟丹、徐轶钦</li>
				<li>学校：湖南大学</li>
				<li><a href="Download.do?address=archives/water.apk" title="海绵里的水">下载</a></li>	
			</ul>
		<p style="clear:both;"></p>
		<br />
		<a name="4th"></a>
		<img src="images/works/work4.png" alt="课程表"></img>
		<ul>
			<li>课程表</li>
			<li>团队：The Team</li>
			<li>队长：王文品</li> 
			<li>研发：熊光裕</li>
			<li>ＵＩ：李自奋</li>
			<li>学校：武汉大学</li>
			<li><a href="Download.do?address=archives/table.apk" title="课程表">下载</a></li>
		</ul>
		
		<p style="clear:both;"></p>
		<br />
		<a name="5th"></a>
		<img src="images/works/work5.jpg" alt="武大讲座通"></img>
		<ul>
		<li>武大讲座通</li>
		<li>团队：Insomnia</li>
		<li>队长：文俊杰</li> 
		<li>队员：高萌 姚亚宇 王程歆</li>
		<li>学校：武汉大学</li>
				<li><a href="Download.do?address=archives/whu.apk" title="武大讲座通">下载</a></li>
		</ul>
		<p style="clear:both;"></p>
		<h2>优秀奖</h2>
		<a name="6th"></a>
		<img src="images/works/work6.png" alt="微点评"></img>
		<ul>
			<li>微点评</li>
			<li>团队：Sidt</li>
			<li>队长：王德浩 </li> 
			<li>队员：王军 秦可晨 </li>
			<li>学校：武汉大学</li>
			<li><a href="Download.do?address=archives/whu.apk" title="微点评">下载</a></li>
		</ul>
		<p style="clear:both;"></p><br />
		<a name="7th"></a>
		<img src="images/works/work7.png" alt="猪猪存钱提醒"></img>
		<ul>
			<li>猪猪存钱提醒</li>
			<li>团队：SHMILY团队</li>
			<li>队长：贾燚超 </li> 
			<li>队员：李思琦 戴忆如  陈泽昊</li>
			<li>学校：武汉大学</li>
			<li><a href="Download.do?address=archives/AccoutRecord.apk" title="猪猪存钱提醒">下载</a></li>
		</ul>
		<p style="clear:both;"></p><br />
		<a name="8th"></a>
		<img src="images/works/work8.png" alt="上课啦闹钟"></img>
		<ul>
			<li>上课啦闹钟</li>
			<li>团队：中国好正点</li>
			<li>队长：陈玉玲 </li> 
			<li>队员：吴国邦，周贺，汤文兵</li>
			<li>学校：武汉大学</li>
			<li><a href="Download.do?address=archives/Alarmfinal.apk" title="上课啦闹钟">下载</a></li>
		
		</ul>
		<p style="clear:both;"></p><br />
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
				<input type="hidden" name="before_page" value="Index.do"/>
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