package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Mastermind {
	
	private final static String[] FARBCODE = {"Rot", "Grün", "Orange", "Gelb", "Blau", "Violett"};
	private final static int CODELENGTH = 4;
	private static ArrayList<Integer> code = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		code = generateCode(CODELENGTH);
		//consoleOutPutArrayList(code);
		Boolean finished = true;
		int versuche = 0;
		while (finished) {
			versuche++;
			ArrayList<Integer> geraten = new ArrayList<Integer>();
			while (geraten.size()<code.size()) {
				geraten = raten(geraten);
				if (geraten.size()>code.size()) {
					System.out.println("Dein input war zu lange, probier doch nochmals!");
					geraten = new ArrayList<Integer>();
				}
			}
			consoleOutPutArrayList(geraten);
			if (ueberpruefung(code, geraten)) {
				finished = false;
			}
		}
		System.out.println("geschafft! Versuche: "+versuche);
			
	}
	
	private static boolean ueberpruefung(ArrayList<Integer> test, ArrayList<Integer> geraten) {
		int supercorrect = 0;
		int correct = 0;
		int[] loesung = {0, 0 , 0, 0};
		for (int i=0;i<test.size();i++) {
			if (test.get(i)==geraten.get(i)) {
				loesung[i] = 1;
			}
		}
		for (int i=0;i<test.size();i++) {
			if (loesung[i] != 1) {
				for (int j=0;j<test.size();j++) {
					if (test.get(j)==geraten.get(i) && loesung[j]==0 ) {
						loesung[j] = 2;
					}
				}
			}
		}
		for (int i=0;i<loesung.length;i++) {
			if (loesung[i]==1) {
				supercorrect++;
			}
			if (loesung[i]==2) {
				correct++;
			}
		}
		if (supercorrect==test.size()) {
			return true;
		} else {
			System.out.println("Anzahl schwarze Sticks: "+ supercorrect);
			System.out.println("Anzahl weisse Sticks: "+ correct);
			return false;
		}
		
	}

	private static ArrayList<Integer> raten(ArrayList<Integer> keya) {
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
        		consoleOutPutArrayList(code);
        		break;
        	default:
        		String[] u = s.split(" ");
        		for (int i = 0;i<u.length;i++) {
        			int number = getFarbeFromString(u[i]);
            		if (number != -1) {
            			keya.add(number);
            		}
        		}
        		
        }
        
        return keya;
		
	}

	private static int getFarbeFromString(String s) {
		int foo = -1;
		try {
			foo = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			for (int i = 0; i<FARBCODE.length;i++) {
				if (FARBCODE[i].equalsIgnoreCase(s)) {
					foo = i;
				}
			}
		}
		if (foo<0 || foo >FARBCODE.length - 1) {
			return -1;
		} else {
			return foo;
		}
		
	}

	private static void help() {
		System.out.println("Du kannst entweder Strings oder Zahlen verwenden um deine Farben zu raten.");
		System.out.println("Dabei gilt folgender Kontext:");
		for (int i = 0; i<FARBCODE.length;i++) {
			System.out.println(FARBCODE[i] + "=" + i);
		}
	}

	private static void consoleOutPutArrayList(ArrayList<Integer> output) {
		for (int i=0;i<output.size();i++) {
			System.out.print(FARBCODE[output.get(i)]);
			System.out.print(" | ");
		}
		System.out.println("");
		
	}

	private static ArrayList<Integer> generateCode(int laenge) {
		Random r = new Random();
		ArrayList<Integer> code = new ArrayList<Integer>();
		for (int i = 0;i<laenge;i++) {
			code.add(r.nextInt(FARBCODE.length));
		}
	
		return code;
	}

}

/*
 * 		int supercorrect = 0;
		int correct = 0;
		ArrayList<Integer> loesung = new ArrayList<Integer>();
		for (int i = 0; i<test.size();i++) {
			if (test.get(i)==geraten.get(i)) {
				if (loesung.contains(geraten.get(i))) {
					correct--;
				}
				loesung.add(geraten.get(i));
				supercorrect++;
				
			} else {
				if (test.contains(geraten.get(i))) {
					correct++;
					if (loesung.contains(geraten.get(i))) {
						correct--;
					} else {
						loesung.add(geraten.get(i));
					}
					
				}
			}
		}
 */
