<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" 	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery.autocomplete.css" />



<script type='text/javascript'>
/*
1.$(function(){})，当文档结构完全加载完毕再去执行函数中的代码。
2.var oTable = $("#count")，获取id属性值为count的对象，在这里就是表格对象。
3.iNum = 1，声明一个变量并赋初值为1，以后可以每增加一行就会+1作为行号。
4.eEle = ''，声明一个变量用来存储行对象。
5.oTable.on('click', function(e){})，为表格对象注册click事件处理函数。
6.var target = e.target，获取被点击的源对象。
7.oTr = $(target).closest('tr')，获取最近的tr祖辈元素。
8.f(oTr.index()==oTable.find('tr').last().index())，判断点击的是否是最后一行。
9.iNum++，iNum的值加1。
10.eEle = oTr.clone()，克隆当前行对象。
11.eEle.find('td').eq(0).text(iNum)，设置最后一行第一个单元格的值。
12.oTable.append(eEle)，为表格的最后添加行。
*/
$(document).ready(function() {
	
	$("input").click(function () {
				  // alert($(this).attr("id"));
				   
				   var str = $(this).attr("id");
				  // alert(str.substr(4, (str.length - 1)));
				  var num =str.substr(7, (str.length - 1));
					  
			$("#duiliao"+num).autocomplete("${pageContext.request.contextPath}/autoCompleteAction!showKuCunListAuto", {
				minChars : 1,
				max : 50,
				width : 570,
				matchContains : true,
				autoFill : false,
				parse : function(joinresult) {
					data = joinresult.rkjlList;
					var rows = [];
					for (var i = 0; i < data.length; i++) {
						rows[rows.length] = {
							data : data[i],
							value : data[i].kuCun.wlmc,
							result : data[i].kuCun.wlmc,
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
					
					var chexing="通用";
					if(item.kuCun.clpp!=""&&item.kuCun.clxh!=""){
						chexing = item.kuCun.clpp+"-"+item.kuCun.clxh;
					}
					
					
					return  item.kuCun.wlmc +"[<font color=#FF0000>车型: "+chexing+"</font>]"+"--||--库存数量 :<font color=#FF0000> "+item.kuCun.dqsl +"</font>--||--供货商 :<font color=#FF0000> "+item.ghs.name +"</font>--||--物料质量 : "+wlzl;
					 
				}
			}).result(function(e, item) {
				$("#rkrq"+num).val(item.rkrq);
				$("#rkid"+num).val(item.rkid);
				$("#dqsl"+num).val(item.kuCun.dqsl);
		   });
			
			
	});
});
	
</script>




