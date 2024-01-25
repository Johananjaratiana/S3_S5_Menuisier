package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.V_quantite_outils;

public class Quantite_outils extends models.Quantite_outils {

    public Quantite_outils() {
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception {
        try {
            V_quantite_outils vqo = new V_quantite_outils();

            List<V_quantite_outils> quantite_outils = vqo.GetAll("", false, connection);

            request.setAttribute("quantite_outils", quantite_outils);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static String BuildWhereConstraint(models.Quantite_outils quantite_outil) {
        return " WHERE id = " + quantite_outil.getId_meuble() + " AND id_materiel = "
                + quantite_outil.getId_materiel();
    }

    public static void InsertQuantiteUtiliser(models.Quantite_outils quantite_outil, Connection connection,
            HttpServletRequest request) throws Exception {
        try {
            if(quantite_outil.getQuantite() == null){
                throw new Exception("Veuillez insérez une quantité.");
            }
            models.V_contrainte_style_materiel_meuble contrainte = new models.V_contrainte_style_materiel_meuble();
            List<models.V_contrainte_style_materiel_meuble> list = contrainte
                    .GetAll(BuildWhereConstraint(quantite_outil), false, connection);
            if (list.size() == 0) {
                throw new Exception("On ne peut pas utiliser cette matériels séléctionner dans ce meuble.");
            }
            AvoidDuplicateMateriel(connection, quantite_outil);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static void AvoidDuplicateMateriel(Connection connection, models.Quantite_outils quantite_outils)throws Exception{
        try{
            quantite_outils.save(false, connection);
        }catch(Exception ex){
            throw new Exception("Ce materiel est deja utiliser par ce meubles");
        }
    }

}
