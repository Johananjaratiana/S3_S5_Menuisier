/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.util.List;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

/**
 *
 * @author hp
 */
public class Grade_params extends models.Grade_params {
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Grade_employee.setDefaultDataToView(connection, request);

            models.V_real_grade_params gp = new models.V_real_grade_params();
            List<models.V_real_grade_params> real_grade_params = gp.GetAll("", false, connection);
            request.setAttribute("real_grade_params", real_grade_params);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void save(HttpServletRequest request, Connection connection) {
        try{
            models.Grade_params grade_params = Johan_Servlet.constructByFormView(models.Grade_params.class, request);
            
            if(grade_params.getYears() == null || grade_params.getX_fois_taux_salaire() == null){
                throw new Exception("Veuillez vérifier les entrées ");
            }

            if(grade_params.getYears().intValue() < 0 || grade_params.getX_fois_taux_salaire().intValue() < 0){
                throw new Exception("Veuillez vérifier les entrées ");
            }

            grade_params.save(false, connection);
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("error", ex.getMessage());
        }
    }
}
