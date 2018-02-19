package minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class PlaygroundScreen {
	
	
	private JLabel[][] labels;
	private JFrame fenster;
	private JPanel panel;
	private JLabel jLabelGewonnen = null;
	
	private final int SCREENSIZE;
	private final int SIZEX;
	private final int SIZEY;
	
	private int schriftGroesse;
	private Font labelFont;
	
	private Minesweeper ms;
	
	public PlaygroundScreen(int sizeX, int sizeY, Minesweeper ms) {
		labels = new JLabel[sizeX+1][sizeY+1];
		this.SIZEX = sizeX;
		this.SIZEY = sizeY;
		this.ms = ms;
		this.SCREENSIZE = ms.getSCREENSIZE();
	}
	
	Runnable guiCreator = new Runnable() {
        public void run() {

        	fenster = new JFrame("Minesweeper");

            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            panel = new JPanel();
            panel.setBackground(new Color(240, 240, 240));
            panel.setPreferredSize(new Dimension(SCREENSIZE, SCREENSIZE));
            panel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            int labelSizeX = Math.round(SCREENSIZE/SIZEX)-5;
    		int labelSizeY = Math.round(SCREENSIZE/SIZEY)-5;
    		schriftGroesse = getSchriftgroesse(labelSizeX, labelSizeY);
    		
            
            for (int i = 0; i<SIZEX;i++) {
            	for (int j = 0; j<SIZEY;j++) {
            		newLabelBombs(c, labelSizeX, labelSizeY, schriftGroesse, i, j);
            	}
            }
            
            
    		fenster.add(panel);
    		panel.validate();
            fenster.setSize(SCREENSIZE, SCREENSIZE);
            fenster.setVisible(true);
        }

		private int getSchriftgroesse(int labelSizeX, int labelSizeY) {
			int schriftGroesse;
			if (labelSizeX>labelSizeY) {
    			schriftGroesse = labelSizeY;
    		} else {
    			schriftGroesse = labelSizeX;
    		}
			return schriftGroesse;
		}

		private void newLabelBombs(GridBagConstraints c, int labelSizeX, int labelSizeY, int schriftGroesse, int i,
				int j) {
			JLabel labelBombs = new JLabel("#", SwingConstants.CENTER);
			labelFont = labelBombs.getFont();
			labelBombs.setFont(new Font(labelFont.getName(), Font.PLAIN, schriftGroesse-5));
			labelBombs.setOpaque(true);
			labelBombs.setPreferredSize(new Dimension(labelSizeX, labelSizeY));
			labelBombs.validate();
			labelBombs.setBackground(new Color(100, 100, 100));
			labelBombs.setForeground(new Color(255,255,200));
			Border blackline = BorderFactory.createLineBorder(Color.black);
			labelBombs.setBorder(blackline);
			labelBombs.addMouseListener(new mouseListener(labelBombs, i, j, ms));
			labels[i][j] = labelBombs;
			c.gridx = i;
			c.gridy = j;
			panel.add(labels[i][j], c);
		}
    };

	public void startGui() {
		SwingUtilities.invokeLater(guiCreator);	
	}

	public void setLabel(int i, int j, String k) {
		if (labels[i][j]!=null) {
			switch (k) {
				case "flag":
					labels[i][j].setText("@");
					labels[i][j].setBackground(new Color(200, 200, 200));
					
					break;
				case "bomb":
					labels[i][j].setText("B");
					labels[i][j].setBackground(new Color(0, 200, 0));
					break;
				case "0":
					labels[i][j].setText("#");
					labels[i][j].setBackground(new Color(100, 100, 100));
					break;
				case "-1":
					labels[i][j].setText("0");
					labels[i][j].setBackground(new Color(30, 10, 5));
					break;
				default:
					labels[i][j].setBackground(new Color((30*(Integer.parseInt(k)+1))%255, (10*(Integer.parseInt(k)+1))%255, (5*(Integer.parseInt(k)+1))%255));
					labels[i][j].setText(k);
			}
			
		}
		
		
	}
	
	public void resetFontSize() {
		for (int i = 0; i<SIZEX;i++) {
        	for (int j = 0; j<SIZEY;j++) {
        		labels[i][j].setFont(new Font(labelFont.getName(), Font.PLAIN, schriftGroesse-5));
        	}
		}
	}
	
	public void setLabelString(int i, int j, String k, int schriftGrosse) {
		Font labelFont = labels[i][j].getFont();
		labels[i][j].setFont(new Font(labelFont.getName(), Font.PLAIN, schriftGrosse));
		labels[i][j].setText(k);
		labels[i][j].setBackground(new Color(100,100,0));
		
	}

	public void clear() {
		
		
	}

	public void close() {
		fenster.dispose();
		
	}
	
	public void animation(String s, int line) {
		int charPerLabel = 1;
		int offset = 0;
		while (true) {
			if (Math.round(s.length()/charPerLabel)<this.SIZEX) {
				break;
			} else {
				charPerLabel++;
			}
		}
		
		if (this.SIZEX*charPerLabel>s.length()) {
			offset = Math.round((this.SIZEX*charPerLabel-s.length())/(2*charPerLabel));
		}
		
		int atChar = s.length()/charPerLabel;
		for  (int i=0;i<atChar;i++) {
			String a = "";
			try {
				a = s.substring(i*charPerLabel, (i+1)*charPerLabel);
			} catch (StringIndexOutOfBoundsException e) {
				a = "A";
			}
			
			
			this.setLabelString(i+offset, line, a, 25-Math.round((charPerLabel*3)));
		}
		
		panel.validate();
		
		


	}

	public void displayGewonnen() {
		animation("gewonnen", 2);
		animation("Richtig Awesome", 4);
		animation("Neues Spiel?", 6);
	}


	public void displayVerloren() {
		animation("verloren", 2);
		animation("Das war schlecht", 4);
		animation("Neues Spiel?", 6);
		
	}  
}




