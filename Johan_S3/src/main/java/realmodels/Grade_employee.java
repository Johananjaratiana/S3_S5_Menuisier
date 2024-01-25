/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.util.List;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hp
 */
public class Grade_employee extends models.Grade_employee {
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Grade_employee ge = new Grade_employee();
            List<models.Grade_employee> grade_employees = ge.GetAll("", false, connection);
            request.setAttribute("grade_employees", grade_employees);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }
}
