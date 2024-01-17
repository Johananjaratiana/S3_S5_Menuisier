  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_filtre_produit_by_prix {
  	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "nom_produit")
	private String nom_produit;

	@J_Column(name = "nom_categorie")
	private String nom_categorie;

	@J_Column(name = "longueur")
	private Float longueur;

	@J_Column(name = "largeur")
	private Float largeur;

	@J_Column(name = "hauteur")
	private Float hauteur;

	@J_Column(name = "sum")
	private Float sum;

	@J_Column(name = "nom_style")
	private String nom_style;

	@J_Column(name = "nom_volume")
	private String nom_volume;


  	public Integer getId_reference() { return id_reference; }
	public String getNom_produit() { return nom_produit; }
	public String getNom_categorie() { return nom_categorie; }
	public Float getLongueur() { return longueur; }
	public Float getLargeur() { return largeur; }
	public Float getHauteur() { return hauteur; }
	public Float getSum() { return sum; }
	public String getNom_style() { return nom_style; }
	public String getNom_volume() { return nom_volume; }

	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setNom_produit(String nom_produit) { this.nom_produit = nom_produit; }
	public void setNom_categorie(String nom_categorie) { this.nom_categorie = nom_categorie; }
	public void setLongueur(Float longueur) { this.longueur = longueur; }
	public void setLargeur(Float largeur) { this.largeur = largeur; }
	public void setHauteur(Float hauteur) { this.hauteur = hauteur; }
	public void setSum(Float sum) { this.sum = sum; }
	public void setNom_style(String nom_style) { this.nom_style = nom_style; }
	public void setNom_volume(String nom_volume) { this.nom_volume = nom_volume; }

      public List<V_filtre_produit_by_prix> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_filtre_produit_by_prix> objectDao = new Johan_DaoSQL<V_filtre_produit_by_prix>(V_filtre_produit_by_prix.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
