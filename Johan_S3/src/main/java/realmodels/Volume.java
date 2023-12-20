package realmodels;

import java.sql.Connection;
import java.util.*;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;

public class Volume extends models.Volume {

    public Volume(){}

    public Volume(HttpServletRequest request){
        Float longueur = Float.valueOf(request.getParameter("longueur"));
        Float largeur = Float.valueOf(request.getParameter("largeur"));
        Float hauteur = Float.valueOf(request.getParameter("hauteur"));
        String nom = String.valueOf(request.getParameter("nom"));
        this.setLongueur(longueur);   
        this.setLargeur(largeur);  
        this.setHauteur(hauteur);
        this.setNom(nom);
    }

    public static double getVolume(models.Volume v){
        return v.getLongueur() * v.getLargeur() * v.getHauteur();
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Volume c = new Volume();
            List<models.Volume> volumes = c.GetAll_(connection);
            request.setAttribute("volumes", volumes);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static List<models.Volume> GetAll_(Connection connection)  {
        List<models.Volume> volumes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM volume"; // Remplacez 'unite' par le nom de votre table
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                models.Volume v = new models.Volume();
                v.setId(resultSet.getInt("id"));
                v.setLongueur(resultSet.getFloat("longueur"));
                v.setLargeur(resultSet.getFloat("largeur"));
                v.setHauteur(resultSet.getFloat("hauteur"));
                v.setNom(resultSet.getString("nom"));
                volumes.add(v);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return volumes;
    }
    
}
