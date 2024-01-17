package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_stock_restante;

public class V_full_stock_restante {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            V_stock_restante c = new V_stock_restante();
            List<models.V_stock_restante> stock_restante = c.GetAll("",false, connection);
            request.setAttribute("stock_restante", stock_restante);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
