package com.nixsolutions.laba8;

import interfaces.task8.SerializableUtils;

import java.io.*;
import java.util.Objects;

public class SerializableUtilsImpl implements SerializableUtils, Serializable {
    //FileOutputStream fos = new FileOutputStream("test.txt");
    //FileInputStream fis = null;

    public SerializableUtilsImpl() throws FileNotFoundException {
    }

    @Override public void serialize(OutputStream outputStream, Object o) {
        Objects.requireNonNull(outputStream);
        Objects.requireNonNull(o);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                outputStream)) {
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException("Serialization Exception",
                    e);
        }

    }

    @Override public Object deserialize(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                inputStream)) {
            return objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException("Deserialization Exception",
                    e);
        }
    }
}
