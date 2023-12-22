package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_produit;


public class Produit extends models.Produit {

    public Produit(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_produit p = new V_produit();
            List<V_produit> produits = p.GetAll("", false, connection);
            request.setAttribute("produits", produits);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
