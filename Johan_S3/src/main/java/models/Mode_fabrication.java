package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Mode_fabrication {
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



  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getId_type_employee() { return id_type_employee; }
	public Integer getDuree() { return duree; }
	public java.sql.Timestamp getDate_() { return date_; }
	public Integer getNombre() { return nombre; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_meuble(Integer id_meuble) throws Exception { this.id_meuble = id_meuble; }
	public void setId_type_employee(Integer id_type_employee) throws Exception { this.id_type_employee = id_type_employee; }
	public void setDuree(Integer duree) throws Exception { this.duree = duree; }
	public void setDate_(java.sql.Timestamp date_) throws Exception { this.date_ = date_; }
	public void setNombre(Integer nombre) throws Exception { this.nombre = nombre; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Mode_fabrication> objectDao = new Johan_DaoSQL<Mode_fabrication>(Mode_fabrication.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Mode_fabrication> objectDao = new Johan_DaoSQL<Mode_fabrication>(Mode_fabrication.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Mode_fabrication> objectDao = new Johan_DaoSQL<Mode_fabrication>(Mode_fabrication.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Mode_fabrication GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Mode_fabrication> objectDao = new Johan_DaoSQL<Mode_fabrication>(Mode_fabrication.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Mode_fabrication> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Mode_fabrication> objectDao = new Johan_DaoSQL<Mode_fabrication>(Mode_fabrication.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
