package realmodels;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public class V_formule_materiel  extends models.V_formule_materiel{

        public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_formule_materiel vfm = new V_formule_materiel();
            String to_parse = request.getParameter("id_materiel");
            List<models.V_formule_materiel> fm = null;
            if(to_parse == null)fm =  new ArrayList<models.V_formule_materiel>();
            else fm = vfm.GetAll("WHERE id_materiel = " + to_parse, false, connection);
            request.setAttribute("formule_materiels", fm);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
