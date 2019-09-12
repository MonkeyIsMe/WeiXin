function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}

var code = getQueryVariable("code");

function SendCode(){
	var account = $("#account").val();
	
	if(account == "" || account == null){
		alert("输入为空");
	}
	else{
		$.post(
				"SendCode.action",
				{
					user_phone:account,
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "Success"){
						alert("已发送验证码！");
					}
					else{
						alert("没有发送成功！");
					}
				}
				);
	}

}

function login(){
	
	var account = $("#account").val();
	var password = $("#pwd").val();
	if(account == "" || account == null || password == null || password == ""){
		alert("输入为空");
	}
	else{
		$.post(
				"Login.action",
				{
					user_phone:account,
					user_code:password
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "NoUser"){
						alert("用户不存在！");
					}
					else if(data == "NoRegister"){
						alert("未注册，请先注册！");
						var url = "Register.html?code=" + code;
					    window.location.replace(url);
					}
					else if(data == "WrongCode"){
						alert("验证码错误！");
					}
					else if(data == "Success"){
						window.close();
					}
				}
				);
	}

}




$(function(){
	$("#register").click(function(){
	    var url = "Register.html?code=" + code;
    window.location.replace(url);
})
	
});