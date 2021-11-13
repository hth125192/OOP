public class TestChess {
    public static void main(String[] args) {
        Piece whiteRook1 = new Rook(5, 4);
        Piece whiteRook2 = new Rook(8, 1, "white");
        Piece blackRook1 = new Rook(3, 8, "black");
        Piece blackRook2 = new Rook(5, 7, "black");
        Piece redRook1 = new Rook(0, 0);
        Piece redRook2 = new Rook(3, 8);

        Board board = new Board();
        board.addPiece(whiteRook1);
        board.addPiece(whiteRook2);
        board.addPiece(blackRook1);
        board.addPiece(blackRook2);
        board.addPiece(redRook1);
        board.addPiece(redRook2);

        Game game = new Game(board);

        System.out.println(game.getBoard().getAt(3, 8).getColor());

        game.movePiece(board.getAt(5, 4), 5, 10);
        game.movePiece(board.getAt(5, 4), 5, 8);
        game.movePiece(board.getAt(8, 1), 8, 8);
        game.movePiece(board.getAt(3, 8), 1, 8);
        game.movePiece(board.getAt(5, 4), 5, 7);
        game.movePiece(board.getAt(1, 8), 8, 8);

        for (Move move : game.getMoveHistory()) System.out.println(move);
    }
}
