<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/myTT/save2" method="post">
		id: <input type="text" name="id" />
		name: <input type="text" name="name" />
		age: <input type="text" name="age" />
		hireDate: <input type="text" name="hireDate" />
		<input type="submit" /> 
	</form>

</body>
</html>