<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*"%>
<%@page import="java.util.*"%>
<% 
    List<V_taux_salaire_employee> taux_salaire_employees = (List<V_taux_salaire_employee>)request.getAttribute("taux_salaire_employees");
	List<Employee> employees = (List<Employee>) request.getAttribute("employees");
	List<Type_employee> type_employees = (List<Type_employee>)request.getAttribute("type_employees");
%>

<div class="content-wrapper">
	<div class="row">
		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Affection d` emplois</h4>
					
					<form class="form-horizontal" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="employement-insert">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Employée</label>
							<div class="col-sm-10">
							<select class= "form-control" name="id_employee">
								<% for(Employee e : employees){ %>
									<option value="<%=e.getId()%>"><%=e.getNom()+" "+e.getPrenom()%></option>
								<% } %>
							</select>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Type</label>
							<div class="col-sm-10">
							<select class= "form-control" name="id_type_employee">
								<% for(Type_employee te : type_employees){ %>
									<option value="<%=te.getId()%>"><%=te.getNom()%></option>
								<% } %>
							</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-12 control-label">Date d'embauche</label>
							<div class="col-sm-10">
								<input class= "form-control" type="date" name="date_embauche"/>
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
						<h4 class="" id="my-title">Salaire des employées</h4>

						<div id="crud-employement">
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
									<span>Nom</span>
									<button class="sort btn" style="color: green;" data-sort="nom">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Type employee</span>
									<button class="sort btn" style="color: green;" data-sort="type-employee">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Grade</span>
									<button class="sort btn" style="color: green;" data-sort="grade">
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
								<th>
									<span>--------------- Anciennetée ---------------</span>
									<button class="sort btn" style="color: green;" data-sort="anciennete">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Taux horaire</span>
									<button class="sort btn" style="color: green;" data-sort="taux-horaire">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
							</thead>
							<!-- IMPORTANT, class="list" have to be at tbody -->
							<tbody class="list">
								<% for(V_taux_salaire_employee tse : taux_salaire_employees) { %>
									<tr>
										<td class="nom"><%= tse.getNom() + " " + tse.getPrenom()%></td>
										<td class="type-employee"><%= tse.getNom_type()%></td>
										<td class="grade"><%= tse.getNom_grade()%></td>
										<td class="age simple-number"><%= realmodels.Employee.CalculateAge(tse.getDate_naissance())%> ans</td>
										<td class="anciennete"><%= realmodels.Employee.EnglishToFrench(tse.getAnciennete())%></td>
										<td class="taux-horaire money-number"><%= realmodels.Employement.CalculateRealTauxHoraire(tse)%></td>
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