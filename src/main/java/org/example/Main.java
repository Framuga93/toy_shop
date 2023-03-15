package org.example;

import org.example.model.FileOperation;
import org.example.model.Repository;
import org.example.model.Toy;

public class Main {
    public static void main(String[] args) {
        FileOperation fo = new FileOperation("test.csv");
        Repository re = new Repository(fo);
        re.addToy(new Toy("sda",1,1));


    }
}