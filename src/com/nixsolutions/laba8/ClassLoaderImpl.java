package com.nixsolutions.laba8;

import interfaces.task8.PathClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.io.DataInputStream;

public class ClassLoaderImpl extends ClassLoader implements PathClassLoader {
    private String path;

    public ClassLoaderImpl() {
    }

    @Override public String getPath() {
        return path == null ? "" : path;
    }

    @Override public void setPath(String dir) {
        Objects.requireNonNull(dir);
        path = dir;
    }

    @Override public Class<?> loadClass(String name)
            throws ClassNotFoundException {
        if (!name.startsWith("java")) {

            String fullClassName =
                    name.replace('.', File.separatorChar) + ".class";
            try (InputStream stream = new FileInputStream(
                    path + "/" + fullClassName)) {
                byte[] buff = new byte[stream.available()];
                DataInputStream in = new DataInputStream(stream);
                in.readFully(buff);

                Class c = defineClass(name, buff, 0, buff.length);
                resolveClass(c);
                return c;
            } catch (NullPointerException | IOException e) {
                throw new ClassNotFoundException();
            }
        }
        return super.loadClass(name);
    }
}