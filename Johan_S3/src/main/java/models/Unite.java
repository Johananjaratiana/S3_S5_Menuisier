package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import services.DatabaseConnection;

public class Unite extends Table{
    private Integer id;
    private String name;
    
    public Unite(){}
    
    public Unite(ResultSet rs){
        this.construct(rs);
    }
    
    public Unite(HttpServletRequest request){
        this.formConstruct(request);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setId(Object id){
        this.id = Integer.valueOf(id.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setName(Object name){
        this.name = name.toString();
    }
    
    public static void getContent(){
        try {
            Class classe = Class.forName("models.Unite");
            //getMainContent(classe);
            String canva  = generate_Form_Canva(classe, new String[0], new String[]{"id"}); 
            System.out.println("content file created");            
            getMainContent(classe);
            System.out.println("main file created");            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*public static List<Unite> selectAll() throws SQLException {
        List<Unite> unites = new ArrayList<>();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = "SELECT * FROM unite"; // Remplacez 'unite' par le nom de votre table
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Unite unite = new Unite();
                unite.setId(resultSet.getInt("id"));
                unite.setName(resultSet.getString("name"));

                unites.add(unite);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
   

        return unites;
    }*/
}
