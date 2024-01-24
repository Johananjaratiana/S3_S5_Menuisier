package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Employement {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Employee.setDefaultDataToView(connection, request);
            Type_employee.setDefaultDataToView(connection, request);

            models.V_taux_salaire_employe tse = new models.V_taux_salaire_employe();
            List<models.V_taux_salaire_employe> taux_salaire_employees = tse.GetAll("", false, connection);
            request.setAttribute("taux_salaire_employees", taux_salaire_employees);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void save(Connection connection, HttpServletRequest request) {
        try{
            models.Employement employement = Johan_Servlet.constructByFormView(models.Employement.class, request);
            employement.save(false, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
