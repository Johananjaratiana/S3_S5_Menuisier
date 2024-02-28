package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import models.V_materiel;

public class Materiel extends models.Materiel{

    public Materiel(){}

    @Override
    public void setNom(String nom) throws Exception{
        try{
            if(nom == null || nom.length() == 0 || nom.compareTo(" ") == 0){
                throw new Exception("Le nom des matériels ne peut être vide");
            }
            super.setNom(nom);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Unite.setDefaultDataToView(connection, request);

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

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Materiel materiel = Johan_Servlet.constructByFormView(Materiel.class, request, isChildClass);
            materiel.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }   
}
