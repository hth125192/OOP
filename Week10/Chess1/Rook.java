public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }
        if (x > this.getCoordinatesX()) {
            for (int i = this.getCoordinatesX() + 1; i < x; i++) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }
        }
        if (x < this.getCoordinatesX()) {
            for (int i = this.getCoordinatesX() - 1; i > x; i--) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }
        }
        if (y > this.getCoordinatesY()) {
            for (int i = this.getCoordinatesY() + 1; i < y; i++) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        }
        if (y < this.getCoordinatesY()) {
            for (int i = this.getCoordinatesY() - 1; i > y; i--) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        }
        if (board.getAt(x, y) != null) {
            return !board.getAt(x, y).getColor().equals(this.getColor());
        }
        return true;
    }

}
