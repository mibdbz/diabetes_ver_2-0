<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>List of Products</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>List of all products</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<table>
			
				<tr>
					<th>Name</th>				
					<th>Kcal</th>				
					<th>Weglowodany</th>				
					<th>Bialka</th>				
					<th>Tluszcz</th>				
					<th>Grupa</th>				
				</tr>
				
				<c:forEach var="tempProduct" items="${products}">
				
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.kcal} </td>
						<td> ${tempProduct.carbohydrates} </td>
						<td> ${tempProduct.proteins} </td>
						<td> ${tempProduct.fat} </td>
						<td> ${tempProduct.type} </td>
					</tr>
					
				</c:forEach>
				
			</table>
			
		</div>
	</div>
	

</body>

</html>