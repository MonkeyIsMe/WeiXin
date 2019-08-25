var row = 1;  //页数
var count; //总记录数

var id;
var name;
var role;
var company;
var phone;
var number;

$(function(){
	$.ajaxSettings.async = false;
	$.post(
			"CountUser.action",
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
        "QueryAllUserByPageSize.action",
        {
            page:row,
            limit:25
        },
        function(data) {
            var data = JSON.parse(data);
            //console.log(data);
            for( var i = 0; i < data.length; i++ ) {
                //动态创建一个tr行标签,并且转换成jQuery对象
                var $trTemp = $("<tr ></tr>");
                //往行里面追加 td单元格
                var WorkFlag;
		        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].userId +"</td>");
		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userName +"</td>");
		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userNumber +"</td>");
		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userRole +"</td>");
		        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].userCompany +"</td>");
		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userPhone +"</td>");
		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userAppid +"</td>");
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
	            "QueryAllUserByPageSize.action",
	            {
	                page:row,
	                limit:25
	            },
	            function(data) {
	                var data = JSON.parse(data);
	                //console.log(data);
	                for( var i = 0; i < data.length; i++ ) {
	                    //动态创建一个tr行标签,并且转换成jQuery对象
	                    var $trTemp = $("<tr ></tr>");
	                    //往行里面追加 td单元格
	                    var WorkFlag;
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].userId +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userName +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userNumber +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userRole +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].userCompany +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userPhone +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userAppid +"</td>");
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
	            "QueryAllUserByPageSize.action",
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
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].userId +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userName +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userNumber +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userRole +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">"+ data[i].userCompany +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userPhone +"</td>");
	    		        $trTemp.append("<td style=" + "text-align:center"  + ">" +data[i].userAppid +"</td>");
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
		    var col4=currentRow.find("td:eq(3)").text(); //获得当前行第一个TD值
		    var col5=currentRow.find("td:eq(4)").text(); //获得当前行第一个TD值
		    var col6=currentRow.find("td:eq(5)").text(); //获得当前行第一个TD值
		    
		    id = col1;
		    name = col2;
		    number = col3;
		    role = col4;
		    company = col5;
		    phone = col6;
		    
		    
		    $("#update_name").val(name);
		    $("#update_number").val(number);
		    $("#update_phone").val(phone);
	  })
	  
	  $("#del").click(function(){
		  	    $.post(
		            "DeleteUser.action",
		            {
		            	user_id:id,
		            },
		            function(data) {
						data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data == "Fail"){
							alert("删除失败！");
							window.location.replace("UserManage.html");
						}
						else{
							alert("删除成功!");
							window.location.replace("UserManage.html");
						}
		            }
	        );
	  })
	  
	  $("#update").click(function(){
		  
				var name = $("#update_name").val();
				var number = $("#update_number").val();
				var phone = $("#update_phone").val();
				var company = $("#select_company option:selected").val();
				var role = $("#select_role option:selected").val();
		  	    $.post(
		            "UpdateUser.action",
		            {
		            	user_id:id,
		            	user_name:name,
		            	user_number:number,
		            	user_role:role,
		            	user_company:company,
		            	user_phone:phone
		            },
		            function(data) {
						data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data == "Fail"){
							alert("更新失败！");
							window.location.replace("UserManage.html");
						}
						else{
							alert("更新成功!");
							window.location.replace("UserManage.html");
						}
		            }
	        );
	  })
	  	  
	  
})

function refresh(){
	window.location.replace("UserManage.html");
}