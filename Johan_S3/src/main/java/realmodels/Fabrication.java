package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_check_left_by_quantite_outils;
import models.V_fabrication;

public class Fabrication {

    public static String BuildWhereRequest(models.Fabrication fabrication){
        return " WHERE id_meuble = " + fabrication.getId_meuble();
    }

    public static String GetManquanteOrNoMateriel(models.Fabrication fabrication, List<V_check_left_by_quantite_outils> list_restante){
        String answer = "";
        for (V_check_left_by_quantite_outils v_check_left_by_quantite_outils : list_restante) {
            if(v_check_left_by_quantite_outils.getQuantite().doubleValue() * fabrication.getQuantite().doubleValue() > v_check_left_by_quantite_outils.getSum().doubleValue()){
                answer += " Il manque " + 
                            ( v_check_left_by_quantite_outils.getQuantite().doubleValue() * fabrication.getQuantite().doubleValue() - v_check_left_by_quantite_outils.getSum().doubleValue() ) + 
                        " de " + v_check_left_by_quantite_outils.getNom_materiel() + ". ";
            }
        }
        if(list_restante.size() == 0)answer = "Ce meubles n` est pas encore bien concus";
        return answer;
    }

    public static void GetInStock(models.Fabrication fabrication, List<V_check_left_by_quantite_outils> list_restante, Connection connection) throws Exception{
        try{
            models.Stock stock ;
            for (V_check_left_by_quantite_outils v_check_left_by_quantite_outils : list_restante) {
                stock = new models.Stock();
                stock.setId_fabrication(fabrication.getId());
                stock.setId_materiel(v_check_left_by_quantite_outils.getId_materiel());
                stock.setNombre((-1) * v_check_left_by_quantite_outils.getQuantite() * fabrication.getQuantite());
                stock.save(false, connection);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void BuildReference(models.Fabrication fabrication, Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_check_left_by_quantite_outils vclbqo = new V_check_left_by_quantite_outils();
            List<V_check_left_by_quantite_outils> list_restante = vclbqo.GetAll(BuildWhereRequest(fabrication), false, connection);
            String exception = GetManquanteOrNoMateriel(fabrication, list_restante);

            if(fabrication.getQuantite().intValue() < 0 )throw new Exception("Negatif");
            if(exception.length() != 0) throw new Exception(exception);
            fabrication.setQuantite(fabrication.getQuantite());   
            Long id_fabrication = fabrication.save(false, connection);
            fabrication.setId(Integer.parseInt(id_fabrication.toString()));
            GetInStock(fabrication, list_restante, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            V_fabrication vr = new V_fabrication();
            List<V_fabrication> fabrications = vr.GetAll("", false, connection);
            request.setAttribute("fabrications", fabrications);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
