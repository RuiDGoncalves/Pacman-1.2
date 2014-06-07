package gui;

import logic.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**	
 * Classe que cria um panel para colocar as vidas, o score e os pacdots restantes
 */
public class PacScorePanel extends JPanel {

	/**	Default Serial Version ID */
	private static final long serialVersionUID = 1L;
	
	/** Objeto da classe Pacworld (parte logica) */
	public PacWorld game = new PacWorld();
	
	/** Labels do numero de vidas, score e pacdots */
	public JLabel lives, score, pacdots;
	
	/** 
	 * Construtor da Classe
	 * 
	 *  Inicializa as labels
	 */
	public PacScorePanel(){
		
		setBackground(Color.YELLOW);
		setSize(730, 20);
		
		lives = new JLabel("LIVES: " + game.LifeCounter());
		score = new JLabel("SCORE: "+ (game.PacdotCounterA(game.pacmaze))*100);
		pacdots = new JLabel("PACDOTS: " + (game.PacdotCounterB(game.pacmaze)));
		
		SetLabels();
		repaint();
		requestFocus();
		
	}
	
	/** 
	 * Metodo que coloca as labels nos locais corretos 
	 * */
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
