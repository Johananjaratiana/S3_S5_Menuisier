package realmodels;

import java.sql.Connection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class Volume extends models.Volume {

    public Volume(){}

    public static double getVolume(models.Volume v){
        return v.getLongueur() * v.getLargeur() * v.getHauteur();
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Volume c = new Volume();
            List<models.Volume> volumes = c.GetAll("", false, connection);
            request.setAttribute("volumes", volumes);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
