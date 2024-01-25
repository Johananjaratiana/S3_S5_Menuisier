  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_duree_fabrication {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "id_type_employee")
	private Integer id_type_employee;

	@J_Column(name = "duree")
	private Integer duree;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;

	@J_Column(name = "nombre")
	private Integer nombre;

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

	@J_Column(name = "nom_type_employee")
	private String nom_type_employee;

	@J_Column(name = "taux_horaire")
	private Float taux_horaire;

	@J_Column(name = "date_type_employee")
	private java.sql.Timestamp date_type_employee;


  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getId_type_employee() { return id_type_employee; }
	public Integer getDuree() { return duree; }
	public java.sql.Timestamp getDate_() { return date_; }
	public Integer getNombre() { return nombre; }
	public String getNom_produit() { return nom_produit; }
	public String getNom_categorie() { return nom_categorie; }
	public String getNom_style() { return nom_style; }
	public String getNom_volume() { return nom_volume; }
	public Float getLongueur() { return longueur; }
	public Float getLargeur() { return largeur; }
	public Float getHauteur() { return hauteur; }
	public String getNom_type_employee() { return nom_type_employee; }
	public Float getTaux_horaire() { return taux_horaire; }
	public java.sql.Timestamp getDate_type_employee() { return date_type_employee; }

	public void setId(Integer id) { this.id = id; }
	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setId_type_employee(Integer id_type_employee) { this.id_type_employee = id_type_employee; }
	public void setDuree(Integer duree) { this.duree = duree; }
	public void setDate_(java.sql.Timestamp date_) { this.date_ = date_; }
	public void setNombre(Integer nombre) { this.nombre = nombre; }
	public void setNom_produit(String nom_produit) { this.nom_produit = nom_produit; }
	public void setNom_categorie(String nom_categorie) { this.nom_categorie = nom_categorie; }
	public void setNom_style(String nom_style) { this.nom_style = nom_style; }
	public void setNom_volume(String nom_volume) { this.nom_volume = nom_volume; }
	public void setLongueur(Float longueur) { this.longueur = longueur; }
	public void setLargeur(Float largeur) { this.largeur = largeur; }
	public void setHauteur(Float hauteur) { this.hauteur = hauteur; }
	public void setNom_type_employee(String nom_type_employee) { this.nom_type_employee = nom_type_employee; }
	public void setTaux_horaire(Float taux_horaire) { this.taux_horaire = taux_horaire; }
	public void setDate_type_employee(java.sql.Timestamp date_type_employee) { this.date_type_employee = date_type_employee; }

      public List<V_duree_fabrication> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_duree_fabrication> objectDao = new Johan_DaoSQL<V_duree_fabrication>(V_duree_fabrication.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
