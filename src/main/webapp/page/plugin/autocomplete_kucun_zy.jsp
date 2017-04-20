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
		var oTable = $("#count"), iNum = 1, eEle = '';
		oTable.on('click', function(e) {
			
			var target = e.target, oTr = $(target).closest('tr');
			if (oTr.index() == oTable.find('tr').last().index()) {
				iNum++;
				
				eEle = oTr.clone();
				eEle.find('td').eq(0).text(iNum);
			}
			var num = iNum-2;
			
			
			eEle.find('input').eq(0).attr("name","rkjlList["+num+"].kuCun.clpp");
			eEle.find('input').eq(0).attr("id","clpp"+num);
			
			eEle.find('input').eq(1).attr("name","rkjlList["+num+"].kuCun.clxh");
			eEle.find('input').eq(1).attr("id","clxh"+num);
			
			eEle.find('input').eq(2).attr("name","rkjlList["+num+"].kuCun.wlmc");
			eEle.find('input').eq(2).attr("id","wlmc"+num);
			
			eEle.find('input').eq(3).attr("name","rkjlList["+num+"].kuCun.dqsl");
			eEle.find('input').eq(3).attr("id","dqsl"+num);
			
			eEle.find('input').eq(4).attr("name","rkjlList["+num+"].bcsl");
			eEle.find('input').eq(5).attr("name","rkjlList["+num+"].danjia");
			
			eEle.find('select').eq(0).attr("name","rkjlList["+num+"].ghs.ghsid");
			eEle.find('select').eq(0).attr("id","ghsid"+num);
			
			eEle.find('select').eq(1).attr("name","rkjlList["+num+"].kuCun.wllx");
			eEle.find('select').eq(1).attr("id","wllx"+num);
			eEle.find('select').eq(2).attr("name","rkjlList["+num+"].wlzl");
			eEle.find('select').eq(2).attr("id","wlzl"+num);
			eEle.find('select').eq(3).attr("name","rkjlList["+num+"].kuCun.huowei");
			eEle.find('select').eq(3).attr("id","huowei"+num);
			
			eEle.find('input').eq(6).attr("name","rkjlList["+num+"].kuCun.remark");
			eEle.find('input').eq(7).attr("name","rkjlList["+num+"].kuCun.kcid");
			eEle.find('input').eq(7).attr("id","kcid"+num);
			//alert(eEle.find('input').eq(0).attr("id"));
			oTable.append(eEle);
			
			
			$("#clxh").autocomplete("${pageContext.request.contextPath}/autoCompleteAction!showKuCunZYListAuto", {
				minChars : 1,
				max : 50,
				width : 600,
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
					return item.kuCun.clpp+"--"+item.kuCun.clxh+"--||--名称 : " +item.kuCun.wlmc +"--||--库存数量 : " +item.kuCun.dqsl +"--||--供货商 : "+item.ghs.name +"--||--物料质量 : "+wlzl;
					 
				}
			}).result(function(e, item) {
				$("#clpp").val(item.kuCun.clpp);
				$("#clxh").val(item.kuCun.clxh);
				$("#wlmc").val(item.kuCun.wlmc);
				$("#dqsl").val(item.kuCun.dqsl);
				$("#ghsid").val(item.ghs.ghsid);
				$("#wllx").val(item.kuCun.wllx);
				$("#wlzl").val(item.wlzl);
				$("#huowei").val(item.kuCun.huowei);
				$("#kcid").val(item.kuCun.kcid);
				
				$("#ghsid").attr("readonly","readonly")
				$("#wllx").attr("readonly","readonly")
				$("#wlzl").attr("readonly","readonly")
				$("#huowei").attr("readonly","readonly")
		   });
			
			$("#clxh"+num).autocomplete("${pageContext.request.contextPath}/autoCompleteAction!showKuCunZYListAuto", {
				minChars : 1,
				max : 50,
				width : 600,
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
					return item.kuCun.clpp+"--"+item.kuCun.clxh+"--||--名称 : " + item.kuCun.wlmc +"--||--库存数量 : "+item.kuCun.dqsl +"--||--供货商 : "+item.ghs.name +"--||--物料质量 : "+wlzl;
					 
				}
			}).result(function(e, item) {
				$("#clpp"+num).val(item.kuCun.clpp);
				$("#clxh"+num).val(item.kuCun.clxh);
				$("#wlmc"+num).val(item.kuCun.wlmc);
				$("#dqsl"+num).val(item.kuCun.dqsl);
				$("#ghsid"+num).val(item.ghs.ghsid);
				$("#wllx"+num).val(item.kuCun.wllx);
				$("#wlzl"+num).val(item.wlzl);
				$("#huowei"+num).val(item.kuCun.huowei);
				$("#kcid"+num).val(item.kuCun.kcid);
				
				$("#ghsid"+num).attr("readonly","readonly")
				$("#wllx"+num).attr("readonly","readonly")
				$("#wlzl"+num).attr("readonly","readonly")
				$("#huowei"+num).attr("readonly","readonly")
		   });
			
			
	});
});
	
</script>




