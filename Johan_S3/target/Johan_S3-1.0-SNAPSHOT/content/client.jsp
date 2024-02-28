<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<%
	List<V_client> clients = (List<V_client>) request.getAttribute("clients");
	List<Sexe> sexes = (List<Sexe>) request.getAttribute("sexes");
%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Nouvelle client</h4>
					<form class="form-horizontal" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="client-insert">
						
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Nom</label>
							<div class="col-sm-10">
								<input class= "form-control" name="nom"/>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Prénom</label>
							<div class="col-sm-10">
								<input class= "form-control" name="prenom"/>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">E-mail</label>
							<div class="col-sm-10">
								<input type="email" class= "form-control" name="email"/>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Date de naissance</label>
							<div class="col-sm-10">
								<input type="date" class= "form-control" name="date_naissance"/>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Sexe</label>
							<select class= "form-control" name="id_sexe">
								<% for(Sexe s : sexes){ %>
									<option value="<%=s.getId()%>"><%=s.getNom()%></option>
								<% } %>
							</select>
						</div>
						<button type="reset" class="btn btn-light offset-md-5">Reset</button>
						<button type="submit" class="btn btn-success mr-2">Ajouter</button>
					</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-12">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body" style="min-height: 520px;">
						<h4 class="" id="my-title">Liste des clients</h4>

						<div id="crud-client">
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
									<span>Nom & prénom</span>
									<button class="sort btn" style="color: green;" data-sort="nom">
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
									<span>Email</span>
									<button class="sort btn" style="color: green;" data-sort="email">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Age</span>
									<button class="sort btn" style="color: green;" data-sort="age">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
							</thead>
							<!-- IMPORTANT, class="list" have to be at tbody -->
							<tbody class="list">
								<% for(V_client c : clients) { %>
									<tr>
										<td class="nom"><%= realmodels.Client.GetFullName(c)%></td>
										<td class="sexe"><%= c.getNom_sexe()%></td>
										<td class="email"><%= c.getEmail()%></td>
										<td class="age simple-number"><%= realmodels.Employee.CalculateAge(c.getDate_naissance())%> ans</td>
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