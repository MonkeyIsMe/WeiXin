$(function(){
	$.ajaxSettings.async = false;
    
    $.post(
            "QueryAllCompany.action",
            {
            	
            },
            function(data) {
            	var data = JSON.parse(data);
            	for(var i = 0; i < data.length; i ++){
            		$("#select_company").append("<option value="+data[i].companyName +">"+data[i].companyName+"</option>");
            	}
            }
    );
    
    $.post(
            "QueryAllRole.action",
            {
            	
            },
            function(data) {
            	var data = JSON.parse(data);
            	for(var i = 0; i < data.length; i ++){
            		$("#select_role").append("<option value="+data[i].roleName +">"+data[i].roleName+"</option>");
            	}
            }
    );
	
});