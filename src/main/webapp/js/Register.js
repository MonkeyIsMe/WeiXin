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

function Register(){
	
	var account = $("#account").val();
	var password = $("#pwd").val();
	
	
	var flag = 0;
	
	$.post(
			"UserIsExist.action",
			{
				user_phone:account,
			},
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				if(data == "Success"){
						
						$.post(
								"UpdateUser.action",
								{
									ali_code:password,
									user_phone:account,
									code:code,
								},
								function(data){
									data = data.replace(/^\s*/, "").replace(/\s*$/, "");
									if(data == "Fail"){
										alert("用户不存在！");
									}
									else if(data == "WrongCode"){
										alert("验证码错误！");
									}
									else if(data == "Success"){
										alert("注册成功，请返回登录！");
										var url = "Login.html";
									    window.location.replace(url);
										window.close();
									}
								}
						);
				}
				else{
					alert("用户不存在");
				}
			}
			);
	


}