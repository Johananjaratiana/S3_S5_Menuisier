<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<%
	List<V_vente> ventes = (List<V_vente>) request.getAttribute("ventes");
	List<V_client> clients = (List<V_client>) request.getAttribute("clients");
	List<V_meuble> meubles = (List<V_meuble>) request.getAttribute("meubles");
%>
<div class="content-wrapper">
	<div class="row">
		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Nouvelle vente</h4>
					<form id="idForm" class="form-horizontal" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="vente-insert">

						<table class="table">
							<thead>
								<tr>
									<th class="offset-4" colspan="4" id="my-title">
										<button
											onclick="addLine('idForm', 'idParent', 'idChild')"
											class="btn btn-success" style="height: 55px; border-radius: 100%;">
											<h3>+</h3>
										</button>
									</th>
								</tr>
								<tr>
									<th>Client</th>
									<th>Meuble</th>
									<th>Quantité</th>
									<th>Date de vente</th>
								</tr>
							</thead>
							<tbody id="idParent">
								<tr>
									<td>
										<div class="form-group">
											<select class="form-control" name="id_client">
											<% for(V_client c : clients){ %>
											<option value="<%=c.getId()%>"><%= realmodels.Client.GetFullName(c)%></option>
											<% } %>
											</select>
										</div>
									</td>
								</tr>
								<tr id="idChild" style="display: none;">
									<td></td>
									<td>
										<div class="form-group">
											<select class="form-control" name="id_meuble">
											<% for(V_meuble vm : meubles){ %>
											<option value="<%=vm.getId()%>"><%= realmodels.Meuble.GetFullName(vm)%></option>
											<% } %>
											</select>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="col-sm-10">
											<input class="form-control" name="quantite" />
											</div>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="col-sm-10">
											<input type="datetime-local" class="form-control currentDateTime" name="date_" />
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>


						<button type="reset" class="btn btn-light offset-md-5">Reset</button>
						<button onclick="removeElementById('idChild')" type="submit" class="btn btn-success mr-2">Ajouter</button>
					</form>

					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body" style="min-height: 520px;">
						<h4 class="" id="my-title">Liste des ventes</h4>

						<div id="crud-vente">
							<div class="row">
								<input class="search form-control col-6" placeholder="Search" />
								<span class="col-3" style="color:white;background: #730000;text-align: center;">
									<svg xmlns="http://www.w3.org/2000/svg" style="margin-block: 0.6rem;" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
										<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
									</svg>
								</span>
							</div>
							
							<table class="table">
							<thead>
								<th>
									<span>Meuble</span>
									<button class="sort btn" style="color: green;" data-sort="meuble">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Client</span>
									<button class="sort btn" style="color: green;" data-sort="client">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Sexe</span>
									<button class="sort btn" style="color: green;" data-sort="sexe">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Nombre</span>
									<button class="sort btn" style="color: green;" data-sort="nombre">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
							</thead>
							<!-- IMPORTANT, class="list" have to be at tbody -->
							<tbody class="list">
								<% for(V_vente v : ventes) { %>
									<tr>
										<td class="meuble"><%= realmodels.Vente.GetMeubleFullName(v)%></td>
										<td class="client"><%= realmodels.Vente.GetClientFullName(v)%></td>
										<td class="sexe"><%= v.getNom_sexe()%></td>
										<td class="nombre simple-number"><%= (-1) * v.getQuantite()%></td>
									</tr>
								<% } %>
							</tbody>
							<tfoot>
								<td><ul class="pagination"></ul></td>
							</tfoot>
							</table>
						</div>
		
		
					</div>
				</div>
			</div>
		</div>
	</div>
</div>