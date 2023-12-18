<%-- 
    Document   : error
    Created on : 16 nov. 2023, 09:59:18
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(request.getAttribute("error") != null) { %>
<div class="container mt-5">
  <div class="alert alert-danger" role="alert">
    <%= request.getAttribute("error");%>
  </div>
</div>
<% } %>
