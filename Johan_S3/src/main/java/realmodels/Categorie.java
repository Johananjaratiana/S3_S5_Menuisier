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
public class Categorie extends models.Categorie {

    public static void Save(Connection connection, HttpServletRequest request){
        try{
            Boolean isChildClass = true;
            Categorie cat = Johan_Servlet.constructByFormView(Categorie.class, request, isChildClass);
            cat.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Categorie c = new Categorie();
            List<models.Categorie> categories = c.GetAll("", false, connection);
            request.setAttribute("categories", categories);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }
}
