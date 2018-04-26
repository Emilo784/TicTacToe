
package tictaetoe;


public class Player{
	//nazwa gracza

	private String name;
	private char XorO;


	Player(String in1, char sign) {//konstruktor
		name = in1;//nazwa gracza
		XorO = sign;//znak gracza
	}	

	public String getName() {
		return name;
	}

	public char getSign() {
		return XorO;
	}
}
