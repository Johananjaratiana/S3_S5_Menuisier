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
    // CRUD CATEGORIE
    options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-categorie', options);

    // CRUD STYLE
    options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-style', options);

    // CRUD UNITE
    options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-unite', options);

    // CRUD VOLUME
    options = {
      valueNames: [ 'longueur', 'largeur', 'hauteur', 'volume', 'nom' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-volume', options);

    // CRUD MATERIEL
    options = {
      valueNames: [ 'nom', 'unite' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-materiel', options);

    // CRUD STYLE-MATERIEL
    options = {
      valueNames: [ 'materiel', 'style', 'unite' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-style-materiel', options);

    // CRUD PRODUIT
    options = {
      valueNames: [ 'categorie', 'produit' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-produit', options);

    // CRUD REFERENCE
    options = {
      valueNames: [ 'produit', 'categorie', 'style', 'taille' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-reference', options);

    // CRUD QUANTITE OUTILS
    options = {
      valueNames: [ 'reference', 'materiel', 'quantite' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-quantte-outils', options);

    // CRUD FORMULE MATERIEL
    options = {
      valueNames: [ 'produit', 'style',  'volume', 'quantite' ],
      page: 5,
      pagination: true
    };
    userList = new List('crud-formule-materiel', options);

    </script>
