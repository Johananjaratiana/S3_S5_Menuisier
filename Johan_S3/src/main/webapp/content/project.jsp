<%-- 
    Document   : index
    Created on : 16 nov. 2023, 10:07:00
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.lang.Double" %>
<%
    Double[] stat = (Double[]) request.getAttribute("statistique");
    if(stat==null) stat= new Double[0];
%>
<div class="content-wrapper">
    <h1><%for(int i=0; i< stat.length; i++) out.println(stat[i]);%></h1>
          <div class="row purchace-popup">
            <div class="col-12">
              <span class="d-flex alifn-items-center">
                <p>You can see here all project status.</p>          
                <button type="button" class="btn ml-auto purchase-button" data-toggle="modal" data-target="#exampleModal" target="_blank">
                  New project
                </button>
                <i class="mdi mdi-close popup-dismiss"></i>
              </span>
            </div>
          </div>

          <hr/>

          <div class="row">
            <div class="col-lg-12">
              <h4 id="my-title" class="card-title">Project 1</h4>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Deploiment</h4>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Tag</th>
                        <th>IP adress</th>
                        <th>Port</th>
                        <th>Created</th>
                        <th>Status</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>#1</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>12 May 2017</td>
                        <td><label class="badge badge-danger">Pending</label></td>
                      </tr>
                      <tr>
                        <td>#2</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>14 May 2017</td>
                        <td><label class="badge badge-info">Fixed</label></td>
                      </tr>
                      <tr>
                        <td>#3</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>16 May 2017</td>
                        <td><label class="badge badge-success">Completed</label></td>
                      </tr>
                      <tr>
                        <td>#4</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>20 May 2017</td>
                        <td><label class="badge badge-warning">In progress</label></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Clustering</h4>
                  <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>Tag</th>
                        <th>Front-end</th>
                        <th>Index</th>
                        <th>Working</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>#1</td>
                        <td>192.168.0.9/9999</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-danger">No</label></td>
                      </tr>
                      <tr>
                        <td>#2</td>
                        <td>192.168.0.9/8888</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-success">OK</label></td>
                      </tr>
                      <tr>
                        <td>#3</td>
                        <td>192.168.0.9/8888</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-success">OK</label></td>
                      </tr>
                      <tr>
                        <td>#4</td>
                        <td>192.168.0.9/8888</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-success">OK</label></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

          <hr/>

          <div class="row">
            <div class="col-lg-12">
              <h4 id="my-title" class="card-title">Project 2</h4>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Deploiment</h4>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Tag</th>
                        <th>IP adress</th>
                        <th>Port</th>
                        <th>Created</th>
                        <th>Status</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>#1</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>12 May 2017</td>
                        <td><label class="badge badge-danger">Pending</label></td>
                      </tr>
                      <tr>
                        <td>#2</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>14 May 2017</td>
                        <td><label class="badge badge-info">Fixed</label></td>
                      </tr>
                      <tr>
                        <td>#3</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>16 May 2017</td>
                        <td><label class="badge badge-success">Completed</label></td>
                      </tr>
                      <tr>
                        <td>#4</td>
                        <td>192.168.0.9</td>
                        <td>8080</td>
                        <td>20 May 2017</td>
                        <td><label class="badge badge-warning">In progress</label></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>

            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Clustering</h4>
                  <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>Tag</th>
                        <th>Front-end</th>
                        <th>Index</th>
                        <th>Working</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>#1</td>
                        <td>192.168.0.9/9999</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-danger">No</label></td>
                      </tr>
                      <tr>
                        <td>#2</td>
                        <td>192.168.0.9/8888</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-success">OK</label></td>
                      </tr>
                      <tr>
                        <td>#3</td>
                        <td>192.168.0.9/8888</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-success">OK</label></td>
                      </tr>
                      <tr>
                        <td>#4</td>
                        <td>192.168.0.9/8888</td>
                        <td>/JavaSession</td>
                        <td><label class="badge badge-success">OK</label></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>

            <hr/>

          </div>

        </div>
