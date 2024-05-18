package objects;

import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int health;
    private int mood;
    private int fullness;
    private boolean afterUse;
    private Random random = new Random();

    public Cat (String name , int age){
        this.name = name;
        this.age = age;
        this.health = getRandom(20,80);
        this.mood = getRandom(20,80);
        this.fullness = getRandom(20,80);
        this.afterUse = false;
    }

    private int getRandom(int min , int max){
        return random.nextInt(max - min) + min + 1;
    }
    private int getRandomForNextDay(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    public int getAverageLevel(){
        return (health + mood + fullness) / 3;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getMood() {
        return mood;
    }

    public int getFullness() {
        return fullness;
    }

    public String getName() {
        return name;
    }

    public boolean isAfterUse() {
        return afterUse;
    }

    public void setAfterUse(boolean afterUse) {
        this.afterUse = afterUse;
    }

}
