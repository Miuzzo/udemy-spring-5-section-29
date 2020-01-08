<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>L2C</title>
		
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	</head>

	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					<tr>
					<c:forEach var="tempCustomer" items="${Customers}">
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
	</body>
</html>