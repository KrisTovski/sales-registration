<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Rejestracja</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="#" method="post" class="user-form">
        <h2 class="user-form-title">Zostałeś pomyslnie zarejestrowany</h2>
        <a href="${pageContext.request.contextPath}">Strona główna</a>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>