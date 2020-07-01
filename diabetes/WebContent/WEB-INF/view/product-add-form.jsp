<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Zapisz Produkt</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-product-style.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Dodawanie Nowego Produktu</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Zapisz Produkt</h3>
		
		<form:form action="saveProduct" modelAttribute="product" method="POST">
		
			<!-- This is where we tell that we have to use the same id and not create another product -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Nazwa:</label></td>
						<td><form:input path="name"/></td>
					</tr>
					
					<tr>
						<td><label>Kcal:</label></td>
						<td><form:input path="kcal"/></td>
					</tr>
					
					<tr>
						<td><label>Weglowodany:</label></td>
						<td><form:input path="carbohydrates"/></td>
					</tr>
					
					<tr>
						<td><label>Bialka:</label></td>
						<td><form:input path="proteins"/></td>
					</tr>
					
					<tr>
						<td><label>Tluszcze:</label></td>
						<td><form:input path="fat"/></td>
					</tr>
					
					<tr>
						<td><label>Typ:</label></td>
						<td>
							<form:select path="type"> 
 								<form:options items="${typesOptions}" />
							</form:select>
						</td>
					</tr>
					
					<tr>
						<td><label></label><td>
						<td><input type="submit" value="Zapisz"/></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Wroc Do Listy</a>
		</p>
		
	</div>
</body>

</html>