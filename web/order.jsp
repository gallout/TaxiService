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
    <title>Заказы</title>
</head>
<style>
    body {
        background: #c7b39b url(images/Taxi-Vegas4.jpg); /* Цвет фона и путь к файлу */
        color: #fff; /* Цвет текста */
    }

    input[type=text], select {
        width: 250px;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 250px;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-left: 55px;
    }
    input[type=button] {
        margin-left: 55px;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
    }

    table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-radius: 10px;
        border-spacing: 0;
        text-align: left;
        margin-top: 450px;
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
        padding: 2px 12px;
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: #aacce0;
        padding-top: 10px;
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

    .block-alignment {
        display: grid;
        grid-template-columns: 1fr 1fr 1fr ;
        grid-column-gap: 5px;
    }

    .block-alignment > div {
        text-align: center;

    }
</style>

<body>
<div style="float:left;">
    <form action="order" accept-charset="UTF-8" method="post" style="max-width:200px; float: left" >

        <div class="block-alignment" style="margin-left: 55px;">
            <div>
                <p>Дата отправки</p> <input type="text" name="order_get_date" maxlength="10" pattern="[0-9]{4}\-[0-9]{2}\-[0-9]{2}">
                <p>Время отправки</p><input type="text" name="order_get_time" maxlength="8" pattern="[0-9]{2}\:[0-9]{2}\:[0-9]{2}">
                <p>Место отправки</p> <input type="text" name="departure_point" maxlength="20" pattern="[A-Za-zА-Яа-яЁё]">
            </div>
            <div>
                <p>Дата прибытия</p> <input type="text" name="order_set_date" maxlength="10" pattern="[0-9]{4}\-[0-9]{2}\-[0-9]{2}">
                <p>Время прибытия</p> <input type="text" name="order_set_time" maxlength="8" pattern="[0-9]{2}\:[0-9]{2}\:[0-9]{2}">
                <p>Место назначения</p> <input type="text" name="destination_point" maxlength="20" pattern="[A-Za-zА-Яа-яЁё]">
            </div>
            <div>
                <p>Статус заказа</p> <input type="text" name="order_status" maxlength="20">
                <p>Цена заказа </p><input type="text" name="order_price" maxlength="12" pattern="[0-9]{12}">
            </div>
        </div>

        <input type="submit" value="Добавить данные о заказе" >
        <br>
        <input type="button" value="Назад" onclick="window.location='/'" />
        <br>
    </form>
</div>

<div>
    <table border="1" width="30%" height="30%" style="float: left; color:black">
        <thead>
        <tr>
            <th><font color=black>Изменить</font></th>
            <th><font color=black>Дата отправки</font></th>
            <th><font color=black>Время отправки</font></th>
            <th><font color=black>Дата прибытия</font></th>
            <th><font color=black>Время прибытия</font></th>
            <th><font color=black>Место отправки</font></th>
            <th><font color=black>Место назначения</font></th>
            <th><font color=black>Статус заказа</font></th>
            <th><font color=black>Сумма заказа</font></th>
            <th><font color=black>Удалить</font></th>
        </tr>
        </thead>
        <tbody>

        <jsp:useBean id="orders" scope="request" type="java.util.List"/>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>
                    <form action="/updateOrder?id_order=${order.getIdOrder()}">
                        <div class="dropdown">
                            <button class="dropbtn" type="button" data-toggle="dropdown" aria-expanded="false">
                                Изменение <span class="caret"></span>
                            </button>
                            <ul class="dropdown-content" role="menu" aria-labelledby="dropdownMenu">
                                <label class="w3-text-blue" hidden>ID</label>
                                <input style="width:260px" type="hidden" value="${order.getIdOrder()}" name="id_order"
                                       placeholder="ID"  required>

                                <label class="w3-text-blue">Дата отправки</label>
                                <input style="width:260px" type="text" value="${order.getOrderGetDate()}" name="order_get_date"
                                       placeholder="Дата отправки"  required>

                                <label class="w3-text-blue" >Время отправки</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getOrderGetTime()}" name="order_get_time"
                                       placeholder="Время отправки"
                                       required>
                                <br>
                                <label class="w3-text-blue" >Дата прибытия</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getOrderSetDate()}" name="order_set_date"
                                       placeholder="Дата прибытия"  required>

                                <label class="w3-text-blue" >Время прибытия</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getOrderSetTime()}" name="order_set_time"
                                       placeholder="Время прибытия"  required>

                                <label class="w3-text-blue" >Место отправки</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getDeparturePoint()}" name="departure_point"
                                       placeholder="Место отправки"  required>

                                <label class="w3-text-blue" >Место назначения</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getDestinationPoint()}" name="destination_point"
                                       placeholder="Место назначения"  required>

                                <label class="w3-text-blue" >Статус заказа</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getOrderStatus()}" name="order_status"
                                       placeholder="Статус заказа"  required>

                                <label class="w3-text-blue" >Сумма заказа</label>
                                <br>
                                <input style="width:260px" type="text" value="${order.getOrderPrice()}" name="order_price"
                                       placeholder="Сумма заказа"  required>

                                <input class="submitAdd" type="submit" value="Принять">
                            </ul>
                        </div>
                    </form>
                </td>
                <td>${order.getOrderGetDate()}</td>
                <td>${order.getOrderGetTime()}</td>
                <td>${order.getOrderSetDate()}</td>
                <td>${order.getOrderSetTime()}</td>
                <td>${order.getDeparturePoint()}</td>
                <td>${order.getDestinationPoint()}</td>
                <td>${order.getOrderStatus()}</td>
                <td>${order.getOrderPrice()}</td>
                <td>
                    <a href="/deleteOrder?id_order=${order.getIdOrder()}"> <p>Удалить</p> </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
