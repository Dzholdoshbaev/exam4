package simulation;

import exceptions.UserInPut;
import objects.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatSimulation {
    private List<Cat> cats;
    private Scanner scanner;

    public CatSimulation(){
        this.cats = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        Cat cat1 = new Cat("Barsik",4);
        Cat cat2 = new Cat("Marusa",10);
        Cat cat3 = new Cat("Inna",16);
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
    }



}
