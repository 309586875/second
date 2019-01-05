<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>用户列表，当前用户 ${user_in_session.name}</h4> &emsp;&emsp; <a href="${pageContext.request.contextPath}/login.jsp">注销</a>
	<hr/>
<%-- <a href="${pageContext.request.contextPath}/input.jsp">新增</a>  <br/> --%>
<a href="${pageContext.request.contextPath}/myTT/input">新增</a>  <br/>

	<table cellpadding="0" cellspacing="0" border="1" width="100" >
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>hireDate</th>
		</tr>
		<c:forEach items="${emps}"  var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.age}</td>
				<td><fmt:formatDate value="${e.hireDate}" pattern="yyyy.MM.dd"/></td>
			</tr>
		</c:forEach>
	
	</table>
	

</body>
</html>