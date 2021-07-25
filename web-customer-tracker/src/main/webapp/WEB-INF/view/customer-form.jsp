<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<head>
	<title>Save Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
	<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<h3>Save Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>First name: </label></td>
							<td><form:input path="fistName"/></td>
						</tr>
						 <tr>
							<td><label>Last name: </label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Email: </label></td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td><input type="submit" value="save" class="add-button"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<p><a href="${pageContext.request.contextPath }/customer/list">Back to list</a></p>
		</div>
	</body>
</html>