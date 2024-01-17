  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_full_stock {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "sum")
	private Float sum;


  	public Integer getId() { return id; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getSum() { return sum; }

	public void setId(Integer id) { this.id = id; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setSum(Float sum) { this.sum = sum; }

      public List<V_full_stock> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_full_stock> objectDao = new Johan_DaoSQL<V_full_stock>(V_full_stock.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
