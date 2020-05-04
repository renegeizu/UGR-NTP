package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Path {

    // Declaration of Variables

    private ArrayList<City> solution;
    private double cost;

    // -----------------------

    // Constructors

    public Path() {
        this.solution = new ArrayList<>();
        this.cost = 0.0;
    }

    public Path(int size) {
        this.solution = new ArrayList<>(size);
        this.cost = 0.0;
    }

    public Path(ArrayList<City> solution, Utilities.Type type) {
        this.solution = new ArrayList<>(solution);

        if (type.getState()) {
            this.cost = IntStream
                    .range(0, this.solution.size() - 1)
                    .mapToDouble(i -> Utilities.euclideanDistance(this.solution.get(i), this.solution.get(i + 1)))
                    .sum();
        } else {
            this.cost = 0.0;

            for (int i = 0; i < this.solution.size() - 1; i++) {
                this.cost += Utilities.euclideanDistance(this.solution.get(i), this.solution.get(i + 1));
            }
        }
    }

    // -----------------------

    // Class Management Methods

    public void addCity(City city) {
        if (this.solution.size() > 0) {
            City aux = this.solution.get(this.solution.size() - 1);
            this.cost += Utilities.euclideanDistance(aux, city);
        }

        this.solution.add(city);
    }

    public double getCost() {
        return this.cost;
    }

    public void reset() {
        this.solution.clear();
        this.cost = 0.0;
    }

    // -----------------------

    // Convert Object to String

    public String toString() {
        List<String> collect = this.solution.stream().map(City::getLabel).collect(Collectors.toList());

        return (collect.stream().reduce("", (x, y) -> x + "City: " + y));
    }

    // -----------------------

    // Print the Object Info

    public void print() {
        this.solution.forEach(city -> System.out.println(city.toString()));

        System.out.println("-----------------------");
        System.out.println("Cost: " + this.cost);
    }

}
