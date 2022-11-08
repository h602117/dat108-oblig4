<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/main.css" />
  <link rel="stylesheet" href="css/styles.css" />
  <script src="js/Validation.js" defer></script>
  <title>Register</title>
</head>
<body>
  <form method="post" action="register">
    <label for="firstname">
        First Name:
        <input
          type="text"
          name="firstname"
          required pattern="([A-ZÆØÅ][a-zæøå-]+\s?)+"
          title="Firstname must begin with a capital letter and contain only letters"
        />
    </label>
    <label for="lastname">
        Last Name:
        <input
          type="text"
          name ="lastname"
          required pattern="([A-ZÆØÅ][a-zæøå-]+\s?)+"
          title="Lastname must begin with a capital letter and contain only letters"
        />
    </label>
    <label for="phonenumber">
        Phonenumber:
        <input
          type="text"
          name ="phonenumber"
          required pattern="[0-9]{8}"
          title="Enter your phonenumber"
        />
    </label>
       <label for="password">
        Password:
        <input id="password" name="password" type="password">
    </label>
    <label for="repeatpassword">
      Repeat Password:
      <input id="repeatpassword" name="repeatpassword" type="password">
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
