<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
	<style>
    table, th, td {
        border: 1px solid black;
    }
    </style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
	</head>
	<body>
	<a href="/">HOME</a>
       <table border="3" width="100%" cellpadding="5">
		  <c:forEach items="${products}" var="product">
           <table>
               <tr>
                   <td colspan="2" rowspan="3">
                    <img src="${product.image}" width="189" height="255" alt="альтернативный текст">
                    </td>
                   <td colspan="2">${product.name} / ${product.manufacturer} </td>
               </tr>
               <tr>
                   <td colspan="2"> ${product.productClass} </td>
               </tr>
               <tr>
                   <td colspan="2">${product.regularPrice}</td>
               </tr>
               <tr>
                   <td>${product.customerReviewCount}  ${product.customerReviewAverage} </td>
                   <td colspan="2">like</td>
                   <td>dezlike</td>
               </tr>
               <tr>
                   <td colspan="4">${product.shortDescription}</td>
               </tr>
           </table>
          </c:forEach>
         </table>
	</body>
</html>