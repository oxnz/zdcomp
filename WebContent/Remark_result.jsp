<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Remark_result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <% 
	String topage=request.getParameter("page").trim();
	String einfo=request.getParameter("info").trim();
	String work_id=request.getParameter("work_id").trim();
	String info="";
	if(einfo.equals("remarksuccess")){
		info="您已成功对该作品打分！注：本作品您只能打分一次";
	}else if(einfo.equals("isremarked")){
		info="您已经对该作品打过分了！";
	}else if(einfo.equals("votesuccess")){
		info="投票成功，您还可以投票支持其他作品";
	}else if(einfo.equals("isvoted")){
		info="您已经投过票，不能对同一作品投两票！";
	}else if(einfo.equals("replysuccess")){
		info="评论成功,感谢您的留言";
	}else if(einfo.equals("validationwrong")){
		info="验证码输入错误，请重新输入";
	}else if(einfo.equals("nullinput")){
		info="请输入正确的评论内容和验证码！";
	}else if(einfo.equals("remarkbeforereply")){
		info="您还没有评分，请先对该作品打分！";
	}
  %>
  <body>
    <form name="form" action="<%=topage %>" method="get" />
    	<input type="hidden" name="work_id" value="<%=work_id %>"/>
    	<script type="text/javascript">
    		alert("<%=info%>");
    		form.submit();
    	</script>
  </body>
</html>
