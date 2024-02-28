package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import models.V_produit;


public class Produit extends models.Produit {

    public Produit(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            Categorie.setDefaultDataToView(connection, request);
            
            V_produit p = new V_produit();
            List<V_produit> produits = p.GetAll("", false, connection);
            request.setAttribute("produits", produits);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Produit produit = Johan_Servlet.constructByFormView(Produit.class, request, isChildClass);
            produit.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
