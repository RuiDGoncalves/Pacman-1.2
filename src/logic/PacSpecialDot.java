package logic;

/** 
 * Classe relativa aos Specialdots
 * 
 * Extende da Classe PacObject
 */
public class PacSpecialDot extends PacObject {
	
	/**
	 * Construtor da classe 
	 * 
	 * @param maze Labirinto
	 * 
	 * @param lin Linha
	 * 
	 * @param col Coluna
	 */
	public PacSpecialDot(char maze[][], int lin, int col) {
		super('S', lin, col);
	}
}