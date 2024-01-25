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

            Client c = new Client();
            List<models.Client> clients = c.GetAll("", false, connection);
            request.setAttribute("clients", clients);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void save(HttpServletRequest request, Connection connection) {
        try{
            models.Client client = Johan_Servlet.constructByFormView(models.Client.class, request);
            client.save(false, connection);
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("error", ex.getMessage());
        }
    }
}
