package gui;

import logic.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PacScorePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public PacWorld game = new PacWorld();
	public JLabel lives, score, pacdots;
	
	public PacScorePanel(){
		
		setBackground(Color.YELLOW);
		setSize(730, 20);
		
		lives = new JLabel("LIVES: " + game.LifeCounter());
		score = new JLabel("SCORE: "+ (game.PacdotCounter(game.pacmaze)));
		pacdots = new JLabel("PACDOTS LEFT: ");
		
		SetLabels();
		
	}
	
	public void SetLabels(){
		//lives = new JLabel("LIVES: ");
		lives.setLocation(0, 0);
		lives.setSize(100, 24);
		lives.setHorizontalAlignment(0);
		lives.setForeground(Color.RED);        
		add(lives);
		
        score.setLocation(305, 0);
        score.setSize(100, 24);
        score.setHorizontalAlignment(0);
        score.setForeground(Color.RED);        
        add(score);
        
        pacdots.setLocation(565, 0);
        pacdots.setSize(100, 24);
        pacdots.setHorizontalAlignment(0);
        pacdots.setForeground(Color.RED);
        add(pacdots);
	}
}
