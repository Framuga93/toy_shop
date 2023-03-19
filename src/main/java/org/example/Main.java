package org.example;

import org.example.model.FileOperation;
import org.example.model.Repository;
import org.example.model.Toy;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation("toysList.csv");
        FileOperation prizeFileOp = new FileOperation("prizeList.csv");
        Repository re = new Repository(fileOperation);
        Lottery lo = new Lottery(fileOperation,prizeFileOp);
        re.addToy(new Toy("bear",80));
        re.addToy(new Toy("robot",70));
        re.addToy(new Toy("dog",50));
        re.addToy(new Toy("rabbit",40));
        re.upgradeToyChance("sda",20);
        lo.addToPrizeList();


    }
}