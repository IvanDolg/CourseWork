<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 22.09.2023
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
  <title>Home</title>
</head>
<body>
  <jsp:include page="_header.jsp"/>

  <div class="container-fluid">
    <div class="row">

      <div class="col-md-6">
        <!-- Левая область -->
        <div style="background-color: #f0f0f0; height: 100vh;">
          <!-- Ваше содержимое для левой области -->
          <div class="container">
            <div class="row">
              <div class="col">
                <%--Описание бд--%>
                    <div class="container">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title">Краткая информация о базе данных "Компьютерная фирма":</h5>
                          <p class="card-text">Схема БД состоит из четырех таблиц:
                            Product(maker, model, type)
                            PC(code, model, speed, ram, hd, cd, price)
                            Laptop(code, model, speed, ram, hd, price, screen)
                            Printer(code, model, color, type, price)
                            Таблица Product представляет производителя (maker), номер модели (model) и тип ('PC' - ПК, 'Laptop' - ПК-блокнот или 'Printer' - принтер).
                            Предполагается, что номера моделей в таблице Product уникальны для всех производителей и типов продуктов.
                            В таблице PC для каждого ПК, однозначно определяемого уникальным кодом – code, указаны модель – model (внешний ключ к таблице Product),
                            скорость - speed (процессора в мегагерцах), объем памяти - ram (в мегабайтах), размер диска - hd (в гигабайтах), скорость считывающего устройства - cd
                            (например, '4x') и цена - price (в долларах). Таблица Laptop аналогична таблице РС за исключением того, что вместо скорости CD содержит размер экрана -screen (в дюймах).
                            В таблице Printer для каждой модели принтера указывается, является ли он цветным - color ('y', если цветной), тип принтера - type (лазерный – 'Laser', струйный – 'Jet' или матричный – 'Matrix') и цена - price.</p>

                          <div class="d-flex justify-content-center">
                            <a href="https://www.sql-ex.ru/help/select13.php#db_1" class="btn btn-primary">Краткая информация о базе данных "Компьютерная фирма"</a>
                          </div>
                        </div>
                      </div>
                    </div>

                  <%--Задание к вопросу--%>
                    <div class="container">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title">Задание: 1 </h5>
                          <p class="card-text"><%--<%= request.getAttribute("description")--%> %></p>

                          <form action="exercises" method="GET">
                            <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="exerciseId">
                              <option selected disabled>Choose exercise</option>
                              <option value="1">Exercise 1</option>
                              <option value="2">Exercise 2</option>
                              <option value="3">Exercise 3</option>
                            </select>
                            <input type="submit" value="Submit">
                          </form>

                          <hr class="my-4">
                          <p>Справка по теме:</p>
                          <a href="http://www.sql-tutorial.ru/ru/book_simple_select_statement/page1.html" class="btn btn-primary">Простой оператор Select</a>
                        </div>
                      </div>
                    </div>

              </div>
            </div>
          </div>
        </div>
      </div>



      <div class="col-md-6">
        <!-- Правая область -->
        <div class="container">
          <div class="row">
            <div class="col">
              <!-- Область для ввода текста -->
              <div class="form-group">
                <label for="exampleTextarea">Введите текст:</label>
                <textarea class="form-control" id="exampleTextarea" rows="5"></textarea>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
          crossorigin="anonymous"></script>
</body>
</html>
