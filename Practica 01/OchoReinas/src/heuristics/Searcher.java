package heuristics;

import classes.Board;
import classes.Cell;
import classes.Type;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Searcher {

    // Declaration of Variables

    private int dimension;

    // -----------------------

    // Imperative Searcher Method

    private ArrayList<Board> locateQueenImperative(int row) {
        ArrayList<Board> solutions = new ArrayList<>();

        if (row == -1) {
            solutions.add(new Board(this.dimension));
        } else {
            ArrayList<Board> aux = locateQueenImperative(row - 1);

            for (Board board : aux) {
                for (int j = 0; j < this.dimension; j++) {
                    Board auxBoard = new Board(board);

                    if (auxBoard.safePosition(new Cell(row, j))) {
                        auxBoard.placeQueen(row, j);
                        solutions.add(auxBoard);
                    }
                }
            }
        }

        return solutions;
    }

    // -----------------------

    // Functional Searcher Method

    private ArrayList<Board> locateQueenFunctional(int row) {
        ArrayList<Board> solutions = new ArrayList<>();

        if (row == -1) {
            solutions.add(new Board(this.dimension));
        } else {
            ArrayList<Board> aux = locateQueenFunctional(row - 1);

            aux.forEach(
                    element -> IntStream.range(0, this.dimension).forEach(
                            col -> {
                                Board auxBoard = new Board(element);

                                if (auxBoard.safePosition(new Cell(row, col))) {
                                    auxBoard.placeQueen(row, col);
                                    solutions.add(auxBoard);
                                }
                            }
                    )
            );
        }

        return solutions;
    }

    // -----------------------

    // Constructor

    public Searcher(int dimension) {
        this.dimension = dimension;
    }

    // -----------------------

    // Solver Method

    public ArrayList<Board> solve(Type type) {
        if (type.getState()) {
            return locateQueenFunctional(this.dimension - 1);
        } else {
            return locateQueenImperative(this.dimension - 1);
        }
    }

}
