package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_meuble;

public class Meuble extends models.Meuble {

    public Meuble(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_meuble vr = new V_meuble();
            List<V_meuble> meubles = vr.GetAll("", false, connection);
            request.setAttribute("meubles", meubles);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
