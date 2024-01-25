package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_meuble;
import models.V_prix_meuble;

public class Prix_meuble {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            
            V_prix_meuble vpm = new V_prix_meuble();
            V_meuble vr = new V_meuble();

            List<V_meuble> references = vr.GetAll("", false, connection);
            List<V_prix_meuble> prix_meubles = vpm.GetAll("", false, connection);
            
            request.setAttribute("references", references);
            request.setAttribute("prix_meubles", prix_meubles);

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
