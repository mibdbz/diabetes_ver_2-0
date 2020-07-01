<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE hmtl>

<html>

<head>

	<title>Szczegoly Produktu</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-product-style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Szczegoly podane na ${grams} gram produktu</h2>
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

				<tr>
					<td>${product.name}</td>
					<td>${product.kcal} </td>
					<td>${product.carbohydrates} </td>
					<td>${product.proteins} </td>
					<td>${product.fat} </td>
					<td>${product.type} </td>
				</tr>
				
			</table>
			
			<br><br>

			<div id="wrapper">
				<div id="header">
					<h2>WW ${exchangers.carbohydrates}</h2>
					<h2>WBT ${exchangers.proteinAndFat}</h2>
				</div>
			</div>

			
		</div>
		
		<div style="clear; both"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Wroc Do Listy</a>
		</p>
		
	</div>

</body>

</html>