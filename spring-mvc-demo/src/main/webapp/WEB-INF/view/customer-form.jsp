<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

	<head>
		<title>Customer Registration Form</title>
		<style>
		.error{color:red;}
		</style>
	</head>
	<body>
		<i>(*)Fill out the form  means required</i>
		<br><br>
		<form:form action="processForm" modelAttribute="customer">
		
			First Name : <form:input path="firstName"/>
			Last Name(*): <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"></form:errors>
			<input type="submit" value="submit"/>
		</form:form>
	</body>
</html>