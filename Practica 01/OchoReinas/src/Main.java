import classes.Board;
import classes.Type;
import heuristics.Searcher;

import java.util.ArrayList;

public class Main {

    public static void print(ArrayList<Board> solutions) {
        System.out.println("Solutions: " + solutions.size() + "\n");

        solutions.forEach(
                element -> System.out.println("--------------------\n" + element.toString())
        );
    }

    public static void main(String[] args) {
        int dimension = 4;
        Searcher searcher = new Searcher(dimension);

        print(searcher.solve(Type.FUNCTIONAL));
    }

}
