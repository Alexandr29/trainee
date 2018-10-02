package com.nixsolutions.laba6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import interfaces.task6.IOUtils;

public class IOUtilsImpl implements IOUtils {
    public IOUtilsImpl() {
    }

    @Override public void copyFile(String source, String dest) {
        InputStream input;
        try {
            input = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        OutputStream output;
        try {
            output = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                input.close();
            } catch (IOException e1) {
                throw new IllegalArgumentException(e1);
            }
            throw new IllegalArgumentException(e);
        }
        int b;
        try {
            while ((b = input.read()) != -1) {
                output.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override public void copyFileBest(String source, String dest) {

        try (FileChannel sourceChannel = new FileInputStream(source)
                .getChannel();
                FileChannel destChannel = new FileOutputStream(dest)
                        .getChannel()) {
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void copyFileBuffered(File source, File dest) {

        //String destName = dest.getAbsolutePath();

        // if (!destName.matches(".*[.]{1}.*")) {
        // throw new IllegalArgumentException();
        // }

        InputStream input;

        try {
            input = new BufferedInputStream(new FileInputStream(source));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        OutputStream output;

        try {
            output = new BufferedOutputStream(new FileOutputStream(dest));
        } catch (FileNotFoundException e) {

            // try {
            // dest.createNewFile();
            // } catch (IOException e1) {
            // throw new IllegalArgumentException(e1);
            // } finally {
            try {
                input.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // }
            throw new IllegalArgumentException(e);
        }

        int b;

        try {
            while ((b = input.read()) != -1) {
                output.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override public String[] findFiles(String folderName) {

        File folder = new File(folderName);
        if (!folder.exists()) {
            throw new IllegalArgumentException();
        }

        List<String> foundFiles = new ArrayList<>();
        Queue<File> folders = new LinkedList<>();

        folders.add(folder);

        while (!folders.isEmpty()) {

            File currentFolder = folders.remove();
            File[] currentFiles = currentFolder.listFiles();

            if (currentFiles != null) {
                for (File f : currentFiles) {
                    if (f.isDirectory()) {
                        folders.add(f);
                    } else if (f.isFile()) {
                        foundFiles.add(f.getAbsolutePath());
                    } else {
                        throw new RuntimeException("It isn't file or folder");
                    }
                }
            }
        }

        return foundFiles.toArray(new String[foundFiles.size()]);
    }

    @Override public String[] findFiles(String folderName,
            String extension) {

        if (extension == null) {
            return findFiles(folderName);
        }

        File folder = new File(folderName);
        if (!folder.exists()) {
            throw new IllegalArgumentException();
        }

        List<String> foundFiles = new ArrayList<>();
        Queue<File> folders = new LinkedList<>();

        folders.add(folder);

        while (!folders.isEmpty()) {

            File currentFolder = folders.remove();
            File[] currentFiles = currentFolder.listFiles();

            if (currentFiles != null) {
                for (File f : currentFiles) {
                    if (f.isDirectory()) {
                        folders.add(f);
                    } else if (f.isFile()) {
                        String name = f.getName();
                        String regex = ".*(" + extension + "){1}$";
                        boolean res = name.matches(regex);
                        if (res) {
                            foundFiles.add(f.getAbsolutePath());
                        }
                    } else {
                        throw new RuntimeException("It isn't file or folder");
                    }
                }
            }
        }

        return foundFiles.toArray(new String[foundFiles.size()]);
    }

    @Override public void replaceChars(Reader in, Writer out,
            String inChars, String outChars) {

        if (in == null || out == null) {
            throw new NullPointerException();
        }

        if (inChars.length()!=outChars.length()){
            throw new IllegalArgumentException("illegal argument");
        }


        int n = inChars.length();
        Map<Character, Character> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inChars.charAt(i), outChars.charAt(i));
        }

        int c;
        char ch;

        try {
            while ((c = in.read()) != -1) {
                ch = (char) c;
                if (map.containsKey(ch)) {
                    ch = map.get(ch);
                }
                out.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}