package heuristics;

import classes.Path;
import classes.Problem;
import classes.Utilities;

public interface Heuristic {

    Path calculateOptimalPath(Problem problem, Utilities.Type type);

}
