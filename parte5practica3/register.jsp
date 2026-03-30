<%
Cookie[] cookies = request.getCookies();
String error ="";
    for (Cookie cookie: cookies){
    if (cookie.getName().equals("error")){
        error=cookie.getValue();
    }
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<body>

<h2>Registro de Usuario</h2>
<%
   if (!error.equals("")) {
%>
   <div>
   	<label><%=error%></label>	
   </div>	
<%
  }
%>
<form action="confirmacion" method="post">

    <label>Login:</label><br>
    <input type="text" name="login" maxlength="16" required><br><br>

    <label>Password:</label><br>
    <input type="passwd" name="passwd" maxlength="16" required><br><br>

    <label>Nombre:</label><br>
    <input type="text" name="name" maxlength="16" required><br><br>

    <label>Apellido:</label><br>
    <input type="text" name="surname" maxlength="16" required><br><br>

    <label>Dirección:</label><br>
    <input type="text" name="address" maxlength="16" required><br><br>

    <label>Teléfono:</label><br>
    <input type="text" name="phone" maxlength="16" required><br><br>

    <input type="submit" value="Registrarse">

</form>

</body>
</html>