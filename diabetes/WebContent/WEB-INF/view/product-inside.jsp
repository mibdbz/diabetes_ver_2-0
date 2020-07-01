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
			<h2>Szczegoly produktu</h2>
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
					<td>${product.kcal}</td>
					<td>${product.carbohydrates}</td>
					<td>${product.proteins}</td>
					<td>${product.fat}</td>
					<td>${product.type}</td>
				</tr>
				
			</table>
			
			<br><br>
			
			<form:form action="howMuchGrams" method="GET">
		
            	Podaj ilosc w gramach: <input type="number" name="numberOfGrams" />
                
        		<input type="submit" value="Dodaj" class="add-button" />
        	
        	</form:form>
			
		</div>
	</div>

</body>

</html>