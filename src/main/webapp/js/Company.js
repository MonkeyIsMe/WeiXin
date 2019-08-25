var row = 1;  //页数
var count; //总记录数

var id;
var name;
var info;

$(function(){
	$.ajaxSettings.async = false;
	$.post(
			"CountCompany.action",
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
	
});

$(function(){
    $.post(
        "QueryAllCompanyByPageSize.action",
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
			        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].companyId +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyName +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyInfo +"</td>");
			        $trTemp.append("<td style=" + "text-align:center"  + ">" + 
			        		'<a ><span class="delete glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px" data-toggle="modal" data-target="#update_Modal"></span></a>'
			        		+'<a ><span class="delete glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px" data-toggle="modal" data-target="#myModal"></span></a>'
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
	            "QueryAllCompanyByPageSize.action",
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
				        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].companyId +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyName +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyInfo +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" + 
				        		'<a ><span class="delete glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px" data-toggle="modal" data-target="#update_Modal"></span></a>'
				        		+'<a ><span class="delete glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px" data-toggle="modal" data-target="#myModal"></span></a>'
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
	            "QueryAllCompanyByPageSize.action",
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
				        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].companyId +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyName +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].companyInfo +"</td>");
				        $trTemp.append("<td style=" + "text-align:center"  + ">" + 
				        		'<a ><span class="delete glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px" data-toggle="modal" data-target="#update_Modal"></span></a>'
				        		+'<a ><span class="delete glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px" data-toggle="modal" data-target="#myModal"></span></a>'
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
		    name = col2;
		    info = col3;
		    
		    $("#update_name").val(name);
		    $("#update_info").val(info);
	  })
	  
	  $("#del").click(function(){
		  	    $.post(
		            "DeleteCompany.action",
		            {
		            	company_id:id,
		            },
		            function(data) {
						data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data == "Fail"){
							alert("删除失败！");
							window.location.replace("CompanyManage.html");
						}
						else{
							alert("删除成功!");
							window.location.replace("CompanyManage.html");
						}
		            }
	        );
	  })
	  
	  $("#update").click(function(){
				var name = $("#update_name").val();
				var info = $("#update_info").val();
		  	    $.post(
		            "UpdateCompany.action",
		            {
		            	company_id:id,
		            	company_name:name,
		            	company_info:info
		            },
		            function(data) {
						data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data == "Fail"){
							alert("更新失败！");
							window.location.replace("CompanyManage.html");
						}
						else{
							alert("更新成功!");
							window.location.replace("CompanyManage.html");
						}
		            }
	        );
	  })
	  	  
	  $("#add").click(function(){
				var name = $("#add_name").val();
				var info = $("#add_info").val();
		  	    $.post(
		            "AddCompany.action",
		            {
		            	company_name:name,
		            	company_info:info
		            },
		            function(data) {
						data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data == "Fail"){
							alert("添加失败！");
							window.location.replace("CompanyManage.html");
						}
						else{
							alert("添加成功!");
							window.location.replace("CompanyManage.html");
						}
		            }
	        );
	  })
	  
})

function refresh(){
	window.location.replace("CompanyManage.html");
}