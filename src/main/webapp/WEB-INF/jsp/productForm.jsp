<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Создать продукт</title>
</head>

<body>
<a href="/">Каталог продуктов</a>

<jsp:useBean id="product" type="den.product.model.Products" scope="request"/>
<h3>${product.isNew() ? 'Создание продукта' : 'Изменение данных о продукте'}</h3>
<form method="post" action="/">
    <form:form name="profileForm" class="form-group" method="post" modelAttribute="product"
               action="/">
        <input type="hidden" name="id" value="${product.id}">
        <dl>
            <dt>Название продукта:</dt>
            <input type="text" value="${product.name}" name="name" size="30" placeholder="" required>
            <form:errors path="name" cssClass="error"/>
        </dl>
        <dl>
            <dt>Описание продукта:</dt>
            <input type="text" value="${product.description}" name="description" style="height:100px" size="100"
                   placeholder="" required>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form:form>
</form>
</body>
</html>
