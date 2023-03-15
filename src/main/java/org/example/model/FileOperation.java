package org.example.model;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    private String fileName;

    public FileOperation(String fileName) {
        this.fileName = fileName;
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName,true))) {
            writer.flush();
        } catch (IOException ex) {
            throw new IllegalStateException("fileop EX CSV");
        }
    }

    public List<Toy> readToyList() {
        try{
            CSVReader reader = new CSVReader(new FileReader(fileName), ',');
            List<Toy> toys = new ArrayList<>();
            String[] row = null;
            while ((row = reader.readNext()) != null) {
                int id = Integer.parseInt(row[0]);
                String description = row[1];
                int quantity = Integer.parseInt(row[2]);
                int chance = Integer.parseInt(row[3]);
                toys.add(new Toy (description,quantity,chance));
            }
            reader.close();
            return toys;
        }catch (IOException e) {
            throw new IllegalStateException("readline EX CSV");
        }

    }

    public void saveAllLines(List<Toy> toys) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, false));
            List<String> lines = new ArrayList<>();
            for (Toy toy : toys){
//                lines.add(toy.toString());
                String[] temp;
                temp = toy.toString().split(",");
                csvWriter.writeNext(temp);
            }
//            for (String line : lines) {
//                String[] temp;
//                temp = line.split(",");
//                csvWriter.writeNext(temp);
//            }
            csvWriter.close();
        }catch (IOException e) {
            throw new IllegalStateException("saveline EX CSV");
        }
    }
}
