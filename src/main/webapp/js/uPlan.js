var row = 1;  //页数
var count; //总记录数

var id;

var url = decodeURI(window.location.href);

var argsIndex = url .split("?PlanId=");
var PlanId = argsIndex[1];

var editor = null;
    


$(function(){
	$.ajaxSettings.async = false;
    //alert(PlanId)
	editor = CKEDITOR.replace("content"); //参数‘content’是textarea元素的name属性值，而非id属性值
	
    $.post(
            "QueryPlan.action",
            {
            	plan_id:PlanId,
            },
            function(data) {
            	var data = JSON.parse(data);
            	//console.log(data);
            	editor.setData(data.planInfo);
            	$("#tittle").val(data.planTittle);
            	$('#select_company').find("option[value='"+data.companyName+"']").attr("selected",true);
            	$('#select_time').find("option[value='"+data.timeId+"']").attr("selected",true);
            	//console.log(data.timeId);
            	$("#select_time").val(data.timeId); 
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
    
    $.post(
            "QueryAllTime.action",
            {
            	
            },
            function(data) {
            	var data = JSON.parse(data);
            	for(var i = 0; i < data.length; i ++){
            		$("#select_time").append("<option value="+data[i].timeName +">"+data[i].timeName+"</option>");
            	}
            }
    );
	
});


function savaData(){

    var content = CKEDITOR.instances.content.getData(); //获取值
	var select_company = $("#select_company option:selected").val();
	var select_time = $("#select_time option:selected").val();
    var tittle = $("#tittle").val();
    
	  	    $.post(
	            "UpdatePlan.action",
	            {
	            	plan_id:PlanId,
	            	plan_info:content,
	            	time_id:select_time,
	            	plan_tittle:tittle,
	            	company_name:select_company,
	            },
	            function(data) {
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "Fail"){
						alert("更新计划失败！");
						window.location.replace("PlanManage.html");
					}
					else{
						alert("更新计划成功!");
						window.location.replace("PlanManage.html");
					}
	            }
      );
    
}

function back(){
	window.location.replace("PlanManage.html");
}
