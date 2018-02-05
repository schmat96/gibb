package minesweeper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minesweeper {
		private Playground pg;
		private Boolean running = true;
		private final int SIZE = 20;
	
	public Minesweeper() {
		pg = new Playground(SIZE, SIZE, this);
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
	        		help();
	        		break;
	        	default:
	        		interpretInput(s);
	        }
		
	}

	public void interpretInput(String s) {
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
			Boolean hue = pg.inputOn(coordX, coordY);
			if (hue==true) {
				System.out.println("verloren");
				pg = new Playground(SIZE, SIZE, this);
				pg.displayVerloren();
			} else {
				
			}
			pg.displayPlayGround();
		}
		
	}

	private void help() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Minesweeper ms = new Minesweeper();

	}

}
