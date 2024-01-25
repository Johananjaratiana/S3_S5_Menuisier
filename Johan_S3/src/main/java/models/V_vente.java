  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_vente {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "id_client")
	private Integer id_client;

	@J_Column(name = "nb")
	private Integer nb;

	@J_Column(name = "date_")
	private java.sql.Date date_;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "nom_client")
	private String nom_client;

	@J_Column(name = "prenom_client")
	private String prenom_client;

	@J_Column(name = "email_client")
	private String email_client;

	@J_Column(name = "id_sexe")
	private Integer id_sexe;

	@J_Column(name = "nom_sexe")
	private String nom_sexe;

	@J_Column(name = "status_client")
	private Integer status_client;

	@J_Column(name = "dtn_client")
	private java.sql.Date dtn_client;

	@J_Column(name = "id_style_meuble")
	private Integer id_style_meuble;

	@J_Column(name = "id_volume_meuble")
	private Integer id_volume_meuble;

	@J_Column(name = "status_meuble")
	private Integer status_meuble;

	@J_Column(name = "id_produit_meuble")
	private Integer id_produit_meuble;

	@J_Column(name = "nom_style_meuble")
	private String nom_style_meuble;

	@J_Column(name = "longueur_meuble")
	private Float longueur_meuble;

	@J_Column(name = "largeur_meuble")
	private Float largeur_meuble;

	@J_Column(name = "hauteur_meuble")
	private Float hauteur_meuble;

	@J_Column(name = "nom_volume_meuble")
	private String nom_volume_meuble;

	@J_Column(name = "id_categorie_meuble")
	private Integer id_categorie_meuble;

	@J_Column(name = "nom_categorie_meuble")
	private String nom_categorie_meuble;

	@J_Column(name = "nom_produit_meuble")
	private String nom_produit_meuble;


  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getId_client() { return id_client; }
	public Integer getNb() { return nb; }
	public java.sql.Date getDate_() { return date_; }
	public Integer getStatus() { return status; }
	public String getNom_client() { return nom_client; }
	public String getPrenom_client() { return prenom_client; }
	public String getEmail_client() { return email_client; }
	public Integer getId_sexe() { return id_sexe; }
	public String getNom_sexe() { return nom_sexe; }
	public Integer getStatus_client() { return status_client; }
	public java.sql.Date getDtn_client() { return dtn_client; }
	public Integer getId_style_meuble() { return id_style_meuble; }
	public Integer getId_volume_meuble() { return id_volume_meuble; }
	public Integer getStatus_meuble() { return status_meuble; }
	public Integer getId_produit_meuble() { return id_produit_meuble; }
	public String getNom_style_meuble() { return nom_style_meuble; }
	public Float getLongueur_meuble() { return longueur_meuble; }
	public Float getLargeur_meuble() { return largeur_meuble; }
	public Float getHauteur_meuble() { return hauteur_meuble; }
	public String getNom_volume_meuble() { return nom_volume_meuble; }
	public Integer getId_categorie_meuble() { return id_categorie_meuble; }
	public String getNom_categorie_meuble() { return nom_categorie_meuble; }
	public String getNom_produit_meuble() { return nom_produit_meuble; }

	public void setId(Integer id) { this.id = id; }
	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setId_client(Integer id_client) { this.id_client = id_client; }
	public void setNb(Integer nb) { this.nb = nb; }
	public void setDate_(java.sql.Date date_) { this.date_ = date_; }
	public void setStatus(Integer status) { this.status = status; }
	public void setNom_client(String nom_client) { this.nom_client = nom_client; }
	public void setPrenom_client(String prenom_client) { this.prenom_client = prenom_client; }
	public void setEmail_client(String email_client) { this.email_client = email_client; }
	public void setId_sexe(Integer id_sexe) { this.id_sexe = id_sexe; }
	public void setNom_sexe(String nom_sexe) { this.nom_sexe = nom_sexe; }
	public void setStatus_client(Integer status_client) { this.status_client = status_client; }
	public void setDtn_client(java.sql.Date dtn_client) { this.dtn_client = dtn_client; }
	public void setId_style_meuble(Integer id_style_meuble) { this.id_style_meuble = id_style_meuble; }
	public void setId_volume_meuble(Integer id_volume_meuble) { this.id_volume_meuble = id_volume_meuble; }
	public void setStatus_meuble(Integer status_meuble) { this.status_meuble = status_meuble; }
	public void setId_produit_meuble(Integer id_produit_meuble) { this.id_produit_meuble = id_produit_meuble; }
	public void setNom_style_meuble(String nom_style_meuble) { this.nom_style_meuble = nom_style_meuble; }
	public void setLongueur_meuble(Float longueur_meuble) { this.longueur_meuble = longueur_meuble; }
	public void setLargeur_meuble(Float largeur_meuble) { this.largeur_meuble = largeur_meuble; }
	public void setHauteur_meuble(Float hauteur_meuble) { this.hauteur_meuble = hauteur_meuble; }
	public void setNom_volume_meuble(String nom_volume_meuble) { this.nom_volume_meuble = nom_volume_meuble; }
	public void setId_categorie_meuble(Integer id_categorie_meuble) { this.id_categorie_meuble = id_categorie_meuble; }
	public void setNom_categorie_meuble(String nom_categorie_meuble) { this.nom_categorie_meuble = nom_categorie_meuble; }
	public void setNom_produit_meuble(String nom_produit_meuble) { this.nom_produit_meuble = nom_produit_meuble; }

      public List<V_vente> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_vente> objectDao = new Johan_DaoSQL<V_vente>(V_vente.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
