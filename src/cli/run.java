package cli;

import java.util.Scanner;

import logic.PacWorld;

/** 
 * Classe que contem o main
 */
public class run {
	
	/** Objeto referente a parte logica do jogo */
	static PacWorld jogo = new PacWorld();
	
	/** 
	 * Recebe input do utilizador e efectua os movimentos necessarios e imprime o labirinto
	 *	
	 *  Corre o jogo em modo de consola
	 */
	public static void main(String[] args){		
		
		while ( jogo.SearchPacdot(jogo.pacmaze) == true && !(jogo.SamePosition()))
		{
			jogo.DisplayPacworld();
		
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
			
			jogo.MoveGhost();
			jogo.MovePacman(x, y);
			
		}		
		
		jogo.DisplayPacworld();
		
		if ( jogo.SamePosition() ){
			System.out.println("Perdeste!");
		}

	}
	
}
