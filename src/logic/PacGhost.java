package logic;

/** 
 * Classe relativa ao Fantasma
 * 
 * Extende da classe PacObject
 */
public class PacGhost extends PacObject{
	
	/** 
	 * Construtor da classe 
	 * 
	 * @param maze Labirinto
	 * 
	 * @param lin Linha
	 * 
	 * @param col Coluna
	 */
	public PacGhost(char maze[][], int lin, int col) {
		super('G', lin, col);
	}
}
