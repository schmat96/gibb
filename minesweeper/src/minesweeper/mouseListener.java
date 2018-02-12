package minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class mouseListener implements MouseListener {
	
	JLabel label;
	private int x;
	private int y;
	private Minesweeper ms;

	public mouseListener(JLabel label, int i, int j, Minesweeper ms) {
		this.label = label;
		this.x = i;
		this.y = j;
		this.ms = ms;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			ms.rightClickOn(x, y);
			
		} else {
			ms.leftClickOn(x, y);
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
