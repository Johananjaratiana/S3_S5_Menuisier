  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_prix_meuble {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "prix_vente")
	private Float prix_vente;

	@J_Column(name = "date_")
	private java.sql.Time date_;

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
	public Integer getId_meuble() { return id_meuble; }
	public Float getPrix_vente() { return prix_vente; }
	public java.sql.Time getDate_() { return date_; }
	public String getNom_produit() { return nom_produit; }
	public String getNom_categorie() { return nom_categorie; }
	public String getNom_style() { return nom_style; }
	public String getNom_volume() { return nom_volume; }
	public Float getLongueur() { return longueur; }
	public Float getLargeur() { return largeur; }
	public Float getHauteur() { return hauteur; }

	public void setId(Integer id) { this.id = id; }
	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setPrix_vente(Float prix_vente) { this.prix_vente = prix_vente; }
	public void setDate_(java.sql.Time date_) { this.date_ = date_; }
	public void setNom_produit(String nom_produit) { this.nom_produit = nom_produit; }
	public void setNom_categorie(String nom_categorie) { this.nom_categorie = nom_categorie; }
	public void setNom_style(String nom_style) { this.nom_style = nom_style; }
	public void setNom_volume(String nom_volume) { this.nom_volume = nom_volume; }
	public void setLongueur(Float longueur) { this.longueur = longueur; }
	public void setLargeur(Float largeur) { this.largeur = largeur; }
	public void setHauteur(Float hauteur) { this.hauteur = hauteur; }

      public List<V_prix_meuble> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_prix_meuble> objectDao = new Johan_DaoSQL<V_prix_meuble>(V_prix_meuble.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
