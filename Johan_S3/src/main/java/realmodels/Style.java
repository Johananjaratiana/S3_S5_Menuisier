/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hp
 */

public class Style extends models.Style {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Style c = new Style();
            List<models.Style> styles = c.GetAll(false, connection);
            request.setAttribute("styles", styles);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
