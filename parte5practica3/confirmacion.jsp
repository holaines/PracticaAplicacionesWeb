

<html>
<head>
<title>Confirmacion</title>
</head>
<body>

<%
Cookie[] cookies = request.getCookies();
String login ="";
String passwd ="";
String name ="";
String surname ="";
String address ="";
String phone ="";


    for (Cookie cookie: cookies){
    if (cookie.getName().equals("login")){
        login=cookie.getValue();
    }
    if (cookie.getName().equals("passwd")){
        passwd=cookie.getValue();
    }
    if (cookie.getName().equals("name")){
        name=cookie.getValue();
    }
    if (cookie.getName().equals("surname")){
        surname=cookie.getValue();
    }
    if (cookie.getName().equals("address")){
        address=cookie.getValue();
    }
    if (cookie.getName().equals("phone")){
        phone=cookie.getValue();
    }
}


%>
<h2>Confirmar Registro</h2>

<form action="register" method="post">
    <p>
        <label for="login">Login: <%=login%></label>
    </p>

    <p>
        <label for="passwd">Password: <%=passwd%></label>
    </p>

    <p>
        <label for="name">Nombre: <%=name%></label>
    </p>

    <p>
        <label for="surname">Apellido: <%=surname%></label>
    </p>

    <p>
        <label for="address">Address: <%=address%></label>
    </p>

    <p>
        <label for="phone">Telefono: <%=phone%></label>
    </p>

    <p>
        <input type="submit" name ="action" value="Si">
        <input type="reset" name ="action" value="No">
    </p>
</form>

</body>
</html>