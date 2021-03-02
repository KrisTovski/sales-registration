<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Dodajawanie rekordów</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="#" method="post" class="saleRecord-form">
        <h2 class="saleRecord-form-title">Dodaj nowy rekord</h2>
        <input name="value" placeholder="Kwota" step="0.01" required>
        <select>
            <option>Paragon</option>
            <option>Faktura</option>
        </select>
        <textarea name="description" placeholder="opis"></textarea>
        <button class="saleRecord-form-button">Dodaj</button>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>