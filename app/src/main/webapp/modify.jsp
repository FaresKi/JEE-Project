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
    </head>
    <body>
        <form method="post">
            <div>
                <label for="name">Nom :</label>
                <input type="text" id="name" name="nom" value = "${changedEmp.nom}">
            </div>
            <div>
                <label for="name">Prénom :</label>
                <input type="text" id="name" name="prenom" value = "${changedEmp.prenom}">
            </div>
            <div>
                <label for="name">Téléphone de domicile :</label>
                <input type="text" id="name" name="teldom" value = "${changedEmp.telDomicile}" >
            </div>    
            <div>
                <label for="name">Téléphone portable :</label>
                <input type="text" id="name" name="telport" value = "${changedEmp.telPortable}"  >
            </div>    
            <div>
                <label for="name">Téléphone professionnel :</label>
                <input type="text" id="name" name="telpro" value = "${changedEmp.telPro}">
            </div>
            <div>
                <label for="name">Adresse :</label>
                <input type="text" id="name" name="adresse" value = "${changedEmp.adresse}">
            </div>
            <div>
                <label for="name">Code Postal :</label>
                <input type="text" id="name" name="codepostal" value = "${changedEmp.codePostal}">
            </div>
            <div>
                <label for="name">Ville :</label>
                <input type="text" id="name" name="ville" value = "${changedEmp.ville}">
            </div>
            <div>
                <label for="mail">e-mail :</label>
                <input type="email" id="mail" name="email" value = "${changedEmp.email}" >
            </div>

            <input type="submit" value="Modifier" />
            <input type="submit" value="Retour à la liste" name="retour"/>
        </form>
    </body>
</html>
