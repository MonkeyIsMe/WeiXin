$(function(){
    $.post(
        "QueryAllUser.action",
        {
        	
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
		        		'<a ><span class="delete check glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px"></span></a>'
		        		+'<a ><span class="delete work glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px"></span></a>'
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
	            "QueryAllUser.action",
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
	    		        		'<a ><span class="delete check glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px"></span></a>'
	    		        		+'<a ><span class="delete work glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px"></span></a>'
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
	            "QueryAllUser.action",
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
	    		        		'<a ><span class="delete check glyphicon glyphicon-pencil" style="cursor:pointer;margin-left:35px"></span></a>'
	    		        		+'<a ><span class="delete work glyphicon glyphicon-align-justify" style="cursor:pointer;margin-left:20px"></span></a>'
	    		        		+"</td>");
	                    // $("#J_TbData").append($trTemp);
	                    $trTemp.appendTo("#KnowList");
	                }
	            }
	        );
	}

}


function refresh(){
	window.location.replace("PlanUser.html");
}