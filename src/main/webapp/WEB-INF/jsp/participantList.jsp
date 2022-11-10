<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/validation.css"/>
  <link rel="stylesheet" href="css/styles.css"/>
  <title>Participants</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Phonenumber</th>
    <th>Gender</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${participants}" var="participant">
    <c:choose>
      <c:when test="${current.phonenumber == participant.phonenumber}">
        <tr style="background-color: #aaffaa">
          <td>${participant.firstname}</td>
          <td>${participant.lastname}</td>
          <td>${participant.phonenumber}</td>
          <td>${participant.gender}</td>
        </tr>
      </c:when>
      <c:otherwise>
        <tr>
          <td>${participant.firstname}</td>
          <td>${participant.lastname}</td>
          <td>${participant.phonenumber}</td>
          <td>${participant.gender}</td>
        </tr>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  </tbody>
</table>
<form method="post" action="logout">
  <button type="submit">logout</button>
</form>
</body>
</html>
