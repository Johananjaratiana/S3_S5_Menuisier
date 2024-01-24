<%-- 
    Document   : clustering
    Created on : 16 nov. 2023, 10:07:00
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<div class="content-wrapper">

          <div class="row">
            <div class="col-md-6 d-flex">
              <div class="col-12 grid-margin">
                <div class="card">
                  <div class="card-body">
                    <h4 class="" id="my-title">New front end</h4>
                    <form class="forms-sample">
                      <div class="form-group">
                        <label for="ip">IP binding</label>
                        <input type="text" class="form-control" id="ip" placeholder="192.168. ...">
                      </div>
                      <div class="form-group">
                        <label for="port">Port to use</label>
                        <input type="text" class="form-control" id="port" placeholder="80 - 9999">
                      </div>
                      <br/>
                      <br/>
                      <button type="reset" class="btn btn-light offset-md-5">Reset</button>
                      <button type="submit" class="btn btn-success mr-2">Add</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 d-flex">
              <div class="col-12 grid-margin">
                <div class="card">
                  <div class="card-body">
                    <h4 class="" id="my-title">New cluster</h4>
                    <form class="forms-sample">
                      <div class="form-group">
                        <label for="project">Project</label>
                        <select type="email" class="form-select" id="project">
                          <option value="">Project 1</option>
                          <option value="">Project 2</option>
                          <option value="">Project 3</option>
                        </select>
                      </div>
                      <div class="form-group">
                        <label for="project">Front end</label>
                        <select type="email" class="form-select" id="project">
                          <option value="">192.168.0.0.9:8888</option>
                          <option value="">192.168.0.0.9:8888</option>
                          <option value="">192.168.0.0.9:8888</option>
                        </select>
                      </div>
                      <div class="form-group">
                        <label for="project">Deploiment</label>
                        <select type="email" class="form-select" id="project">
                          <option value="">Deploiment 1</option>
                          <option value="">Deploiment 2</option>
                          <option value="">Deploiment 3</option>
                        </select>
                      </div>
                      <br/>
                      <br/>
                      <button type="reset" class="btn btn-light offset-md-5">Reset</button>
                      <button type="submit" class="btn btn-success mr-2">Add</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="" id="my-title">Front end</h4>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Front end</th>
                        <th>Remove front end</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>192.168.0.9:9999</td>
                        <td><button class="badge badge-danger">Drop</button></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="" id="my-title">All clustering</h4>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Front end</th>
                        <th>Back end</th>
                        <th>Remove back end</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>192.168.0.9:9999</td>
                        <td>192.168.0.9:9999</td>
                        <td><button class="badge badge-danger">Drop</button></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

        </div>