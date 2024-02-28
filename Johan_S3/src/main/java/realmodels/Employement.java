package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Employement extends models.Employement{

    public static Float CalculateRealTauxHoraire(models.V_taux_salaire_employee taux_salaire_employee){
        return taux_salaire_employee.getTaux_horaire_type() * taux_salaire_employee.getX_fois_taux_salaire();
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Employee.setDefaultDataToView(connection, request);
            Type_employee.setDefaultDataToView(connection, request);

            models.V_taux_salaire_employee tse = new models.V_taux_salaire_employee();
            List<models.V_taux_salaire_employee> taux_salaire_employees = tse.GetAll("", false, connection);
            request.setAttribute("taux_salaire_employees", taux_salaire_employees);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Employement employement = Johan_Servlet.constructByFormView(Employement.class, request, isChildClass);
            employement.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }    
}
