  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_stock_restante {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "sum")
	private Float sum;

	@J_Column(name = "nom_materiel")
	private String nom_materiel;


  	public Integer getId() { return id; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getSum() { return sum; }
	public String getNom_materiel() { return nom_materiel; }

	public void setId(Integer id) { this.id = id; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setSum(Float sum) { this.sum = sum; }
	public void setNom_materiel(String nom_materiel) { this.nom_materiel = nom_materiel; }

      public List<V_stock_restante> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_stock_restante> objectDao = new Johan_DaoSQL<V_stock_restante>(V_stock_restante.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
