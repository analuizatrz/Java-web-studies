<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
	<title>Student registration</title>
</head>
<body>t
	<form:form action="processForm" modelAttribute="student">
	
		First Name : <form:input path="firstName"/>
		Last Name: <form:input path="lastName"/>
		
		Country:
		<form:select path="country">
		<form:options items="${student.countryOptions}"  />
		</form:select>
		
		<br><br>
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

		<br><br>
		Operation Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		Windows<form:checkbox path="operatingSystems" value="Windows"/>
		<input type="submit" value="submit"/>
	</form:form>
</body>
</html>