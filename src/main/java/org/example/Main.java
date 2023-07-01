package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<String> tasks = new ArrayList<>();

    public void main(String[] args) {

        do {
            System.out.println("\n1. Добавить задачу \n2. Вывести список задач \n3. Удалить задачу \n0. Выход\nВыберите действие: ");
        } while (Program(System.in));
    }


    public void addWork(InputStream inputStream){
        System.out.println("Введите задачу для добавления:");
        Scanner scanner = new Scanner(inputStream);
        String task = scanner.nextLine();
        tasks.add(task);
    }

    public void deleteWork(InputStream inputStream){
        System.out.println("Введите номер задачи для удаления:");
        Scanner scanner = new Scanner(inputStream);
        try{
            int numberOfWork = Integer.parseInt(scanner.nextLine());
            tasks.remove(numberOfWork - 1);
        } catch (Exception ex) {
            System.out.println("Введен не номер задачи или такой задачи нет!");
        }

    }

    public void printAllWorks(){
        System.out.println("Список задач:");
        for (int t = 1; t <= tasks.size(); t++) {
            System.out.println(t + ". " + tasks.get(t - 1));
        }
    }

    public boolean Program(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream);
        String enter = scanner.nextLine();

        try {
            int number = Integer.parseInt(enter);
            switch (number) {
                case (0):
                    System.out.println("Пока!");
                    printAllWorks();
                    return false;
                case (1):
                    addWork(inputStream);
                    printAllWorks();
                    return true;
                case (2):
                    printAllWorks();
                    return true;
                case (3):
                    deleteWork(inputStream);
                    printAllWorks();
                    return true;
                default:
                    System.out.println("Вы ввели не номер задачи! Попробуйте снова!");
                    return true;
            }
        } catch (Exception ex) {
            System.out.println("Вы ввели не номер задачи! Попробуйте снова!");
            return true;
        }
    }
}