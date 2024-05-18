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

    public void printCats(){
        cats.sort((c1,c2)-> c2.getAverageLevel() - c1.getAverageLevel());
        System.out.println("==============================================================================");
        System.out.println("# |     Имя     | Возраст | Здоровье | Настроение | Сытость | Средний уровень");
        for (int i = 0; i < cats.size(); i++) {
            Cat cat = cats.get(i);
            String isItAfterUse = cat.isAfterUse() ? "*" : "";
            System.out.printf("%-2d| %-11s | %-7d | %-8d | %-10d | %-7d | %-13d%n",
                    (i + 1), isItAfterUse + cat.getName(), cat.getAge(), cat.getHealth(),
                    cat.getMood(), cat.getFullness(), cat.getAverageLevel());
        }
        System.out.println("==============================================================================");
    }
    private String userCheckEmptyInput(){
        while (true){
            try{
                String current = scanner.nextLine().trim();
                if (current.isEmpty()){
                    throw new UserInPut();
                }
                return current;
            }catch (UserInPut e){
                System.out.println("Вы ничего не ввели ! напишите снова !");
            }
        }
    }
    private int getIntInput() {
        while (true) {
            try {
                String current = userCheckEmptyInput();
                int userChoice = Integer.parseInt(current);
                return userChoice;
            } catch (NumberFormatException e) {
                System.out.print("Надо ввести число ! введите заново : ");
            }
        }
    }
    private int getChoice(int min, int max){
        int choice;
        while (true) {
            try {
                choice = getIntInput();
                if (choice < min || choice > max) {
                    throw new UserInPut();
                }
                break;
            } catch (UserInPut e) {
                System.out.printf("Число не должен быть меньше %s и больше чем  %s выберите между этими значениями ", min, max);
            }
        }
        return choice;
    }
    private Cat findCatByNumber(int number) {
        if (number >= 1 && number <= cats.size()) {
            return cats.get(number - 1);
        } else {
            return null;
        }
    }

    public void runSimulation(){
        while (true){
            printCats();
            System.out.printf("Выберите что вы хотите сделать !%n1) Кормить кота%n2) Играть с котом%n3) Лечить кота%n4) Завести нового питомца%n5) Следующий день%n");
            int choiceAction = getChoice(1,5);
            switch (choiceAction){
                case 1:
                case 2:
                case 3:
                    actionWithCat(choiceAction);
                    break;
                case 4:
                    addCat();
                    break;
                case 5:
                    nextDay();
                    cleanBooleanIsAfterUse();
                    System.out.println("Настал следующий день !");
                    break;
            }
        }
    }
    private void cleanBooleanIsAfterUse(){
        for (int i = 0 ; i < cats.size();i++){
            cats.get(i).setAfterUse(false);
        }
    }
    private void actionWithCat(int choicenNum){
        System.out.println("Введите номер кота для действия с ним  : ");
        int number = getIntInput();
        Cat cat = findCatByNumber(number);
        if (cat == null) {
            System.out.println("Кот не найден .");
            return;
        }
        switch (choicenNum){
            case 1:
                cat.feed();
                cat.setAfterUse(true);
                break;
            case 2:
                cat.play();
                cat.setAfterUse(true);
                break;
            case 3:
                cat.heal();
                cat.setAfterUse(true);
                System.out.printf("You healed cat %s , %d years old%n",cat.getName(),cat.getAge());
                break;
        }
    }
    private void addCat(){
        System.out.println("Введите имя кота на английском (для вашего удобства) : ");
        String name = userCheckEmptyInput();
        System.out.println("Введите возраст от 1 го до 18 лет : ");
        int age = getChoice(1,18);
        Cat newCat = new Cat(name,age);
        cats.add(newCat);
        System.out.println("Кошка добавлена успешно !");
    }
    private void nextDay(){
        for (Cat cat : cats){
            cat.nextDay();
        }
    }


}
