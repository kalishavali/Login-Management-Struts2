<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome, ${sessionScope.username}</h1>
        <br>
        <a href="AccountController?action=logout">Logout</a>
    </body>
</html>
