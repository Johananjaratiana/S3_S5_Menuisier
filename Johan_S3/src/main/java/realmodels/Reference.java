package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_reference;

public class Reference extends models.Reference {

    public Reference(){}

    public Reference(HttpServletRequest request) {
        Integer id_categorie = Integer.valueOf(request.getParameter("id_categorie"));
        Integer id_style = Integer.valueOf(request.getParameter("id_style"));
        Integer id_volume = Integer.valueOf(request.getParameter("id_volume"));
        Integer id_produit = Integer.valueOf(request.getParameter("id_produit"));

        this.setId_categorie(id_categorie);
        this.setId_style(id_style);
        this.setId_volume(id_volume);
        this.setId_produit(id_produit);
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            Categorie c = new Categorie();
            Style s = new Style();
            realmodels.Volume v = new Volume();
            Produit p = new Produit();
            V_reference vr = new V_reference();

            List<models.Categorie> categories = c.GetAll("", false, connection);
            List<models.Style> styles = s.GetAll("", false, connection);
            List<models.Volume> volumes = v.GetAll_(connection);
            List<models.Produit> produits = p.GetAll("", false, connection);
            List<V_reference> references = vr.GetAll("", false, connection);

            request.setAttribute("categories", categories);
            request.setAttribute("styles", styles);
            request.setAttribute("volumes", volumes);
            request.setAttribute("produits", produits);
            request.setAttribute("references", references);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
