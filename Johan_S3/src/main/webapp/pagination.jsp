<%-- 
    Document   : pagination
    Created on : 12 déc. 2023, 10:56:42
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Head -->
<jsp:include page="templates/head.jsp" />
<!-- Head -->
<body>
<div class="container-scroller">
      
    <!-- Modal -->
    <jsp:include page="templates/modal.jsp" />
    <!-- Modal -->

    <!-- Content -->
    <div class="container-fluid page-body-wrapper">
      <div class="row row-offcanvas row-offcanvas-right">
          
        <!-- partial:partials/_sidebar -->
        <jsp:include page="templates/sidebar.jsp" />
        <!-- partial -->
        
        <!-- Real-content -->
        <jsp:include page="content/pagination.jsp" />
        <!-- Real-content -->
        
        <!-- partial:partials/_footer -->
        <jsp:include page="templates/footer.jsp" />
        <!-- partial -->
        
      </div>
    </div>
    <!-- Content -->

  </div>

  <!-- Script -->
  <jsp:include page="templates/script.jsp" />
  <!-- Script -->

</body>
</html>
