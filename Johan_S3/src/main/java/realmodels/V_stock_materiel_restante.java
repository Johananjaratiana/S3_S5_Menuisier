package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class V_stock_materiel_restante {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Materiel.setDefaultDataToView(connection, request);

            models.V_stock_materiel_restante c = new models.V_stock_materiel_restante();
            List<models.V_stock_materiel_restante> stock_restante = c.GetAll("",false, connection);
            request.setAttribute("stock_restante", stock_restante);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
