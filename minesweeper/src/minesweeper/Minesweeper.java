package minesweeper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * 
 *	Diese Klasse beinhaltet zum einen die Konstanten für das Minesweeper auf welche andere Klassen mit gettern Darauf zugreiffen können
 *	Weiterhin ist die Klasse für das korrekte Handling der userinputs zuständig.
 *	@author Mathias Schmid
 *	 
 */
public class Minesweeper {
		private Playground pg;
		private Boolean running = true;
		private final int SIZEX = 20;
		private final int SIZEY = 20;
		private final int BOMBS = 100;
		private final int SCREENSIZE = 800;
		private final boolean CONSOLEOUTPUT = true;
		private boolean gewonnen = false;
	
	

	/**
	 * This is the constructor for Minesweeper. It generates the playground and afterwards listens to user inputs.
	 */
	public Minesweeper() {
		pg = new Playground(SIZEX, SIZEY, this);
		pg.displayPlayGround();
		while (running) {
			this.playCycle();
			if (gewonnen==false) {
				pg.displayPlayGround();
			}
			
		}
	}

	/**
	 * This Method looks for consoler input and interprets them to help or cheat. if both are not valid it gives the data to this.interpretInput() 
	 */
	private void playCycle() {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter Coord");
	        String s = "";
	        
	        try {
	        	s = br.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        interpretInput(s);
		
	}

	private void interpretInput(String s) {
		switch (s) {
			case "help":
				help();
				break;
			case "?":
				help();
				break;
			case "/?":
				help();
				break;
			case "cheat":
				if (pg.getCheat()) {
					pg.setCheat(false);
				} else {
					pg.setCheat(true);
				}
				
				break;
			default:
				interpretInputInteger(s);
		}
	}
	
	/**
	 * This method tries to get 2 coords out of a string. If he finds 2 int from the string splitted by a blank it gives them to input on leftClickOn()
	 * TODO make left and right click possible with console inputs.
	 * @param s - the string to be interpreted
	 */
	public void interpretInputInteger(String s) {
		if (s.split(" ").length==2) {
			String a = s.split(" ")[0];
			String b = s.split(" ")[1];
			int coordX = -1;
			int coordY = -1;
			try {
				coordX = Integer.parseInt(a);
				coordY = Integer.parseInt(b);
			} catch (NumberFormatException e) {
				
			}
			
			leftClickOn(coordX, coordY);
		}
		
	}
	
	/**
	 * this method is there to make changes to the program when the players makes either a leftClick on a panel or a console input.
	 * The Method checks if the player has lost with his input, if not it changes the panel(s) value.
	 * furthermore it shows/updates the playground.
	 * @param coordX the x-coord for the input
	 * @param coordY the y-coord for the input
	 */
	public void leftClickOn(int coordX, int coordY) {
		if (gewonnen) {
			pg.resetPlayground();
			pg.getScreen().resetFontSize();
			gewonnen = false;
			pg.displayPlayGround();
		} else {
			if (CONSOLEOUTPUT) {
				System.out.println("Left click on "+coordX+":"+coordY);
			}
			
			Boolean bombBoolean = pg.inputOn(coordX, coordY);
			if (bombBoolean==true) {
				verloren();
			} else {
				if (pg.checkToWin()) {
					gewonnen();
				}
			}
			if (gewonnen==false) {
				pg.displayPlayGround();
			}
		}
		
		
	}

	private void gewonnen() {
		gewonnen = true;
		System.out.println("gewonnen");
		pg.displayGewonnen();
	}

	private void verloren() {
		System.out.println("verloren");
		gewonnen = true;
		pg.displayVerloren();
	}
	
	/**
	 * This Method interprets a right click on a panel. Therefore it either sets a flag or removes a flag on the coordX/coordY
	 * @param coordX the x-coord for the input
	 * @param coordY the y-coord for the input
	 */
	public void rightClickOn(int coordX, int coordY) {
		if (CONSOLEOUTPUT) {
			System.out.println("Right click on "+coordX+":"+coordY);
		}
		
		pg.setFlag(coordX, coordY);
		pg.displayPlayGround();
	}
	

	/**
	 * this  method helps the player.
	 */
	private void help() {
		System.out.println("Leider kann ich dir nicht helfen");
	}
	
	/**
	 * @return the final this.SCREENSIZE.
	 */
	public int getSCREENSIZE() {
		return SCREENSIZE;
	}
	
	public int getBOMBS() {
		return this.BOMBS;
	}
	
	public boolean isCONSOLEOUTPUT() {
		return CONSOLEOUTPUT;
	}

	public static void main(String[] args) {
		
		testInstanzVariabeln();
		new Minesweeper();
	}

	private static void testInstanzVariabeln() {
		ArrayList<InstanzVariablenTester> InstanzVariabelnTesterArray = new ArrayList<InstanzVariablenTester>();
		InstanzVariabelnTesterArray.add(new InstanzVariablenTester("Erste Klasse"));
		printAllArray(InstanzVariabelnTesterArray);
		System.out.println("-----------------------------------------------");
		System.out.println();
		InstanzVariabelnTesterArray.add(new InstanzVariablenTester("Zweite Klasse"));
		printAllArray(InstanzVariabelnTesterArray);
		
		System.out.println("-----------------------------------------------");
		System.out.println();
		InstanzVariabelnTesterArray.add(new InstanzVariablenTester("Dritte Klasse"));
		printAllArray(InstanzVariabelnTesterArray);
	}

	private static void printAllArray(ArrayList<InstanzVariablenTester> InstanzVariabelnTesterArray) {
		Iterator<InstanzVariablenTester> it = InstanzVariabelnTesterArray.iterator();
		while (it.hasNext()) {
			it.next().printClass();
		}
	}

	public void newGame() {
		
		pg.resetPlayground();
		pg.displayPlayGround();
		
	}

}
