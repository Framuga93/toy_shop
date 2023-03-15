package org.example.model;


import java.util.List;

public class Repository {
    private FileOperation fileOperation;

    public Repository(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    public void addToy(Toy toy){
        List<Toy> toyList = fileOperation.readToyList();
        toyList.add(toy);
        fileOperation.saveAllLines(toyList);
    }

}
