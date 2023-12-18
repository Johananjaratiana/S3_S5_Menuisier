<%-- 
    Document   : modal
    Created on : 16 nov. 2023, 09:51:25
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- NEW PROJECT  -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h2 class="modal-title" id="exampleModalLabel">New Project</h2>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form action="" class="forms-sample">
              <div class="form-group">
                <label for="name">New project name</label>
                <input id="name" name="name" type="text" class="form-control" placeholder="">
              </div>
              <div class="form-group">
                <label for="name">Ressource Url</label>
                <input id="name" name="name" type="text" class="form-control" placeholder="">
              </div>
              <div class="form-group">
                <label for="resourceType">Ressource Type</label>
                <div class="form-row">
                  <div class="col"></div>
                  <div class="col form-check">
                    <input class="form-check-input" type="radio" id="gitRadio" name="resourceType" value="git">
                    <label class="form-check-label" for="gitRadio">Git</label>
                  </div>
                  <div class="col form-check">
                    <input class="form-check-input" type="radio" id="ftpRadio" name="resourceType" value="ftp">
                    <label class="form-check-label" for="ftpRadio">FTP</label>
                  </div>
                  <div class="col form-check">
                    <input class="form-check-input" type="radio" id="sshRadio" name="resourceType" value="ssh">
                    <label class="form-check-label" for="sshRadio">SSH</label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="localPath">Local path to use</label>
                <input id="localPath" name="localPath" type="text" class="form-control" placeholder="Chemin local sur votre ordinateur">
              </div>                 
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Create</button>
          </div>
        </div>
      </div>
    </div>
  <!-- NEW PROJECT  --> 
