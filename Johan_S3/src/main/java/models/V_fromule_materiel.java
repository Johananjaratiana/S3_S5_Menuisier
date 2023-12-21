  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_fromule_materiel {
  	@J_Column(name = "id_produit")
	private Integer id_produit;

	@J_Column(name = "nom_produit")
	private String nom_produit;

	@J_Column(name = "id_volume")
	private Integer id_volume;

	@J_Column(name = "nom_volume")
	private String nom_volume;

	@J_Column(name = "longueur")
	private Float longueur;

	@J_Column(name = "largeur")
	private Float largeur;

	@J_Column(name = "hauteur")
	private Float hauteur;

	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "nom_materiel")
	private String nom_materiel;

	@J_Column(name = "quantite")
	private Float quantite;


  	public Integer getId_produit() { return id_produit; }
	public String getNom_produit() { return nom_produit; }
	public Integer getId_volume() { return id_volume; }
	public String getNom_volume() { return nom_volume; }
	public Float getLongueur() { return longueur; }
	public Float getLargeur() { return largeur; }
	public Float getHauteur() { return hauteur; }
	public Integer getId_reference() { return id_reference; }
	public Integer getId_materiel() { return id_materiel; }
	public String getNom_materiel() { return nom_materiel; }
	public Float getQuantite() { return quantite; }

	public void setId_produit(Integer id_produit) { this.id_produit = id_produit; }
	public void setNom_produit(String nom_produit) { this.nom_produit = nom_produit; }
	public void setId_volume(Integer id_volume) { this.id_volume = id_volume; }
	public void setNom_volume(String nom_volume) { this.nom_volume = nom_volume; }
	public void setLongueur(Float longueur) { this.longueur = longueur; }
	public void setLargeur(Float largeur) { this.largeur = largeur; }
	public void setHauteur(Float hauteur) { this.hauteur = hauteur; }
	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setNom_materiel(String nom_materiel) { this.nom_materiel = nom_materiel; }
	public void setQuantite(Float quantite) { this.quantite = quantite; }

      public List<V_fromule_materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_fromule_materiel> objectDao = new Johan_DaoSQL<V_fromule_materiel>(V_fromule_materiel.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
