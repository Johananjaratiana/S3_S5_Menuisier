<%-- 
    Document   : newjsp
    Created on : 11 déc. 2023, 13:52:51
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="/Johan_S3/InsertDB" method="get">
    <label>Id : </label> <input type="text" name="id">
    <label>Type : </label> <input type="text" name="type">
    <label>Nom : </label> <input type="text" name="nom">
    <input type="submit" value="OK">
</form>