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
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="#" method="post" class="user-form">
        <h2 class="user-form-title">Rejestracja użytkownika</h2>
        <i class="fa fa-user icon"></i>
        <input name="username" placeholder="Nazwa użytkownika" required>
        <i class="fa fa-envelope icon"></i>
        <input name="email" placeholder="email" type="email" required>
        <i class="fa fa-key icon"></i>
        <input name="password" placeholder="Hasło" type="password" required>
        <button class="user-form-button">Zarejestruj się</button>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>