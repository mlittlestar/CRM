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
<title>服务分配</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
   <br>

	<form action="service/findByCon?curpage=1" method="post" name="frm">
		<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
			<tr>
				<td class="page_title">客户服务管理</td>
				<td class="page_title_middle">&nbsp;</td>
				<td width=3><IMG height=32
					src="images/m_mpr.gif" width=3>
				</td>
			</tr>
		</table>
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<td width=100% height=30 align=left
					background="images/m_table_top.jpg"
					colspan="6"><strong>&nbsp;服务分配</strong></td>
			</tr>
			<tr>
				<th height="28">客户</th>
				<td><input type="text" name="svrCustName"/></td>
				<th height="28">概要</th>
				<td><input type="text" name="svrTitle"/></td>
			</tr>
			<tr>
				<th height="28">服务类型</th>
				<td><select name="svrType" >
						<option value="" selected='selected'>全部</option>
						<option value="咨询">咨询</option>
						<option value="建议">建议</option>
						<option value="投诉">投诉</option>
				</select></td>
				<th height="22">状态</th>
				<td><input type="text" name="svrStatus" value="新创建" /></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help"><input class="common_button" type="button"
						value="帮助"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="common_button" >查询</button>
				</td>
			</tr>
		</table>
	</form>
	<br />

	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<td class="page_title">检索结果</td>
			<td class="page_title_middle">&nbsp;</td>
			<td width=3><IMG height=32
				src="images/m_mpr.gif" width=3>
			</td>
		</tr>
	</table>

	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>客户</th>
			<th>概要</th>
			<th>服务类型</th>
			<th>创建人</th>
			<th>分配给</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${AllService.list }" var="Service">
				<tr>
					<td class="list_data_number">${Service.svrId }</td>
					<td class="list_data_text">${Service.svrCustName }</td>
					<td class="list_data_ltext">${Service.svrTitle }</td>
					<td class="list_data_text">${Service.svrType }</td>
					<td class="list_data_text">${Service.svrCreateBy }</td>
					<td class="list_data_text">
								<form action="" method="post" name="frm">
									<input type="hidden" value="" name="svr_id">
									<select name="svrDueTo" id="cs.svr_due_to">
										<option value="">请选择..</option>
										
											<option></option>
									
									</select> <input type="hidden" name="svrStatus" id="cs.svr_status" />
									<input type="submit" value="分配" name="" onclick="fenpei()">
								</form>
					
								<input type="hidden" value="" name="cs.svr_id">
								<select name="svrDueTo" id="cs.svr_due_to" disabled="disabled">
									<option value="">请选择..</option>

								</select>
						</td>
					<td class="list_data_op"><a href="javascript:if(confirm('确认删除？')){window.location.href='${Service.svrId }/deleteSD'}">
					<img
							title="删除"
							src="images/bt_del.gif"
							class="op_button" onclick="del()" /> </a></td>
				</tr>
				
				</c:forEach>
				
		<tr>
			<td colspan="8" align="center">共${AllService.total } 记录 每页${AllService.pageSize } 条 
			第${AllService.pageNum }页 <a
				href="1/servicedispatch">首页</a> 
				<c:choose>
					<c:when test="${sessionScope.AllService.hasPreviousPage }">
						<a href="${sessionScope.AllService.prePage }/servicedispatch">上一页</a>
					</c:when>
				</c:choose> 
				
				<font color="#ABA8AB">上一页</font>
				
				 <c:choose>
					<c:when test="${sessionScope.AllService.hasNextPage }">
						<a href="${sessionScope.AllService.nextPage }/servicedispatch">下一页</a>
					</c:when>
				</c:choose> <font color="#ABA8AB">下一页</font>
				 <a
				href="${sessionScope.AllService.navigateLastPage}/servicedispatch">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>