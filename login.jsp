<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <fieldset>
            ${error}
            <form action="AccountController" method="post">
                <table cellpadding="2" cellspacing=""2>
                    <tr>
                        <td>username</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="checkbox" name="remember"/> Remember Me?</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </form>
            
        </fieldset>
    </body>
</html>
