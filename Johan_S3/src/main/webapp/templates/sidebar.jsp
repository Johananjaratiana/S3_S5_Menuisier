<%-- 
    Document   : navbar
    Created on : 16 nov. 2023, 09:50:46
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <nav class="sidebar sidebar-offcanvas" id="sidebar">

        <ul class="nav navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <li class="nav-item">
                <a class="my-nav-link collapsed" href="/Johan_S3/Controller?action=statistique-global">
                    <i class="fa fa-camera"></i>
                    <span>STATISTIQUES</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".mesure-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-arrows"></i>
                    <span>MESURE</span>
                </a>
                <div class="collapse mesure-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Insertions</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-unite">
                          <span class="menu-title">Unité</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-volume">
                          <span class="menu-title">Volume</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".materiel-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-road"></i>
                    <span>MATERIEL</span>
                </a>
                <div class="collapse materiel-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Insertion</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-materiel">
                          <span class="menu-title">Matériel</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-stock-materiel">
                          <span class="menu-title">Entrée matériels</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        
                        <h6 class="collapse-header">Monétaire</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-prix-materiel">
                          <span class="menu-title">Prix unitaire</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                      
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".style-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-bookmark"></i>
                    <span>STYLE</span>
                </a>
                <div class="collapse style-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Insertion</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-style">
                          <span class="menu-title">Style</span>
                          <i class="mdi mdi-home menu-icon"></i>
                        </a>
                        
                        <h6 class="collapse-header">Contrainte matériel</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-style-materiel">
                          <span class="menu-title">Style et matériel</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                      
                    </div>
                </div>
            </li>
                        
            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".meuble-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-wheelchair"></i>
                    <span>MEUBLE</span>
                </a>
                <div class="collapse meuble-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Création</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-categorie">
                          <span class="menu-title">Catégorie</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-produit">
                          <span class="menu-title">Produits</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-meuble">
                          <span class="menu-title">Meubles</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        
                        <h6 class="collapse-header">Composition</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-quantite-outils">
                          <span class="menu-title">Matériel(s) utilisé(s)</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>

                        <h6 class="collapse-header">Prix</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-prix-meuble">
                          <span class="menu-title">Unitaire</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                      
                    </div>
                </div>
            </li>

            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target="#employe-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-user"></i>
                    <span>EMPLOYE</span>
                </a>
                <div id="employe-collapse" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Insertions</h6>  
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-employee">
                          <span class="menu-title">Employées</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-type-employee">
                          <span class="menu-title">Type employée</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a> 

                        <h6 class="collapse-header">Grade</h6>  
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-grade-employee">
                          <span class="menu-title">Grade existant</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-grade-params">
                          <span class="menu-title">Paramètres</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        
                        <h6 class="collapse-header">Affectation</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-employement">
                          <span class="menu-title">Emploie</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>

                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".fabrication-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-industry"></i>
                    <span>FABRICATION</span>
                </a>
                <div class="collapse fabrication-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Insertions</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-mode-fabrication">
                          <span class="menu-title">Mode de fabrication</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-fabrication">
                          <span class="menu-title">Fabrication</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>

                    </div>
                </div>
            </li>
                        
            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".client-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-user"></i>
                    <span>CLIENT</span>
                </a>
                <div class="collapse client-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Insertions</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-sexe">
                          <span class="menu-title">Sexe</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-client">
                          <span class="menu-title">Client</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>

                    </div>
                </div>
            </li>


            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".vente-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-bookmark"></i>
                    <span>VENTE</span>
                </a>
                <div class="collapse vente-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Nouvelle</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=crud-vente">
                          <span class="menu-title">Vente</span>
                          <i class="mdi mdi-home menu-icon"></i>
                        </a>
                        
                        <h6 class="collapse-header">Statistiques</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=statistique-vente">
                          <span class="menu-title">Stat.</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                      
                    </div>
                </div>
            </li>

            <li class="nav-item">
                <a class="my-nav-link collapsed" href="#" data-toggle="collapse" data-target=".filtre-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa fa-filter"></i>
                    <span>FILTRE</span>
                </a>
                <div class="collapse filtre-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="collapse-inner rounded my-collapsed">

                        <h6 class="collapse-header">Monétaire</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=benefice-meuble">
                          <span class="menu-title">Filtre bénéfice apporté (/meubles)</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=filtre-prix">
                          <span class="menu-title">Filtre par prix de fabrication</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>

                        <h6 class="collapse-header">Fabrication</h6>
                        <a class="my-nav-link-second collapse-item" href="/Johan_S3/Controller?action=formule-materiel-request">
                          <span class="menu-title">Utilisation de matériel</span>
                          <%-- <i class="mdi mdi-contacts menu-icon"></i> --%>
                        </a>
                    
                    </div>
                </div>
            </li>

        </ul>


          <ul class="nav">
            <!--<li class="nav-item">
              <a class="my-nav-link" href="/Johan_S3/Controller?action=clustering">
                <span class="menu-title">Clustering</span>
                <i class="mdi mdi-contacts menu-icon"></i>
              </a>
            </li>-->
          </ul>
            <!--
          <div class="sidebar-progress">
            <p>Success deploiment</p>
            <div class="progress progress-sm">
              <div class="progress-bar bg-gradient-success" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <p>50 %</p>
          </div>
          <div class="sidebar-progress">
            <p>Warning deploiment</p>
            <div class="progress progress-sm">
              <div class="progress-bar bg-gradient-primary" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <p>3 %</p>
          </div>-->
        </nav>
