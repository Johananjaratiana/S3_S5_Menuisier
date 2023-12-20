<%-- 
    Document   : script
    Created on : 16 nov. 2023, 10:01:13
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <script src="assets/js/jquery-3.5.1.slim.min.js"></script>
  <script src="assets/js/popper.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
  <script src="assets/js/list.js"></script>
  <script>
    // CRUD TEMPLATE
    var options = {
      valueNames: [ 'name', 'born' ],
      page: 5,
      pagination: true
    };
    
    var userList = new List('crud', options);
    // CRUD TEMPLATE


    // CRUD CATEGORIE
    options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    
    userList = new List('crud-categorie', options);
    // CRUD CATEGORIE

    // CRUD style
    options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    
    userList = new List('crud-style', options);
    // CRUD style

    // CRUD unite
    options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    
    userList = new List('crud-unite', options);
    // CRUD unite

    // CRUD volume
    options = {
      valueNames: [ 'longueur', 'largeur', 'hauteur', 'volume', 'taille' ],
      page: 5,
      pagination: true
    };
    
    userList = new List('crud-volume', options);
    // CRUD volume

    // CRUD materiel
    options = {
      valueNames: [ 'nom', 'unite' ],
      page: 5,
      pagination: true
    };
    
    userList = new List('crud-materiel', options);
    // CRUD materiel

    // CRUD style-materiel
    options = {
      valueNames: [ 'style', 'materiel', 'unite' ],
      page: 5,
      pagination: true
    };
    
    userList = new List('crud-style-materiel', options);
    // CRUD style-materiel
  </script>
