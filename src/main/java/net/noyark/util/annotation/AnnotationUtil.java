package net.noyark.util.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationUtil {

    public static boolean hasAnnotation(Class<?> clz, Annotation annotation){
        return clz.getAnnotation(annotation.getClass()) != null;
    }

    public <T extends Annotation> Map<Field,T> getFieldByAnnotation(Class<?> clz, Class<T> annotation, boolean declared){
        Map<Field,T> fieldsMap = new HashMap<Field, T>();
        Field[] fields = declared?clz.getDeclaredFields():clz.getFields();
        for(Field field:fields){
            T t = field.getAnnotation(annotation);
            if(t!=null){
                fieldsMap.put(field,t);
            }
        }
        return fieldsMap;
    }

    public <T extends Annotation> Map<Method,T> getMethodByAnnotation(Class<?> clz, Class<T> annotation, boolean declared){
        Map<Method,T> methodsMap = new HashMap<Method, T>();
        Method[] methods = declared?clz.getDeclaredMethods():clz.getMethods();
        for(Method method:methods){
            T t = method.getAnnotation(annotation);
            if(t!=null){
                methodsMap.put(method,t);
            }
        }
        return methodsMap;
    }

}
