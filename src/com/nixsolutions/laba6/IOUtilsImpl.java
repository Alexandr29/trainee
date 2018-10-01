package com.nixsolutions.laba6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import interfaces.task6.IOUtils;

public class IOUtilsImpl implements IOUtils {

    @Override public void copyFile(final String source, final String dest) {

        // if (!dest.matches(".*[.]{1}.*")) {
        // throw new IllegalArgumentException(new FileNotFoundException());
        // }

        InputStream input = null;

        try {
            input = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        OutputStream output = null;

        try {
            output = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            // File fileDest = new File(dest);
            // try {
            // fileDest.createNewFile();
            // } catch (IOException e1) {
            // throw new IllegalArgumentException(e1);
            // } finally {
            try {
                input.close();
            } catch (IOException e1) {
                throw new IllegalArgumentException(e1);
                // e1.printStackTrace();
            }
            throw new IllegalArgumentException(e);
            // }
        }

        int b = 0;

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

    @Override public void copyFileBest(final String source, final String dest) {

        // if (!dest.matches(".*[.]{1}.*")) {
        // throw new IllegalArgumentException();
        // }

        FileInputStream input = null;

        try {
            input = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        FileOutputStream output = null;

        try {
            output = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            // File fileDest = new File(dest);
            // try {
            // fileDest.createNewFile();
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

        FileChannel inputChannel = input.getChannel();
        FileChannel ouptupChannel = output.getChannel();

        try {
            inputChannel.transferTo(0, inputChannel.size(), ouptupChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override public void copyFileBuffered(final File source, final File dest) {

        String destName = dest.getAbsolutePath();

        // if (!destName.matches(".*[.]{1}.*")) {
        // throw new IllegalArgumentException();
        // }

        InputStream input = null;

        try {
            input = new BufferedInputStream(new FileInputStream(source));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        OutputStream output = null;

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

        int b = 0;

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

    @Override public String[] findFiles(final String folderName) {

        File folder = new File(folderName);
        if (!folder.exists()) {
            throw new IllegalArgumentException();
        }

        List<String> foundFiles = new ArrayList<String>();
        Queue<File> folders = new LinkedList<File>();

        folders.add(folder);

        while (!folders.isEmpty()) {

            File currentFolder = folders.remove();
            File[] currentFiles = currentFolder.listFiles();

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

        return foundFiles.toArray(new String[foundFiles.size()]);
    }

    @Override public String[] findFiles(final String folderName,
            final String extention) {

        if (extention == null) {
            return findFiles(folderName);
        }

        File folder = new File(folderName);
        if (!folder.exists()) {
            throw new IllegalArgumentException();
        }

        List<String> foundFiles = new ArrayList<String>();
        Queue<File> folders = new LinkedList<File>();

        folders.add(folder);

        while (!folders.isEmpty()) {

            File currentFolder = folders.remove();
            File[] currentFiles = currentFolder.listFiles();

            for (File f : currentFiles) {
                if (f.isDirectory()) {
                    folders.add(f);
                } else if (f.isFile()) {
                    String name = f.getName();
                    String regex = ".*(" + extention + "){1}$";
                    boolean res = name.matches(regex);
                    if (res) {
                        foundFiles.add(f.getAbsolutePath());
                    }
                } else {
                    throw new RuntimeException("It isn't file or folder");
                }
            }
        }

        return foundFiles.toArray(new String[foundFiles.size()]);
    }

    @Override public void replaceChars(final Reader in, final Writer out,
            final String inChars, final String outChars) {

        if (in == null || out == null) {
            throw new NullPointerException();
        }

        if (inChars != null && outChars != null && inChars.length() != outChars
                .length()) {
            throw new IllegalArgumentException();
        }

        int n = 0;
        if (inChars == null || outChars == null) {
            n = 0;
        } else {
            n = inChars.length();
        }
        Map<Character, Character> map = new HashMap<Character, Character>(n);
        for (int i = 0; i < n; i++) {
            map.put(inChars.charAt(i), outChars.charAt(i));
        }

        int c = 0;
        char ch = 0;

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