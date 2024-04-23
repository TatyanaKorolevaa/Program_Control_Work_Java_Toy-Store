package Toy_Store;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;


public class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();

    public void addToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    public Toy getPrize() {
        if (prizes.size() == 0) {
            Random rnd = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getQuantity(); i++) {
                    Toy temp = new Toy(toy.getId(), toy.getName(), rnd.nextInt(1, 11), i);
                    prizes.add(temp);
                }
            }
        }
        return prizes.poll();
    }

    public void drawToys() {
        if (toys.size() >= 2) {
            Toy prize = getPrize();
            System.out.println("Вы выиграли: " + prize.getName());
            saveResult(prize.getInfo());
        } else {
            System.out.println("Необходимо поолнить количество игрушек.");
        }
    }

    public void changeToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " отсутствует.");
    }

    private void saveResult(String text) {
        File file = new File("Result.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
