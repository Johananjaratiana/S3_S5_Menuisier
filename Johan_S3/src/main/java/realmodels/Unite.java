package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Unite extends models.Unite{

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Unite c = new Unite();
            List<models.Unite> unites = c.GetAll("", false, connection);
            request.setAttribute("unites", unites);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Unite unite = Johan_Servlet.constructByFormView(Unite.class, request, isChildClass);
            unite.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }

    // public static List<Unite> selectAll() throws SQLException {
    //     List<Unite> unites = new ArrayList<>();

    //     try (Connection connection = DatabaseConnection.GetConnection()) {
    //         String sql = "SELECT * FROM unite"; // Remplacez 'unite' par le nom de votre table
    //         PreparedStatement preparedStatement = connection.prepareStatement(sql);

    //         ResultSet resultSet = preparedStatement.executeQuery();

    //         while (resultSet.next()) {
    //             Unite unite = new Unite();
    //             unite.setId(resultSet.getInt("id"));
    //             unite.setName(resultSet.getString("name"));

    //             unites.add(unite);
    //         }
    //     }
    //     catch(Exception e){
    //         e.printStackTrace();
    //     }
   

    //     return unites;
    // }
}
