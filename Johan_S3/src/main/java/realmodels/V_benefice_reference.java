package realmodels;

import java.sql.Connection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import johan.dao.annotation.J_Column;

public class V_benefice_reference extends models.V_benefice_reference {

	@J_Column(name = "min")
    Double min;

	@J_Column(name = "max")
    Double max;

    
    public V_benefice_reference(){}

    public String buildWhereRequest(){
        return " WHERE benefice >= " + this.getMin() + " AND benefice <= " + this.getMax(); 
    }
    public void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{

            if(this.getMin() == null || this.getMax() == null){
                request.setAttribute("filtre_prix_benefice_references", new ArrayList<realmodels.V_filtre_produit_by_prix>());
                return;
            }

            V_benefice_reference vqo = new V_benefice_reference();

            System.out.println(this.buildWhereRequest());

            List<models.V_benefice_reference> filtre_prix_benefice_references = vqo.GetAll(this.buildWhereRequest(), false, connection);

            request.setAttribute("filtre_prix_benefice_references", filtre_prix_benefice_references);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
    
}
