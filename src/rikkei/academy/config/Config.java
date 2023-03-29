package rikkei.academy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static final String PATH_PRODUCT = "D:\\Code\\Java\\Lession18\\FileBI_CRUD\\src\\rikkei\\academy\\database\\product.txt";
    public static Scanner scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public List<T> readFromFile(String filePath){
        List<T> tList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
        } catch (FileNotFoundException f){
            System.err.println("File not found");
        } catch (IOException i ) {
            System.err.println("IOE Exception");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not found");
        }
        return tList;
    }

    public void writeToFile(String filePath, List<T>tList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException f) {
            System.err.println("File not found");
        } catch (IOException i) {
            System.err.println("IOE Exception");
        }
    }
}
