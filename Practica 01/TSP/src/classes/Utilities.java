package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utilities {

    // -----------------------

    // Enum Class

    public enum Type {
        FUNCTIONAL(true),
        IMPERATIVE(false);

        private boolean state;

        Type(boolean state) {
            this.state = state;
        }

        public boolean getState() {
            return this.state;
        }

    }

    // -----------------------

    // Functions to Create the Distance Matrix

    private static Map<String, Map<String, Double>> createFunctionalMatrix(ArrayList<City> cities) {
        Map<String, Map<String, Double>> distanceMatrix = new HashMap<>();

        cities.forEach(
                element -> {
                    distanceMatrix.put(element.getLabel(), new HashMap<>());

                    cities.stream().filter(component -> !component.equals(element))
                            .forEach(
                                    component -> distanceMatrix.get(element.getLabel())
                                            .put(component.getLabel(), Utilities.euclideanDistance(element, component))
                            );
                }
        );

        return distanceMatrix;
    }

    private static Map<String, Map<String, Double>> createImperativeMatrix(ArrayList<City> cities) {
        Map<String, Map<String, Double>> distanceMatrix = new HashMap<>();

        for (int i = 0; i < cities.size(); i++) {
            distanceMatrix.put(cities.get(i).getLabel(), new HashMap<>());
            for (int j = 0; j < cities.size(); j++) {
                if (i != j) {
                    distanceMatrix
                            .get(cities.get(i).getLabel())
                            .put(cities.get(j).getLabel(), Utilities.euclideanDistance(cities.get(i), cities.get(j)));
                }
            }
        }

        return distanceMatrix;
    }

    public static Map<String, Map<String, Double>> createDistanceMatrix(ArrayList<City> cities, Type status) {
        if (status.getState()) {
            return createFunctionalMatrix(cities);
        } else {
            return createImperativeMatrix(cities);
        }
    }

    // -----------------------

    // Data List

    public static ArrayList<String> loadData() {
        String path = "./data/";
        ArrayList<String> data = new ArrayList<>();

        data.add(path + "a280.tsp");
        data.add(path + "berlin52.tsp");
        data.add(path + "eil101.tsp");
        data.add(path + "lin318.tsp");
        data.add(path + "mona-lisa100k.tsp");
        data.add(path + "pla33810.tsp");
        data.add(path + "pr1002.tsp");
        data.add(path + "small4.tsp");
        data.add(path + "small5.tsp");
        data.add(path + "small10.tsp");
        data.add(path + "zi929.tsp");

        return data;
    }


    // -----------------------

    // Function to Calculate the Euclidean Distance

    public static double euclideanDistance(City cFirst, City cSecond) {
        double distX = Math.abs(cFirst.getX() - cSecond.getX());
        double distY = Math.abs(cFirst.getY() - cSecond.getY());

        return Math.sqrt((distX * distX) + (distY * distY));
    }


    // -----------------------

    // Function to Shuffle an Array

    public static ArrayList<City> suffleCollection(ArrayList<City> cities) {
        ArrayList<City> shuffleCities = new ArrayList<>(cities);
        Random random = new Random();

        for (int i = shuffleCities.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            City aux = shuffleCities.get(index);
            shuffleCities.set(index, shuffleCities.get(i));
            shuffleCities.set(i, aux);
        }

        return shuffleCities;
    }
}