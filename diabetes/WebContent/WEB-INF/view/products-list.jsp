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
		
		<input type="button" value="Dodaj Produkt" onclick="window.location.href='showFormForAdd'; return false" 
		class="add-button" />
			
			<table>
			
				<tr>
					<th>Name</th>				
					<th>Kcal</th>				
					<th>Weglowodany</th>				
					<th>Bialka</th>				
					<th>Tluszcz</th>				
					<th>Grupa</th>
					<th>Akcja</th>			
				</tr>
				
				<c:forEach var="tempProduct" items="${products}">
				
					<c:url var="updateLink" value="/product/showUpdateForm">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/product/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
				
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.kcal} </td>
						<td> ${tempProduct.carbohydrates} </td>
						<td> ${tempProduct.proteins} </td>
						<td> ${tempProduct.fat} </td>
						<td> ${tempProduct.type} </td>
						<td>
							<a href="${updateLink}">Edytuj</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Czy napewno chcesz usunac ten produkt?'))) return false">Usun</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
		</div>
	</div>
	

</body>

</html>