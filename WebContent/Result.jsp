<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String einfo=request.getParameter("info").trim();
String topage=request.getParameter("page");
String info="";
if(einfo.equals("pwdwrong")){
	info="密码错误，请重新输入！";
}else if(einfo.equals("regsuccess")){
	info="注册成功！";
}else if(einfo.equals("regfailed")){
	info="注册失败";
}else if(einfo.equals("regemail")){
	info="该邮箱已经被注册，请重新输入";
}else if(einfo.equals("securityfail")){
	info="验证码输入错误，请重新输入！";
}else if(einfo.equals("unlogged")){
	info="您还没有登录，请先登录！";
}else if(einfo.equals("nullemailpwd")){
	info="请输入正确的邮箱和密码";
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="form" action="<%=topage %>" method="post" />
    	<script type="text/javascript">
    		alert("<%=info%>");
    		form.submit();
    	</script>
  </body>
</html>
