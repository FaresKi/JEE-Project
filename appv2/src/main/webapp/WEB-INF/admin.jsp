<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Administration des employés</title>
    <c:if test="${empty listEmp}">
        <h1 style="color: blue">Nous devons recruter !</h1>
    </c:if>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
    <link rel="stylesheet" type="text/css" href="./dashboard.css">
</head>

<body class="is-light-blue">
    <c:if test="${!emplSelected}">
        <div class="notification is-danger">
            Veuillez sélectionner un employé.
        </div>
    </c:if>
    <c:if test="${emplDeleted}">
        <div class= "notification is-success">
            Suppression réussie! 
        </div>
    </c:if>
    <nav class="navbar has-shadow is-white" role="navigation" aria-label="main navigation">
        <div id="navbarBasicExample" class="navbar-menu">
            <div class="navbar-start">
                <div class="navbar-item">
                    <div class="label">
                        <h1>
                            Bonjour
                            <c:out value="${admin.username}" />
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
                                        <input type="radio" name="idEmpl" value="${emp.id}">
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
                    <input class="button is-info" type="submit" value="Ajouter" name="action" />
                    <input class="button is-info" type="submit" value="Supprimer" name="action" />
                    <input class="button is-info" type="submit" value="Modifier" name="action" />
                </div>

            </form>
        </div>
    </section>
</body>

</html>