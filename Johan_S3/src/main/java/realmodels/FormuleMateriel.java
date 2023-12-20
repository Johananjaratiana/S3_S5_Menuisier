package realmodels;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import services.DatabaseConnection;

public class FormuleMateriel {
    private Produit produit;
    private Double quantite;
    private Volume volume;

    public Double getQuantite(){return this.quantite;}

    public void setQuantite(Double qte){this.quantite = qte;}

    public Produit getProduit() {
        return produit;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public Volume getVolume() {
        return volume;
    }
    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public static List<FormuleMateriel> GetReferenceUsingMateriel(Integer id_materiel)
    {
        List<FormuleMateriel> answer = new ArrayList<FormuleMateriel>();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = 
                "SELECT p.id as id_produit,  p.nom as nom_produit, " + 
                "       v.id as id_volume , v.nom as nom_volume,   " +
                "       qo.quantite " +
                        "    FROM produit p" +
                        "    JOIN reference r on r.id_produit = p.id" +
                        "    JOIN quantite_outils qo ON qo.id_reference = r.id" +
                        "    JOIN volume v ON v.id = r.id_volume" +
                        "    WHERE " +
                        "        id_materiel = ?" +
                        "        AND qo.quantite >= 1 ;"; // Remplacez 'unite' par le nom de votre table
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_materiel);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Produit temp_produit = new Produit();
                Double temp_quantite = null;
                Volume temp_volume = new Volume();

                temp_produit.setId(resultSet.getInt("id_produit"));
                temp_produit.setNom(resultSet.getString("nom_produit"));

                temp_quantite = resultSet.getDouble("quantite");

                temp_volume.setId(resultSet.getInt("id_volume"));
                temp_volume.setNom(resultSet.getString("nom_volume"));

                FormuleMateriel temp = new FormuleMateriel();
                temp.setProduit(temp_produit);
                temp.setQuantite(temp_quantite);
                temp.setVolume(temp_volume);
                answer.add(temp);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) {
        String to_parse = request.getParameter("id_materiel");
        if(to_parse == null)request.setAttribute("finals", new ArrayList<FormuleMateriel>());
        else{
            Integer id_materiel = Integer.valueOf(to_parse);
            request.setAttribute("finals", GetReferenceUsingMateriel(id_materiel));
        }
    }
}
