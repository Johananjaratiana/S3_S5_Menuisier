package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_reference;
import models.V_prix_meuble;

public class Prix_meuble {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            
            V_prix_meuble vpm = new V_prix_meuble();
            V_reference vr = new V_reference();

            List<V_reference> references = vr.GetAll("", false, connection);
            List<V_prix_meuble> prix_meubles = vpm.GetAll("", false, connection);
            
            request.setAttribute("references", references);
            request.setAttribute("prix_meubles", prix_meubles);

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
