<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" 	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery.autocomplete.css" />



<script type='text/javascript'>
$(document).ready(function() {
			$("#cphm").autocomplete("${pageContext.request.contextPath}/autoCompleteAction!showCheLiangListAuto", {
				minChars : 1,
				max : 50,
				width : 390,
				matchContains : true,
				autoFill : false,
				parse : function(joinresult) {
					data = joinresult.shiGongDanList;
					var rows = [];
					for (var i = 0; i < data.length; i++) {
						rows[rows.length] = {
							data : data[i],
							value : data[i].cphm,
							result : data[i].cphm,
						};
					}
					return rows;
				},
				formatItem : function(item) {
				 
					return item.cphm +"--||--车辆品牌 : "+item.clpp +"--||--车辆型号 : "+item.clxh;
					 
				}
			}).result(function(e, item) {
				$("#clpp").val(item.clpp);
				$("#clxh").val(item.clxh);
				$("#cjh").val(item.cjh);
				$("#fdjh").val(item.fdjh);
				$("#fdjpx").val(item.fdjpx);
				//$("#cllc").val(item.cllc);
				$("#scrq").val(item.scrq);
				$("#khmc").val(item.khmc);
				$("#khdh").val(item.khdh);
		   });
	});
 
	
</script>