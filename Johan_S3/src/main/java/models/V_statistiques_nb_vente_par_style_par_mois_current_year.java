  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_statistiques_nb_vente_par_style_par_mois_current_year {
  	@J_Column(name = "month")
	private Integer month;

	@J_Column(name = "id_style")
	private Integer id_style;

	@J_Column(name = "nom_style")
	private String nom_style;

	@J_Column(name = "status_style")
	private Integer status_style;

	@J_Column(name = "nb_vente")
	private Integer nb_vente;


  	public Integer getMonth() { return month; }
	public Integer getId_style() { return id_style; }
	public String getNom_style() { return nom_style; }
	public Integer getStatus_style() { return status_style; }
	public Integer getNb_vente() { return nb_vente; }

	public void setMonth(Integer month) { this.month = month; }
	public void setId_style(Integer id_style) { this.id_style = id_style; }
	public void setNom_style(String nom_style) { this.nom_style = nom_style; }
	public void setStatus_style(Integer status_style) { this.status_style = status_style; }
	public void setNb_vente(Integer nb_vente) { this.nb_vente = nb_vente; }

      public List<V_statistiques_nb_vente_par_style_par_mois_current_year> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_statistiques_nb_vente_par_style_par_mois_current_year> objectDao = new Johan_DaoSQL<V_statistiques_nb_vente_par_style_par_mois_current_year>(V_statistiques_nb_vente_par_style_par_mois_current_year.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
