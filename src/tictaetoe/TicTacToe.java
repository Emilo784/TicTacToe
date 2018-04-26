package tictaetoe;

import java.util.Scanner;

// PROJEKT Z "Języki i paradygmaty programowania"
// ES, DW
// 2016/2017 semestr 3
// ID1/III

public class TicTacToe {

    
    public static void main(String args[]) {
        String ch; //zmienna do znakow
		
		Board board = new Board("Emil", "Dagmara");
		
        do{
            board.newBoard();//nowa tablica
            board.play();
			
            System.out.println ("Zagrać ponownie (wpisz 'y')? ");
            Scanner in =new Scanner(System.in);
            ch=in.nextLine();//wyswietlenie wyboru w nowej linii
            System.out.println("Twój wybór to:  "+ch);
        }while (ch.equalsIgnoreCase("y"));
    }
}
