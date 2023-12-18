<%-- 
    Document   : error-label
    Created on : 17 nov. 2023, 05:53:00
    Author     : Johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
              <% if(request.getAttribute("error") != null) { %>
                <label class="block text-sm" style="color: red; padding-block: 1rem;">
                    <%= request.getAttribute("error")%>
                </label>
              <% } %>
