/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realmodels;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

/**
 *
 * @author tsaramirana
 */

public class Util {

    public static void writeFile(String filePath, String content){
        try {
            File file = new File(filePath);
            if(file.exists()){
                return;
            }
            FileWriter fileWriter = new FileWriter(filePath);
            try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
                writer.write(content);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static String readFile(String filePath){
        String result = new String();
        try {
            FileReader fileReader = new FileReader(filePath);
            StringBuilder content;
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                content = new StringBuilder();
                String line = reader.readLine();
                while(line!=null){
                    content.append(line).append("\n");
                    line = reader.readLine();
                }
            }
            result = content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static Object constructObject(Class concerned, Class[] parameters, Object[] paramValue){
        Object ans = null;
        try{
            Constructor con = concerned.getDeclaredConstructor(parameters);
            ans = con.newInstance(paramValue);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ans;
    }
    
    public static Object get_method(Object principal,Field concerned) throws Exception {
        String field_name = capitalize(concerned.getName());
        Class field_class = concerned.getType();

        Class[] arguments = new Class[0];

        String funcName = "get" + field_name;

        Method get_meth = principal.getClass().getMethod(funcName, arguments);

        Object invocation = get_meth.invoke(principal, new Object[0]);
        return invocation;
    }

    public static void set_method(Object principal,Field concerned, Object value) {
        //generalized set method invocation
        String field_name=capitalize(concerned.getName());

        String funcName="set"+field_name;
        try{
            Method set_meth=principal.getClass().getMethod(funcName, new Class[]{Class.forName("java.lang.Object")});
            Object invocation=set_meth.invoke(principal, value);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String decapitalize(String str){
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String capitalize(String str){
        //Capitalizing the first letter: for the set method
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
