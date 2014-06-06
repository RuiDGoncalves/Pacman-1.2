package logic;

import java.util.Random;
import java.util.Scanner;

public class PacWorld {
	public char pacmaze[][];
	public PacMan pacman;
	public PacDot dots;
	public PacSpecialDot lsd1, lsd2, lsd3, lsd4;
	public PacGhost ghost;
	
	char[][] maze_temp;
	public int dots_count;
	
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
		
		SetPacdots(pacmaze);
		lsd1.SetSymbol(pacmaze);
		lsd2.SetSymbol(pacmaze);
		lsd3.SetSymbol(pacmaze);
		lsd4.SetSymbol(pacmaze);
		pacman.SetSymbol(pacmaze);
		ghost.SetSymbol(pacmaze);
	}
	
	
	//Faz display da matriz de jogo original
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
	
	
	//Troca todos os simbolos ' ' por pacdots
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
	
	
	//Procura a matriz por algum pacdot
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
	
	
	
	//Funcao responsavel pelo movimento do pacman
	public void MovePacman(int x, int y){
		
		if ( pacman.CheckWall(pacmaze, x, y) && pacman.CheckNFloor(pacmaze, x, y) ){
			pacmaze[pacman.column][pacman.line] = ' ';
			pacmaze[pacman.column+x][pacman.line+y] = pacman.symbol;
			pacman.MoveObject(x, y);
		}
	}		
		
	
	//Funcao responsavel pelo movimento do fantasma
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
		
		while ( pacmaze[ghost.column+x][ghost.line+y] != 'X' || pacmaze[ghost.column+x][ghost.line+y] != 'N'){
			
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
			
			else if ( pacmaze[ghost.column+x][ghost.line+y] == 'N' )
			{}
			
		}
	}

	
	//Funcao que verifica se o Pacman e um fantasma estao na mesma posicao
	public boolean SamePosition(){
		
		if ( (pacman.column == ghost.column) && (pacman.line == ghost.line) )
			return true;
		else 
			return false;
	}
	
	
	
	//
	//Contadores para as JLabels
	//
	
	//Contador de vidas
	public int LifeCounter(){
		
		int vidas = 3;
		
		if ( SamePosition() )
			vidas = vidas - 1;
		
		return vidas;
	}
	
	
	//Contador de pacdots
	public int PacdotCounter(char[][] maze){
		
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( (maze[i][j] == dots.symbol) || (maze[i][j] == lsd1.symbol) )
					dots_count++;
			}		
		}
			
		return dots_count;
	}

			
	
	//Esta é a funcao principal da classe. Recebe input do utilizador e efectua os movimentos necessarios
	public void PacPlay(){
		
		while ( SearchPacdot(pacmaze) == true ){
			
			DisplayPacworld();
		
			Scanner in = new Scanner(System.in);
			System.out.println("Faz jogada: ");
			char tecla = in.nextLine().charAt(0);
			
			int x = 0;
			int y = 0;
		
			switch (tecla)
			{
				case 'w':
					x = -1;
					y = 0;
					break;
				case 's':
					x = 1;
					y = 0;
					break;
				case 'a':
					x = 0;
					y = -1;
					break;
				case 'd':
					x = 0;
					y = 1;
					break;
			}
			
			MoveGhost();
			MovePacman(x, y);
			
		}
		
		DisplayPacworld();

	}
	
}

