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
        background-color: #f44336; /* Red */
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
        <c:if test="${empty listEmp}">
            <h1 style="color: blue">Nous devons recruter !</h1>
        </c:if>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
    <c:if test="${!selected}">
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Veuillez sélectionner quelqu'un à modifier ou supprimer.
        </div>
    </c:if>
        <h1>Liste des employés</h1>
        <form method="POST" action="Project">
            <table>
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
                            <c:out value="${emp.nom}"/>
                        </td>
                        <td>
                            <c:out value="${emp.prenom}"/>
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
            
            <input type="submit" value="Ajouter" name="add" />
            <input type="submit" value="Supprimer" name="delete"/>
            <input type="submit" value="Modifier" name="modify"/>
            <input type="submit" value="Déconnecter" name="logout"/>
        </form>
    </body>
</html>
