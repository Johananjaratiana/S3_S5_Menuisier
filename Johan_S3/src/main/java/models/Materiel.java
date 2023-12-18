package models;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import services.*;
public class Materiel extends Table{
    Integer id;
    String nom;
    String caracteristique;
    Integer id_unite;

    
    /*public void insert() throws Exception {
    String query = "INSERT INTO materiel (nom, caracteristique, id_unite) VALUES (?, ?, ?)";

    try (Connection connection = DatabaseConnection.GetConnection()) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, caracteristique);
            preparedStatement.setInt(3, id_unite);

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie dans la base de données.");
        }
    } catch (Exception e) {
        System.out.println("Erreur lors de l'insertion : " + e.getMessage());
        throw e;
    }
    }*/
    


    public Materiel(){
        
    }
    public Materiel(ResultSet rs){
        this.construct(rs);
    }
    
    public Materiel(HttpServletRequest request){
        this.formConstruct(request);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public Integer getIdUnite() {
        return id_unite;
    }

    public void setIdUnite(Integer id_unite) {
        this.id_unite = id_unite;
    }
    
    public void setId(Object id){
        this.id = Integer.valueOf(id.toString());
    }
    public void setNom(Object nom){
        this.nom = nom.toString();
    }
    public void setCaracteristique(Object caract){
        this.caracteristique = caract.toString();
    }
    public void setId_unite(Object caract){
        this.id_unite = Integer.valueOf(caract.toString());
    }
     /*public static List<Materiel> selectAll() throws SQLException {
        List<Materiel> materiels = new ArrayList<>();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = "SELECT * FROM materiel"; // Remplacez 'materiel' par le nom de votre table
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Materiel materiel = new Materiel();
                materiel.setId(resultSet.getInt("id"));
                materiel.setNom(resultSet.getString("nom"));
                materiel.setCaracteristique(resultSet.getString("caracteristique"));
                materiel.setIdUnite(resultSet.getInt("id_unite"));

                materiels.add(materiel);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }

        return materiels;
    }*/
    public static void getContent(){
        try {
            Class classe = Class.forName("models.Materiel");
            //getMainContent(classe);
            String canva  = generate_Form_Canva(classe, new String[0], new String[]{"id"});
            System.out.println("content file created");            
            getMainContent(classe);
            System.out.println("main file created");            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static List<Materiel> selectAllByStyle(Integer id_style) throws SQLException {
        List<Materiel> materiels = new ArrayList<>();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = "SELECT m.* \n" +
            "    from stylemateriel sm\n" +
            "     join materiel m on sm.id_materiel=m.id\n" +
            "    where id_style=?\n" +
            "    and status = 10"; // Remplacez 'materiel' par le nom de votre table
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_style);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Materiel materiel = new Materiel();
                materiel.setId(resultSet.getInt("id"));
                materiel.setNom(resultSet.getString("nom"));
                materiel.setCaracteristique(resultSet.getString("caracteristique"));
                materiel.setIdUnite(resultSet.getInt("id_unite"));

                materiels.add(materiel);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }

        return materiels;
    }
     /*SELECT m.* 
    from stylemateriel sm
     join materiel m on sm.id_materiel=m.id
    where id_style=1
    and status = 10;   */
    
}
