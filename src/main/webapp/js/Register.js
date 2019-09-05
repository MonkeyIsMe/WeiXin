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
					if(data == "Fail"){
						alert("没有发送成功！");
					}
					else{
						alert("已发送验证码！");
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
									user_phone:phone,
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