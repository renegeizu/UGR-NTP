package heuristics;

import classes.City;
import classes.Path;
import classes.Problem;
import classes.Utilities;

import java.util.Map;

public class NearestNeighbour implements Heuristic {

    // Declaration of Variables

    private Path path;
    Map<String, Map<String, Double>> distanceMatrix;

    // -----------------------

    // Support Functional Methods

    private String getKeyFunctional(City city) {
        return this.distanceMatrix.get(city.getLabel()).entrySet()
                .stream().filter(element -> element.getValue() > 0)
                .min(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
                .orElse(null);
    }

    private void cancelKeyFunctional(City city) {
        this.distanceMatrix.entrySet().stream()
                .filter(obj -> !obj.getKey().equals(city.getLabel()))
                .forEach(obj -> obj.getValue().put(city.getLabel(), 0.0));
    }

    // -----------------------

    // NN Functional Heuristic

    private Path functional(Problem problem) {
        City city = problem.getFirstCity();
        String key = city.getLabel();

        while (null != key) {
            this.path.addCity(city);
            cancelKeyFunctional(city);
            key = getKeyFunctional(city);
            city = problem.getCity(key);
        }

        return this.path;
    }

    // -----------------------

    // Support Imperative Methods

    private String getKeyImperative(City city) {
        Map<String, Double> aux = this.distanceMatrix.get(city.getLabel());

        String key = null;
        double min = 0.0;

        for (Map.Entry<String, Double> object : aux.entrySet()) {
            if (null == key) {
                if (object.getValue() > 0.0) {
                    key = object.getKey();
                    min = object.getValue();
                }
            } else if (object.getValue() > 0.0 && min > object.getValue()) {
                key = object.getKey();
                min = object.getValue();
            }
        }

        return key;
    }

    private void cancelKeyImperative(City city) {
        for (Map.Entry<String, Map<String, Double>> object : this.distanceMatrix.entrySet()) {
            if (!object.getKey().equals(city.getLabel())) {
                object.getValue().put(city.getLabel(), 0.0);
            }
        }
    }

    // -----------------------

    // NN Imperative Heuristic

    private Path imperative(Problem problem) {
        City city = problem.getFirstCity();
        String key = city.getLabel();

        while (null != key) {
            this.path.addCity(city);
            cancelKeyImperative(city);
            key = getKeyImperative(city);
            city = problem.getCity(key);
        }

        return this.path;
    }

    // -----------------------

    // Constructor

    public NearestNeighbour() {
        this.path = new Path();
    }

    // -----------------------

    // Method to Calculate the Path

    @Override
    public Path calculateOptimalPath(Problem problem, Utilities.Type type) {
        this.distanceMatrix = Utilities.createDistanceMatrix(problem.getCities(), type);

        if (type.getState()) {
            path = functional(problem);
        } else {
            path = imperative(problem);
        }

        return path;
    }
}
