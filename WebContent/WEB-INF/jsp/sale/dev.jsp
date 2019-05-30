<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="js/changetrcolor.js"
	type="text/javascript"></script>
</head>
<body>
  <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">客户开发计划</TD>
			<TD class="page_title_middle">&nbsp;</TD>
			<TD width=3><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>
	<form
		action=""
		method="post">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th>客户名称</th>
				<td><input type="text" name="chc_cust_name" /></td>
				<th>概要</th>
				<td><input type="text" name="chc_title" /></td>
				<th>联系人</th>
				<td><input type="text" name="chc_linkman" size="20" /></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help"><input
						class="common_button" type="button" value="帮助"></a>&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp; <input class="common_button" type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
		<TD class="page_title">检索结果</TD>
		<TD class="page_title_middle">&nbsp;</TD>
		<TD width=3><IMG height=32
			src="images/m_mpr.gif" width=3></TD>
	</tr>
	</table>

	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>客户名称</th>
			<th>概要</th>
			<th>联系人</th>
			<th>联系人电话</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${salPlan}" var="SalPlan">

							<tr>
								<td class="list_data_number">${SalPlan.plaId}</td>
								<td class="list_data_text"></td>
								<td class="list_data_ltext"></td>
								<td class="list_data_text"></td>
								<td class="list_data_text"></td>
								<td class="list_data_text"></td>

								<td class="list_data_op"><a
									href="dev_plan"><img
										title="制定计划"
										src="images/bt_plan.gif"
										class="op_button" /></a> 
								</td>
							</tr>
					
					<tr>
						<td class="list_data_number"></td>
						<td class="list_data_text"></td>
						<td class="list_data_ltext"></td>
						<td class="list_data_text"></td>
						<td class="list_data_text"></td>
						<td class="list_data_text"></td>

						<td class="list_data_op"><img
								onClick="to('dev_detail');"
								title="查看"
								src="images/bt_detail.gif"
								class="op_button" /></td>
					</tr>
					
					</c:forEach>

		<tr>
			<th colspan="10" class="pager">
				<div class="pager">
					
				</div>
			</th>
		</tr>
	</table>
</body>
</html>