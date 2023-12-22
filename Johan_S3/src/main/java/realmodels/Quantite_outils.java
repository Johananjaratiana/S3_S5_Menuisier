package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_quantite_outils;

public class Quantite_outils extends models.Quantite_outils {
    
    public Quantite_outils(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_quantite_outils vqo = new V_quantite_outils();

            List<V_quantite_outils> quantite_outils = vqo.GetAll("", false, connection);

            request.setAttribute("quantite_outils", quantite_outils);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }
    
}
