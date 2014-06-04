package gui;

import logic.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class PacPanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	ImageIcon imageicon;
	Image image;
	ImageIcon Gameover;	
	Image Wallpaper;
	Image Floor;
	Image Wall;
	Image Pacdot;
	Image SpecialDot;
	Image PacmanInit;
	Image Pacman_Right;
	Image Pacman_Up;
	Image Pacman_Left;
	Image Pacman_Down;
	Image Ghost;
	PacWorld game;
	
	PacFrame frame;
	
	boolean estado;
	
	public PacPanel(PacFrame pacframe){
		
		frame = pacframe;
		estado = true;
		game = new PacWorld();
		LoadImages();
		addKeyListener(this);
		
	}
	
	//Funçao que carrega as imagens necessarias para o jogo
	public void LoadImages(){
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/wallpaper.jpg"));
		Wallpaper = imageicon.getImage();		

		imageicon = new ImageIcon(this.getClass().getResource("/images/floor.png"));
		Floor = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/wall.png"));
		Wall = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/pacman_right.png"));
		PacmanInit = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/pacman_right.png"));
		Pacman_Right = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/pacman_up.png"));
		Pacman_Up = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/pacman_left.png"));
		Pacman_Left = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/pacman_down.png"));
		Pacman_Down = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/ghost_blue.png"));
		Ghost = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/pacdot.jpg"));
		Pacdot = imageicon.getImage();
		
		imageicon = new ImageIcon(this.getClass().getResource("/images/specialpacdot.png"));
		SpecialDot = imageicon.getImage();
		
		Gameover = new ImageIcon(this.getClass().getResource("/images/gameover.jpg"));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if ( estado )
			g.drawImage(Wallpaper, 0,0 ,getWidth(),getHeight(), null);
		
		else {
			PaintMaze(g2);
			PaintObjects(g2);
		}		
	}
	
	public void PaintImage(Graphics2D g2, int x, int y, char s){
		
		int imageWidth = (getWidth() / game.pacmaze.length);
		int imageHeight = (getHeight() / game.pacmaze.length);

		switch (s) {
		case 'X':
			image = Wall;
			break;
		case ' ':
			image = Floor;
			break;
		case 'P':
			image = PacmanInit;
			break;
		case 'D':
			image = Pacdot;
			break;
		case 'S':
			image = SpecialDot;
			break;
		case 'G':
			image = Ghost;
			break;
		case 'N':
			image = Floor;
			break;
		}

		g2.drawImage(image, x * imageWidth, y * imageHeight, imageWidth, imageHeight, null);

	}
	
	public void PaintMaze(Graphics2D g2){
		
		char maze[][] = game.pacmaze;
		
		for ( int i = 0; i < maze.length; i++ ){
			for ( int j = 0; j < maze[i].length; j++ ){
					PaintImage(g2, j, i, maze[i][j]);
			}
		}
	}
	
	public void PaintObjects(Graphics2D g2){
		
		char maze[][] = game.NewPacmaze();
		
		for ( int i = 0; i < maze.length; i++ ){
			for ( int j = 0; j < maze[i].length; j++ ){
				
				if ( maze[i][j] == game.dots.symbol)
					PaintImage(g2, j, i, game.dots.symbol);
				
				else if ( maze[i][j] == game.pacman.symbol)
					PaintImage(g2, j, i, game.pacman.symbol);
				
				else if ( maze[i][j] == game.lsd1.symbol)
					PaintImage(g2, j, i, game.lsd1.symbol);
				
				else if ( maze[i][j] == game.ghost.symbol)
					PaintImage(g2, j, i, game.ghost.symbol);

			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		//Object[] options = { "Okay :(", "I will never surrender!" };
		int keycode = e.getKeyCode();

		if (keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W){
			game.MovePacman(-1, 0);
			game.MoveGhost();
			PacmanInit = Pacman_Up;
		}
		else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			game.MovePacman(0, 1);
			game.MoveGhost();
			PacmanInit = Pacman_Right;
		}
		else if (keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S){
			game.MovePacman(1, 0);
			game.MoveGhost();
			PacmanInit = Pacman_Down;
		}
		else if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A){
			game.MovePacman(0, -1);
			game.MoveGhost();
			PacmanInit = Pacman_Left;
		}
		
		if ( game.SamePosition() ){
			JOptionPane.showMessageDialog(null, null, "GAMEOVER", JOptionPane.INFORMATION_MESSAGE, Gameover);
			estado = true;
	        frame.setSize(1150, 650);
	        frame.ButtonsFunctions();
	        frame.setLocationRelativeTo(null);
		}
		
		validate();
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}
	
	
	//Funcao que muda o Wallpaper inicial para o jogo.
	public void BeginGame(){
		estado = false;
		setRequestFocusEnabled(true);
		requestFocus();
	}
	
	
}