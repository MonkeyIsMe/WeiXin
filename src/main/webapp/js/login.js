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

function login(){
	
	var account = $("#account").val();
	var password = $("#pwd").val();
	
	$.post(
			"Login.action",
			{
				user_number:account,
				user_password:password
			},
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				if(data == "Fail"){
					alert("用户不存在！");
				}
				else if(data == "Wrong"){
					alert("密码错误！");
				}
				else if(data == "Success"){
					window.close();
				}
			}
			);
}



function ToRegister(){
    var url = "Register.html?code=" + code;
    window.location.replace(url);
}