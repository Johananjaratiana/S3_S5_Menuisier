<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<%
	List<V_vente> ventes = (List<V_vente>) request.getAttribute("ventes");
	List<Client> clients = (List<Client>) request.getAttribute("clients");
	List<V_meuble> meubles = (List<V_meuble>) request.getAttribute("meubles");
%>
<div class="content-wrapper">
	<div class="row">
		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Nouvelle vente</h4>
					<form class="form-horizontal" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="vente-insert">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Client</label>
							<select class= "form-control" name="id_client">
								<% for(Client c : clients){ %>
									<option value="<%=c.getId()%>"><%=c.getNom()+" "+c.getPrenom()%></option>
								<% } %>
							</select>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Meuble</label>
							<select class= "form-control" name="id_meuble">
								<% for(V_meuble vm : meubles){ %>
									<option value="<%=vm.getId()%>"><%= realmodels.Meuble.GetFullName(vm)%></option>
								<% } %>
							</select>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Nombre</label>
							<div class="col-sm-10">
								<input class="form-control" name="nb"/>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Date de vente</label>
							<div class="col-sm-10">
								<input type="date" class= "form-control" name="date_"/>
							</div>
						</div>

						<button type="reset" class="btn btn-light offset-md-5">Reset</button>
						<button type="submit" class="btn btn-success mr-2">Ajouter</button>
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
										<td class="nombre"><%= v.getNb()%></td>
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