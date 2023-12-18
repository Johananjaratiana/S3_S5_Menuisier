/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import services.DatabaseConnection;
import java.util.*;

/**
 *
 * @author hp
 */

public class Style extends Table {
    Integer id;
    String nom;
    
     public void setId(Object id){
        this.id = Integer.valueOf(id.toString());
    }
    public void setNom(Object nom){
        this.nom = nom.toString();
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public Style(){
        
    }
    public Style(ResultSet rs){
        this.construct(rs);
    }
    public Style(HttpServletRequest request){
        this.setNom(request.getParameter("nom"));
    }
    
    public static void getContent(){
        try {
            Class classe = Class.forName("models.Style");
            //getMainContent(classe);
            String canva  = generate_Form_Canva(classe, new String[0], new String[]{"id"}); 
            getMainContent(classe);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*public static List<Style> selectAll() throws SQLException {
        List<Style> styles = new ArrayList<>();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = "SELECT * FROM style"; // Remplacez 'style' par le nom de votre table
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Style style = new Style();
                style.setId(resultSet.getInt("id"));
                style.setNom(resultSet.getString("nom"));

                styles.add(style);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }

        return styles;
    }*/
}
