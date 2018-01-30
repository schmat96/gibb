package minesweeper;

public class Playground {
	private int sizeX;
	private int sizeY;
	private int[][] playground;
	private boolean[][] bombs;
	
	public Playground(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.playground = new int[sizeX+1][sizeY+1];
		this.resetPlayground();
	}
	
	public void resetPlayground() {
		for (int i=0;i<this.sizeX;i++) {
			for (int j=0;j<this.sizeY;j++) {
				playground[i][j] = 0;
				bombs[i][j] = false;
			}
		}
	}
	
	public void displayPlayGround() {
		for (int i=0;i<this.sizeX;i++) {
			for (int j=0;j<this.sizeY;j++) {
				System.out.print(playground[i][j]);
			}
			System.out.println();
		}
	}

	public void inputOn(int coordX, int coordY) {
		// TODO Auto-generated method stub
		
	}
}
