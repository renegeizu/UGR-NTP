package classes;

import java.util.Arrays;
import java.util.Objects;

public class Board {

    // Declaration of Variables

    private int dimension;
    private Cell[][] content;

    // -----------------------

    // Constructors

    public Board(int dimension) {
        this.dimension = dimension;
        this.content = new Cell[dimension][dimension];

        Arrays.stream(this.content).forEach(
                element -> Arrays.stream(element).forEach(object -> object = null)
        );
    }

    public Board(Board board) {
        this.dimension = board.dimension;
        this.content = new Cell[dimension][dimension];

        Arrays.stream(this.content).forEach(
                element -> Arrays.stream(element).forEach(object -> object = null)
        );

        Arrays.stream(board.content).forEach(
                element -> Arrays.stream(element)
                        .filter(Objects::nonNull)
                        .forEach(
                                object -> placeQueen(object.getRow(), object.getCol())
                        )
        );
    }

    // -----------------------

    // Position the Queen on the Board

    public void placeQueen(int row, int col) {
        this.content[row][col] = new Cell(row, col);
    }

    // -----------------------

    // Check if the Queen can be Positioned

    public boolean safePosition(Cell cell) {
        boolean flag = true;

        for (int i = 0; i < this.dimension && flag; i++) {
            for (int j = 0; j < this.dimension && flag; j++) {
                if (this.content[i][j] != null) {
                    flag = !this.content[i][j].existConflict(cell);
                }
            }
        }

        return flag;
    }

    // -----------------------

    // Convert Object to String

    public String toString() {
        StringBuilder chain = new StringBuilder();

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.content[i][j] == null) {
                    chain.append(" X ");
                } else {
                    chain.append(" R ");
                }
            }

            chain.append("\n");
        }

        return chain.toString();
    }

}
