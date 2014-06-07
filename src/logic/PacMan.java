package logic;

/** 
 * Classe relativa ao Pacman
 * 
 * Extende da classe PacObject
 */
public class PacMan extends PacObject{

	/** 
	 * Construtor da classe 
	 * 
	 * @param maze Labirinto
	 * 
	 * @param lin Linha
	 * 
	 * @param col Coluna
	 */
	public PacMan(char maze[][], int lin, int col) {
		super('P', lin, col);
	}
	
}
