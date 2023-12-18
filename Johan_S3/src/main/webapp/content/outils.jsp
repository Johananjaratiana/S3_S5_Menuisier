<%-- 
    Document   : outils
    Created on : 12 déc. 2023, 15:13:42
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<% 
    List<Unite> unit = (List<Unite>)(request.getAttribute("unites"));
%>  
<div class="container">
    <h1>Outils/matériels</h1>
    <form action="/Johan_S3/Controller" method="post">
    <input type="hidden" name="action" value="mat_insert">
    <label>Nom : </label> <input type="text" name="nom">
    <label>Caractéristiques : </label> <input type="text" name="caracteristique"><!-- comment -->
    <label>Unité : </label> 
    <select name="id_unite">
        <% for(int i=0; i<unit.size(); i++){ %>
        <option value="<%= unit.get(i).getId()%>"><% out.println(unit.get(i).getName());%></option>
        <% } %>
    </select>
    <input type="submit" value="OK">
    </form>
</div>