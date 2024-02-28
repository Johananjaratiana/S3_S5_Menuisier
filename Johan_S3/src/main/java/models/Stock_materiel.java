package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Stock_materiel {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "nombre")
	private Float nombre;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;

	@J_Column(name = "id_fabrication")
	private Integer id_fabrication;



  	public Integer getId() { return id; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getNombre() { return nombre; }
	public java.sql.Timestamp getDate_() { return date_; }
	public Integer getId_fabrication() { return id_fabrication; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_materiel(Integer id_materiel) throws Exception { this.id_materiel = id_materiel; }
	public void setNombre(Float nombre) throws Exception { this.nombre = nombre; }
	public void setDate_(java.sql.Timestamp date_) throws Exception { this.date_ = date_; }
	public void setId_fabrication(Integer id_fabrication) throws Exception { this.id_fabrication = id_fabrication; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_materiel> objectDao = new Johan_DaoSQL<Stock_materiel>(Stock_materiel.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_materiel> objectDao = new Johan_DaoSQL<Stock_materiel>(Stock_materiel.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_materiel> objectDao = new Johan_DaoSQL<Stock_materiel>(Stock_materiel.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Stock_materiel GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_materiel> objectDao = new Johan_DaoSQL<Stock_materiel>(Stock_materiel.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Stock_materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_materiel> objectDao = new Johan_DaoSQL<Stock_materiel>(Stock_materiel.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
