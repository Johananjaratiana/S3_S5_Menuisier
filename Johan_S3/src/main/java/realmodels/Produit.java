package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class Produit extends models.Produit {

    public Produit(){}

    public Produit(HttpServletRequest request) {
	    String nom = String.valueOf(request.getParameter("nom"));
	    this.setNom( nom); 
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            Produit p = new Produit();
            List<models.Produit> produits = p.GetAll("", false, connection);
            request.setAttribute("produits", produits);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
