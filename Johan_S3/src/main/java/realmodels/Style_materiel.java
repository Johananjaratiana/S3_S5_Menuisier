package realmodels;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.dao.annotation.J_Column;
import models.V_style_materiel;

import java.sql.*;

public class Style_materiel extends models.Style_materiel{

    public Style_materiel(){}

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            V_style_materiel vsm = new V_style_materiel();
            List<V_style_materiel> style_materiels = vsm.GetAll("", false, connection);
            request.setAttribute("style_materiels", style_materiels);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
