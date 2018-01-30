package minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minesweeper {
		private Playground pg;
	
	public Minesweeper() {
		pg = new Playground(10, 10);
		pg.displayPlayGround();
		this.getInput();
	}

	private void getInput() {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter (a) Color(s)");
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

	private void interpretInput(String s) {
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
			
			pg.inputOn(coordX, coordY);
			
		}
		
	}

	private void help() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Minesweeper ms = new Minesweeper();

	}

}
