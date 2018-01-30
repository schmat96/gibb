package minesweeper;

import java.util.Random;

public class Playground {
	private int sizeX;
	private int sizeY;
	private int[][] playground;
	private boolean[][] bombs;
	
	public Playground(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.playground = new int[sizeX+1][sizeY+1];
		this.bombs = new boolean[sizeX+1][sizeY+1];
		this.resetPlayground();
	}
	
	public void resetPlayground() {
		Random rnd = new Random();
		for (int i=0;i<this.sizeX;i++) {
			for (int j=0;j<this.sizeY;j++) {
				playground[i][j] = 0;
				if (rnd.nextInt(5)==2) {
					bombs[i][j] = true;
				} else {
					bombs[i][j] = false;
				}
				
			}
		}
	}
	
	public void displayPlayGround() {
		for (int i=0;i<this.sizeX;i++) {
			for (int j=0;j<this.sizeY;j++) {
				String s = Integer.toString(playground[i][j]);
				if (s.length()==2) {
					System.out.print(playground[i][j]+ "|");
				} else {
					System.out.print("+" + playground[i][j]+ "|");
				}
				
			}
			System.out.println();
		}
	}

	public boolean inputOn(int coordX, int coordY) {
		if (bombs[coordX][coordX]==true) {
			return true;
		}
		aufdecken(coordX, coordY);
		
		return false;
		
	}

	private void aufdecken(int coordX, int coordY) {
		playground[coordX][coordY]=-1;
		int anzahl = 0;
		for (int i=-1;i<=1;i++) {
			for (int j=-1;j<=1;j++) {
				try {
					if (bombs[coordX+i][coordY+j]==true) {
						anzahl++;
					} 
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}
				
			}
		}
		if (anzahl==0) {
			for (int i=-1;i<=1;i++) {
				for (int j=-1;j<=1;j++) {
					try {
						if (playground[coordX+i][coordY+j]==0) {
							aufdecken(coordX+i, coordY+j);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
				}
			}
			
		} else {
			playground[coordX][coordY]=anzahl;
		}
		
		
		
	}
}
