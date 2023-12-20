/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import services.DatabaseConnection;

/**
 *
 * @author johan
 */
public class Personne extends Table {
    Integer id;
    String nom;
    String prenom;
    Date dtn;
    String email;
    String mdp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setId(Object id){
        this.id =Integer.valueOf(id.toString());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNom(Object nom){
        this.nom = nom.toString();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setPrenom(Object prenom) {
        this.prenom  = prenom.toString();
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
    public void setDtn(Object dtn){
        this.dtn = Date.valueOf(dtn.toString());
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmail(Object email){
        this.email = email.toString();
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setMdp(Object mdp){
        this.mdp = mdp.toString();
    }
    
    public String getFullName(){
        return (this.nom + " " + this.prenom);
    }
    
    public Personne(){}
    
    public Personne(HttpServletRequest request){
        this.setNom(request.getParameter("nom"));
        this.setPrenom(request.getParameter("prenom"));
        this.setEmail(request.getParameter("email"));
        this.setDtn(Date.valueOf(request.getParameter("dtn")));
        this.setMdp(request.getParameter("mdp"));
    }
    public Personne(ResultSet rs){
        super(rs);
        this.construct(rs);
    }
    
    public static Personne Login(String email , String mdp) throws Exception
    {
        Personne personne = null;
        try {
            try (Connection connection = DatabaseConnection.GetConnection()) {
                String sql = "SELECT * FROM personne WHERE email = ? AND mdp = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Set the value for the placeholder
                preparedStatement.setString(1,email);
                preparedStatement.setString(2, mdp);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Process the result
                if (resultSet.next()) {
                    personne = new Personne();
                    personne.id = resultSet.getInt("id");
                    personne.nom = resultSet.getString("nom");
                    personne.prenom = resultSet.getString("prenom");
                    personne.email = resultSet.getString("email");
                    personne.dtn = resultSet.getDate("dtn");
                }
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return personne;
    }
    
    public static Personne AjouterUtilisateur(HttpServletRequest request) throws Exception {
        Personne newPersonne = new Personne(request);
        try {
            try (Connection connection = DatabaseConnection.GetConnection()) {
                String sql =    "INSERT INTO personne (nom, prenom, email, mdp, dtn) VALUES " + 
                                " (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    // Set the values for the placeholders
                    preparedStatement.setString(1, newPersonne.nom);
                    preparedStatement.setString(2, newPersonne.prenom);
                    preparedStatement.setString(3, newPersonne.email);
                    preparedStatement.setString(4, newPersonne.mdp);
                    preparedStatement.setDate(5, newPersonne.dtn);

                    // Execute the update
                    preparedStatement.executeUpdate();
                }
            }
            return newPersonne;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    public static Double[] getStat(){
        Double[] ans = new Double[]{Double.valueOf(15), Double.valueOf(100),Double.valueOf(85)};
        return ans;
    }
}