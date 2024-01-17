package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class Type_employee {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            models.Type_employee te = new models.Type_employee();
            List<models.Type_employee> type_employees = te.GetAll("", false, connection);
            request.setAttribute("type_employees", type_employees);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
