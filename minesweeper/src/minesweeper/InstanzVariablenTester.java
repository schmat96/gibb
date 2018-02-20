package minesweeper;

public class InstanzVariablenTester {
	public int counter = 0;
	public static int counter2 = 0;
	private String name;
	
	public InstanzVariablenTester(String name) {
		counter++;
		counter2++;
		this.name = name;
	}
	
	public void printClass() {
		System.out.println("Klasse: "+name);
		System.out.println(" Instanzvariable: "+counter);
		System.out.println(" Instanzvariable: "+counter2);
		System.out.println();
		
		
	}
}
