package logic;

import java.util.Random;
import java.util.Scanner;

/** 
 * Classe principal da parte logica do jogo
 * 
 * Responsavel por criar e colocar os objetos no labirinto
 * 
 * Responsavel pelos movimentos do pacman e do fantasma
 * 
 */
public class PacWorld {
	/** Labirinto */
	public char pacmaze[][];
	
	/** Objeto Pacman */
	public PacMan pacman;
	
	/** Objecto Dots */
	public PacDot dots;
	
	/** 4 Objetos que representam os Specialdots */
	public PacSpecialDot lsd1, lsd2, lsd3, lsd4;
	
	/** Objeto Fantasma */
	public PacGhost ghost;
	
	/** Contadores de pacdots */
	public int dots_countA, dots_countB, specialdots_count;
	
	/** 
	 * Contrutor da Classe
	 * 
	 * Cria o labirinto e coloca todos os objetos necessarios para o jogo
	 * 
	 */
	public PacWorld(){
		char maze[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
						 {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'N', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'N', 'N', 'N', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', ' ', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
						 {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						 {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }};
		
		pacmaze = maze;
		
		pacman = new PacMan(pacmaze, 10, 14);
		dots = new PacDot(pacmaze);
		lsd1 = new PacSpecialDot( pacmaze, 1, 1);
		lsd2 = new PacSpecialDot( pacmaze, 19, 1);
		lsd3 = new PacSpecialDot( pacmaze, 1, 19);
		lsd4 = new PacSpecialDot( pacmaze, 19, 19);
		ghost = new PacGhost(pacmaze, 10, 7);
		
		lsd1.SetSymbol(pacmaze);
		lsd2.SetSymbol(pacmaze);
		lsd3.SetSymbol(pacmaze);
		lsd4.SetSymbol(pacmaze);
		SetPacdots(pacmaze);		
		pacman.SetSymbol(pacmaze);
		ghost.SetSymbol(pacmaze);
	}
	
	
	/** 
	 * Metodo Responsavel por imprimir o labirinto na consola
	 */
	public void DisplayPacworld()
	{
		for ( int i = 0; i < pacmaze.length; i++ ){
			for( int j = 0; j < pacmaze[i].length; j++ ){
				System.out.print(pacmaze[i][j]);

				if ( j != ( pacmaze[i].length - 1) )
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 *  Troca todos os simbolos ' ' por pacdots
	 *  
	 *  @param maze Labirinto
	 *  
	 */
	public void SetPacdots(char maze[][]){
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( maze[i][j] == ' ' )
					maze[i][j] = dots.symbol;					
			}		
		}
	}
	
	
	/** 
	 * Procura a matriz por algum pacdot
	 * 
	 * @param maze Labirinto
	 * 
	 */
	public boolean SearchPacdot(char maze[][]){
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( maze[i][j] == dots.symbol || maze[i][j] == lsd1.symbol )
					return true;
			}		
		}
			
		return false;
	}
	
	
	
	/** 
	 * Metodo responsavel pelo movimento do pacman
	 * 
	 *  @param x Movimento realizado no sentido vertical
	 *  
	 *  @param y Movimento realizado no sentido horizontal
	 *  
	 */
	public void MovePacman(int x, int y){
		
		if ( pacman.CheckWall(pacmaze, x, y) && pacman.CheckNFloor(pacmaze, x, y) ){
			pacmaze[pacman.column][pacman.line] = ' ';
			pacmaze[pacman.column+x][pacman.line+y] = pacman.symbol;
			pacman.MoveObject(x, y);
		}
	}		
		
	
	/** 
	 * Metodo responsavel pelo movimento do fantasma 
	 */
	public void MoveGhost(){
		Random random = new Random();
		int randNumber = random.nextInt(4) + 1;
		
		int x = 0;
		int y = 0;

		switch (randNumber) {

		case 1:
			x = 0;
			y = 1;
			break;
		case 2:
			x = 1;
			y = 0;
			break;
		case 3:
			x = 0;
			y = -1;
			break;
		case 4:
			x = -1;
			y = 0;
			break;
		}
			
			if ( pacmaze[ghost.column+x][ghost.line+y] == 'D' ){
				pacmaze[ghost.column][ghost.line] = 'D';
				pacmaze[ghost.column+x][ghost.line+y] = ghost.symbol;
				ghost.MoveObject(x, y);
			}

			else if ( pacmaze[ghost.column+x][ghost.line+y] == ' ' ){
				pacmaze[ghost.column][ghost.line] = ' ';
				pacmaze[ghost.column+x][ghost.line+y] = ghost.symbol;
				ghost.MoveObject(x, y);
			}
			
	}

	
	/**
	 * Metodo que verifica se o Pacman e um fantasma estao na mesma posicao 
	 */
	public boolean SamePosition(){
		
		if ( (pacman.column == ghost.column) && (pacman.line == ghost.line) )
			return true;
		else 
			return false;
	}
	
	
	/**
	 * Procura a matriz por specialpacdots
	 * 
	 * Se houver menos de 4 specialpacdots, retorna true
	 */
	public boolean SearchSpecialDots(char[][] maze){
		
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( SpecialDotCounter(maze) <= 3 )
					return true;
			}		
		}
			
		return false;
	}
	
	
	
	/** 
	 * Contador de vidas
	 */
	public int LifeCounter(){
		
		int vidas = 3;
		
		if ( SamePosition() )
			vidas = vidas - 1;
		
		return vidas;
	}
	
	
	/** 
	 * Contador de pacdots
	 * 
	 * Utilizado para saber o score 
	 * 
	 * @param maze Labirinto
	 * 
	 */
	public int PacdotCounterA(char[][] maze){
		
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( (maze[i][j] == dots.symbol) || (maze[i][j] == lsd1.symbol) )
					dots_countA++;
			}		
		}
			
		return (172 - dots_countA);
	}
	
	
	/** 
	 * Contador de pacdots
	 * 
	 * Utilizado para saber os pacdots restantes
	 * 
	 * @param maze Labirinto
	 * 
	 */
	public int PacdotCounterB(char[][] maze){
		
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( (maze[i][j] == dots.symbol) || (maze[i][j] == lsd1.symbol) )
					dots_countB++;
			}		
		}
			
		return dots_countB;
	}
	
	
	/** 
	 * Contador de specialdots 
	 * 
	 * @param maze Labirinto
	 * 
	 */
	public int SpecialDotCounter(char[][] maze){
				
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( maze[i][j] == lsd1.symbol )
					specialdots_count++;
			}		
		}
			
		return specialdots_count;
	}
	
}

