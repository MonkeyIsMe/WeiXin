var row = 1;  //页数
var count; //总记录数

var id;

var editor = null;
window.onload = function () {
    editor = CKEDITOR.replace("content"); //参数‘content’是textarea元素的name属性值，而非id属性值
}

$(function(){
	$.ajaxSettings.async = false;
	$.post(
			"CountIntroduction.action",
			{
			},
			function(data){
				var data = JSON.parse(data);
				//console.log(data);
				var sum = data.cnt;
				count = Math.ceil(sum/25);
				var total = "共" + Math.ceil(sum/25) + "页";
				$("#TotalPage").append(total);
				$("#NowPage").append("，当前第" + row + "页");
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

$(function(){
    $.post(
        "QueryAllIntroductionByPageSize.action",
        {
            page:row,
            limit:25
        },
        function(data) {
            var data = JSON.parse(data);
            //console.log(data)
                for( var i = 0; i < data.length; i++ ) {
                    //动态创建一个tr行标签,并且转换成jQuery对象
                    var $trTemp = $("<tr ></tr>");
                    //往行里面追加 td单元格
                    var WorkFlag;
			        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].introductionId +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].introductionTittle +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyName +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].introductionInfo +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" + 
			        		'<a ><span class="delete check glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px"></span></a>'
			        		+'<a ><span class="delete work glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px" data-toggle="modal" data-target="#myModal"></span></a>'
			        		+"</td>");
                    // $("#J_TbData").append($trTemp);
                    $trTemp.appendTo("#KnowList");
                }
        }
    );

});

function PrevPage(){	
	if(row == 1){
		alert("没有前一页了");
	}
	else{
		row--;
		$("#KnowList").html("");
	    $.post(
	            "QueryAllIntroductionByPageSize.action",
	            {
	                page:row,
	                limit:25
	            },
	            function(data) {
	                var data = JSON.parse(data);
	                for( var i = 0; i < data.length; i++ ) {
	                    //动态创建一个tr行标签,并且转换成jQuery对象
	                    var $trTemp = $("<tr ></tr>");
	                    //往行里面追加 td单元格
	                    var WorkFlag;
				        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].introductionId +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].introductionTittle +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyName +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].introductionInfo +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" + 
				        		'<a ><span class="delete check glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px"></span></a>'
				        		+'<a ><span class="delete work glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px" data-toggle="modal" data-target="#myModal"></span></a>'
				        		+"</td>");
	                    // $("#J_TbData").append($trTemp);
	                    $trTemp.appendTo("#KnowList");
	                }
	            }
	        );
	}
}

function NextPage(){
	if(row == count){
		alert("没有后一页了");
	}
	else{
		row ++;
		$("#KnowList").html("");
	    $.post(
	            "QueryAllIntroductionByPageSize.action",
	            {
	                page:row,
	                limit:25
	            },
	            function(data) {
	                var data = JSON.parse(data);
	                for( var i = 0; i < data.length; i++ ) {
	                    //动态创建一个tr行标签,并且转换成jQuery对象
	                    var $trTemp = $("<tr ></tr>");
	                    //往行里面追加 td单元格
	                    var WorkFlag;
				        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].introductionId +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].introductionTittle +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyName +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].introductionInfo +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" + 
				        		'<a ><span class="delete check glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px"></span></a>'
				        		+'<a ><span class="delete work glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px" data-toggle="modal" data-target="#myModal"></span></a>'
				        		+"</td>");
	                    // $("#J_TbData").append($trTemp);
	                    $trTemp.appendTo("#KnowList");
	                }
	            }
	        );
	}

}

$(document).ready(function(){
	
	  $("#myTable").on('click','.delete',function(){
		    //获得当前行
		    var currentRow=$(this).closest("tr"); 
		    var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
		    var col2=currentRow.find("td:eq(1)").text(); //获得当前行第一个TD值
		    var col3=currentRow.find("td:eq(2)").text(); //获得当前行第一个TD值
		    
		    id = col1;
		    
	  })
	  
	  	  	  $("#myTable").on('click','.check',function(){
		    //获得当前行
		    var currentRow=$(this).closest("tr"); 
		    var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
		    var col2=currentRow.find("td:eq(1)").text(); //获得当前行第一个TD值
		    var col3=currentRow.find("td:eq(2)").text(); //获得当前行第一个TD值
		    
		    id = col1;
		    
		    var url = "UpdateIntroduction.html?IntroductionId=" + id;
		    window.location.replace(url);
	  })
	  
	  $("#del").click(function(){
		  	    $.post(
		            "DeleteIntroduction.action",
		            {
		            	introduction_id:id,
		            },
		            function(data) {
						data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data == "Fail"){
							alert("删除失败！");
							window.location.replace("IntroductionManage.html");
						}
						else{
							alert("删除成功!");
							window.location.replace("IntroductionManage.html");
						}
		            }
	        );
	  })
	  
	  	  
	  
})

function savaData(){

    var content = CKEDITOR.instances.content.getData(); //获取值
	var select_company = $("#select_company option:selected").val();
    var tittle = $("#tittle").val();
    //alert(select_company);
	  	    $.post(
	            "AddIntroduction.action",
	            {
	            	introduction_info:content,
	            	introduction_tittle:tittle,
	            	company_name:select_company,
	            },
	            function(data) {
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "Fail"){
						alert("添加计划失败！");
						window.location.replace("IntroductionManage.html");
					}
					else{
						alert("添加计划成功!");
						window.location.replace("IntroductionManage.html");
					}
	            }
      );
    
}

function refresh(){
	window.location.replace("IntroductionManage.html");
}