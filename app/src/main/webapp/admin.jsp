<%-- 
    Document   : home
    Created on : 18 oct. 2019, 10:41:14
    Author     : fareskissoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        </table>
        <form method="post">
             <input type="submit" value="Ajouter"/>
        </form>
        
           
       
        
        
    </body>
</html>
