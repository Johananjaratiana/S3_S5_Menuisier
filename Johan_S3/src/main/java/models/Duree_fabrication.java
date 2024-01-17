package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Duree_fabrication {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "id_type_employee")
	private Integer id_type_employee;

	@J_Column(name = "duree")
	private Integer duree;

	@J_Column(name = "date_")
	private Object date_;

	@J_Column(name = "nombre")
	private Integer nombre;



  	public Integer getId() { return id; }
	public Integer getId_reference() { return id_reference; }
	public Integer getId_type_employee() { return id_type_employee; }
	public Integer getDuree() { return duree; }
	public Object getDate_() { return date_; }
	public Integer getNombre() { return nombre; }

	public void setId(Integer id) { this.id = id; }
	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setId_type_employee(Integer id_type_employee) { this.id_type_employee = id_type_employee; }
	public void setDuree(Integer duree) { this.duree = duree; }
	public void setDate_(Object date_) { this.date_ = date_; }
	public void setNombre(Integer nombre) { this.nombre = nombre; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duree_fabrication> objectDao = new Johan_DaoSQL<Duree_fabrication>(Duree_fabrication.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duree_fabrication> objectDao = new Johan_DaoSQL<Duree_fabrication>(Duree_fabrication.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duree_fabrication> objectDao = new Johan_DaoSQL<Duree_fabrication>(Duree_fabrication.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Duree_fabrication GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duree_fabrication> objectDao = new Johan_DaoSQL<Duree_fabrication>(Duree_fabrication.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Duree_fabrication> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duree_fabrication> objectDao = new Johan_DaoSQL<Duree_fabrication>(Duree_fabrication.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}