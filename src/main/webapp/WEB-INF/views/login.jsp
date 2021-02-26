<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="j_security_check" method="post" class="user-form">
        <h2 class="user-form-title">Logowanie</h2>
        <input name="j_username" placeholder="Nazwa użytkownika" required>
        <input name="j_password" placeholder="Hasło" type="password" required>
        <button class="user-form-button">Zaloguj się</button>
        <p>Nie masz konta? <a href="${pageContext.request.contextPath}/signup">Zarejestruj się</a></p>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>