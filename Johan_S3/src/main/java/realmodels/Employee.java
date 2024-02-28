package realmodels;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Employee extends models.Employee{

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            models.Employee e = new models.Employee();
            List<models.Employee> employees = e.GetAll("", false, connection);
            request.setAttribute("employees", employees);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(HttpServletRequest request, Connection connection) {
        try{
            Boolean isChildClass = true;
            Employee employee = Johan_Servlet.constructByFormView(Employee.class, request, isChildClass);
            employee.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static int CalculateAge(Date birthDate) {
        LocalDate birthday = birthDate.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthday, currentDate);
        return period.getYears();
    }

    public static String EnglishToFrench(Object chars){
        String str = chars.toString();
        return str.replace("years", "ans").replace("mons", "mois").replace("days", "jours");
    }
    
}
