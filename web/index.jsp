<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Data</title>
  <style>
    .fig {
      text-align: left;
      margin-bottom: 0px;
    }
  </style>
</head>
<body>
<table border="1" width="60%" cellpadding="5">
  <tr>
    <th bgcolor="#5692f8"> 	<h3 class="fig">Регистрация</h3>	</th>
    <th bgcolor="#60b42e">	<h3 class="fig">Авторизация</h3>	</th>
  </tr>
  <tr>
    <th bgcolor="#94bdff"><form method="post" action="/Registrad" class="fig">
      &#160&#160&#160&#160&#160&#160&#160Login:<input type="text" name="regLogin"><br><br>
      Password:<input type="text" name="regPass">
      <input type="submit" name="registr" value="Регистрация">
    </form> </th>
    <th bgcolor="#8dc16d"><form method="post" action="/Autentification" class="fig">
      &#160&#160&#160&#160&#160&#160&#160Login:<input type="text" name="autLogin"><br><br>
      Password:<input type="text" name="autPass">
      <input type="submit" name="registr" value="Авторизация">
    </form> </th>
  </tr>
</table>
<p class="fig">${message}</p>
</body>
</html>
