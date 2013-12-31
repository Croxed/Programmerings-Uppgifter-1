package eu3_done;

public class ReachableFieldsOnChessboard {

	public static void main(String[] args)
	{
		ReachableFieldsOnChessboard example = new ReachableFieldsOnChessboard();
	}

	public ReachableFieldsOnChessboard()
	{
		Chessboard chessBoard = new Chessboard ();
		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6]; 
		pieces[0] = chessBoard.new Pawn ('w', 'P');
		pieces[1] = chessBoard.new Rook ('b', 'R');
		pieces[2] = chessBoard.new Queen ('w', 'Q');
		pieces[3] = chessBoard.new Bishop ('w', 'B'); 
		pieces[4] = chessBoard.new King ('b', 'K');
		pieces[5] = chessBoard.new Knight ('w', 'N');

		for(int i = 0; i < pieces.length; i++)
		{
			try 
			{
				pieces[i].moveTo(pieces[i].row, pieces[i].column);
				pieces[i].markReachableFields();
				System.out.println(chessBoard);
				pieces[i].unmarkReachableFields();
				pieces[i].moveOut();
			} catch (NotValidFieldException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
