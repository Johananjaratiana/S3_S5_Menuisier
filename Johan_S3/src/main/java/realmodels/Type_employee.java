package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;


public class Type_employee extends models.Type_employee {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            models.Type_employee te = new models.Type_employee();
            List<models.Type_employee> type_employees = te.GetAll("", false, connection);
            request.setAttribute("type_employees", type_employees);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Type_employee type_employee = Johan_Servlet.constructByFormView(Type_employee.class, request, isChildClass);
            type_employee.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
