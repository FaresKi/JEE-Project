<%-- 
    Document   : home
    Created on : 22 oct. 2019, 21:43:05
    Author     : fareskissoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true" %>
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
        <title>Consultation des employés</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    <c:if test="${empty listEmp}">
        <h1 style="color: blue">Nous devons recruter !</h1>
    </c:if>
    </head>
    <body>
    <c:if test="${!empty listEmp}">
        <h1>Liste des employés</h1>
        <table>
            <tr>
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
    </c:if>
    </body>
    <form method="post" action="Project">
        <div style="position: absolute; top: 10px; right: 100px;">
            Bonjour <c:out value="${user.username}" />
        </div>
        <input type="submit" value="Déconnecter" name="logout" style="position: absolute; top: 10px; right: 10px" />
    </form>
</html>
