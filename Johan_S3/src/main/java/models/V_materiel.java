  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_materiel {
  	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "nom_materiel")
	private String nom_materiel;

	@J_Column(name = "id_unite")
	private Integer id_unite;

	@J_Column(name = "nom_unite")
	private String nom_unite;


  	public Integer getId_materiel() { return id_materiel; }
	public String getNom_materiel() { return nom_materiel; }
	public Integer getId_unite() { return id_unite; }
	public String getNom_unite() { return nom_unite; }

	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setNom_materiel(String nom_materiel) { this.nom_materiel = nom_materiel; }
	public void setId_unite(Integer id_unite) { this.id_unite = id_unite; }
	public void setNom_unite(String nom_unite) { this.nom_unite = nom_unite; }

      public List<V_materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_materiel> objectDao = new Johan_DaoSQL<V_materiel>(V_materiel.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
