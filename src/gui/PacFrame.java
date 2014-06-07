package gui;

import logic.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**	
 * Classe que cria a janela de jogo e coloca os panels necessarios
 */
public class PacFrame extends JFrame {

	/**	Default Serial Version ID */
	private static final long serialVersionUID = 1L;
	
	/**	Objeto do panel principal */
	public PacPanel panel;
	
	/**	Objeto do panel com as labels */
	public PacScorePanel scorepanel;
	
	/**	3 Botoes necessarios no menu principal */
	public JButton play, options, exit;
	
	/**	Objeto da classe Pacworld (parte logica) */
	public PacWorld game = new PacWorld();
	
	/**	
	 * Construtor da Classe
	 */
	public PacFrame(){		
		
		panel = new PacPanel(this);
		scorepanel = new PacScorePanel();
		
		setTitle("PacMan");
		setSize(1150, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		ButtonsFunctions();
		
		panel.setLayout(null);
		scorepanel.setLayout(null);
		
		add(panel);
		
		validate();
				
	}
		
	
	/**	
	 * Metodo que inicializa e coloca o local certo os botoes 
	 */
	public void SetButtons(){		
		play = new JButton("Play");
		play.setBounds(420, 74, 150, 50);
		play.setBackground(Color.BLUE);
		play.setForeground(Color.BLACK);
		
		options = new JButton("Options");
		options.setBounds(520, 280, 150, 50);
		options.setBackground(Color.YELLOW);
		options.setForeground(Color.BLACK);
		
		exit = new JButton("Exit");
		exit.setBounds(620, 479, 150, 50);
		exit.setBackground(Color.RED);
		exit.setForeground(Color.BLACK);
	}
	
	
	/**	
	 * Metodo que controla as funcoes de cada botao
	 */
	public void ButtonsFunctions(){
		SetButtons();		
		play.addActionListener(new BPlay());
		exit.addActionListener(new BExit());
		panel.add(play);
		panel.add(options);
		panel.add(exit);		
	}	


	/**	
	 * Classe utilizada para definir a açao exucutada pelo botao Play
	 */
	public class BPlay implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panel.BeginGame();
			setSize(730, 731); //width, height
			panel.remove(play);
			panel.remove(options);
			panel.remove(exit);
			
			add(scorepanel);
			add(panel);
			repaint();
		}
	}
	
	
	/**	
	 * Classe utilizada para definir a açao exucutada pelo botao Exit
	 */
	public class BExit implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
