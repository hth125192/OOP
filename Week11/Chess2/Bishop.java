public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int currentX = this.getCoordinatesX();
        int currentY = this.getCoordinatesY();
        if (Math.abs(x - currentX) != Math.abs(y - currentY)) {
            return false;
        }
        if (x > currentX) {
            for (int i = 1; i < y - currentY; i++) {
                if (board.getAt(currentX + i, currentY + i) != null) {
                    return false;
                }
            }
            for (int i = 1; i < currentY - y; i++) {
                if (board.getAt(currentX + i, currentY - i) != null) {
                    return false;
                }
            }
        }
        if (x < currentX) {
            for (int i = 1; i < y - currentY; i++) {
                if (board.getAt(currentX - i, currentY + i) != null) {
                    return false;
                }
            }
            for (int i = 1; i < currentY - y; i++) {
                if (board.getAt(currentX - i, currentY - i) != null) {
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
