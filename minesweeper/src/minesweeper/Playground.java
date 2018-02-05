package minesweeper;

import java.util.Random;

public class Playground {
	private int sizeX;
	private int sizeY;
	private int[][] playground;
	private boolean[][] markierungen;
	private boolean[][] bombs;
	private PlaygroundScreen screen;
	private final int BOMBS;
	
	public Playground(int sizeX, int sizeY, Minesweeper ms, int bombs, int screensize) {
		screen = new PlaygroundScreen(sizeX, sizeY, ms, screensize);
		screen.startGui();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.BOMBS = bombs;
		this.playground = new int[sizeX+1][sizeY+1];
		this.bombs = new boolean[sizeX+1][sizeY+1];
		this.markierungen = new boolean[sizeX+1][sizeY+1];
		this.resetPlayground();
	}
	
	public void resetPlayground() {
		Random rnd = new Random();
		for (int i=0;i<this.sizeX;i++) {
			for (int j=0;j<this.sizeY;j++) {
				playground[i][j] = 0;
				if (rnd.nextInt(BOMBS)==1) {
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
							if (markierungen[i][j]) {
								screen.setLabel(i,j,"flag");
							} else {
								screen.setLabel(i,j,playground[i][j]+"");
							}
							
						} else {
							if (markierungen[i][j]) {
								screen.setLabel(i,j,"flag");
							} else {
								screen.setLabel(i,j,playground[i][j]+"");
							}
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

	public void close() {
		screen.close();
		
	}

	public Boolean checkToWin() {
		for (int i=0;i<sizeX;i++) {
			for (int j=0;j<sizeY;j++) {
				if (playground[i][j] == 0 && bombs[i][j] == false) {
					return false;
				}
			}
		}
		return true;
	}

	public void displayGewonnen() {
		screen.displayGewonnen();
		
	}

	public void setFlag(int coordX, int coordY) {
		if (markierungen[coordX][coordY]) {
			markierungen[coordX][coordY] = false;
		} else {
			markierungen[coordX][coordY] = true;
		}
		
		
	}
}
