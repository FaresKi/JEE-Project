<%-- 
    Document   : modify
    Created on : 20 oct. 2019, 14:43:14
    Author     : fareskissoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier l'employé</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
        <link rel="stylesheet" type="text/css" href="dashboard.css">
    </head>

    <body>
        <section class="hero is-light-blue is-fullheight">
            <div class="hero-body">
                <div class="container">
                    <div class="columns is-centered">
                        <div class="column is-white has-shadow is-5-tablet is-4-desktop is-3-widescreen">
                            <!--<h1 class="label">Ajout d'un Employé</h1>-->
                            <form method="post">
                                <div class="field">
                                    <label class="label">Nom</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Trump" type="text" name="modifiedNom" value="${changedEmp.nom}"
                                               class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Prenom</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Donald " type="text" name="modifiedPrenom"
                                               value="${changedEmp.prenom}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Téléphone de domicile</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="01.41.21.23.12" type="text" name="modifiedTeldom"
                                               value="${changedEmp.telDomicile}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Téléphone portable</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="01.41.21.23.12" type="text" name="modifiedTelport"
                                               value="${changedEmp.telPortable}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Téléphone professionnel</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="01.41.21.23.12" type="text" name="modifiedTelpro"
                                               value="${changedEmp.telPro}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Adresse</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="7 avenue de la republique" type="text" name="modifiedAdresse"
                                               value="${changedEmp.adresse}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Code Postal</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="88123" type="text" name="modifiedCodePostal"
                                               value="${changedEmp.codePostal}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Ville</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Washington" type="text" name="modifiedVille"
                                               value="${changedEmp.ville}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Email</label>
                                    <div class="control has-icons-left">
                                        <input placeholder="Donald Trump" type="email" name="modifiedEmail"
                                               value="${changedEmp.email}" class="input">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope"></i>

                                        </span>
                                    </div>
                                </div>
                                <div class="buttons">
                                    <input class="button is-info" type="submit" value="Modifier" name="modify" />
                                    <input class="button is-info" type="submit" value="Retour à la liste" name="retour" />
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

</html>