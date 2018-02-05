package minesweeper;

import java.util.Random;

public class Playground {
	private int sizeX;
	private int sizeY;
	private int[][] playground;
	private boolean[][] bombs;
	private PlaygroundScreen screen;
	
	public Playground(int sizeX, int sizeY, Minesweeper ms) {
		screen = new PlaygroundScreen(sizeX, sizeY, ms);
		screen.startGui();
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
				if (rnd.nextInt(10)==2) {
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
					if (screen!=null) {
						if (bombs[i][j] == true) {
							screen.setLabel(i,j,playground[i][j]+"");
						} else {
							screen.setLabel(i,j,playground[i][j]+"");
						}
						
					}
				
			}
		}
	}

	public boolean inputOn(int coordX, int coordY) {
		if (bombs[coordX][coordY]==true) {
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

	public void displayVerloren() {
	
		
	}
}
