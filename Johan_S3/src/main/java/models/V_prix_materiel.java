  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_prix_materiel {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "prix_unitaire")
	private Float prix_unitaire;

	@J_Column(name = "date_")
	private Object date_;

	@J_Column(name = "nom_materiel")
	private String nom_materiel;

	@J_Column(name = "status_materiel")
	private Integer status_materiel;


  	public Integer getId() { return id; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getPrix_unitaire() { return prix_unitaire; }
	public Object getDate_() { return date_; }
	public String getNom_materiel() { return nom_materiel; }
	public Integer getStatus_materiel() { return status_materiel; }

	public void setId(Integer id) { this.id = id; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setPrix_unitaire(Float prix_unitaire) { this.prix_unitaire = prix_unitaire; }
	public void setDate_(Object date_) { this.date_ = date_; }
	public void setNom_materiel(String nom_materiel) { this.nom_materiel = nom_materiel; }
	public void setStatus_materiel(Integer status_materiel) { this.status_materiel = status_materiel; }

      public List<V_prix_materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_prix_materiel> objectDao = new Johan_DaoSQL<V_prix_materiel>(V_prix_materiel.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
