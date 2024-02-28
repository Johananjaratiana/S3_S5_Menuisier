/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

/**
 *
 * @author hp
 */

public class Style extends models.Style {

    @Override
    public void setNom(String nom) throws Exception{
        try{
            if(nom == null || nom.length() == 0){
                throw new Exception("Le nom des styles ne peut être vide");
            }
            super.setNom(nom);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Style c = new Style();
            List<models.Style> styles = c.GetAll("", false, connection);
            request.setAttribute("styles", styles);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static String BuildErrorStyleMateriel(){
        return "Ca existe déjà";
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Style style = Johan_Servlet.constructByFormView(Style.class, request, isChildClass);
            style.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }

}
