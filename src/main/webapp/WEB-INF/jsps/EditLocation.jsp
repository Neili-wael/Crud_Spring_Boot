<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location </title>
</head>
<body>

	<form action="updateLoc" method="POST">
	<pre>
		Id : <input type="text" name="id" value="${location.id}" readonly="true" /> Code : <input type="text"
			name="code" value="${location.code}" /> Name : <input type="text" name="name" value="${location.name}" /> Type : Urban <input type="radio" name="type" value="Urban" ${location.type=='Urban'?'checked' :'' }/>
		Rural <input type="radio" name="type" value="Rural"${location.type=='Rural'?'checked' :'' } /> <input type="submit"
			value="save" />
	</pre>
	</form>
	
</body>
</html>