package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Style_materiel {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_style")
	private Integer id_style;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public Integer getId_style() { return id_style; }
	public Integer getId_materiel() { return id_materiel; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) { this.id = id; }
	public void setId_style(Integer id_style) { this.id_style = id_style; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setStatus(Integer status) { this.status = status; }

    public void save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style_materiel> objectDao = new Johan_DaoSQL<Style_materiel>(Style_materiel.class);
    		objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style_materiel> objectDao = new Johan_DaoSQL<Style_materiel>(Style_materiel.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style_materiel> objectDao = new Johan_DaoSQL<Style_materiel>(Style_materiel.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Style_materiel GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style_materiel> objectDao = new Johan_DaoSQL<Style_materiel>(Style_materiel.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Style_materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style_materiel> objectDao = new Johan_DaoSQL<Style_materiel>(Style_materiel.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
