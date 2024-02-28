package realmodels;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import models.V_style_materiel;

import java.sql.*;

public class Style_materiel extends models.Style_materiel{

    public Style_materiel(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Style.setDefaultDataToView(connection, request);
            Materiel.setDefaultDataToView(connection, request);

            V_style_materiel vsm = new V_style_materiel();
            List<V_style_materiel> style_materiels = vsm.GetAll("", false, connection);
            request.setAttribute("style_materiels", style_materiels);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Style_materiel style_materiel = Johan_Servlet.constructByFormView(Style_materiel.class, request, isChildClass);
            style_materiel.save(isChildClass, connection);
        }catch(Exception ex){
            if(ex.getMessage().contains("existe")){
                request.setAttribute("error", "Cette information a été déjà enregistrer.");
            }
        }
    }
}
