package realmodels;

public class V_stock_meuble_restante {

    public static String GetFullMeubleName(models.V_stock_meuble_restante stock_meuble_restante) {
        return stock_meuble_restante.getNom_produit() + " " + stock_meuble_restante.getNom_style() + " " + stock_meuble_restante.getNom_volume();
    }
    
}
