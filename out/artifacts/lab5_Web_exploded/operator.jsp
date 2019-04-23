<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 03.04.2019
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import ="java.sql.*" %>
<%@page import ="java.lang.String" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<link rel="stylesheet" href="style.css">

<html>
<head>
    <title>Оператор</title>
</head>
<style>
    body {
        background: #c7b39b url(images/Taxi-Vegas4.jpg); /* Цвет фона и путь к файлу */
        color: #fff; /* Цвет текста */
    }

    input[type=text], select {
        width: 150%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        padding: 20px;
    }

    table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-radius: 10px;
        border-spacing: 0;
        text-align: left;
    }
    th {
        background: #aacce0;
        color: white;
        text-shadow: 0 1px 1px #ffffff;
        padding: 10px 10px;
        text-align: center;
    }
    th {
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: whitesmoke;
    }
    th:first-child, td:first-child {
        text-align: left;
    }
    th:first-child {
        border-top-left-radius: 10px;
    }
    th:last-child {
        border-top-right-radius: 10px;
        border-right: none;
    }
    td {
        background: #ffffff;
        padding: 0px 10px;
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: #aacce0;

    }
    tr:last-child td:first-child {
        border-radius: 0 0 0 10px;
    }
    tr:last-child td:last-child {
        border-radius: 0 0 10px 0;
    }
    tr td:last-child {
        border-right: none;
    }
    /* Dropdown Button */
    .dropbtn {
        background-color: #4CAF50;
        color: white;
        padding: 16px;
        font-size: 16px;
        border: none;
    }

    /* The container <div> - needed to position the dropdown content */
    .dropdown {
        position: relative;
        display: inline-block;
    }

    /* Dropdown Content (Hidden by Default) */
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f1f1f1;
        min-width: 300px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        padding-top: 20px;
    }

    /* Links inside the dropdown */
    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    /* Change color of dropdown links on hover */
    .dropdown-content a:hover {background-color: #ddd;}

    /* Show the dropdown menu on hover */
    .dropdown:hover .dropdown-content {display: block;}

    /* Change the background color of the dropdown button when the dropdown content is shown */
    .dropdown:hover .dropbtn {background-color: #3e8e41;}

    .dropdown-button { max-width:100px;}
</style>
<body>
<form action="operator" accept-charset="UTF-8" method="post" style="max-width:200px; float: left ;margin-left: 55px;">
    <p>Фио <input type="text" name="fio" maxlength="40" pattern="[А-Яа-я]*?\s[А-Яа-я]*?\s[А-Яа-я]*"></p>
    <p>Адрес <input type="text" name="adress" maxlength="40"></p>
    <p>Контактный телефон <input type="text" name="contact_num" maxlength="12" pattern="[0-9]{10,12}"></p>
    <input type="submit" value="Отправить" >
    <br>
    <input type="button" value="Назад" onclick="window.location='/'" />
    <br>
</form>

</div>
<div>
    <table border="1" width="30%" height="30%" style="float: right; color:black">
        <thead>
        <tr>
            <th><font color=black>Изменить</font></th>
            <th><font color=black>Фио</font></th>
            <th><font color=black>Адрес</font></th>
            <th><font color=black>Контактный телефон</font></th>
            <th><font color=black>Удалить</font></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${operators}" var="operator">
            <tr>
                <td>
                    <form action="/updateOperator?id_operator=${operator.getIdOperator()}">
                        <div class="dropdown">
                            <button class="dropbtn" type="button" data-toggle="dropdown" aria-expanded="false">
                                Изменение <span class="caret"></span>
                            </button>
                            <ul class="dropdown-content" role="menu" aria-labelledby="dropdownMenu">
                                <label class="w3-text-blue" hidden>ID</label>
                                <input style="width:260px" type="hidden" value="${operator.getIdOperator()}" name="id_operator"
                                       placeholder="ID"  required>

                                <label class="w3-text-blue" >Фамилия оператора</label>
                                <input style="width:260px" type="text" value="${operator.getFio()}" name="fio" maxlength="40" pattern="[А-Яа-я]*?\s[А-Яа-я]*?\s[А-Яа-я]*"
                                       placeholder="Фамилия оператора"  required>

                                <label class="w3-text-blue" >Адрес</label>
                                <br>
                                <input style="width:260px" type="text" value="${operator.getAddress()}" name="adress" maxlength="40"
                                       placeholder="Адрес"
                                       required>

                                <label class="w3-text-blue" >Контактный телефон</label>
                                <br>
                                <input style="width:260px" type="text" value="${operator.getContactNum()}" name="contact_num" maxlength="12" pattern="[0-9]{10,12}"
                                       placeholder="Контактный телефон"  required>

                                <input class="submitAdd" type="submit" value="Принять">
                            </ul>
                        </div>
                    </form>
                </td>
                <td>${operator.getFio()}</td>
                <td>${operator.getAddress()}</td>
                <td>${operator.getContactNum()}</td>
                <td>
                    <a href="/deleteOperator?id_operator=${operator.getIdOperator()}"> <p>Удалить</p> </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
