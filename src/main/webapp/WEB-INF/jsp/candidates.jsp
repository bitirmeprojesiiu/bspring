<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List,bitirme.service.ExamServiceWeb" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bitirme.model.ClassicExam" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <style>
    * {
      box-sizing: border-box;
    }
    body {
      margin: 0;
      font-family: Arial, Helvetica, sans-serif;
    }
    input[type=text], select, textarea {
      width: 20%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 4px;
      resize: vertical;
    }

    label {
      padding: 12px 12px 12px 0;
      display: inline-block;
    }

    input[type=submit] {
      background-color: #4CAF50;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      float: right;
    }

    input[type=submit]:hover {
      background-color: #45a049;
    }

    container {
      border-radius: 5px;
      padding: 20px;
    }
    /* Container for flexboxes */
    section {
      display: -webkit-flex;
      display: flex;
    }



    /* Style the left table */
    tableleft {
      -webkit-flex: 3;
      -ms-flex: 3;
      flex: 3;
      padding: 20px;
    }

    /* Style the right table */
    tableright {
      -webkit-flex: 3;
      -ms-flex: 3;
      flex: 3;
      padding: 20px;
    }
    .header {
      overflow: hidden;
      background-color: #f1f1f1;
      padding: 20px 10px;
    }


    .header a {
      float: left;
      color: black;
      text-align: center;
      padding: 12px;
      text-decoration: none;
      font-size: 18px;
      line-height: 25px;
      border-radius: 4px;
    }
    .header a.logo {
      font-size: 25px;
      font-weight: bold;
    }

    .header a:hover {
      background-color: #ddd;
      color: black;
    }

    .header a.active {
      background-color: dodgerblue;
      color: white;
    }

    .header-right {
      float: right;
    }

    @media screen and (max-width: 500px) {
      .header a {
        float: none;
        display: block;
        text-align: left;

      }
      section {
        -webkit-flex-direction: column;
        flex-direction: column;
      }

    }

    table {
      border-collapse: collapse;
      width: 90%;
    }

    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    tr:hover {background-color:#f5f5f5;}



    form {
      width: 70%;
      padding: 20px;
    }
    .btn{

      background-color: dodgerblue;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      float: left;
    }

  </style>
  <title>Insert title here</title>
</head>
<body>

<div class="header">
  <a href="#default" class="logo">CompanyLogo</a>
  <div class="header-right">
    <a href="/home">Ana sayfa</a>
    <a href="/exams">Sınavlar</a>
    <a class="active" href="/candidates">Adaylar</a>
    <a href="/results">Sonuçlar</a>
    <a href="#about">Hesabım</a>
    <a href="/index">Çıkış</a>
  </div>
</div>



<div class="container">
  <p font-size="15px">Sınav ara</p>
  <form action="/action_page.php">
    <div>
      <label for="id">Aday no</label>
      <input type="text" id="id" name="Aday No" placeholder="..">

      <label for="name">Aday adı</label>
      <input type="text" id="name" name="Aday Adı" placeholder="..">

      <label for="lname">Aday soyadı</label>
      <input type="text" id="lname" name="Aday Soyadı" placeholder="..">

      <input type="submit" value="Aday Ara">
      <input type="submit" value="Aday ekle" formaction="/addcandidate">


    </div>
  </form>
</div>

<section>
  <tableleft>
    <p>Adaylar</p>
    <table>
      <tr>
        <th>Numara</th>
        <th>Adı</th>
        <th>Soyadı</th>
      </tr>

      <!--
      ArrayList<ClassicExam> exm =
      (ArrayList<ClassicExam>)request.getAttribute("exam");
      for(ClassicExam e:exm){
      -->
      <tr>
        <th><c:out value="${e.getExamId()}"/></th>
        <th><c:out value="${e.getExamId()}"/></th>
        <th><c:out value="${e.getExamId()}"/></th>
      </tr>

    </table>
  </tableleft>


</section>
</body>
</html>
