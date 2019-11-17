<%-- 
    Document   : home
    Created on : 18 oct. 2019, 10:41:14
    Author     : fareskissoum
--%>

<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    .alert {
        padding: 20px;
        background-color: #f44336;
        /* Red */
        color: white;
        margin-bottom: 15px;
    }

    /* The close button */
    .closebtn {
        margin-left: 15px;
        color: white;
        font-weight: bold;
        float: right;
        font-size: 22px;
        line-height: 20px;
        cursor: pointer;
        transition: 0.3s;
    }

    /* When moving the mouse over the close button */
    .closebtn:hover {
        color: black;
    }
</style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Administration des employés</title>

</head>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration des employés</title>
        <c:if test="${empty listEmp}">
            <h1 style="color: blue">Nous devons recruter !</h1>
        </c:if>
    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
        <link rel="stylesheet" type="text/css" href="dashboard.css">
    </head>
    
    <body class="is-light-blue">
        <c:if test="${!selected}">
            <div class="alert is-alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                Veuillez sélectionner quelqu'un à modifier ou supprimer.
            </div>
        </c:if>
        <nav class="navbar has-shadow is-white" role="navigation" aria-label="main navigation">
            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <div class="navbar-item">
                        <div class="label">
                            <h1>
                                Bonjour
                                <c:out value="${admin.userName}" />
                            </h1>
                        </div>
                    </div>
                </div>
                <div class="navbar-end">
                    <div class="navbar-item">
                        <form method="POST" action="Project">
                            <input class="button is-info" type="submit" value="Déconnecter" name="logout" />
                        </form>
                    </div>
                </div>
            </div>
        </nav>
    
        <section class="section has-shadow ">
            <div class="container ">
                <form method="POST" action="Project">
                    <c:if test="${!empty listEmp}">
                        <h1 class="label">Liste des employés</h1>
                        <table class="table has-shadow">
                            <tr>
                                <th>Sel</th>
                                <th>NOM</th>
                                <th>PRENOM</th>
                                <th>TEL DOMICILE</th>
                                <th>TEL PORTABLE</th>
                                <th>TEL PROFESSIONNEL</th>
                                <th>ADRESSE</th>
                                <th>CODE POSTAL</th>
                                <th>VILLE</th>
                                <th>EMAIL</th>
                            </tr>
                            <c:forEach items="${listEmp}" var="emp">
    
                                <tr>
                                    <td>
                                        <div class="radio">
                                            <input type="radio" name="select" value="${emp.id}">
                                        </div>
                                    </td>
                                    <td>
                                        <c:out value="${emp.nom}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.prenom}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.telDomicile}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.telPortable}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.telPro}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.adresse}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.codePostal}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.ville}" />
                                    </td>
                                    <td>
                                        <c:out value="${emp.email}" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                    <div class="buttons">
                        <input class="button is-info" type="submit" value="Ajouter" name="add" />
                        <input class="button is-info" type="submit" value="Supprimer" name="delete" />
                        <input class="button is-info" type="submit" value="Modifier" name="modify" />
                    </div>
    
                </form>
            </div>
        </section>
    </body>

</html>