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
        <input type="text" id="name" name="nom">
    </div>
    <div>
        <label for="name">Prénom :</label>
        <input type="text" id="name" name="prenom">
    </div>
     <div>
        <label for="name">Téléphone de domicile :</label>
        <input type="text" id="name" name="teldom">
    </div>    
     <div>
        <label for="name">Téléphone portable :</label>
        <input type="text" id="name" name="telport">
    </div>    
     <div>
        <label for="name">Téléphone professionnel :</label>
        <input type="text" id="name" name="telpro">
    </div>
     <div>
        <label for="name">Adresse :</label>
        <input type="text" id="name" name="adresse">
    </div>
     <div>
        <label for="name">Code Postal :</label>
        <input type="text" id="name" name="codepostal">
    </div>
     <div>
        <label for="name">Ville :</label>
        <input type="text" id="name" name="ville">
    </div>
    <div>
        <label for="mail">e-mail :</label>
        <input type="email" id="mail" name="email">
    </div>
        
        <input type="submit" value="Ajouter" />
</form>
     </body>
    
    
</html>
