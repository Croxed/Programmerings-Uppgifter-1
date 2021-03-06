package eu3_done;

public class ChessboardTest {

	public static void main(String args[])
	{
		ChessboardTest test = new ChessboardTest();
	}

	public ChessboardTest()
	{
		Chessboard chessBoard = new Chessboard ();
		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6]; 
		pieces[0] = chessBoard.new Pawn ('w', 'P');
		pieces[1] = chessBoard.new Rook ('b', 'R');
		pieces[2] = chessBoard.new Queen ('w', 'Q');
		pieces[3] = chessBoard.new Bishop ('w', 'B'); 
		pieces[4] = chessBoard.new King ('b', 'K'); 
		pieces[5] = chessBoard.new Knight ('w', 'N');
		System.out.println("\n Pawn: " + pieces[0] 
				+ "\n Rook: " + pieces[1] 
						+" \n Queen: "+ pieces[2]
								+ "\n Bishop: " + pieces[3]
										+ "\n King: " + pieces[4]
												+ "\n Knight: " + pieces[5]);
	}
}