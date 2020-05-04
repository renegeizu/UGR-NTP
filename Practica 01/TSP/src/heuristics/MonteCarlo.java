package heuristics;

import classes.City;
import classes.Path;
import classes.Problem;
import classes.Utilities;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MonteCarlo implements Heuristic {

    // MonteCarlo Functional Heuristic

    private Path functional(Problem problem, int solutions) {
        ArrayList<City> cities = problem.getCities();

        List<Path> collect = IntStream
                .range(0, solutions)
                .mapToObj(
                        index -> {
                            Collections.shuffle(cities);
                            return new Path(cities, Utilities.Type.FUNCTIONAL);
                        }
                )
                .collect(Collectors.toList());

        return collect.stream()
                .min(Comparator.comparing(Path::getCost))
                .orElseThrow();
    }

    // -----------------------

    // MonteCarlo Imperative Heuristic

    private Path imperative(Problem problem, int solutions) {
        ArrayList<Path> collect = new ArrayList<>(solutions);

        for (int i = 0; i < solutions; i++) {
            collect.add(new Path(Utilities.suffleCollection(problem.getCities()), Utilities.Type.IMPERATIVE));
        }

        Path path = collect.get(0);

        for (int i = 1; i < collect.size(); i++) {
            if (path.getCost() > collect.get(i).getCost()) {
                path = collect.get(i);
            }
        }

        return path;
    }

    // -----------------------

    // Method to Calculate the Path

    @Override
    public Path calculateOptimalPath(Problem problem, Utilities.Type type) {
        int numSol = (int) (Math.random() * 11 + 1);

        Path path;
        if (type.getState()) {
            path = functional(problem, numSol);
        } else {
            path = imperative(problem, numSol);
        }

        return path;
    }
}
