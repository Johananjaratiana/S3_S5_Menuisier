package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class V_duree_fabrication {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Meuble.setDefaultDataToView(connection, request);
            Type_employee.setDefaultDataToView(connection, request);

            models.V_duree_fabrication c = new models.V_duree_fabrication();
            List<models.V_duree_fabrication> duree_fabrications = c.GetAll("",false, connection);
            request.setAttribute("duree_fabrications", duree_fabrications);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
