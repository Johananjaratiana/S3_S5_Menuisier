package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_quantite_outils;

public class Quantite_outils extends models.Quantite_outils {

    public Quantite_outils(HttpServletRequest request) {
        Integer id_reference = Integer.valueOf(request.getParameter("id_reference"));
        Integer id_mtr = Integer.valueOf(request.getParameter("id_materiel"));
        Float quantite = Float.valueOf(request.getParameter("quantite"));
        this.setId_reference(id_reference);
        this.setId_materiel(id_mtr);
        this.setQuantite(quantite);
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            Reference r = new Reference();
            Materiel m = new Materiel();
            V_quantite_outils vqo = new V_quantite_outils();


            List<models.Reference> references = r.GetAll("", false, connection);
            List<models.Materiel> materiels = m.GetAll("", false, connection);
            List<V_quantite_outils> quantite_outils = vqo.GetAll("", false, connection);

            request.setAttribute("references", references);
            request.setAttribute("materiels", materiels);
            request.setAttribute("quantite_outils", quantite_outils);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }
    
}
