<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
</head>
<body>
  <form method="post" action="register">
    <label for="firstname">
        First Name:
        <input name="firstname">
    </label>
       <label for="lastname">
        Last Name:
        <input name="lastname">
    </label>
       <label for="phonenumber">
        Phonenumber:
        <input name="phonenumber">
    </label>
       <label for="password">
        Password:
        <input name="password" type="password">
    </label>
    <label for="repeatpassword">
      Repeat Password:
      <input name="repeatpassword" type="password">
    </label>
    <label>
      Gender:
      <input type="radio" name="gender" value="M" id="male" />
      <label for="male">Male</label>
      <input type="radio" name="gender" value="F" id="female" />
      <label for="female">Female</label>
    </label>
    <input type="submit" value="register" />
  </form>
</body>
</html>
