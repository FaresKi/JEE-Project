<%--
  Created by IntelliJ IDEA.
  User: fareskissoum
  Date: 15/11/2019
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    body {
        padding: 3rem;
        font-size: 16px;
    }

    textarea {
        width: 100%;
        min-height: 30rem;
        font-family: "Lucida Console", Monaco, monospace;
        font-size: 0.8rem;
        line-height: 1.2;
    }
</style>

<head>
    <title>REST Client Interface</title>
</head>
<body>


<h2>REST API Client</h2>

<form method="POST">
    <select name="protocolChoice">
        <option value="GET">GET</option>
        <option value="PUT">PUT</option>
        <option value="POST">POST</option>
        <option value="DELETE">DELETE</option>
    </select>

    <input type="submit" value="Send" name="sendRequest"/>
    <input type="text" name="id">

    <textarea name="inputTextBoxArea" id="myTextArea" cols="10" rows="10" style="resize: none">

    </textarea>

    <textarea name="resultTextBox" id="myTextarea" cols="30" rows="10" readonly style="resize: none;">
       <c:out value="${response}"/>
    </textarea>


</form>

</body>
</html>
