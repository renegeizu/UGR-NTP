package classes;

public class Cell {

    // Declaration of Variables

    private int row;
    private int col;

    private boolean diagonal(Cell cell) {
        return (Math.abs(this.row - cell.row) == Math.abs(this.col - cell.col));
    }

    // -----------------------

    // Support Functional Methods

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // -----------------------

    // Getter Methods

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // -----------------------

    // Check Conflicts

    public boolean existConflict(Cell cell) {
        boolean flag = false;

        if (this.row == cell.row || this.col == cell.col || diagonal(cell)) {
            flag = true;
        }

        return flag;
    }

    // -----------------------

    // Convert Object to String

    public String toString() {
        return ("(" + this.row + ", " + this.col + ")");
    }
}
