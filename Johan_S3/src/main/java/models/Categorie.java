/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import services.DatabaseConnection;

/**
 *
 * @author hp
 */
public class Categorie extends Table {
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
    
    public Categorie(){
        
    }
    public Categorie(ResultSet rs){
        this.construct(rs);
    }
    public Categorie(HttpServletRequest request){
        this.formConstruct(request);
    }
    public static void getContent(){
        try {
            Class classe = Class.forName("models.Categorie");
            //getMainContent(classe);
            String canva  = generate_Form_Canva(classe, new String[0], new String[]{"id"}); 
            System.out.println("content file created");

            getMainContent(classe);
            System.out.println("main file created");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
