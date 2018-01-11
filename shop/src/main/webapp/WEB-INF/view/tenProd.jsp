<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
	</head>
	<body>
       ${products}
       <table border="1" width="100%" cellpadding="5">
		  <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.sku}</td>
                <td>${product.productId}</td>
            </tr>
          </c:forEach>
         </table>
	</body>
</html>