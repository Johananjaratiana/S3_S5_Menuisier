package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_materiel;

public class Materiel extends models.Materiel{

    public Materiel(){}

    public Materiel(HttpServletRequest request) {
        String nom = request.getParameter("nom");
        Integer id_unite = Integer.valueOf(request.getParameter("id_unite"));
        this.setNom(nom);
        this.setId_unite(id_unite);
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            V_materiel c = new V_materiel();
            Unite u = new Unite();
            List<models.V_materiel> materiels = c.GetAll("",false, connection);
            List<models.Unite> unites = u.GetAll("",false, connection);
            request.setAttribute("materiels", materiels);
            request.setAttribute("unites", unites);
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
