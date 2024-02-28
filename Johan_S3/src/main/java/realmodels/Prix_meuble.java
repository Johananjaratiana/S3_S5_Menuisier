package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Prix_meuble extends models.Prix_meuble{

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            Meuble.setDefaultDataToView(connection, request);

            models.V_prix_meuble vpm = new models.V_prix_meuble();
            models.V_meuble vr = new models.V_meuble();

            List<models.V_meuble> references = vr.GetAll("", false, connection);
            List<models.V_prix_meuble> prix_meubles = vpm.GetAll("", false, connection);
            
            request.setAttribute("references", references);
            request.setAttribute("prix_meubles", prix_meubles);

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Prix_meuble prix_meuble = Johan_Servlet.constructByFormView(Prix_meuble.class, request, isChildClass);
            prix_meuble.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
