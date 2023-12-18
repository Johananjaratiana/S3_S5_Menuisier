package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import services.DatabaseConnection;

public class StyleMateriel extends Table{
     Integer id;
     Integer idStyle;
    Integer idMateriel;
    Integer status;

    public StyleMateriel(HttpServletRequest request) {
        this.formConstruct(request);
    }
    public StyleMateriel(ResultSet rs){
        this.construct(rs);
    }

    /*public void insert() throws Exception {
        String query = "INSERT INTO stylemateriel (id_style, id_materiel, status) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.GetConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idStyle);
                preparedStatement.setInt(2, idMateriel);
                preparedStatement.setInt(3, status);

                preparedStatement.executeUpdate();
                System.out.println("Insertion réussie dans la base de données.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'insertion : " + e.getMessage());
            throw e;
        }
    }*/
    public StyleMateriel(){
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Integer idStyle) {
        this.idStyle = idStyle;
    }

    public Integer getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(Integer idMateriel) {
        this.idMateriel = idMateriel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public void setId(Object id) {
        this.id = Integer.valueOf(id.toString());
    }
    
    public void setIdStyle(Object idStyle) {
        this.idStyle = Integer.valueOf(idStyle.toString());
    }
    public void setIdMateriel(Object idMateriel) {
        this.idMateriel = Integer.valueOf(idMateriel.toString());
    }
    public void setStatus(Object status) {
        this.status =Integer.valueOf(status.toString());
    }
    public static void getContent(){
        try {
            Class classe = Class.forName("models.StyleMateriel");
            //getMainContent(classe);
            String canva  = generate_Form_Canva(classe, new String[]{"idStyle", "idMateriel"}, new String[]{"id", "status"});
            System.out.println("content file created");
            getMainContent(classe);
            System.out.println("main file created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
