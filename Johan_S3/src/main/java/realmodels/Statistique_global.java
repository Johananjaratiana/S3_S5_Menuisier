package realmodels;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Statistique_global {

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request)throws Exception
    {
        try{
            models.V_benefice_meuble bm1 = new models.V_benefice_meuble();
            List<models.V_benefice_meuble> rentables = bm1.GetAll(" WHERE benefice >= 0 ", false, connection);
            List<models.V_benefice_meuble> non_rentables = bm1.GetAll(" WHERE benefice < 0 ", false, connection);
            InverseBenefice(non_rentables);
            request.setAttribute("rentables", rentables);
            request.setAttribute("non_rentables", non_rentables);

            models.V_stock_meuble_restante smr = new models.V_stock_meuble_restante();
            List<models.V_stock_meuble_restante> stock_meuble_restantes = smr.GetAll("", false, connection);
            request.setAttribute("stock_meuble_restantes", stock_meuble_restantes);


            models.V_statistiques_nb_vente_par_style_par_mois_current_year nbvpspm = new models.V_statistiques_nb_vente_par_style_par_mois_current_year();
            List<models.V_statistiques_nb_vente_par_style_par_mois_current_year> statistiques_nb_vente_par_style_par_mois_current_years = nbvpspm.GetAll(" ORDER BY month ASC, id_style ASC ", false, connection);
            request.setAttribute("statistiques_nb_vente_par_style_par_mois_current_years", statistiques_nb_vente_par_style_par_mois_current_years);

        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("error", ex.getMessage());
        }
    }

    public static void InverseBenefice(List<models.V_benefice_meuble> benefice_meubles){
        for (models.V_benefice_meuble benefice_meuble : benefice_meubles) {
            benefice_meuble.setBenefice(-1 * benefice_meuble.getBenefice());
        }
    }

    // ------------------------------ BENEFICE MEUBLE
    public static ArrayList<String> Build_X_label_benefice_meuble(List<models.V_benefice_meuble> benefice_meubles){
        ArrayList<String> x_Values = new ArrayList<String>();
            // add("Italy");
        for (models.V_benefice_meuble benefice_meuble : benefice_meubles) {
            x_Values.add("\""+ V_benefice_meuble.GetFullMeubleName(benefice_meuble) +" \"");
        }
        return x_Values;
    }
    public static ArrayList<Float> Build_Y_label_benefice_meuble(List<models.V_benefice_meuble> benefice_meubles){
        ArrayList<Float> y_Values = new ArrayList<Float>();
            // add("Italy");
        for (models.V_benefice_meuble benefice_meuble : benefice_meubles) {
            y_Values.add(benefice_meuble.getBenefice());
        }
        return y_Values;
    }

    // ----------------------------------- STOCK MEUBLE RESTANTE
    public static ArrayList<String> Build_X_label_stock_meuble_restante(List<models.V_stock_meuble_restante> stock_meuble_restantes){
        ArrayList<String> x_Values = new ArrayList<String>();
            // add("Italy");
        for (models.V_stock_meuble_restante stock_meuble_restante : stock_meuble_restantes) {
            x_Values.add("\""+ V_stock_meuble_restante.GetFullMeubleName(stock_meuble_restante) +" \"");
        }
        return x_Values;
    }
    public static ArrayList<Integer> Build_Y_label_stock_meuble_restante(List<models.V_stock_meuble_restante> stock_meuble_restantes){
        ArrayList<Integer> y_Values = new ArrayList<Integer>();
            // add("Italy");
        for (models.V_stock_meuble_restante stock_meuble_restante : stock_meuble_restantes) {
            y_Values.add(stock_meuble_restante.getQuantite());
        }
        return y_Values;
    }

    // ----------------------------------- NB VENTE PAR STYLE PAR MOIS DE L ANNEE ACTUEL
    public static ArrayList<String> Build_X_label_statistiques_nb_vente_par_style_par_mois_current_year(List<models.V_statistiques_nb_vente_par_style_par_mois_current_year> statistiques_nb_vente_par_style_par_mois_current_years){
        ArrayList<String> x_Values = new ArrayList<String>();
            // add("Italy");
        for (models.V_statistiques_nb_vente_par_style_par_mois_current_year statistiques_nb_vente_par_style_par_mois_current_year : statistiques_nb_vente_par_style_par_mois_current_years) {
            x_Values.add("\""+ statistiques_nb_vente_par_style_par_mois_current_year.getNom_style() +" \"");
        }
        return x_Values;
    }
    public static ArrayList<Integer> Build_Y_label_statistiques_nb_vente_par_style_par_mois_current_year(List<models.V_statistiques_nb_vente_par_style_par_mois_current_year> statistiques_nb_vente_par_style_par_mois_current_years){
        ArrayList<Integer> y_Values = new ArrayList<Integer>();
            // add("Italy");
        for (models.V_statistiques_nb_vente_par_style_par_mois_current_year statistiques_nb_vente_par_style_par_mois_current_year : statistiques_nb_vente_par_style_par_mois_current_years) {
            y_Values.add(statistiques_nb_vente_par_style_par_mois_current_year.getNb_vente());
        }
        return y_Values;
    }
    
}
