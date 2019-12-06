package net.noyark.util.cls;

public class ClassUtil {

    /**
     * 获得一个类的最大父类(Object类下的最大)
     */
    public static Class<?> mostSuperClass(Class<?> clzz){
        while (true){
            Class<?> sub = clzz;
            clzz = clzz.getSuperclass();
            if(clzz.equals(Object.class))
                return sub;
        }
    }
}
