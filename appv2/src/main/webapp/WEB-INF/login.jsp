<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
    <link rel="stylesheet" type="text/css" href="./dashboard.css">
</head>

<body>

    <body>
        <section class="hero is-light-blue is-fullheight">
            <div class="hero-body">
                <div class="container">
                    <div class="columns is-centered">
                        <div class="column is-white has-shadow is-5-tablet is-4-desktop is-3-widescreen">
                            <c:if test="${not empty errorConnection}">
                                <div class="notification is-danger">
                                    Echec de la connexion! Verifiez votre login et/ou mot de passe et essayer à nouveau                            
                                </div>
                            </c:if>
                            <form method="post" action="Project">
                                <div class="field">
                                    <label class="label">Login</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Donald Trump" name="login" class="input" required>
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Password</label>
                                    <div class="control has-icons-left">
                                        <input type="password" placeholder="*******" name="password" class="input"
                                            required>
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field is-centered">
                                    <button class="button is-info" type="submit" name="action" value="Submit">
                                        Login
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

</html>