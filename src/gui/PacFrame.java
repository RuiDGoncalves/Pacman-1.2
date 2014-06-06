package gui;

import logic.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PacFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public PacPanel panel;
	public PacScorePanel scorepanel;
	public JButton play, options, exit;
	public JLabel lives, score, pacdots;
	
	public PacWorld game = new PacWorld();
	
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
	
	
	public void ButtonsFunctions(){
		SetButtons();		
		play.addActionListener(new BPlay());
		panel.add(play);
		panel.add(options);
		panel.add(exit);
		
	}	


	//Classe utilizada para definir a a�ao exucutada pelo botao New Game
	public class BPlay implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panel.BeginGame();
			setSize(730, 731); //width, height
			panel.remove(play);
			panel.remove(options);
			panel.remove(exit);
			
			add(scorepanel);
			add(panel);			
		}
	}

}
