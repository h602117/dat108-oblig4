<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/validation.css" />
    <link rel="stylesheet" href="css/styles.css" />
    <script src="js/Validation.js" defer></script>
    <title>Register</title>
  </head>
  <body>
    <h1>Register for the party</h1>
    <form id="form-register" method="post" action="register">
      <fieldset>
        <label class="category-label" for="firstname">First Name:</label>
        <input
          type="text"
          name="firstname"
          required
          pattern="([A-ZÆØÅ][a-zæøå-]+\s?)+"
          title="Firstname must begin with a capital letter and contain only letters"
        />
      </fieldset>

      <fieldset>
        <label class="category-label" for="lastname">Last Name:</label>
        <input
          type="text"
          name ="lastname"
          required
          pattern="[A-ZÆØÅ][a-zæøå-]+"
          title="Lastname must begin with a capital letter and contain only letters"
        />
      </fieldset>

      <fieldset>
        <label class="category-label" for="phonenumber">Phonenumber:</label>
        <input
          type="text"
          name ="phonenumber"
          required
          pattern="[0-9]{8}"
          title="Enter your phonenumber"
        />
      </fieldset>

      <fieldset>
        <label class="category-label" for="password">Password:</label>
        <input
          id="password"
          name="password"
          type="password"
          required
          minLength="8"
        />
      </fieldset>

      <fieldset>
        <label class="category-label" for="repeatpassword">Repeat Password:</label>
        <input
          id="repeatpassword"
          name="repeatpassword"
          type="password"
          required
          minLength="8"
        />
      </fieldset>

      <fieldset>
        <label class="category-label">Gender:</label>
        <input type="radio" name="gender" value="M" id="male" required />
        <label for="male">Male</label>
        <input type="radio" name="gender" value="F" id="female" required />
        <label for="female">Female</label>
      </fieldset>

      <fieldset>
        <label class="category-label"></label>
        <input type="submit" value="register" />
      </fieldset>
    </form>
  </body>
</html>
