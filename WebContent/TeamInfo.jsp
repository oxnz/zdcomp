<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,entity.Work" pageEncoding="utf-8"%>

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
	
	<script type="text/javascript">
							function refresh(){
								var img=document.getElementById("img_validation");
								img.src="Validation.do?"+Math.random();
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
			<h2>作品信息</h2>
		</div>
		<div id="main">
			<div id="teaminfo">
				<img src="${requestScope.work.logo }" alt="" />
				<ul>
					<li>队伍名称：<span id="teamname">${requestScope.team.team_name }</span></li>
					<li>队长：<span id="teamleader">${requestScope.team.leader_name }</span></li>
					<!-- <li>队员：<span id="teammates"></span></li> -->
					<li>下载链接：<a href="Download.do?address=${requestScope.work.address }&&work_id=${requestScope.work.work_id}" title="">请点击此处下载</a></li>
					<li>下载量：<span id="downloads">${requestScope.work.downloads }</span></li>
					<li>粉丝数：<span id="sup_num">${requestScope.voteCount }</span></li>
				</ul>
				<ul id="interact">
					<li>
						<a id="support" href="Vote.do?work_id=${requestScope.work.work_id }" title="顶"></a>
					</li>
					<li>
						<a id="comment" href="#com" title="评论"></a>
					</li>
					<li>
						<a id="teamintro" href="ShowMembers.do?team_id=${requestScope.team.team_id }&&team_name=${requestScope.team.team_name}" title="队伍详细信息"></a>
					</li>
				</ul>
			</div>
			<div id="swinfo" class="clear">
				<h2>软件功能介绍：</h2><br/>
				<p>${requestScope.work.introduction} </p>
			</div>
			<div id="swpics">
				<h2>软件截图：</h2>
				<ul>
					<li><img src="${requestScope.work.pic1 }" alt="" /></li>
					<li><img src="${requestScope.work.pic2 }" alt="" /></li>
					<li><img src="${requestScope.work.pic3 }" alt="" /></li>
					<c:if test="${requestScope.work.pic4!='null'}">
					<li><img src="${requestScope.work.pic4 }" alt="" /></li>
					</c:if>
					<c:if test="${requestScope.work.pic5!='null'}">
					<li><img src="${requestScope.work.pic5 }" alt="" /></li>
					</c:if>
				</ul>
			</div>
				<div id="offcomments">
					<h2>官方评论：</h2>
					<ul class="comment">
						<c:forEach var="offReply" varStatus="i" items="${requestScope.officialReply}">
							<li>
							<table>
							<tr>
								<td width="50"><span><h3>${i.index+1}楼</h3></span></td>
								<td>
									<span class="nickname">${offReply.nickname } </span>
									<span class="time">${offReply.reply_time }</span>		
								</td>
							</tr>
							<tr>
								<td></td>
								<td><p>${offReply.content }</p></td>
							</tr>
							</table>
							</li>
						</c:forEach>
					</ul>				
				</div>
				<div id="fanscomments">
					<h2>粉丝评论：</h2>
					<ul class="comment">
						<c:forEach var="norReply" varStatus="i" items="${requestScope.normalReply}">
							<li>
							<table>
							<tr>
								<td width="50"><span><h3>${i.index+1}楼</h3></span></td>
								<td>
									<span class="nickname">${norReply.nickname } </span>
									<span class="time">${norReply.reply_time }</span>		
								</td>
							</tr>
							<tr>
								<td></td>
								<td><p>${norReply.content }</p></td>
							</tr>
							</table>
							</li>	
						</c:forEach>
					</ul>				
				</div>
		</div>
		<h2 id="comments">评论区</h2>
		<c:set var="user" value="${sessionScope.login_user}" scope="page" ></c:set>
		<c:if test="${user.user_type==2}">
		<form id="score" action="Remark.do" method="post">
		<input type="hidden" name="work_id" value="${requestScope.work.work_id }"/>
			<p>评分：
				<select name="score">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
				<button type="submit" type>评分</button>
			</p>
		</form>
		</c:if>
		<form id="com" action="Reply.do" method="post">
			<input type="hidden" name="work_id" value="${requestScope.work.work_id }"/>
			<textarea rows="6" cols="70" name="content"></textarea>
			<label for="security">验证码：</label>
			<input type="text" name="security"/>
			<img alt="" src="Validation.do" id="img_validation" />
			<a onClick="refresh()">看不清换一个</a>
			<button type="submit">提交</button>
		</form>
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
				<input type="hidden" name="before_page" value="WorkDetail.do?work_id=${requestScope.work.work_id}"/>
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