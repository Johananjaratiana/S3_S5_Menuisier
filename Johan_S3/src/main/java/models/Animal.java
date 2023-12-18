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
public class Animal extends Table{
    Integer id;
    String type;
    String nom;
    
    public void setId(Object id){
        this.id = Integer.valueOf(id.toString());
    }
    public void setType(Object type){
        this.type = type.toString();
    }
    public void setNom(Object nom){
        this.nom = nom.toString();
    }
    
    public Integer getId(){
        return this.id;
    }
    public String getType(){
        return this.type;
    }
    public String getNom(){
        return this.nom;
    }
    
    public Animal(){
        
    }
    public Animal(ResultSet rs){
        this.construct(rs);
    }
    public Animal(HttpServletRequest request){
        this.setNom(request.getParameter("nom"));
        this.setType(request.getParameter("type"));
    }
    
}
