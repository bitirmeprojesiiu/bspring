<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<style>


* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
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

  .header-right {
    float: none;
  }
}
.center {
  margin-left: auto;
  margin-right: auto;
  width: 20%;
  padding: 10px;
  margin-top: 20px;
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
    <a href="/candidates">Adaylar</a>
    <a href="/results">Sonuçlar</a>
    <a href="#about">Hesabım</a>
    <a href="/index">Çıkış</a>
  </div>
</div>

<form class="center">
  <div class="row">
    <div class="col-25">
      <label for="name">Sınav adı</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="examname" placeholder="Sınav adı.." path= "name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="job">İş tanımı</label>
    </div>
    <div class="col-75">
      <input type="text" id="job" name="jobdescription" placeholder="İş tanımı.." path= "job">
    </div>
  </div>

  <input type="submit" >
</form>
</body>
</html>