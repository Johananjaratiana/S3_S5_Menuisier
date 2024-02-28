<%-- 
    Document   : clustering
    Created on : 16 nov. 2023, 10:07:00
    Author     : johan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<%
	List<V_benefice_meuble> rentables = (List<V_benefice_meuble>) request.getAttribute("rentables");
	List<V_benefice_meuble> non_rentables = (List<V_benefice_meuble>) request.getAttribute("non_rentables");
	List<V_stock_meuble_restante> stock_meuble_restantes = (List<V_stock_meuble_restante>) request.getAttribute("stock_meuble_restantes");
	List<V_statistiques_nb_vente_par_style_par_mois_current_year> statistiques_nb_vente_par_style_par_mois_current_years = (List<V_statistiques_nb_vente_par_style_par_mois_current_year>) request.getAttribute("statistiques_nb_vente_par_style_par_mois_current_years");
%>

<div class="content-wrapper">

  <div class="row">

    <div class="col-lg-6 grid-margin stretch-card">
      <div class="card">
        <div class="card-body">
          <h4 class="" id="my-title">Reste en stock des meubles</h4>
          <div style="display: none;" id="x_stock_meuble_restante"><%= realmodels.Statistique_global.Build_X_label_stock_meuble_restante(stock_meuble_restantes)%></div>
          <div style="display: none;" id="y_stock_meuble_restante"><%= realmodels.Statistique_global.Build_Y_label_stock_meuble_restante(stock_meuble_restantes)%></div>
          <canvas id="chart-doughnut-stock-meuble" style="width:100%;max-width:600px"></canvas>
        </div>
      </div>
    </div>

    <div class="col-lg-6 grid-margin stretch-card">
      <div class="card">
        <div class="card-body">
          <h4 class="" id="my-title">Nombre de vente par style de cette exercice</h4>
          <div style="display: none;" id="x_statistiques_nb_vente_par_style_par_mois_current_year"><%= realmodels.Statistique_global.Build_X_label_statistiques_nb_vente_par_style_par_mois_current_year(statistiques_nb_vente_par_style_par_mois_current_years)%></div>
          <div style="display: none;" id="y_statistiques_nb_vente_par_style_par_mois_current_year"><%= realmodels.Statistique_global.Build_Y_label_statistiques_nb_vente_par_style_par_mois_current_year(statistiques_nb_vente_par_style_par_mois_current_years)%></div>
          <canvas id="chart-multiple-lines-vente-style" style="width:100%;max-width:600px"></canvas>
        </div>
      </div>
    </div>

  </div>


  <div class="row">

    <div class="col-lg-12 grid-margin stretch-card">
      <div class="card">
        <div class="card-body row">
          <h4 class="" id="my-title">Bénéfice apportés par meubles</h4>
          <div class="col-lg-6">
            <div style="display: none;" id="x_benefice_rentable"><%= realmodels.Statistique_global.Build_X_label_benefice_meuble(rentables)%></div>
            <div style="display: none;" id="y_benefice_rentable"><%= realmodels.Statistique_global.Build_Y_label_benefice_meuble(rentables)%></div>
            <div id="plotly-donut-benefice-general-rentable" style="width:100%;max-width:700px"></div>
          </div>
          <div class="col-lg-6">
            <div style="display: none;" id="x_benefice_non_rentable"><%= realmodels.Statistique_global.Build_X_label_benefice_meuble(non_rentables)%></div>
            <div style="display: none;" id="y_benefice_non_rentable"><%= realmodels.Statistique_global.Build_Y_label_benefice_meuble(non_rentables)%></div>
            <div id="plotly-donut-benefice-general-non-rentable" style="width:100%;max-width:700px"></div>
          </div>
        </div>
      </div>
    </div>

  </div>


</div>