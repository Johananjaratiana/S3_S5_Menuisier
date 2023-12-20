<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-6">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
					<h4 class="card-title" id="my-title">Create</h4>
					<form class="forms-sample">
						<div class="form-group">
						<label for="ip">Nom</label>
						<input type="text" class="form-control" id="ip" placeholder="...">
						</div>
						<br/>
						<button type="reset" class="btn btn-light offset-md-5">Reset</button>
						<button type="submit" class="btn btn-success mr-2">Ajouter</button>
					</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body" style="min-height: 520px;">
						<h4 class="card-title" id="my-title">Read</h4>

						<div id="crud">
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
                                        <span>Name</span>
                                        <button class="sort btn" style="color: green;" data-sort="name">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
                                            </svg>
                                        </button>
                                    </th>
                                    <th>
                                        <span>Name</span>
                                        <button class="sort btn" style="color: green;" data-sort="born">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
                                            </svg>
                                        </button>
                                    </th>
                                </thead>
                                <!-- IMPORTANT, class="list" have to be at tbody -->
                                <tbody class="list">
                                    <tr>
                                        <td class="name">Jonny Stromberg</td>
                                        <td class="born">1986</td>
                                    </tr>
                                    <tr>
                                        <td class="name">Jonas Arnklint</td>
                                        <td class="born">1985</td>
                                    </tr>
                                    <tr>
                                        <td class="name">Martina Elm</td>
                                        <td class="born">1986</td>
                                    </tr>
                                    <tr>
                                        <td class="name">Gustaf Lindqvisteee</td>
                                        <td class="born">1983</td>
                                    </tr>
                                    <tr>
                                        <td class="name">Gustaf Lindqvistyyy</td>
                                        <td class="born">1983</td>
                                    </tr>
                                    <tr>
                                        <td class="name">Gustaf Lindqvistppp</td>
                                        <td class="born">1983</td>
                                    </tr>
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