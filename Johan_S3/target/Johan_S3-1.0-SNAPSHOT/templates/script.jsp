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
  <script src="assets/js/input-line-copy.js"></script>
  <script src="assets/js/default-date-value.js"></script>
  <script src="assets/js/numeral.min.js"></script>
  <script src="assets/js/number-formatter.js">
  <script>
    // CRUD TEMPLATE
    var template_options = {
      valueNames: [ 'name', 'born' ],
      page: 5,
      pagination: true
    };
    var template_userList = new List('crud', template_options);

    // CRUD CATEGORIE
    var categorie_options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    var categorie_userList = new List('crud-categorie', categorie_options);

    // CRUD STYLE
    var style_options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    var style_userList = new List('crud-style', style_options);

    // CRUD UNITE
    var unite_options = {
      valueNames: [ 'nom' ],
      page: 5,
      pagination: true
    };
    var unite_userList = new List('crud-unite', unite_options);

    // CRUD VOLUME
    var volume_options = {
      valueNames: [ 'longueur', 'largeur', 'hauteur', 'volume', 'nom' ],
      page: 5,
      pagination: true
    };
    var volume_userList = new List('crud-volume', volume_options);

    // CRUD MATERIEL
    var materiel_options = {
      valueNames: [ 'nom', 'unite' ],
      page: 5,
      pagination: true
    };
    var materiel_userList = new List('crud-materiel', materiel_options);

    // CRUD STYLE-MATERIEL
    var style_materiel_options = {
      valueNames: [ 'materiel', 'style', 'unite' ],
      page: 5,
      pagination: true
    };
    var style_materiel_userList = new List('crud-style-materiel', style_materiel_options);

    // CRUD PRODUIT
    var produit_options = {
      valueNames: [ 'categorie', 'produit' ],
      page: 5,
      pagination: true
    };
    var produit_userList = new List('crud-produit', produit_options);

    // CRUD REFERENCE
    var reference_options = {
      valueNames: [ 'produit', 'categorie', 'style', 'taille' ],
      page: 5,
      pagination: true
    };
    var reference_userList = new List('crud-reference', reference_options);

    // CRUD QUANTITE OUTILS
    var outils_options = {
      valueNames: [ 'reference', 'materiel', 'quantite' ],
      page: 5,
      pagination: true
    };
    var outils_userList = new List('crud-quantte-outils', outils_options);

    // CRUD FORMULE MATERIEL
    var materiel_options = {
      valueNames: [ 'produit', 'style',  'volume', 'quantite' ],
      page: 5,
      pagination: true
    };
    var materiel_userList = new List('crud-formule-materiel', materiel_options);

    // CRUD EMPLOYEE
    var employee_options = {
      valueNames: [ 'nom', 'prenom', 'dtn', 'age' ],
      page: 5,
      pagination: true
    };
    var employee_userList = new List('crud-employee', employee_options);

    // CRUD EMPLOYEMENT
    var employement_options = {
      valueNames: [ 'nom', 'type-employee',  'grade', 'age', 'anciennete', 'taux-horaire' ],
      page: 5,
      pagination: true
    };
    var employement_userList = new List('crud-employement', employement_options);

    // CRUD GRADE PARAMS
    var grade_params_options = {
      valueNames: [ 'grade', 'year', 'salaire', 'date_' ],
      page: 5,
      pagination: true
    };
    var grade_params_userList = new List('crud-grade-params', grade_params_options);

    // CRUD CLIENT
    var client_options = {
      valueNames: [ 'nom', 'sexe', 'email', 'age' ],
      page: 5,
      pagination: true
    };
    var client_userList = new List('crud-client', client_options);

    // CRUD STOCK MATERIEL
    var stock_materiel_options = {
      valueNames: [ 'materiel', 'reste', 'unite' ],
      page: 5,
      pagination: true
    };
    var stock_materiel_userList = new List('crud-stock-materiel', stock_materiel_options);

    // CRUD TYPE EMPLOYEE
    var type_employee_options = {
      valueNames: [ 'nom', 'taux' ],
      page: 5,
      pagination: true
    };
    var type_employee_userList = new List('crud-type-employee', type_employee_options);

    </script>
