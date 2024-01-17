package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_prix_materiel;

public class Prix_materiel {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            V_prix_materiel pm = new V_prix_materiel();
            List<models.V_prix_materiel> prix_materiels = pm.GetAll("",false, connection);
            request.setAttribute("prix_materiels", prix_materiels);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
