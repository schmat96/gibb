package minesweeper;

import java.awt.Color;
import java.awt.Dimension;
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
	
	private final int SCREENSIZE = 500;
	
	private Minesweeper ms;
	
	public PlaygroundScreen(int sizeX, int sizeY, Minesweeper ms) {
		labels = new JLabel[sizeX+1][sizeY+1];
		this.ms = ms;
	}
	
	Runnable guiCreator = new Runnable() {
        public void run() {

        	fenster = new JFrame("Minesweeper");

            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            panel = new JPanel();
            panel.setBackground(new Color(200, 200, 200));
            panel.setLayout(new GridBagLayout());
            panel.setPreferredSize(new Dimension(400,400));
            GridBagConstraints c = new GridBagConstraints();

            
            for (int i = 0; i<labels.length-1;i++) {
            	for (int j = 0; j<labels.length-1;j++) {
            		JLabel labelBombs = new JLabel("0", SwingConstants.CENTER);
            		int labelSize = Math.round(SCREENSIZE/labels.length)-5;
            		labelBombs.setPreferredSize(new Dimension(labelSize, labelSize));
            		labelBombs.setBackground(new Color(j, 200, 200));
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
			labels[i][j].setText(k);
			panel.validate();
			fenster.validate();
		}
		
		
	}

	public void clear() {
		
		
	}  
}




