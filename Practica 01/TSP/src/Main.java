import classes.Path;
import classes.Problem;
import classes.Utilities;
import heuristics.Heuristic;
import heuristics.MonteCarlo;
import heuristics.NearestNeighbour;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> data = Utilities.loadData();
        Problem problem = new Problem(data.get(0));
        Heuristic heuristic = new MonteCarlo();
        Utilities.Type type = Utilities.Type.IMPERATIVE;

        Path path = heuristic.calculateOptimalPath(problem, type);

        path.print();
    }

}
