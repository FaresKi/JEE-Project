<%-- 
    Document   : add
    Created on : 18 oct. 2019, 15:57:17
    Author     : fareskissoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter Employé</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
        <link rel="stylesheet" type="text/css" href="dashboard.css">
    </head>

    <body>
        <section class="hero is-light-blue is-fullheight">
            <div class="hero-body">
                <div class="container">
                    <div class="columns is-centered">
                        <div class="column is-white has-shadow is-5-tablet is-4-desktop is-3-widescreen">
                            <h1 class="label">Ajout d'un Employé</h1>
                            <form method="post">
                                <div class="field">
                                    <label class="label">Nom</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Trump" type="text" name="addNom" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Prenom</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Donald " type="text" name="addPrenom" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Téléphone de domicile</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="01.41.21.23.12" type="text" name="addTeldom" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Téléphone portable</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="01.41.21.23.12" type="text" name="addTelport" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Téléphone professionnel</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="01.41.21.23.12" type="text" name="addTelpro" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Adresse</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="7 avenue de la republique" type="text" name="addAdresse"
                                               class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Code Postal</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="88123" type="text" name="addCodePostal" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Ville</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Washington" type="text" name="addVille" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Email</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Donald.Trump@gmail.com" type="email" name="addEmail" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>

                                        </span>
                                    </div>
                                </div>
                                <div class="buttons">
                                    <input class="button is-info" type="submit" value="Ajouter" name="add" />
                                    <input class="button is-info" type="submit" value="Retour à la liste" name="retour" />
                                </div>
                                <c:if test="${errorAdd}">
                                    <div class="notification is-danger">
                                        Echec de l'Ajout!
                                    </div>
                                </c:if>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

</html>