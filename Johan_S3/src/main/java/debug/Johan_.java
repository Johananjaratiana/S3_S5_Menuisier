package debug;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;

public class Johan_ {

    public static void setMethod(Object principal, Field concerned, Object value) throws Exception {
        // Generalized set method invocation
        String fieldName = capitalize(concerned.getName());

        String funcName = "set" + fieldName;
        try {
            Method setMethod = principal.getClass().getMethod(funcName, concerned.getType());
            setMethod.invoke(principal, value);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static <T> T constructByFormView(Class<T> clazz, HttpServletRequest request) throws Exception {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getSuperclass().getDeclaredFields();
            for (Field field : fields) {
                String parameterName = field.getName();
                String parameterValue = request.getParameter(parameterName);
                setMethod(obj, field, parameterValue);
            }
            return obj;
        } catch (Exception e) {
            
            throw new Exception(e.getMessage());
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}