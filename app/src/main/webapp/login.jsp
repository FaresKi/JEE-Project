<%-- 
    Document   : login
    Created on : 17 Oct 2019, 10:03:21
    Author     : tomklotz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="Project">
            <table style="with: 50%">
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
            </table>
            <input type="submit" name="action" value="Submit"/></form>
    </body>
</html>
