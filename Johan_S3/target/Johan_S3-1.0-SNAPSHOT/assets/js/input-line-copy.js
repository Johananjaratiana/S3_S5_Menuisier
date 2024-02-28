function addLine(idForm, idParent, idChild) {
    var submitHandler = function(event) {
      event.preventDefault();
  
      document.getElementById(idForm).removeEventListener('submit', submitHandler);
  
      var parent = document.getElementById(idParent);
      var originalChild = document.getElementById(idChild); 
      var newChild = originalChild.cloneNode(true);
      newChild.removeAttribute("id");
      newChild.removeAttribute("style");
      parent.appendChild(newChild);
    };
  
    document.getElementById(idForm).addEventListener('submit', submitHandler);
}

function removeElementById(id) {
    var child = document.getElementById(id);
    if (child) {
        child.parentNode.removeChild(child);
    }
}

// ------------------------------- UTILISATION

// ----------- FORM : ajout id="" et efface la 1er element
// <form id="idForm">
// <button onclick="removeElementById('idChild')" type="submit" class="btn btn-success mr-2">Ajouter</button>
// </form>

// ----------- TABLE A REPLIQUER
// <thead>
//     <tr>
//         <th colspan="2" id="my-title">
//             Etat routière
//             <button 
//                 onclick="addLine('idForm', 'idParent', 'idChild')"
//                 class="btn btn-success" style="height: 55px; border-radius: 100%;">
//                 <h3>+</h3>
//             </button>
//         </th>
//     </tr>
// </thead>
// <tbody id="idParent">
//     <tr id="idChild" style="display: none;">
//         <td>
//             <select name="rnpk" class="form-select" id="project">
//                 <% for(Rn rn : rns){ %>
//                     <% for(Pk pk : rn.getInitial()) { %>
//                         <option value="<%= rn.getId() + " " + pk.getPk().getId() %>"><%= rn.getNom().replace("-", "") + " " + pk.getPk().getNom() %></option>
//                     <% } %>
//                 <% } %>
//             </select>
//         </td>
//         <td>
//             <select name="status" class="form-select" id="project">
//                 <option value="0">0</option>
//                 <option value="1">1</option>
//                 <option value="2">2</option>
//                 <option value="3">3</option>
//                 <option value="4">4</option>
//                 <option value="5">5</option>
//                 <option value="6">6</option>
//                 <option value="7">7</option>
//                 <option value="8">8</option>
//                 <option value="9">9</option>
//                 <option value="10">10</option>
//             </select>
//         </td>
//     </tr>
// </tbody>