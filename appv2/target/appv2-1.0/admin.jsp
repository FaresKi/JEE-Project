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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration des employés</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
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
