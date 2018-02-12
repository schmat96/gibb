package minesweeper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minesweeper {
		private Playground pg;
		private Boolean running = true;
		private final int SIZEX = 10;
		private final int SIZEY = 10;
		private final int BOMBS = 10;
		private final int SCREENSIZE = 800;
		private final boolean CONSOLEOUTPUT = false;
	
	

	public Minesweeper() {
		pg = new Playground(SIZEX, SIZEY, this);
		pg.displayPlayGround();
		while (running) {
			this.getInput();
			pg.displayPlayGround();
		}
	}

	private void getInput() {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter Coord");
	        String s = "";
	        
	        try {
	        	s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	        		interpretInput(s, 0);
	        }
		
	}

	public void interpretInput(String s, int taste) {
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
	
	public void leftClickOn(int coordX, int coordY) {
		if (CONSOLEOUTPUT) {
			System.out.println("Left click on "+coordX+":"+coordY);
		}
		
		Boolean hue = pg.inputOn(coordX, coordY);
		if (hue==true) {
			System.out.println("verloren");
			pg.close();
			pg = new Playground(SIZEX, SIZEY, this);
			pg.displayVerloren();
		} else {
			if (pg.checkToWin()) {
				System.out.println("gewonnen");
				pg.displayGewonnen();
			}
		}
		pg.displayPlayGround();
	}
	
	public void rightClickOn(int coordX, int coordY) {
		if (CONSOLEOUTPUT) {
			System.out.println("Right click on "+coordX+":"+coordY);
		}
		
		pg.setFlag(coordX, coordY);
		pg.displayPlayGround();
	}

	private void help() {
		// TODO Auto-generated method stub
	}
	
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
		Minesweeper ms = new Minesweeper();

	}

}
