package net.noyark.util.jar;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JarFileClassLoader extends URLClassLoader {

    public JarFileClassLoader(File file) throws MalformedURLException {
        super(new URL[]{file.toURI().toURL()},JarSearcherUtil.getClassLoader());
    }

}
