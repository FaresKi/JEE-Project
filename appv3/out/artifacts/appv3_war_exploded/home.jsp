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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultation des employés</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
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
    </body>
    <form method="post" action="Project">
        <div style="position: absolute; top: 10px; right: 100px;">
            Bonjour <c:out value="${user.username}" />
        </div>
        <input type="submit" value="Déconnecter" name="logout" style="position: absolute; top: 10px; right: 10px" />
    </form>
</html>
