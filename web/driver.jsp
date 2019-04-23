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
    <title>Водитель</title>
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
        margin-left: 55px;
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
        grid-template-columns: 1fr 1fr 1fr;
        grid-column-gap: 5px;
    }

    .block-alignment > div {
        text-align: center;
        height: 350px;
    }
</style>

<body>
<div style="float:left;">
<form action="driver" accept-charset="UTF-8" method="post">
<div class="block-alignment">
    <div>
        <p>Фио</p> <input type="text" name="fio" maxlength="40" pattern="[А-Яа-я]*?\s[А-Яа-я]*?\s[А-Яа-я]*">
        <p>Серия паспорта</p><input type="text" name="pass_seria" maxlength="4" pattern="[0-9]{4}">
        <p>Номер паспорта</p><input type="text" name="pass_numb" maxlength="6" pattern="[0-9]{6}">
    </div>
    <div>
        <p>ИНН</p> <input type="text" name="inn"  maxlength="12" pattern="[0-9]{12}">
        <p>Лицензия</p> <input type="text" name="licence" maxlength="8" pattern="[0-9]{,8}">
        <p>Стаж</p> <input type="text" name="stage" maxlength="2" pattern="[0-9]{,2}">
    </div>
    <div>
        <p>Категория</p> <input type="text" name="category" maxlength="1" pattern="[A-Za-zА-Яа-яЁё]">
        <p>Личный авто</p><input type="text" name="personal_auto" maxlength="3" pattern="[a-я]{,3}">
        <p>Число поездок</p><input type="text" name="trip_num" maxlength="8" pattern="[0-9]{,8}">
    </div>
</div>
    <input type="submit" value="Отправить" >
    <br>
    <input type="button" value="Назад" onclick="window.location='/'" />
    <br>
</form>


    <table border="1" width="20%" height="30%" style="float: left; color:black" >
        <thead>
        <tr>
            <th><font color=black>Изменить</font></th>
            <th><font color=black>Фио</font></th>
            <th><font color=black>Серия паспорта</font></th>
            <th><font color=black>Номер паспорта</font></th>
            <th><font color=black>ИНН</font></th>
            <th><font color=black>Лицензия</font></th>
            <th><font color=black>Стаж</font></th>
            <th><font color=black>Категория</font></th>
            <th><font color=black>Личный автомобиль</font></th>
            <th><font color=black>Количество поездок</font></th>
            <th><font color=black>Удалить</font></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${drivers}" var="driver">
            <tr>
                <td>
                    <form action="/updateDriver?id_driver=${driver.getIdDriver()}">
                        <div class="dropdown">
                            <button class="dropbtn" type="button" data-toggle="dropdown" aria-expanded="false">
                                Изменение <span class="caret"></span>
                            </button>
                            <ul class="dropdown-content" role="menu" aria-labelledby="dropdownMenu">
                                <label class="w3-text-blue" hidden>ID</label>
                                <input style="width:260px" type="hidden" value="${driver.getIdDriver()}" name="id_driver"
                                       placeholder="ID"  required>

                                <label class="w3-text-blue" >Фамилия водителя</label>
                                <input style="width:260px" type="text" value="${driver.getFio()}" name="fio"  maxlength="40" pattern="[А-Яа-я]*?\s[А-Яа-я]*?\s[А-Яа-я]*"
                                       placeholder="Фамилия водителя"  required>

                                <label class="w3-text-blue" >Серия паспорта</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getPassSeria()}" name="pass_seria" maxlength="4" pattern="[0-9]{4}"
                                       placeholder="Серия паспорта"
                                       required>

                                <label class="w3-text-blue" >Номер паспорта</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getPassNumb()}" name="pass_numb"  maxlength="6" pattern="[0-9]{6}"
                                       placeholder="Номер паспорта"  required>
                                <br>
                                <label class="w3-text-blue" >ИНН</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getInn()}" name="inn" maxlength="12" pattern="[0-9]{12}"
                                       placeholder="ИНН"  required>

                                <label class="w3-text-blue" >Лицензия</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getLicence()}" name="licence" maxlength="8" pattern="[0-9]{,8}"
                                       placeholder="Лицензия"  required>
                                <br>
                                <label class="w3-text-blue" >Стаж</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getStage()}" name="stage" maxlength="2" pattern="[0-9]{,2}"
                                       placeholder="Стаж"  required>

                                <label class="w3-text-blue" >Категория</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getCategory()}" name="category" maxlength="1" pattern="[A-Za-zА-Яа-яЁё]"
                                       placeholder="Категория"  required>

                                <label class="w3-text-blue" >Личный авто</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getPersonalAuto()}" name="personal_auto" maxlength="3" pattern="[a-я]{,3}"
                                       placeholder="Личный авто"  required>

                                <label class="w3-text-blue" >Количество поездок</label>
                                <br>
                                <input style="width:260px" type="text" value="${driver.getTripNum()}" name="trip_num"  maxlength="8" pattern="[0-9]{,8}"
                                       placeholder="Количество поездок"  required>
                                <input class="submitAdd" type="submit" value="Принять">
                            </ul>
                        </div>
                    </form>
                </td>
                <td>${driver.getFio()}</td>
                <td>${driver.getPassSeria()}</td>
                <td>${driver.getPassNumb()}</td>
                <td>${driver.getInn()}</td>
                <td>${driver.getLicence()}</td>
                <td>${driver.getStage()}</td>
                <td>${driver.getCategory()}</td>
                <td>${driver.getPersonalAuto()?"да":"нет"}</td>
                <td>${driver.getTripNum()}</td>
                <td>
                    <a href="/deleteDriver?id_driver=${driver.getIdDriver()}"> <p>Удалить</p> </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
