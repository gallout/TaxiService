<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 19.02.2019
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Яндекс Такси 2.0</title>
    <link rel="icon" type="image/ico" href="images/taxilogo.png" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>


<style>
    body {
        background: #c7b39b url(images/Taxi-Vegas4.jpg); /* Цвет фона и путь к файлу */
        color: #fff; /* Цвет текста */
    }
</style>

<body class="w3-black">

<div class="w3-container w3-opacity w3-right-align">
    <h1 class="w3-text-white" style="text-shadow:1px 1px 0 #444">
        <b>Яндекс Такси 2.0</b></h1>
</div>


<div class="w3-container" style="padding-left: 550px">
    <form  action="client" accept-charset="UTF-8">           <!--переход на страницу-->
        <button type="submit" class="w3-button w3-block w3-white w3-round" style="width:30%">Данные о клиентах</button>
    </form>
    <form action="car" accept-charset="UTF-8">
        <button type="submit" class="w3-button w3-block w3-white w3-round" style="width:30%">Данные об автомобилях</button>
    </form>

    <form action="driver" accept-charset="UTF-8">
        <button type="submit" class="w3-button w3-block w3-white w3-round" style="width:30%">Данные о водителях</button>
    </form>
    <form action="operator" accept-charset="UTF-8">
        <button type="submit" class="w3-button w3-block w3-white  w3-round" style="width:30%">Данные об операторах</button>
    </form>
    <form action="order" accept-charset="UTF-8">
        <button type="submit" class="w3-button w3-block w3-white  w3-round" style="width:30%">Данные о заказах</button>
    </form>
</div>

</body>
</html>
