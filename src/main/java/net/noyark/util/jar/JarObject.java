package net.noyark.util.jar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;

/**
 * jar包对象
 */
public class JarObject {

    private File file;

    private String fileName;

    private Map<String,Class<?>> classes;


    private JarFile jarFile;



    public JarObject(File file, String fileName, Map<String, Class<?>> classes, JarFile jarFile) {
        this.file = file;
        this.fileName = fileName;
        this.classes = classes;
        this.jarFile = jarFile;
    }

    public JarObject() {
        classes = new HashMap<String, Class<?>>();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, Class<?>> getClasses() {
        return classes;
    }

    public void setClasses(Map<String, Class<?>> classes) {
        this.classes = classes;
    }

    public JarFile getJarFile() {
        return jarFile;
    }

    public void setJarFile(JarFile jarFile) {
        this.jarFile = jarFile;
    }
}
