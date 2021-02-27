<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Ewidencja sprzedaży</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/images.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>
    <main>
        <img src="${pageContext.request.contextPath}/images/indeximage.jpg" alt="image" class="responsive"/>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>