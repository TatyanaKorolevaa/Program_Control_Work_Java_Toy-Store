package Toy_Store;
import java.util.Objects;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getInfo() {
        return String.format("ID: %d, Название: %s", id, name);
}

public int hashCode() {
    return Objects.hash(name);
}

@Override
public int compareTo(Toy o) {
    return Integer.compare(this.quantity, o.quantity);
}
}
