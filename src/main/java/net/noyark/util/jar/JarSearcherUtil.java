/*
JavaReflectTools是一款简便的java反射辅助工具,简便一些关于反射开发操作
 */
package net.noyark.util.jar;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 对于jar包的工具
 */
public class JarSearcherUtil {

    public static JarObject getJar(File file, URLClassLoader classLoader) throws IOException {
        JarObject object = new JarObject();
        try {
            JarFile f = new JarFile(file);
            Enumeration<JarEntry> files = f.entries();
            while (files.hasMoreElements()) {
                JarEntry entry = files.nextElement();
                String name = getClassName(entry.getName());
                object.getClasses().put(name,classLoader.loadClass(name));
            }
            object.setFile(file);
            object.setFileName(file.getName());
            object.setJarFile(f);
            return object;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static JarObject getJar(File file) throws IOException{
        return getJar(file,new JarFileClassLoader(file));
    }

    private static String getClassName(String name){
        return name.substring(0, name.lastIndexOf(".")).replace("/", ".");
    }

    public static ClassLoader getClassLoader(){
        return JarSearcherUtil.class.getClassLoader();
    }

}
