package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_materiel;

public class Materiel extends models.Materiel{

    public Materiel(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            V_materiel c = new V_materiel();
            List<models.V_materiel> materiels = c.GetAll("",false, connection);
            request.setAttribute("materiels", materiels);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
     /*SELECT m.* 
    from stylemateriel sm
     join materiel m on sm.id_materiel=m.id
    where id_style=1
    and status = 10;   */   
}
