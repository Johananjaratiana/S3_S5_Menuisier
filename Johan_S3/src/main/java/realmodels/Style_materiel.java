package realmodels;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.dao.annotation.J_Column;
import models.V_style_materiel;

import java.sql.*;

public class Style_materiel extends models.Style_materiel{

    public Style_materiel(){}

    public Style_materiel(HttpServletRequest request) {
	    Integer id_style = Integer.valueOf(request.getParameter("id_style"));
	    Integer id_materiel = Integer.valueOf(request.getParameter("id_materiel"));
	    this.setId_style(id_style);
	    this.setId_materiel(id_materiel);
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Style s = new Style();                    
            Materiel m = new Materiel();
            V_style_materiel vsm = new V_style_materiel();
            List<models.Style> styles = s.GetAll(false, connection);
            List<models.Materiel> materiels = m.GetAll(false, connection);
            List<V_style_materiel> style_materiels = vsm.GetAll(false, connection);
            request.setAttribute("styles", styles);
            request.setAttribute("materiels", materiels);
            request.setAttribute("style_materiels", style_materiels);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
