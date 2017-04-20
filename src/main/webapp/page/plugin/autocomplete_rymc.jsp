<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" 	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery.autocomplete.css" />



<script type='text/javascript'>
$(document).ready(function() {
	$("#rymc").autocomplete("${pageContext.request.contextPath}/autoCompleteAction!showRyglNameListAuto", {
		minChars : 1,
		max : 50,
		width : 500,
		matchContains : true,
		autoFill : false,
		parse : function(joinresult) {
			data = joinresult.ryglList;
			var rows = [];
			for (var i = 0; i < data.length; i++) {
				rows[rows.length] = {
					data : data[i],
					value : data[i].name,
					result : data[i].name,
				};
			}
			return rows;
		},
		formatItem : function(item) {
			 
			return "人员姓名："+item.name;
			 
		}
	}).result(function(e, item) {
		$("#ryid").val(item.ryid);
   });
});
</script>




