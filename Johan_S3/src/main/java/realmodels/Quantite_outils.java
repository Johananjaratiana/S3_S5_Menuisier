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
        return " WHERE id = " + quantite_outil.getId_reference() + " AND id_materiel = "
                + quantite_outil.getId_materiel();
    }

    public static Boolean CanInsert(models.Quantite_outils quantite_outil, Connection connection,
            HttpServletRequest request) throws Exception {
        try {
            models.V_contrainte_style_materiel_reference contrainte = new models.V_contrainte_style_materiel_reference();
            List<models.V_contrainte_style_materiel_reference> list = contrainte
                    .GetAll(BuildWhereConstraint(quantite_outil), false, connection);
            if (list.size() == 0) {
                throw new Exception("On ne peut pas utiliser cette matériels séléctionner dans ce meuble.");
            }
            return true;
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            return false;
        }
    }

}
