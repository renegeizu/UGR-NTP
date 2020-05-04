package classes;

import java.util.List;

public class City {

    // Declaration of Variables

    private double x, y;
    private String label;

    // -----------------------

    // Constructors

    public City(List<String> element) {
        this.x = Double.parseDouble(element.get(1));
        this.y = Double.parseDouble(element.get(2));
        this.label = element.get(0);
    }

    public City(double x, double y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    // -----------------------

    // Getters and Setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // -----------------------

    // Method to Compare 2 Objects

    public boolean equals(City city) {
        return (this.x == city.x && this.y == city.y);
    }

    // -----------------------

    // Convert Object to String

    public String toString() {
        return (this.label + ": [" + this.x + ", " + this.y + "]");
    }

}
