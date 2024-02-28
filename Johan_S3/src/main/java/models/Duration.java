package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Duration {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "jour")
	private Integer jour;

	@J_Column(name = "heure")
	private Integer heure;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getJour() { return jour; }
	public Integer getHeure() { return heure; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_meuble(Integer id_meuble) throws Exception { this.id_meuble = id_meuble; }
	public void setJour(Integer jour) throws Exception { this.jour = jour; }
	public void setHeure(Integer heure) throws Exception { this.heure = heure; }
	public void setStatus(Integer status) throws Exception { this.status = status; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duration> objectDao = new Johan_DaoSQL<Duration>(Duration.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duration> objectDao = new Johan_DaoSQL<Duration>(Duration.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duration> objectDao = new Johan_DaoSQL<Duration>(Duration.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Duration GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duration> objectDao = new Johan_DaoSQL<Duration>(Duration.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Duration> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Duration> objectDao = new Johan_DaoSQL<Duration>(Duration.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
