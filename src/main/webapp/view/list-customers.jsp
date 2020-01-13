<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
				<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">
				<form:form method="post" action="${pageContext.request.contextPath}/customer/list" modelAttribite="lastNameSearch">
					Search customer:<input type="text" id="lastNameSearch" name="lastNameSearch"/>
					<input type="submit" value="Search" class="add-button" /></td>
				</form:form>
				<table>
					<tr>
						<th>&nbsp;</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					<tr>
					<c:forEach var="tempCustomer" items="${Customers}">
<!-- 						Construct an update link with customer id -->
							<c:url value="/customer/showFormForUpdate" var="updateURL">
							    <c:param name="customerId" value="${tempCustomer.id}" />
							</c:url>
							<c:url value="/customer/deleteCustomer" var="deleteURL">
							    <c:param name="customerId" value="${tempCustomer.id}" />
							</c:url>
							<tr>
<%-- 							<form:form method="post" action="${pageContext.request.contextPath}/customer/showFormForUpdate" modelAttribite="CustomerId"> --%>
								<td>
									<input type="hidden" id="id" name="id" value="${tempCustomer.id}"/>
								</td>
								<td> ${tempCustomer.firstName} </td>
								<td> ${tempCustomer.lastName} </td>
								<td> ${tempCustomer.email} </td>
								<td> <a href="${updateURL}">Update</a>
								|<a href="${deleteURL}" onclick="if(!confirm('Do you really want to cancel?')) return false;" >Delete</a></td>
<!-- 							<td><input type="submit" value="Update"/></td> -->
<%-- 							</form:form> --%>
							</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>