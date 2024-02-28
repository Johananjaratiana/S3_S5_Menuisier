<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<%@ page import="realmodels.Statistique_vente" %>
<%
	List<V_meuble> meubles = (List<V_meuble>) request.getAttribute("meubles");
	Statistique_vente statistique_vente = (Statistique_vente) request.getAttribute("statistique_vente");
%>
<div style="display:none;" id="homme-part"><%= statistique_vente.GetHommePart()%></div>
<div style="display:none;" id="femme-part"><%= statistique_vente.GetFemmePart()%></div>
<div class="content-wrapper">
	<div class="row">
		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Statistiques de ventes par sexe</h4>
					<form class="forms-sample" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="statistique-vente">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-12 control-label">Meuble</label>
                            <select class= "form-control" name="id_meuble">
								<option value="-1">Tout</option>
                                <% for(V_meuble vm : meubles){ %>
                                    <option value="<%=vm.getId()%>"><%= realmodels.Meuble.GetFullName(vm)%></option>
                                <% } %>
                            </select>
                        </div>                                            
                        <br/>
						<button type="submit" class="btn btn-success mr-2">Voir</button>
					</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
            <div class="col-md-12">
                <div class="col-12 grid-margin">
                    <div class="card">
                        <div class="card-body row">
                            <table class="table table-bordered col-2 offset-2">
                                <!-- IMPORTANT, class="list" have to be at tbody -->
                                <tbody class="list">
                                    <tr>
                                        <th>Sexe</th>
                                        <th>Parité</th>
                                    </tr>
                                    <tr>
                                        <td>Homme</td>
                                        <td><span class="money-number"><%= statistique_vente.GetHommePart()%></span> %</td>
                                    </tr>
                                    <tr>
                                        <td>Femme</td>
                                        <td><span class="money-number"><%= statistique_vente.GetFemmePart()%></span> %</td>
                                    </tr>
                                </tbody>
                            </table>  
                            <div class="col-6 offset-2">
                                <canvas id="myChart" style="width:100%;max-width:600px"></canvas>
                            </div>              
                        </div>
                    </div>
                </div>
            </div>
		</div>
	</div>
</div>