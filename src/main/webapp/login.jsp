<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style type="text/css">
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
    }
    form {
      background-color: #fff;
      max-width: 500px;
      margin: 50px auto;
      padding: 20px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.3);
      border-radius: 5px;
    }
    input[type="text"], input[type="password"] {
      display: block;
      width: 100%;
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      margin-bottom: 10px;
      box-sizing: border-box;
      font-size: 16px;
    }
    input[type="submit"] {
      display: block;
      background-color: #4CAF50;
      color: #fff;
      padding: 10px;
      border-radius: 5px;
      border: none;
      cursor: pointer;
      font-size: 16px;
    }
    input[type="submit"]:hover {
      background-color: #3e8e41;
    }
    h1 {
      text-align: center;
    }
    .error {
      color: #f00;
      font-size: 14px;
      margin: 10px 0;
    }
  </style>
</head>
<body>
<form action="login.jsp" method="post">
  <h1>登录</h1>
  <label for="userName">用户名：</label>
  <input type="text" id="userName" name="userName" required autofocus>
  <label for="password">密码：</label>
  <input type="password" id="password" name="password" required>
  <input type="submit" value="登录">
</form>
</body>
</html>
