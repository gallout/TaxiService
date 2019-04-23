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
    <title>Автомобили</title>
</head>
<style>
    body {
        background: #c7b39b url(images/Taxi-Vegas4.jpg); /* Цвет фона и путь к файлу */
        color: #fff; /* Цвет текста */
    }

    input[type=text], select {
        width: 150%;
        padding: 12px 20px;
        margin: 2px 0;
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
        margin: 2px 0;
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
<div style="float:left;">
<form action="car" accept-charset="UTF-8" method="post" style="max-width:200px; float: left">
    <p>Бренд <input type="text" name="brand" maxlength="40" pattern="[A-Za-zА-Яа-яЁё]*"></p>
    <p>Модель <input type="text" name="model" maxlength="40" pattern="[A-Za-zА-Яа-яЁё]*"></p>
    <p>Цвет <input type="text" name="color" maxlength="20" pattern="[A-Za-zА-Яа-яЁё]*"></p>
    <p>Год выпуска <input type="text" name="release_year" maxlength="10" pattern="[0-9]{4}\-[0-9]{2}\-[0-9]{2}"></p>
    <p>Гос.номер <input type="text" name="state_num" maxlength="8" pattern="[0-9]*" ></p>
    <p>Тех.статус<input type="text" name="tech_state" maxlength="15" pattern="[A-Za-zА-Яа-яЁё]*"></p>
    <p>Статус<input type="text" name="status" maxlength="15"></p>
    <input type="submit" value="Добавить автомобиль" >
    <br><br>
    <input type="button" value="Назад" onclick="window.location='/'" />
    <br>
</form>

    <table border="1" width="30%" height="30%"  style="float: right; color:black">
        <thead>
        <tr>
            <th><font color=black>Изменить</font></th>
            <th><font color=black>Бренд</font></th>
            <th><font color=black>Модель</font></th>
            <th><font color=black>Цвет</font></th>
            <th><font color=black>Год выпуска</font></th>
            <th><font color=black>Гос номер</font></th>
            <th><font color=black>Техническое состояние</font></th>
            <th><font color=black>Статус</font></th>
            <th><font color=black>Удалить</font></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cars}" var="car">
            <tr>
                <td>

                    <form action="/updateCar?id_car=${car.getIdCar()}" id="form1">
                        <div class="dropdown">
                            <button class="dropbtn" type="button" data-toggle="dropdown" aria-expanded="false">
                                Изменение <span class="caret"></span>
                            </button>
                            <ul class="dropdown-content" role="menu" aria-labelledby="dropdownMenu">

                                <label class="w3-text-blue" hidden>ID</label>
                                <input style="width:260px" type="hidden" value="${car.getIdCar()}" name="id_car"
                                       placeholder="ID"  required>

                                <label class="w3-text-blue" >Бренд</label>
                                <input style="width:260px" type="text" value="${car.getBrand()}" name="brand" maxlength="40" pattern="[A-Za-zА-Яа-яЁё]*"
                                       placeholder="Бренд"  required>

                                <label class="w3-text-blue" >Модель</label>
                                <br>
                                <input style="width:260px" type="text" value="${car.getModel()}" name="model" maxlength="40" pattern="[A-Za-zА-Яа-яЁё]*"
                                       placeholder="Модель"
                                       required>
                                <br>
                                <label class="w3-text-blue" >Цвет</label>
                                <br>
                                <input style="width:260px" type="text" value="${car.getColor()}" name="color" maxlength="20" pattern="[A-Za-zА-Яа-яЁё]*"
                                       placeholder="Цвет"  required>
                                <br>
                                <label class="w3-text-blue" >Год выпуска</label>
                                <br>
                                <input style="width:260px" type="text" value="${car.getReleaseYear()}" name="release_year" maxlength="10" pattern="[0-9]{4}\-[0-9]{2}\-[0-9]{2}"
                                       placeholder="Год выпуска"  required>

                                <label class="w3-text-blue" >Гос.номер</label>
                                <br>
                                <input style="width:260px" type="text" value="${car.getStateNum()}" name="state_num" maxlength="8" pattern="[0-9]*"
                                       placeholder="Гос.номер"  required>

                                <label class="w3-text-blue" >Техническое состояние</label>
                                <br>
                                <input style="width:260px" type="text" value="${car.getTechState()}" name="tech_state" maxlength="15" pattern="[A-Za-zА-Яа-яЁё]*"
                                       placeholder="Техническое состояние"  required>

                                <label class="w3-text-blue" >Статус</label>
                                <br>
                                <input style="width:260px" type="text" value="${car.getStatus()}" name="status"  maxlength="15"
                                       placeholder="Статус"  required>

                                <input class="submitAdd" type="submit" value="Принять">
                            </ul>
                        </div>
                    </form>

                </td>
                <td>${car.getBrand()}</td>
                <td>${car.getModel()}</td>
                <td>${car.getColor()}</td>
                <td>${car.getReleaseYear()}</td>
                <td>${car.getStateNum()}</td>
                <td>${car.getTechState()}</td>
                <td>${car.getStatus()}</td>
                <td>
                    <a href="/deleteCar?id_car=${car.getIdCar()}"> <p>Удалить</p> </a>
                </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
