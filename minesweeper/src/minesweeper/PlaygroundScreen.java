package minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class PlaygroundScreen {
	
	
	private JLabel[][] labels;
	private JFrame fenster;
	private JPanel panel;
	
	private final int SCREENSIZE;
	
	private Minesweeper ms;
	
	public PlaygroundScreen(int sizeX, int sizeY, Minesweeper ms, int screensize) {
		labels = new JLabel[sizeX+1][sizeY+1];
		this.ms = ms;
		this.SCREENSIZE = screensize;
	}
	
	Runnable guiCreator = new Runnable() {
        public void run() {

        	fenster = new JFrame("Minesweeper");

            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            panel = new JPanel();
            panel.setBackground(new Color(240, 240, 240));
            panel.setLayout(new GridBagLayout());
            panel.setPreferredSize(new Dimension(400,400));
            GridBagConstraints c = new GridBagConstraints();

           

            
            for (int i = 0; i<labels.length-1;i++) {
            	for (int j = 0; j<labels.length-1;j++) {
            		JLabel labelBombs = new JLabel("0", SwingConstants.CENTER);
            		int labelSize = Math.round(SCREENSIZE/labels.length)-5;
            		
                    Font labelFont = labelBombs.getFont();
                    labelBombs.setFont(new Font(labelFont.getName(), Font.PLAIN, labelSize-10));
                    labelBombs.setOpaque(true);
            		labelBombs.setPreferredSize(new Dimension(labelSize, labelSize));
            		labelBombs.setBackground(new Color(30, 10, 5));
            		labelBombs.setForeground(new Color(255,255,200));
            		Border blackline = BorderFactory.createLineBorder(Color.black);
            		labelBombs.setBorder(blackline);
            		labelBombs.addMouseListener(new mouseListener(labelBombs, i, j, ms));
            		labels[i][j] = labelBombs;
            		c.gridx = i;
            		c.gridy = j;
            		panel.add(labels[i][j], c);
            	}
            }
            
            
    		fenster.add(panel);
    		
    		panel.validate();

            fenster.setSize(SCREENSIZE, SCREENSIZE);
            fenster.setVisible(true);
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
				case "-1":
					labels[i][j].setText("#");
					labels[i][j].setBackground(new Color(100, 100, 100));
					break;
				default:
					labels[i][j].setBackground(new Color((30*(Integer.parseInt(k)+1))%255, (10*(Integer.parseInt(k)+1))%255, (5*(Integer.parseInt(k)+1))%255));
					labels[i][j].setText(k);
			}
			
		}
		
		
	}

	public void clear() {
		
		
	}

	public void close() {
		fenster.dispose();
		
	}

	public void displayGewonnen() {
		panel.removeAll();
		panel.repaint();
		JLabel jp = new JLabel("gewonnen");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		panel.add(jp, c);
		fenster.validate();
		fenster.repaint();
	}  
}




