package gui;

import logic.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class PacFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public PacPanel panel;
	public JLabel lives, score, pacdots;
	public JButton play, options, exit;
	
	public PacFrame(){		
		
		panel = new PacPanel(this);
		lives = new JLabel("LIVES: " + panel.game.LifeCounter());
		score = new JLabel("SCORE: ");
		pacdots = new JLabel("PACDOTS LEFT: ");
		
		setTitle("PacMan");
		setSize(1150, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		ButtonsFunctions();
		
		panel.setLayout(null);
		
		add(panel);
		validate();
				
	}
	
	
	public void SetLabels(){
		//lives = new JLabel("LIVES: ");
		lives.setLocation(0, 0);
		lives.setSize(100, 34);
		lives.setHorizontalAlignment(0);
		lives.setForeground(Color.RED);
        panel.add(lives);
        
        
        score.setLocation(305, 0);
        score.setSize(100, 34);
        score.setHorizontalAlignment(0);
        score.setForeground(Color.RED);
        panel.add(score);
        
        
        pacdots.setLocation(565, 0);
        pacdots.setSize(100, 34);
        pacdots.setHorizontalAlignment(0);
        pacdots.setForeground(Color.RED);
        panel.add(pacdots);
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
			setSize(730, 732); //width, height
			panel.remove(play);
			panel.remove(options);
			panel.remove(exit);
			SetLabels();
			add(panel);
		}
	}

}
