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
public class Sexe extends models.Sexe {
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Sexe c = new Sexe();
            List<models.Sexe> sexes = c.GetAll("", false, connection);
            request.setAttribute("sexes", sexes);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }
}
