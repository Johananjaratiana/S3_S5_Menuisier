/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import services.DatabaseConnection;
import java.util.Vector;
import java.util.Collections;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Vector;
import services.DatabaseConnection;
//import com.google.gson.Gson;

/**
 *
 * @author tsaramirana
 */

public class Table 
{
    
    public Table(){
        
    }
    public Table(ResultSet rs){
        this.construct(rs);
    }
    
    public static String stringify_list(Vector<Table>list){
        String ans = "[";
        for(Table tab : list){
            ans+=stringify(tab);
        }
        ans+="]";
        return ans;
    }
    public static String stringify(Table tab){
        String ans = "{";
        Field[] fields = tab.getClass().getDeclaredFields();
        for (Field field : fields) {
            ans += "\t" + field.getName() + ":";
            try {
                ans += Util.get_method(tab, field) + ",\n";
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        ans+="}\n";
        return ans;
    }
    public static void getMainContent(Class classe){
        try {
            String mainContent = generateMainFile(classe);
            String fileName = "/home/hp/Bureau/Johan_S3/Johan_S3/src/main/webapp/";
            fileName+= Util.decapitalize(classe.getSimpleName())+".jsp";
            Util.writeFile(fileName, mainContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateMainFile(Class concerned){
        String content = "";
        //head
        content+="<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n<!DOCTYPE html>\n<html lang=\"en\">\n";
        content+="<!-- Head -->\n<jsp:include page=\"templates/head.jsp\" />\n<!-- Head -->\n";
        //body
        content+="<body>\n<div class=\"container-scroller\">\n\t<!-- Modal -->\n\t<jsp:include page=\"templates/modal.jsp\" />\n\t<!-- Modal -->\n";
        //header
        content+="\t<!-- Header -->\n\t<jsp:include page=\"templates/header.jsp\" />\n\t<!-- Header -->\n";
        content+="\t<!-- Content -->\n\t<div class=\"container-fluid page-body-wrapper\">\n\t<div class=\"row row-offcanvas row-offcanvas-right\">\n";
        //sidebar
        content+="\t\t<!-- partial:partials/_sidebar -->\n\t\t<jsp:include page=\"templates/sidebar.jsp\" />\n\t\t<!-- partial -->\n";
        //content
        content+="\t\t<!-- Real-content -->\n\t\t"+"<jsp:include page=\"content/"+Util.decapitalize(concerned.getSimpleName())+".jsp\"/>\n\t\t<!-- Real-content -->\n";
        //footer
        content+="\t\t<!-- partial:partials/_footer -->\n\t\t<jsp:include page=\"templates/footer.jsp\" />\n\t\t<!-- partial -->\n\t</div>\n\t</div>\n\t<!-- Content -->\n</div>\n";
        //script
        content+="<!-- Script -->\n<jsp:include page=\"templates/script.jsp\" />\n<!-- Script -->\n</body>\n</html>\n";
        return content;
    }

    
//Generate a form
    public static String generate_Form_Canva(Class concerned, String[] select, String[] notInclude){
        String canva = "<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n";
        canva+="<div class=\"content-wrapper\">\n\t<form class=\"form-horizontal\" action=\"/Johan_S3/Controller\" method=\"post\">";
        canva+="\n\t\t<input type=\"hidden\" name=\"action\" value=\""+Util.decapitalize(concerned.getSimpleName())+"_insert"+"\">";
        Field[] classFields = concerned.getDeclaredFields();
        for (Field field : classFields) {
            if(!isInside(notInclude, field.getName())){
                canva+="\n\t\t<div class=\"form-group\">";
                canva+="\n\t\t\t<label for=\"inputEmail3\" class=\"col-sm-2 control-label\">"+field.getName()+"</label>\n\t\t\t<div class=\"col-sm-10\">";

                if(!isInside(select, field.getName())) canva+="\n\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\""+field.getName()+"\" name=\""+field.getName()+"\">";

                else canva+="\n\t\t\t<select class= \"form-control\" name=\""+field.getName()+"\">\n\t\t\t</select>";
                canva+="\n\t\t\t</div>\n\t\t</div>";
            }
        }
        canva+="\n\t\t<button type=\"submit\" class=\"btn btn-default\">Submit</button>";
        canva+="\n\t</form>\n</div>";
        String fileName="/home/hp/Bureau/Johan_S3/Johan_S3/src/main/webapp/content/"+Util.decapitalize(concerned.getSimpleName())+".jsp";
        Util.writeFile(fileName, canva);
        return canva;
    }
    
    private static boolean isInside(Object[] list, Object element){
        for (Object object : list) {
            if(element.equals(object)) return true;
        }
        return false;
    }

    public static void insert(Table table){
        Field[] fields = table.getClass().getDeclaredFields();
        String query = "INSERT INTO "+table.getClass().getSimpleName()+"(";
        for (int i = 1; i < fields.length; i++) {
            query+=fields[i].getName();
            if (i!=fields.length-1){
                query+=",";
            }
        }
        query+=") "+"VALUES(";
        for (int i = 1; i < fields.length; i++) {
            query+="?";
            if (i!=fields.length-1) {
                query+=",";
            }
        }
        query+=")"; 
        System.out.println("query: "+ query);
        try {
            Connection conn = DatabaseConnection.GetConnection();
            PreparedStatement stmt=conn.prepareStatement(query);
            for(int i=1; i<fields.length; i++){
                //System.out.println(i+2);
                stmt.setObject(i, Util.get_method(table, fields[i]));
            }  
            int update=stmt.executeUpdate();
            DatabaseConnection.closeConnection(conn);  
            System.out.println("a row has been updated successfully"); 
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    
    public static Vector<Table> fetch(String table, String condition){
   //fetching datas from a database
        Vector<Table> list = new Vector<Table>();
        try{
            String query = "SELECT* FROM "+table;
            if(condition!=null) query+=" "+condition;
            System.out.println(query);

            Connection con = DatabaseConnection.GetConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                //constructing the object with the resultset
                Object element = Util.constructObject(Class.forName("models."+table),
                new Class[]{Class.forName("java.sql.ResultSet")}, new Object[]{rs});

                //adding it to the list
                list.add((Table)element);
            }
            System.out.println("Vector content:");
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i).getClass());
            }
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     *
     * @param request
     *
     */
    public void formConstruct(HttpServletRequest request){
        try{
            Enumeration<String> attributeNames = request.getAttributeNames();
                while (attributeNames.hasMoreElements()) {
                    String attributeName = attributeNames.nextElement();
                    Object attributeValue = request.getAttribute(attributeName);
                    Util.set_method(this, this.getClass().getField(attributeName), attributeValue);
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void construct(ResultSet rs){
        //Constructor dedicated for datas fetching from database(generalized)
        try{
            Field[] attributs=this.getClass().getDeclaredFields();
            int champs=attributs.length;

            for (int i=0; i<champs; i++){
                //getting the resultset values
                Object value=rs.getObject(i+1);
                Util.set_method(this, attributs[i], value);
            }
        }
        catch(SecurityException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

