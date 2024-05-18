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
    public void nextDay(){
        fullness -= getRandomForNextDay(1,5);
        if (fullness < 0 ){
            fullness = 0;
        }
        mood += getRandomForNextDay(-3,+3);
        if (mood > 100){
            mood = 100;
        }
        if (mood < 0){
            mood = 0;
        }
        health += getRandomForNextDay(-3,+3);
        if (health > 100){
            health = 100;
        }
        if (health < 0){
            health = 0;
        }
    }
    public void feed(){
        if (!afterUse){
            int randomFeed = random.nextInt(10)+1;
            if (randomFeed > 4){
                if (age <= 5){
                    fullness += 7;
                    if (fullness > 100){
                        fullness = 100;
                    }
                    mood += 7;
                    if (mood > 100){
                        mood = 100;
                    }
                }
                if (age > 5 && age <= 10){
                    fullness += 5;
                    if (fullness > 100){
                        fullness = 100;
                    }
                    mood += 5;
                    if (mood > 100){
                        mood = 100;
                    }
                }
                if (age > 10){
                    fullness += 4;
                    if (fullness > 100){
                        fullness = 100;
                    }
                    mood += 4;
                    if (mood > 100){
                        mood = 100;
                    }
                }
                System.out.printf("You fed cat %s , %d years old%n",name,age);
            }else {
                mood -= 10;
                if (mood < 0){
                    mood = 0;
                }
                health -=10;
                if (health < 0){
                    health = 0;
                }
                System.out.println("Кот отравился !");
            }
            }
    }
    public void heal(){
        if (!afterUse){
            if (age <= 5){
                health += 7;
                if (health > 100){
                    health = 100;
                }
                mood -= 3;
                if (mood < 0){
                    mood = 0;
                }
                fullness -= 3;
                if (fullness < 0){
                    fullness = 0;
                }
            }
            if (age > 5 && age <= 10){
                health += 5;
                if (health > 100){
                    health = 100;
                }
                mood -= 5;
                if (mood < 0){
                    mood = 0;
                }
                fullness -= 5;
                if (fullness < 0){
                    fullness = 0;
                }
            }
            if (age > 10){
                health += 4;
                if (health > 100){
                    health = 100;
                }
                mood -= 6;
                if (mood < 0){
                    mood = 0;
                }
                fullness -= 6;
                if (fullness < 0){
                    fullness = 0;
                }
            }
        }
    }
    public void play(){
        if (!afterUse){
            int randomGame = random.nextInt(10)+1;
            if (randomGame > 4){
                if (age <= 5){
                    mood += 7;
                    if (mood > 100){
                        mood = 100;
                    }
                    health += 7;
                    if (health > 100){
                        health = 100;
                    }
                    fullness -= 3;
                    if (fullness < 0){
                        fullness = 0;
                    }
                }
                if (age > 5 && age <= 10){
                    mood += 5;
                    if (mood > 100){
                        mood = 100;
                    }
                    health += 5;
                    if (health > 100){
                        health = 100;
                    }
                    fullness -= 5;
                    if (fullness < 0){
                        fullness = 0;
                    }
                }
                if (age > 10){
                    mood += 4;
                    if (mood > 100){
                        mood = 100;
                    }
                    health += 4;
                    if (health > 100){
                        health = 100;
                    }
                    fullness -= 6;
                    if (fullness < 0){
                        fullness = 0;
                    }
                }
                System.out.printf("You played with cat %s , %d years old%n",name,age);
            }else {
                mood -= 10;
                if (mood < 0){
                    mood = 0;
                }
                health -=10;
                if (health < 0){
                    health = 0;
                }
                System.out.println("Кот травмировался !");
            }
        }
    }
}
