<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Ewidencja sprzedaży</title>
    <%@ include file="../segments/stylesheet.jspf" %>
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