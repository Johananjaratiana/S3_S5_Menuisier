package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_check_left_by_quantite_outils;
import models.V_commande;

public class Commande {

    public static String BuildWhereRequest(models.Commande commande){
        return " WHERE id_reference = " + commande.getId_reference();
    }

    public static String GetManquante(models.Commande commande, List<V_check_left_by_quantite_outils> list_restante){
        String answer = "";
        for (V_check_left_by_quantite_outils v_check_left_by_quantite_outils : list_restante) {
            if(v_check_left_by_quantite_outils.getQuantite().doubleValue() * commande.getQuantite().doubleValue() > v_check_left_by_quantite_outils.getSum().doubleValue()){
                answer += " Il manque " + 
                            ( v_check_left_by_quantite_outils.getQuantite().doubleValue() * commande.getQuantite().doubleValue() - v_check_left_by_quantite_outils.getSum().doubleValue() ) + 
                        " de " + v_check_left_by_quantite_outils.getNom_materiel() + ". ";
            }
        }
        return answer;
    }

    public static void GetInStock(models.Commande commande, List<V_check_left_by_quantite_outils> list_restante, Connection connection) throws Exception{
        try{
            models.Stock stock ;
            for (V_check_left_by_quantite_outils v_check_left_by_quantite_outils : list_restante) {
                stock = new models.Stock();
                stock.setId_commande(commande.getId());
                stock.setId_materiel(v_check_left_by_quantite_outils.getId_materiel());
                stock.setNombre((-1) * v_check_left_by_quantite_outils.getQuantite() * commande.getQuantite());
                stock.save(false, connection);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void BuildReference(models.Commande commande, Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_check_left_by_quantite_outils vclbqo = new V_check_left_by_quantite_outils();
            List<V_check_left_by_quantite_outils> list_restante = vclbqo.GetAll(BuildWhereRequest(commande), false, connection);
            String exception = GetManquante(commande, list_restante);

            if(commande.getQuantite().intValue() < 0 )throw new Exception("Negatif");
            if(exception.length() != 0) throw new Exception(exception);
            commande.setQuantite(commande.getQuantite());   
            Long id_commande = commande.save(false, connection);
            commande.setId(Integer.parseInt(id_commande.toString()));
            GetInStock(commande, list_restante, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_commande vr = new V_commande();
            List<V_commande> commandes = vr.GetAll("", false, connection);
            request.setAttribute("commandes", commandes);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
