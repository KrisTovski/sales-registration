<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Ewidencja sprzedaży</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/table.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>
    <main>
        <%@ include file="../segments/record-table.jspf" %>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>