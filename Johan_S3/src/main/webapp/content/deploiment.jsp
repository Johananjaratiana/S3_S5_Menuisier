<%-- 
    Document   : deploiment
    Created on : 16 nov. 2023, 10:07:00
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>    
<div class="content-wrapper">
  <div class="row">
    <div class="col-md-6 d-flex offset-md-3">
      <div class="col-12 grid-margin">
        <div class="card">
          <div class="card-body">
            <h4 class="card-title" id="my-title">New depoiment</h4>
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
                <label for="ip">Remote IP</label>
                <input type="text" class="form-control" id="ip" placeholder="192.168. ...">
              </div>
              <div class="form-group">
                <label for="port">Remote port</label>
                <input type="text" class="form-control" id="port" placeholder="80 - 9999">
              </div>
              <div class="form-group">
                <label>Payload</label>
                <input type="file" name="img[]" class="file-upload-default">
                <div class="input-group col-xs-12">
                  <input type="text" class="form-control file-upload-info" disabled placeholder="Payload file">
                  <span class="input-group-btn">
                    <button class="file-upload-browse btn btn-info" type="button">Choose file</button>
                  </span>
                </div>
              </div>
              <br/>
              <br/>
              <button type="reset" class="btn btn-light offset-md-5">Reset</button>
              <button type="submit" class="btn btn-success mr-2">Deploy</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>