var row = 1;  //页数
var count; //总记录数

var id;

var url = decodeURI(window.location.href);

var argsIndex = url .split("?IntroductionId=");
var IntroductionId = argsIndex[1];

var editor = null;
    


$(function(){
	$.ajaxSettings.async = false;
    //alert(PlanId)
	editor = CKEDITOR.replace("content"); //参数‘content’是textarea元素的name属性值，而非id属性值
	
    $.post(
            "QueryIntroduction.action",
            {
            	introduction_id:IntroductionId,
            },
            function(data) {
            	var data = JSON.parse(data);
            	//console.log(data);
            	editor.setData(data.planInfo);
            	$("#tittle").val(data.planTittle);
            	$('#select_company').find("option[value='"+data.companyName+"']").attr("selected",true);
            }
    );
	
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
    
	
});


function savaData(){

    var content = CKEDITOR.instances.content.getData(); //获取值
	var select_company = $("#select_company option:selected").val();
    var tittle = $("#tittle").val();
    
	  	    $.post(
	            "UpdateIntroduction.action",
	            {
	            	introduction_id:IntroductionId,
	            	introduction_info:content,
	            	introduction_tittle:tittle,
	            	company_name:select_company,
	            },
	            function(data) {
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "Fail"){
						alert("更新介绍失败！");
						window.location.replace("IntroductionManage.html");
					}
					else{
						alert("更新介绍成功!");
						window.location.replace("IntroductionManage.html");
					}
	            }
      );
    
}

function back(){
	window.location.replace("IntroductionManage.html");
}
