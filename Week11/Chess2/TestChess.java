public class TestChess {
    public static void main(String[] args) {
        Piece whiteBishop1 = new Bishop(5, 4);
        Piece whiteBishop2 = new Bishop(7, 1, "white");
        Piece blackBishop1 = new Bishop(4, 8, "black");
        Piece blackBishop2 = new Bishop(7, 6, "black");
        Piece redBishop1 = new Bishop(0, 0);
        Piece redBishop2 = new Bishop(4, 8);

        Board board = new Board();
        board.addPiece(whiteBishop1);
        board.addPiece(whiteBishop2);
        board.addPiece(blackBishop1);
        board.addPiece(blackBishop2);
        board.addPiece(redBishop1);
        board.addPiece(redBishop2);

        Game game = new Game(board);

        System.out.println(game.getBoard().getAt(4, 8).getColor());

        game.movePiece(board.getAt(5, 4), 8, 7);
        game.movePiece(board.getAt(5, 4), 7, 6);
        game.movePiece(board.getAt(7, 1), 2, 6);
        game.movePiece(board.getAt(4, 8), 1, 5);
        game.movePiece(board.getAt(4, 8), 3, 7);
        game.movePiece(board.getAt(3, 7), 2, 6);

        for (Move move : game.getMoveHistory()) System.out.println(move);
    }
}
