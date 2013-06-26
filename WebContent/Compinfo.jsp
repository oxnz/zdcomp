<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	 <base href="<%=basePath%>">
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
			<h2>比赛详情</h2>
		</div>
		<div id="lefttopheader">
		<p><b>比赛要求</b></p>
		</div>
		<div id="lefttop">
			<p><b>app类题目要求：</b></p>
			<ul>
			<li>完成具有独立功能，可在安卓平台上正常运行的的应用或插件。</li>
		    <li>插件应具有完整的设源代码，UI设计图和使用说明文档。</li>
		    <li>提醒类和工具类插件，如需要利用正点官方产品接口，可发邮件申请索要API使用文档。</li>
		    </ul>
		    <p><b>比赛形式：</b></p>
		    <ul>
		    <li>以小组形式参加，以小组为单位参与评审</li>
		    <li>作品提交：源程序 + 可运行的APK + 操作说明书打包，以附件形式发送至邮箱 game@zdworks.com</li>
		    <li>比赛期间完成作品可随时提交，以最后提交的作品为准。</li>
		    </ul>
		    <p><b>设计类题目要求：</b></p>
			<ul>
			<li>为正点闹钟换肤插件提供皮肤设计稿组图。</li>
		    <li>皮肤设计需参照大赛官网所给图片规格文档，主题不限（动漫，影视，自然风光，中国风等均可）。</li>
		    <li>获得正点艺术家奖的设计作品会录入正点闹钟插件皮肤库。</li>
		    <li>具体要求见附件。</li>
		    </ul>
		    <p><b>比赛形式：</b></p>
		    <ul>
		    <li>以个人形式参加，以个人为单位参与评审。</li>
		    <li>作品提交：将logo + 皮肤图 + 壁纸 打包以附件形式发送至邮箱 game@zdworks.com</li>
		    <li>一人可提交多套皮肤作品，同一邮箱提交多套作品请注明。</li>
		    </ul>
		</div>
		
		
		<div id="righttop">
			<p><b>app类奖项设置：</b></p>
			
		    <ul>
		    <li>一等奖（1名）  ：奖金1024元 + 荣誉证书 +精美纪念品</li>
		   <li>二等奖（1名）：奖金 512元 + 荣誉证书 +精美纪念品 </li>
		    <li>三等奖（3名）：奖金 256元 + 荣誉证书 +精美纪念品</li>
		    <li>优秀奖（10名） ：精美纪念品</li>
		    </ul>
		   
		    <p><b>设计类奖项设置：</b></p>
		    

		    <ul>
		    <li>一等奖（1名）： 奖金500元+荣誉证书+精美纪念品</li>
		    <li>二等奖（3名）： 奖金200元+荣誉证书+精美纪念品</li>
		    <li>优秀奖 （10名）：精美纪念品 </li>
		    </ul>
		   
		    <b>评审说明：</b>
		     <ul>
			<li>评审原则:大赛主要从作品的可运行性、作品的美观性及作品的创新性方面进行考评。</li>
		    <li>评审方式:有正点科技公司专业人员通过作品的可运行性、美观性及创新性等方面对作品进行打分及评价，最终评选出获奖作品。</li>
		    <li>评审组织:邀请正点科技公司专业人员组成评审小组，对作品进行专业评审。</li>
			</ul>
		</div>
		
		<div id="righttopheader">
		<p><b>奖项设置</b></p>
		</div>
		
		
		
	  
			<div id="lefttopheader">
		<p><b>时间及报名</b></p>
		</div>
		<div id="lefttop">
			<p><b>比赛时间：</b></p>
			<ul>
			<li>报名阶段：2012年10月13日9:00-10月27日20：00</li>
		    <li>作品提交阶段：截止至2012年11月26日20:00</li>
		    <li>评审阶段：2012年11月27日9:00-12月7日20:00</li>
		    <li>颁奖时间：2012年12月9日18:00</li>
		    </ul>
		    <p><b>报名方式：</b></p>
		    <ul>
		    <li>步骤一.登陆大赛官方网站 <a href="http://zdcup.zhengdianclub.com">
		    http://zdcup.zhengdianclub.com</a></li>
		    <li>步骤二.确定参赛类别，下载相应报名表并完成，发送报名表至邮箱 game@zdworks.com</li>
		    <li>步骤三.等待审核后收到确认邮件回复，报名成功。</li>
		    <li>设计类比赛可略过报名环节，直接投稿。</li>
		    </ul>
		</div>
		
		
		<div id="righttop">
			<p><b>附件下载：</b></p>
			<ul>
			<li>附件一：<a href="Download.do?address=archives/work1.rar&&work_id=1" title="">比赛报名表</a></li>
			<li>附件二：<a href="Download.do?address=archives/work2.rar&&work_id=2" title="">大赛说明文档</a></li>
			<li>附件三：<a href="Download.do?address=archives/work3.rar&&work_id=3" title="">设计说明</a></li>
			</ul>
			<br></br>
		</div>
		
		<div id="righttopheader">
		<p><b>附件下载</b></p>
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