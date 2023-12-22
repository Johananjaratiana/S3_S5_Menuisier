  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_produit {
  	@J_Column(name = "id_produit")
	private Integer id_produit;

	@J_Column(name = "nom_produit")
	private String nom_produit;

	@J_Column(name = "id_categorie")
	private Integer id_categorie;

	@J_Column(name = "nom_categorie")
	private String nom_categorie;


  	public Integer getId_produit() { return id_produit; }
	public String getNom_produit() { return nom_produit; }
	public Integer getId_categorie() { return id_categorie; }
	public String getNom_categorie() { return nom_categorie; }

	public void setId_produit(Integer id_produit) { this.id_produit = id_produit; }
	public void setNom_produit(String nom_produit) { this.nom_produit = nom_produit; }
	public void setId_categorie(Integer id_categorie) { this.id_categorie = id_categorie; }
	public void setNom_categorie(String nom_categorie) { this.nom_categorie = nom_categorie; }

      public List<V_produit> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_produit> objectDao = new Johan_DaoSQL<V_produit>(V_produit.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
