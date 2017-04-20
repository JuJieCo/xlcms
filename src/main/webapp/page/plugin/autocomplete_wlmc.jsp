<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" 	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery.autocomplete.css" />

<!-- 用在这个页面的 beiliaomodify.jsp   -->

<script type='text/javascript'>
$(document).ready(function() {
	$("#wlmc").autocomplete("${pageContext.request.contextPath}/autoCompleteAction!showKuCunWlmcListAuto", {
		minChars : 1,
		max : 50,
		width : 500,
		matchContains : true,
		autoFill : false,
		parse : function(joinresult) {
			data = joinresult.rkjlList;
			var rows = [];
			for (var i = 0; i < data.length; i++) {
				rows[rows.length] = {
					data : data[i],
					value : data[i].kuCun.cphm,
					result : data[i].kuCun.cphm,
				};
			}
			return rows;
		},
		formatItem : function(item) {
			var wlzl ="";
			if(item.wlzl==1){
				wlzl = "原车"
			}
			if(item.wlzl==2){
				wlzl = "其它"
			}
			return item.kuCun.wlmc +"--||--库存数量 : "+item.kuCun.dqsl +"--||--供货商 : "+item.ghs.name +"--||--物料质量 : "+wlzl;
			 
		}
	}).result(function(e, item) {
		$("#wlmc").val(item.kuCun.wlmc);
   });
});
</script>




