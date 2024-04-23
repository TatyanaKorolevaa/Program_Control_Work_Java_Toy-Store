package Toy_Store;

import java.util.Scanner;


public class Programm {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(1, "Трек Hot Wheels", 18, 30);
        toyStore.addToy(2, "Шарик", 27, 10);
        toyStore.addToy(3, "Кукла Барби", 10, 18);
        toyStore.addToy(4, "Динозавр", 10, 15);
        toyStore.addToy(5, "Мягкая игрушка", 20, 15);

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Выберите опцию:");
            System.out.println("1. Добавить игрушку");
            System.out.println("2. Изменить вес игрушки");
            System.out.println("3. Розыгрыш игрушек");
            System.out.println("4. Выйти");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Введите ID игрушки:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Введите название игрушки:");
                    String name = scanner.nextLine();
                    System.out.println("Введите количество игрушек:");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите вес игрушки (в % от 100):");
                    double weight = scanner.nextDouble();
                    toyStore.addToy(id, name, quantity, weight);
                    break;
                case 2:
                    System.out.println("Введите ID игрушки, у которой хотите изменить вес:");
                    int toyId = scanner.nextInt();
                    System.out.println("Введите новый вес (в % от 100):");
                    double newWeight = scanner.nextDouble();
                    toyStore.changeToyWeight(toyId, newWeight);
                    break;
                case 3:
                    toyStore.drawToys();
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите действие.");
                    break;
            }
        } while (option != 4);
    }
}
