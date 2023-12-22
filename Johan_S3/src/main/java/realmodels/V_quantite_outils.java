package realmodels;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public class V_quantite_outils  extends models.V_quantite_outils{

        public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_quantite_outils vfm = new V_quantite_outils();
            String to_parse = request.getParameter("id_materiel");
            List<models.V_quantite_outils> fm = null;
            if(to_parse == null)fm =  new ArrayList<models.V_quantite_outils>();
            else fm = vfm.GetAll("WHERE id_materiel = " + to_parse, false, connection);
            request.setAttribute("quantite_outils", fm);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
