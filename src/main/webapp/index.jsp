<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Ewidencja sprzedaży</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./styles/main.css">
</head>
<body>
<div class="container">
    <nav class="navbar">
        <a href="#" class="logo">
            <i class="fas fa-pencil-alt"></i>
            Ewidencja sprzedaży
        </a>
        <a href="#" class="login-button">Zaloguj</a>
    </nav>

    <main>

        <p>Styczeń 2021</p>

        <div class="Table Table">
            <div class="TableHeading">
                <div class="TableRow">
                    <div class="TableHead">Lp.</div>
                    <div class="TableHead">Data</div>
                    <div class="TableHead">Kwota</div>
                    <div class="TableHead">Typ</div>
                    <div class="TableHead">Uwagi</div>
                </div>
            </div>
            <div class="TableBody">
                <c:forEach var="record" items="${requestScope.records}">
                    <div class="TableRow">
                        <div class="TableCell">1</div>
                        <div class="TableCell">${record.dateAdded.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}</div>
                        <div class="TableCell"><c:out value="${record.value}"/></div>
                        <div class="TableCell"><c:out value="${record.type}"/></div>
                        <div class="TableCell"><c:out value="${record.description}"/></div>
                    </div>
                </c:forEach>
            </div>
            <div class="Table outerTableFooter">
                <div class="tableFootStyle">
                    <div class="links">
                        <a href="#">&laquo;</a>
                        <a class="active" href="#">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">&raquo;</a>
                    </div>
                </div>
            </div>

            <p>Suma: 300zł</p>

    </main>
</div>
</body>
</html>