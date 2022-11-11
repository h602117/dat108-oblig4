<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css" />
    <script src="js/Validation.js" defer></script>
    <title>Login</title>
  </head>
  <body>
    <h1>Login</h1>
    <form id="form-login" method="post" action="login">
      <fieldset>
        <label class="category-label" for="phonenumber">Phonenumber:</label>
        <input name="phonenumber" type="text" />
      </fieldset>

      <fieldset>
        <label class="category-label" for="password">Password:</label>
        <input name="password" type="password" />
      </fieldset>

      <fieldset>
        <label class="category-label"></label>
        <input type="submit" value="submit" />
      </fieldset>

      <a id="not-registered-link" href="register">Not registered yet?</a>
    </form>
  </body>
</html>
