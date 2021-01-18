<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Каталог продуктов</title>
</head>
<body>
<h3 class="text-center"><a href="/">Каталог продуктов</a></h3>
<br>
<div class="jumbotron pt-4">
    <div>Фильтр по названию</div>
    <form method="get" action="/">
        <input type="text" name="filter" value="" placeholder="Пустой запрос вернет весь список продуктов" size="40">
        <button type="submit">Найти</button>
    </form>
    <div class="jumbotron pt-4">
        <div class="container">
            <a href="/create">Создать продукт</a>
            <br>
            <table border="1" cellpadding="8" cellspacing="0">
                <thead>
                <tr>
                    <th>Название продукта</th>
                    <th>Описание продукта</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${products}" var="products">
                    <tr>
                        <th>${products.name}</th>
                        <th> ${products.description}</th>
                        <td><a href="/delete?id=${products.id}">Удалить</a>
                        <td><a href="/update?id=${products.id}">Редактировать</a>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
