  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_reference {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_categorie")
	private Integer id_categorie;

	@J_Column(name = "id_style")
	private Integer id_style;

	@J_Column(name = "id_volume")
	private Integer id_volume;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "id_produit")
	private Integer id_produit;

	@J_Column(name = "nom_produit")
	private String nom_produit;

	@J_Column(name = "nom_categorie")
	private String nom_categorie;

	@J_Column(name = "nom_style")
	private String nom_style;

	@J_Column(name = "nom_volume")
	private String nom_volume;

	@J_Column(name = "longueur")
	private Float longueur;

	@J_Column(name = "largeur")
	private Float largeur;

	@J_Column(name = "hauteur")
	private Float hauteur;


  	public Integer getId() { return id; }
	public Integer getId_categorie() { return id_categorie; }
	public Integer getId_style() { return id_style; }
	public Integer getId_volume() { return id_volume; }
	public Integer getStatus() { return status; }
	public Integer getId_produit() { return id_produit; }
	public String getNom_produit() { return nom_produit; }
	public String getNom_categorie() { return nom_categorie; }
	public String getNom_style() { return nom_style; }
	public String getNom_volume() { return nom_volume; }
	public Float getLongueur() { return longueur; }
	public Float getLargeur() { return largeur; }
	public Float getHauteur() { return hauteur; }

	public void setId(Integer id) { this.id = id; }
	public void setId_categorie(Integer id_categorie) { this.id_categorie = id_categorie; }
	public void setId_style(Integer id_style) { this.id_style = id_style; }
	public void setId_volume(Integer id_volume) { this.id_volume = id_volume; }
	public void setStatus(Integer status) { this.status = status; }
	public void setId_produit(Integer id_produit) { this.id_produit = id_produit; }
	public void setNom_produit(String nom_produit) { this.nom_produit = nom_produit; }
	public void setNom_categorie(String nom_categorie) { this.nom_categorie = nom_categorie; }
	public void setNom_style(String nom_style) { this.nom_style = nom_style; }
	public void setNom_volume(String nom_volume) { this.nom_volume = nom_volume; }
	public void setLongueur(Float longueur) { this.longueur = longueur; }
	public void setLargeur(Float largeur) { this.largeur = largeur; }
	public void setHauteur(Float hauteur) { this.hauteur = hauteur; }

      public List<V_reference> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_reference> objectDao = new Johan_DaoSQL<V_reference>(V_reference.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
