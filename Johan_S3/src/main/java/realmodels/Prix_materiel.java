package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import models.V_prix_materiel;

public class Prix_materiel extends models.Prix_materiel{

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Materiel.setDefaultDataToView(connection, request);

            V_prix_materiel pm = new V_prix_materiel();
            List<models.V_prix_materiel> prix_materiels = pm.GetAll("",false, connection);
            request.setAttribute("prix_materiels", prix_materiels);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Prix_materiel prix_materiel = Johan_Servlet.constructByFormView(Prix_materiel.class, request, isChildClass);
            prix_materiel.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
