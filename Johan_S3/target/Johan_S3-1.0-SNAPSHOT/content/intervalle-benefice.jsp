<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.V_benefice_meuble" %>
<%
	List<V_benefice_meuble> filtre_prix_benefice_meubles = (List<V_benefice_meuble>) request.getAttribute("filtre_prix_benefice_meubles");
%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-6">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="" id="my-title">Entrée l` intervalle de bénéfice</h4>
					<form class="forms-sample" action="/Johan_S3/Controller" method="post">
						<input type="hidden" name="action" value="benefice-meuble">
						<div class="form-group">
							<label for="project">Min.</label>
							<input name="min" class="form-control" id="project"/>
						</div>
						<div class="form-group">
							<label for="project">Prix max.</label>
							<input name="max" class="form-control" id="project"/>
						</div>
						<br/>
						<button type="reset" class="btn btn-light offset-md-5">Reset</button>
						<button type="submit" class="btn btn-success mr-2">Voir</button>
					</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body" style="min-height: 520px;">
						<h4 class="" id="my-title">
							Listes des meubles correspondant
							<%-- <% 
								if(quantite_outils.size() > 0)out.print(quantite_outils.get(0).getNom_materiel());
								else out.print("...");
							%> --%>
						</h4>

						<div id="crud-formule-materiel">
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
									<span>Meubles</span>
									<button class="sort btn" style="color: green;" data-sort="produit">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
								<th>
									<span>Bénéfice</span>
									<button class="sort btn" style="color: green;" data-sort="style">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
										</svg>
									</button>
								</th>
							</thead>
							<!-- IMPORTANT, class="list" have to be at tbody -->
							<tbody class="list">
								<% for(V_benefice_meuble br : filtre_prix_benefice_meubles) { %>
									<tr>
										<td class="produit"><%=br.getNom_produit()+" "+br.getNom_categorie()+" "+br.getNom_style()+" "+br.getNom_volume()%></td>
										<td class="style"><%= br.getBenefice()%></td>
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