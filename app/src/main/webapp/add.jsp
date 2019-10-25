<%-- 
    Document   : add
    Created on : 18 oct. 2019, 15:57:17
    Author     : fareskissoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter Employé</title>
    </head>
    <body>
        <h1>Ajout d'un Employé</h1>
        <form method="post">
            <div>
                <label for="name">Nom :</label>
                <input type="text" id="name" name="addNom">
            </div>
            <div>
                <label for="name">Prénom :</label>
                <input type="text" id="name" name="addPrenom">
            </div>
            <div>
                <label for="name">Téléphone de domicile :</label>
                <input type="text" id="name" name="addTeldom">
            </div>    
            <div>
                <label for="name">Téléphone portable :</label>
                <input type="text" id="name" name="addTelport">
            </div>    
            <div>
                <label for="name">Téléphone professionnel :</label>
                <input type="text" id="name" name="addTelpro">
            </div>
            <div>
                <label for="name">Adresse :</label>
                <input type="text" id="name" name="addAdresse">
            </div>
            <div>
                <label for="name">Code Postal :</label>
                <input type="text" id="name" name="addCodePostal">
            </div>
            <div>
                <label for="name">Ville :</label>
                <input type="text" id="name" name="addVille">
            </div>
            <div>
                <label for="mail">e-mail :</label>
                <input type="email" id="mail" name="addEmail">
            </div>

            <input type="submit" value="Ajouter" />
            <input type="submit" value="Retour à la liste" name="retour"/>

        </form>
    </body>
</html>
