<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
	<title>Student registration</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	
		First Name : <form:input path="firstName"/>
		Last Name: <form:input path="lastName"/>
		
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<input type="submit" value="submit"/>
	</form:form>
</body>
</html>