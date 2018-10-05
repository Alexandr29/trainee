package com.nixsolutions.laba8;

import interfaces.task8.SerializableUtils;

import java.io.*;

public class SerializableUtilsImpl implements SerializableUtils {
    FileOutputStream fos = new FileOutputStream("test.txt");
    FileInputStream fis = null;

    public SerializableUtilsImpl() throws FileNotFoundException {
    }

    @Override public void serialize(OutputStream outputStream, Object o) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(o);

            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            //        outputStream);
            //objectOutputStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public Object deserialize(InputStream inputStream) {
Object o = null;
        try {
            fis = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(fis);
            o = oin.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return o;
    }
}
