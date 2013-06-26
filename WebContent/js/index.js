//index.js
$(document).ready(function(){
	var login = false;
	if (login === false) {
		$("#nav").css("margin","20px 0 20px 80px");
		$("#nav").css("padding-left","50px");
	} else {
		$("a#register").hide();
		$("#nav").css("margin","20px 0 20px 160px");
		$("#nav").css("padding-left","0");
	}
	
	$("div.cover").css("width", $(document).width());
	$("div.cover").css("height", $(document).height());
	$("div.cover").css("opacity", 0.5);
	$("a#tologin").click(function(){
		var width = $(document).scrollLeft();
		var height = $(document).scrollTop();
		var top = $(window).height()/2 + height - 
					$("#login").height()/2;
		var left = $(window).width()/2 + width - 
					$("#login").width()/2;
		$("#login").css("top",top);
		$("#login").css("left",left);
		$("#login").css("z-index",2);
		$("div.cover").show();
		$("#login").show();
	});
	$("a#close").click(function(){
		$("#login").hide();
		$("div.cover").hide();
	});
	
	//官方邀请码
	var f = "null";
	$("input[name=code]").val("仅限评委填写，普通用户请勿输入");
	$("input[name=code]").css("color", "#999999");
	$("input[name=code]").focus(function(){
		$("input[name=code]").val("");
		$("input[name=code]").css("color", "#000000");
	});
	$("input[name=code]").blur(function(){
		f = $("input[name=code]").val();
		if (f.length==0){
			f="null";
			$("input[name=code]").val("仅限评委填写，普通用户请勿输入");
			$("input[name=code]").css("color", "#999999");
		}
	});
	if (f!="null"){	
		//官方人员
		$("#reg_form img").show();
		$().get("Register.do", {security: f}, function(data){
			$("#reg_form img").hide();
			$("#reg_form img").add("<p>"+data+"</p>").appendTo("li#security");
		});
	}	
	
	$("#reg_form button").click(function(){
		var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$"; 
		var re = new RegExp(regu); 
		var a = "@";
		var b = $("input[name=email]").val();
		var c = $("input#pass").val();
		var d = $("input#pass1").val();
		var e = $("input[name=nickname]").val();
		var e1 = $("input[name=qq]").val();
		var g = $("input[name=security]").val();
		if(e.length==0){	
			alert("请输入您的昵称");
			return false;
		}
		else if(!re.test(e)){		
			alert("用户名只允许为英文，数字和汉字的混合,\n请检查是否前后有空格或者其他符号"); 
			return false; 
		}  
		if(b.length==0){
			alert("邮箱不能为空");
			return false;
		}
		else if(b.indexOf(a)<0){
			alert("请输入正确的E-mail格式");
			return false;
		}
		if(c.length==0){	
			alert("密码不能为空");
			return false;
		}
		else if(c.length>16){
			alert("密码长度不能大于十六位");
			return false;
		}
		else if(c.length<4){	
			alert("密码长度不能小于四位");
			return false;
		}
		if(d.length==0){	
			alert("请再输一遍密码");
			return false;
		}
		else if(c!==d){
			alert("请确认您第二次输入的密码");
			return false;
		}
		if(e1.length==0){	
			alert("请输入QQ号");
			return false;
		}
		if(f=="null"){	
			$("input[name=code]").val("null");
		}	
		if(g.length==0){	
			alert("请输入验证码");
			return false;
		}
		return true;
	});
	
	$("#com textarea").keydown(function(){
		var val = $("#com textarea").val();
		if (val.length >= 100){
			if (event.keyCode > 47 && event.keyCode < 91 || event.keyCode == 32
					|| /^[\u4e00-\u9fa5]+$/.test(val)){
				alert("评论字数不能超过100字");
			}
		}
	});

});