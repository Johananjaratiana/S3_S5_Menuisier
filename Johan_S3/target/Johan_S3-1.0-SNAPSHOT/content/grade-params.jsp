<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>
<%
	List<Grade_employee> grade_employees = (List<Grade_employee>) request.getAttribute("grade_employees");
	List<V_real_grade_params> real_grade_params = (List<V_real_grade_params>) request.getAttribute("real_grade_params");
%>
<div class="content-wrapper">
	<div class="row">
		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Parametrage de grade</h4>
					<form class="forms-sample" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="grade-params-insert">
						<div class="form-group">
							<label for="project">Grade</label>
							<select name="id_grade" class="form-select" id="project">
								<% for (Grade_employee ge : grade_employees) { %>
									<option value="<%= ge.getId()%>"><%= ge.getNom()%></option>
								<% } %>
							</select>
						</div>
						<div class="form-group">
							<label for="ip">Année d` expérience</label>
							<input type="text" name="years" class="form-control" id="ip" placeholder="...">
						</div>
						<div class="form-group">
							<label for="ip">Multiplication par la salaire de base</label>
							<input type="text" name="x_fois_taux_salaire" class="form-control" id="ip" placeholder="...">
						</div>
						<div class="form-group">
							<label for="ip">Début du règlement</label>
							<input type="datetime-local" name="date_" class="form-control" id="ip" placeholder="...">
						</div>
						<br/>
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
						<h4 class="" id="my-title">Liste des grades paramétrés</h4>

						<div id="crud-grade-params">
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
									<span>Grade</span>
									<button class="sort btn" style="color: green;" data-sort="grade">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Année d' expérience</span>
									<button class="sort btn" style="color: green;" data-sort="year">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>* Salaire de base</span>
									<button class="sort btn" style="color: green;" data-sort="salaire">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Début du règles</span>
									<button class="sort btn" style="color: green;" data-sort="date_">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
							</thead>
							<!-- IMPORTANT, class="list" have to be at tbody -->
							<tbody class="list">
								<% for(V_real_grade_params rgp : real_grade_params) { %>
									<tr>
										<td class="grade"><%= rgp.getNom_grade()%></td>
										<td class="year"><%= rgp.getYears()%></td>
										<td class="salaire"><%= rgp.getX_fois_taux_salaire()%></td>
										<td class="date_"><%= rgp.getDate_()%></td>
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