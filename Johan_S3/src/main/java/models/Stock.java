package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Stock {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "nombre")
	private Float nombre;

	@J_Column(name = "date_")
	private Object date_;

	@J_Column(name = "id_commande")
	private Integer id_commande;



  	public Integer getId() { return id; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getNombre() { return nombre; }
	public Object getDate_() { return date_; }
	public Integer getId_commande() { return id_commande; }

	public void setId(Integer id) { this.id = id; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setNombre(Float nombre) { this.nombre = nombre; }
	public void setDate_(Object date_) { this.date_ = date_; }
	public void setId_commande(Integer id_commande) { this.id_commande = id_commande; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock> objectDao = new Johan_DaoSQL<Stock>(Stock.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock> objectDao = new Johan_DaoSQL<Stock>(Stock.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock> objectDao = new Johan_DaoSQL<Stock>(Stock.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Stock GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock> objectDao = new Johan_DaoSQL<Stock>(Stock.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Stock> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock> objectDao = new Johan_DaoSQL<Stock>(Stock.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
