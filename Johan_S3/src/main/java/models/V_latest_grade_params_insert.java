  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_latest_grade_params_insert {
  	@J_Column(name = "id_grade")
	private Integer id_grade;

	@J_Column(name = "max_date")
	private java.sql.Timestamp max_date;


  	public Integer getId_grade() { return id_grade; }
	public java.sql.Timestamp getMax_date() { return max_date; }

	public void setId_grade(Integer id_grade) { this.id_grade = id_grade; }
	public void setMax_date(java.sql.Timestamp max_date) { this.max_date = max_date; }

      public List<V_latest_grade_params_insert> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_latest_grade_params_insert> objectDao = new Johan_DaoSQL<V_latest_grade_params_insert>(V_latest_grade_params_insert.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
