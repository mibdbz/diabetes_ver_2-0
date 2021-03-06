<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>List of Products</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista Produkt�w</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Dodaj Produkt" onclick="window.location.href='showFormForAdd'; return false" 
		class="add-button" />
		
		<form:form action="search" method="GET">
		
            Szukaj: <input type="text" name="theSearchName" />
                
        	<input type="submit" value="Szukaj" class="add-button" />
        	
        </form:form>
			
			<table>
			
				<tr>
					<th>Name</th>				
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
				
					<c:url var="nameLink" value="/product/insideForm">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					<tr>
						<td> <a href="${nameLink}">${tempProduct.name}</a></td>
						<td> ${tempProduct.type} </td>
						<td>
							<a href="${updateLink}">Edytuj</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Czy napewno chcesz usunac ten produkt?'))) return false">Usun</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
			<div style="clear; both"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Wroc Do Listy</a>
		</p>
			
		</div>
	</div>
	

</body>

</html>