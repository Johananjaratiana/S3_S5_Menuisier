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
public class Client extends models.Client {
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Sexe.setDefaultDataToView(connection, request);

            models.V_client c = new models.V_client();
            List<models.V_client> clients = c.GetAll("", false, connection);
            request.setAttribute("clients", clients);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(HttpServletRequest request, Connection connection) {
        try{
            Boolean isChildClass = true;
            Client client = Johan_Servlet.constructByFormView(Client.class, request, isChildClass);
            client.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static String GetFullName(models.V_client client){
        return client.getNom() + " " + client.getPrenom(); 
    }
}
