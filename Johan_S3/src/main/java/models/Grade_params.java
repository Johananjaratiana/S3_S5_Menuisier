package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Grade_params {
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



  	public Integer getId() { return id; }
	public Integer getId_grade() { return id_grade; }
	public Integer getYears() { return years; }
	public Float getX_fois_taux_salaire() { return x_fois_taux_salaire; }
	public java.sql.Timestamp getDate_() { return date_; }

	public void setId(Integer id) { this.id = id; }
	public void setId_grade(Integer id_grade) { this.id_grade = id_grade; }
	public void setYears(Integer years) { this.years = years; }
	public void setX_fois_taux_salaire(Float x_fois_taux_salaire) { this.x_fois_taux_salaire = x_fois_taux_salaire; }
	public void setDate_(java.sql.Timestamp date_) { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Grade_params> objectDao = new Johan_DaoSQL<Grade_params>(Grade_params.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Grade_params> objectDao = new Johan_DaoSQL<Grade_params>(Grade_params.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Grade_params> objectDao = new Johan_DaoSQL<Grade_params>(Grade_params.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Grade_params GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Grade_params> objectDao = new Johan_DaoSQL<Grade_params>(Grade_params.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Grade_params> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Grade_params> objectDao = new Johan_DaoSQL<Grade_params>(Grade_params.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
