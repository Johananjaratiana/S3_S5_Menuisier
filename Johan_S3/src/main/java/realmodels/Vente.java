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
public class Vente extends models.Vente {

    public static String GetClientFullName(models.V_vente vente){
        return vente.getNom_client() + " " + vente.getPrenom_client();
    }

    public static String GetMeubleFullName(models.V_vente vm){
        return vm.getNom_produit_meuble()+" "+vm.getNom_categorie_meuble()+"" +vm.getNom_style_meuble()+" "+vm.getNom_volume_meuble();
    }
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Sexe.setDefaultDataToView(connection, request);
            Client.setDefaultDataToView(connection, request);
            Meuble.setDefaultDataToView(connection, request);

            models.V_vente c = new models.V_vente();
            List<models.V_vente> ventes = c.GetAll("", false, connection);
            request.setAttribute("ventes", ventes);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void save(HttpServletRequest request, Connection connection) {
        try{
            models.Vente vente = Johan_Servlet.constructByFormView(models.Vente.class, request);
            vente.save(false, connection);
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("error", ex.getMessage());
        }
    }
}
