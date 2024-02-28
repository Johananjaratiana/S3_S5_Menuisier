  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_check_left_by_quantite_outils {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "quantite")
	private Float quantite;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "reste")
	private Float reste;

	@J_Column(name = "nom_materiel")
	private String nom_materiel;


  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getQuantite() { return quantite; }
	public Integer getStatus() { return status; }
	public Float getReste() { return reste; }
	public String getNom_materiel() { return nom_materiel; }

	public void setId(Integer id) { this.id = id; }
	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setQuantite(Float quantite) { this.quantite = quantite; }
	public void setStatus(Integer status) { this.status = status; }
	public void setReste(Float reste) { this.reste = reste; }
	public void setNom_materiel(String nom_materiel) { this.nom_materiel = nom_materiel; }

      public List<V_check_left_by_quantite_outils> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_check_left_by_quantite_outils> objectDao = new Johan_DaoSQL<V_check_left_by_quantite_outils>(V_check_left_by_quantite_outils.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
