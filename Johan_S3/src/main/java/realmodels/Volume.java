package realmodels;

import java.sql.Connection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

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

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Volume volume = Johan_Servlet.constructByFormView(Volume.class, request, isChildClass);
            volume.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
