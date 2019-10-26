

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <table style="with: 50%">
                <tr>
                    <td>Login</td>
			<td><input type="text" name="login" /></td>
		</tr>	
                <tr>
                    <td>Password</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<input type="submit" value="Submit" />
        </form>
    </body>
</html>
