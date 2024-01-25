package realmodels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import services.DatabaseConnection;

public class Statistique_vente {
    Integer id_meuble;
    Double total_acheteur;
    Double nb_homme;
    Double nb_femme;

    public Double GetHommePart(){
        return 100 * this.getNb_homme() / this.getTotal_acheteur();
    }  
    public Double GetFemmePart(){
        return 100 * this.getNb_femme() / this.getTotal_acheteur();
    }

    public static void SetStatVente(HttpServletRequest request, Connection connection) throws Exception{
        try{
            Statistique_vente statistique_vente = Johan_Servlet.constructByFormView(Statistique_vente.class, request);
            statistique_vente = statistique_vente.Getstat();
            request.setAttribute("statistique_vente", statistique_vente);
        }catch(Exception ex){
            request.setAttribute("statistique_vente", new Statistique_vente());
            throw new Exception(ex);
        }
    }

    public Statistique_vente Getstat()throws Exception{
        try{
            if(this.getId_meuble() == null || this.getId_meuble().intValue() < 0)return Statistique_vente.GetGlobal();
            return Statistique_vente.GetByMeubleId(this.getId_meuble());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static Statistique_vente GetGlobal() throws Exception {
        Statistique_vente statistique_vente = new Statistique_vente();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = "SELECT \n" + //
                    "    COALESCE(SUM(nb),-1) as total,\n" + //
                    "    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 2 ), 0) as nb_homme,\n" + //
                    "    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 3 ), 0) as nb_femme\n" + //
                    "    from vente";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                statistique_vente.setTotal_acheteur(resultSet.getDouble("total"));
                statistique_vente.setNb_homme(resultSet.getDouble("nb_homme"));
                statistique_vente.setNb_femme(resultSet.getDouble("nb_femme"));
            }
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return statistique_vente;
    }

    public static Statistique_vente GetByMeubleId(Integer id_meuble) throws Exception {
        Statistique_vente statistique_vente = new Statistique_vente();

        try (Connection connection = DatabaseConnection.GetConnection()) {
            String sql = "SELECT \n" + //
                    "    COALESCE(SUM(nb),-1) as total,\n" + //
                    "    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 2 and id_meuble = ? ), 0) as nb_homme,\n" + //
                    "    COALESCE((SELECT SUM(nb) from v_vente where id_sexe = 3 and id_meuble = ? ), 0) as nb_femme\n" + //
                    "    from vente\n" + //
                    "    where id_meuble = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id_meuble);
            preparedStatement.setInt(2, id_meuble);
            preparedStatement.setInt(3, id_meuble);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                statistique_vente.setTotal_acheteur(resultSet.getDouble("total"));
                statistique_vente.setNb_homme(resultSet.getDouble("nb_homme"));
                statistique_vente.setNb_femme(resultSet.getDouble("nb_femme"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return statistique_vente;
    }

    public Integer getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(Integer id_meuble) {
        this.id_meuble = id_meuble;
    }

    public Double getTotal_acheteur() {
        return total_acheteur;
    }

    public void setTotal_acheteur(Double total_acheteur) {
        this.total_acheteur = total_acheteur;
    }

    public Double getNb_homme() {
        return nb_homme;
    }

    public void setNb_homme(Double nb_homme) {
        this.nb_homme = nb_homme;
    }

    public Double getNb_femme() {
        return nb_femme;
    }

    public void setNb_femme(Double nb_femme) {
        this.nb_femme = nb_femme;
    }
    

    public Statistique_vente() {
        this.setTotal_acheteur(Double.valueOf(1));
        this.setNb_homme(Double.valueOf(0));
        this.setNb_femme(Double.valueOf(0));
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            models.V_meuble c = new models.V_meuble();
            List<models.V_meuble> meubles = c.GetAll("", false, connection);
            request.setAttribute("meubles", meubles);

            // Statistique du vente
            SetStatVente(request, connection);
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("error", ex.getMessage());
        }
    }
}
