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
				user_number:account,
			},
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				if(data == "Fail"){
					flag = 1;
				}
				else{
					alert("用户已经存在");
				}
			}
	);
	
	if(flag == 1){
		
		$.post(
				"UserIsExist.action",
				{
					user_number:account,
					user_phone:phone,
					code:code,
					user_role:select_role,
					user_company:select_company,
					user_name:name,
					user_password:pwd,
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					alert("注册成功！");
				}
		);
	}
}