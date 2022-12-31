<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="customer" class="classic.web.app.CustomerBean" scope="session"/>
<c:if test="${empty customer.id}">
	<c:redirect url="customer.jsp"/>
</c:if>
<html>
	<head>
		<title>ClassicWebApp</title>
	</head>
	<body>
		<h1>Welcome Customer ${customer.id}</h1>
		<h3>Your Orders</h3>
		<table border="1">
			<tr>
				<th>Product No</th>
				<th>Quantity</th>
				<th>Order Date</th>
			</tr>
			<c:forEach var="entry" items="${customer.orders}">
				<tr>
					<td>${entry.productNo}</td>
					<td>${entry.quantity}</td>
					<td>${entry.orderDate}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a href="customer.jsp?signout=true">Logout</a>
		</p>
	</body>
</html>

