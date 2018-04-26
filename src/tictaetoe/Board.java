package tictaetoe;

import java.util.Scanner;

public class Board {
				
	private final char posn[] = new char[10]; //pozycje w tablicy od 1 do 9 - nie moze byc zmieniona dlatego jest jako final 
	private Player currentPlayer; //gracz
	private Player pl1;
	private Player pl2;
	
	private Player winner = null;

	Board() {
		pl1 = new Player("Gracz 1", 'X');
		pl2 = new Player("Gracz 2", 'O');
	}

	Board(String name1, String name2) {
		pl1 = new Player(name1, 'X');
		pl2 = new Player(name2, 'O');
	} 

	public void newBoard()
	{
		//tablica 2D 
		// 3x3
		// 9 pozycji ponumerowanych
		char posndef[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int i;
		currentPlayer = pl1;
		for(i=1; i<10; i++) 
			posn[i]=posndef[i];
		
		System.out.println("Gracz #1 " + pl1.getName() +" będzie pierwszy i będzie jako 'X'" );
		System.out.println("Gracz #2 " + pl2.getName() +" będzie drugi i będzie jako 'O'" );
		showBoard();    
	}

	public  void play()
	{
		int spot;//liczba pola w tablicy
		char blank = ' ';

		do {
			System.out.print("\nGracz " + currentPlayer.getName()+" wybiera pozycję.\nPozycja:" );

			boolean posTaken = true;
			
			while (posTaken) {
				// System.out.println( "position is taken, please enter a valid space");
				Scanner in =new Scanner (System.in);
				spot=in.nextInt();
				posTaken = checkPosn(spot);
				
				if(posTaken==false)
					posn[spot] = currentPlayer.getSign();
				
			}
			showBoard();              // display current board
			checkWinner();
				
			nextPlayer();
		}while (doWeHaveAWinner());
	}

	private boolean checkWinner()
	{
		// sprawdzenie czy X wygrał
		if (posn[1] == 'X' && posn[2] == 'X' && posn[3] == 'X') 
			winner = pl1;
		if (posn[4] == 'X' && posn[5] == 'X' && posn[6] == 'X') 
			winner = pl1;
		if (posn[7] == 'X' && posn[8] == 'X' && posn[9] == 'X') 
			winner = pl1;
		if (posn[1] == 'X' && posn[4] == 'X' && posn[7] == 'X') 
			winner = pl1;
		if (posn[2] == 'X' && posn[5] == 'X' && posn[8] == 'X') 
			winner = pl1;
		if (posn[3] == 'X' && posn[6] == 'X' && posn[9] == 'X')
			winner = pl1;
		if (posn[1] == 'X' && posn[5] == 'X' && posn[9] == 'X') 
			winner = pl1;
		if (posn[3] == 'X' && posn[5] == 'X' && posn[7] == 'X') 
			winner = pl1;
		if (winner != null) {
			System.out.println(pl1.getName() + " - WYGRYWA." );
			return true;
		}

		// sprawdzenie czy O wygrał
		if (posn[1] == 'O' && posn[2] == 'O' && posn[3] == 'O') 
			winner = pl2;
		if (posn[4] == 'O' && posn[5] == 'O' && posn[6] == 'O') 
			winner = pl2;
		if (posn[7] == 'O' && posn[8] == 'O' && posn[9] == 'O') 
			winner = pl2;
		if (posn[1] == 'O' && posn[4] == 'O' && posn[7] == 'O') 
			winner = pl2;
		if (posn[2] == 'O' && posn[5] == 'O' && posn[8] == 'O') 
			winner = pl2;
		if (posn[3] == 'O' && posn[6] == 'O' && posn[9] == 'O')
			winner = pl2;
		if (posn[1] == 'O' && posn[5] == 'O' && posn[9] == 'O') 
			winner = pl2;
		if (posn[3] == 'O' && posn[5] == 'O' && posn[7] == 'O') 
			winner = pl2;
		if (winner != null )
		{
			System.out.println(pl2.getName() + " - WYGRYWA." );
			return true; 
		}

		// sprawdzenie czy jest 1 z 3 wygrania - win dla X czy O albo remis
		for(int i=1;i<10;i++)
		{
			if(posn[i]=='X' || posn[i]=='O')
			{
				if(i==9)
				{
					char Draw='R';
					System.out.println(" R E M I S ");
					return true;
				}
			}
			else
				break;    
		}
		return false;
	}

	private boolean checkPosn(int spot)
	{
		//sprawdzenie czy pozycja zostala uzyta
		//jesli tak - wybierz ponownie
		if (posn[spot] == 'X' || posn[spot] == 'O')
		{
			System.out.println("Wybrana pozycja została uzyta - wybierz ponownie");
			return true;
		} else {
			return false;
		}
	}

	public String showBoard()
	{   
		//wyswietlanie tablicy z numerami pola
		System.out.println(  "\n" );
		System.out.println(  "\t  " + posn [1] + " | " +posn [2]+ "  | " +posn [3]);
		System.out.println(  "\t ___|____|___ " );
		System.out.println(  "\t  " +posn [4]+ " | " +posn [5]+ "  | " +posn [6]);
		System.out.println(  "\t ___|____|___ " );
		System.out.println(  "\t  " +posn [7]+ " | " +posn [8]+ "  | " +posn [9]);
		System.out.println(  "\t    |    |   " );
		System.out.println(  "\n" );
		return "currentBoard";
	}
	
	public  void nextPlayer() {
        if (currentPlayer == pl1)
			currentPlayer = pl2;
        else 
			currentPlayer = pl1;
	}
	
	private boolean doWeHaveAWinner() {
		return winner == null;
	}
}
