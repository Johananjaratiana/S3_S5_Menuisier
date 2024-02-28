/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import johan.dao.annotation.J_Column;
import johan.servlet.Johan_Servlet;

/**
 *
 * @author hp
 */
public class Vente {
    @J_Column(name = "id_client")
    Integer id_client;

    @J_Column(name = "id_meuble")
    Integer[] id_meuble;

    @J_Column(name = "quantite")
    Integer[] quantite;

    @J_Column(name = "date_")
    Timestamp[] date_;

    public List<models.Stock_meuble> BuildAllVente()throws Exception{
        List<models.Stock_meuble> stock_meubles = new ArrayList<models.Stock_meuble>();
        try{
            models.Stock_meuble temp;
            for(int i = 0 ; i < id_meuble.length ; i++){
                temp = new models.Stock_meuble();
                temp.setId_client(this.getId_client());
                temp.setId_meuble(this.getId_meuble()[i]);
                temp.setQuantite(this.getQuantite()[i]);
                temp.setDate_(this.getDate_()[i]);
                stock_meubles.add(temp);
                if(temp.getQuantite() == null || temp.getQuantite().intValue() < 0){
                    throw new Exception("Les quantités doivent être strictement supérieur à 0.");
                }
            }
            return stock_meubles;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static String GetClientFullName(models.V_vente vente){
        return vente.getNom_client() + " " + vente.getPrenom_client();
    }

    public static String GetMeubleFullName(models.V_vente vm){
        return vm.getNom_produit_meuble()+" "+vm.getNom_categorie_meuble()+"" +vm.getNom_style_meuble()+" "+vm.getNom_volume_meuble();
    }
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            Sexe.setDefaultDataToView(connection, request);
            Client.setDefaultDataToView(connection, request);
            Meuble.setDefaultDataToView(connection, request);

            models.V_vente c = new models.V_vente();
            List<models.V_vente> ventes = c.GetAll("", false, connection);
            request.setAttribute("ventes", ventes);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(HttpServletRequest request, Connection connection) {
        try{
            Vente vente = Johan_Servlet.constructByFormView(Vente.class, request, false);
            List<models.Stock_meuble> stock_meubles = vente.BuildAllVente();
            String error = "";

            for (models.Stock_meuble sm : stock_meubles) {
                error += CheckError_with_LeftVerification(sm, connection);
                sm.setQuantite(-1 * sm.getQuantite());
            }
            if(error.length() > 0)throw new Exception("Il manque " + error);

            for (models.Stock_meuble sm : stock_meubles) {
                sm.save(false, connection);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static String CheckError_with_LeftVerification(models.Stock_meuble vente, Connection connection) throws Exception{
        try{
            Integer left = GetLeftQuantityByMeuble_Id(vente.getId_meuble(), connection);
            if(left.intValue() < vente.getQuantite().intValue()){
                models.V_meuble vm = new models.V_meuble();
                vm = vm.GetAll(" WHERE id = " + vente.getId_meuble(), false, connection).get(0);
                return (vente.getQuantite().intValue() - left) + " unité de " + realmodels.Meuble.GetFullName(vm) + ", ";
            }
            return "";
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public static Integer GetLeftQuantityByMeuble_Id(Integer id_meuble, Connection connection){
        Integer left = Integer.valueOf(0);
        try {
            String sql = "SELECT COALESCE(sum(quantite),0) AS reste FROM stock_meuble WHERE id_meuble = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id_meuble);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                left = resultSet.getInt("reste");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return left;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer[] getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(Integer[] id_meuble) {
        this.id_meuble = id_meuble;
    }

    public Integer[] getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer[] quantite) {
        this.quantite = quantite;
    }

    public Timestamp[] getDate_() {
        return date_;
    }

    public void setDate_(Timestamp[] date_) {
        this.date_ = date_;
    }
}
