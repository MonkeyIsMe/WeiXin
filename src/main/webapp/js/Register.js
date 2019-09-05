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

function Register(){
	
	var account = $("#account").val();
	var password = $("#pwd").val();
	var name = $("#name").val();
	var phone = $("#phone").val();
	var select_company = $("#select_company option:selected").val();
	var select_role = $("#select_role option:selected").val();
	
	
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
									ali_code:ali_code,
									user_phone:phone,
									code:code,
								},
								function(data){
									data = data.replace(/^\s*/, "").replace(/\s*$/, "");
									alert("注册成功！");
									window.location.replace("Login.html");
								}
						);
				}
				else{
					alert("用户不存在");
				}
			}
			);
	


}