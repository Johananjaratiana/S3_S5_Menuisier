  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_real_grade_params {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_grade")
	private Integer id_grade;

	@J_Column(name = "years")
	private Integer years;

	@J_Column(name = "x_fois_taux_salaire")
	private Float x_fois_taux_salaire;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;

	@J_Column(name = "nom_grade")
	private String nom_grade;

	@J_Column(name = "status_grade")
	private Integer status_grade;


  	public Integer getId() { return id; }
	public Integer getId_grade() { return id_grade; }
	public Integer getYears() { return years; }
	public Float getX_fois_taux_salaire() { return x_fois_taux_salaire; }
	public java.sql.Timestamp getDate_() { return date_; }
	public String getNom_grade() { return nom_grade; }
	public Integer getStatus_grade() { return status_grade; }

	public void setId(Integer id) { this.id = id; }
	public void setId_grade(Integer id_grade) { this.id_grade = id_grade; }
	public void setYears(Integer years) { this.years = years; }
	public void setX_fois_taux_salaire(Float x_fois_taux_salaire) { this.x_fois_taux_salaire = x_fois_taux_salaire; }
	public void setDate_(java.sql.Timestamp date_) { this.date_ = date_; }
	public void setNom_grade(String nom_grade) { this.nom_grade = nom_grade; }
	public void setStatus_grade(Integer status_grade) { this.status_grade = status_grade; }

      public List<V_real_grade_params> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_real_grade_params> objectDao = new Johan_DaoSQL<V_real_grade_params>(V_real_grade_params.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
