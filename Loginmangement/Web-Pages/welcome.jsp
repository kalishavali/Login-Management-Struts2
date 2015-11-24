<%-- 
    Document   : welcome
    Created on : Nov 24, 2015, 10:45:42 PM
    Author     : Kalishavali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        Welcome,${sessionScope.username}
        <br>
        <s:a action="logout">Logout</s:a>
    </body>
</html>
