  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_taux_salaire_employee {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "prenom")
	private String prenom;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "date_naissance")
	private java.sql.Date date_naissance;

	@J_Column(name = "nom_type")
	private String nom_type;

	@J_Column(name = "taux_horaire_type")
	private Float taux_horaire_type;

	@J_Column(name = "date_embauche")
	private java.sql.Date date_embauche;

	@J_Column(name = "anciennete")
	private Object anciennete;

	@J_Column(name = "x_fois_taux_salaire")
	private Float x_fois_taux_salaire;

	@J_Column(name = "nom_grade")
	private String nom_grade;


  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public Integer getStatus() { return status; }
	public java.sql.Date getDate_naissance() { return date_naissance; }
	public String getNom_type() { return nom_type; }
	public Float getTaux_horaire_type() { return taux_horaire_type; }
	public java.sql.Date getDate_embauche() { return date_embauche; }
	public Object getAnciennete() { return anciennete; }
	public Float getX_fois_taux_salaire() { return x_fois_taux_salaire; }
	public String getNom_grade() { return nom_grade; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setStatus(Integer status) { this.status = status; }
	public void setDate_naissance(java.sql.Date date_naissance) { this.date_naissance = date_naissance; }
	public void setNom_type(String nom_type) { this.nom_type = nom_type; }
	public void setTaux_horaire_type(Float taux_horaire_type) { this.taux_horaire_type = taux_horaire_type; }
	public void setDate_embauche(java.sql.Date date_embauche) { this.date_embauche = date_embauche; }
	public void setAnciennete(Object anciennete) { this.anciennete = anciennete; }
	public void setX_fois_taux_salaire(Float x_fois_taux_salaire) { this.x_fois_taux_salaire = x_fois_taux_salaire; }
	public void setNom_grade(String nom_grade) { this.nom_grade = nom_grade; }

      public List<V_taux_salaire_employee> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_taux_salaire_employee> objectDao = new Johan_DaoSQL<V_taux_salaire_employee>(V_taux_salaire_employee.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
