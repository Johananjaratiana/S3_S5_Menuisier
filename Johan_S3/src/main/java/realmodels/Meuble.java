package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_reference;

public class Meuble extends models.Meuble {

    public Meuble(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_reference vr = new V_reference();
            List<V_reference> references = vr.GetAll("", false, connection);
            request.setAttribute("references", references);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
