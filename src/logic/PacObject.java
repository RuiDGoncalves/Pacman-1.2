package logic;

/** 
 * Classe relativa a todos os objetos do labirinto 
 */
public class PacObject {
	
	/** Simbolo do Objeto */
	public char symbol;
	
	/** Numero da linha do objeto */
	int line;
	
	/** Numero da coluna do objeto */
	int column;
	
	
	/** 
	 * Primeiro construtor da classe
	 * 
	 * @param simbolo Simbolo
	 * 
	 * @param linha Linha
	 * 
	 * @param coluna Coluna
	 */
	public PacObject(char simbolo, int linha, int coluna)
	{
		symbol = simbolo;
		line = linha;
		column = coluna;
	}
	
	/** Segundo construtor da classe 
	 * 
	 * @param simbolo Simbolo
	 */
	public PacObject(char simbolo)
	{
		symbol = simbolo;
	}
	
	
	/** 
	 * Metodo que verifica se há parede
	 * 
	 * @param maze Labirinto
	 * 
	 * @param move_x Movimento efetuado na vertical
	 * 
	 * @param move_y Movimento efetuado na horizontal
	 */
	public boolean CheckWall(char maze[][], int move_x, int move_y){
		
		if ( maze[column+move_x][line+move_y] != 'X' )			
			return true;
		else
			return false;
	}
	
	
	/**
	 * Metodo que verifica se a proxima posicao é spawn dos fantasmas
	 * 
	 * @param maze Labirinto
	 * 
	 * @param move_x Movimento efetuado na vertical
	 * 
	 * @param move_y Movimento efetuado na horizontal
	 */
	public boolean CheckNFloor(char maze[][], int move_x, int move_y){
			
		if ( maze[column+move_x][line+move_y] != 'N' )			
			return true;
		else
			return false;
	}	
	
	
	/**
	 * Metodo base para o movimento dos objetos
	 * 
	 * @param move_x Movimento efetuado na vertical
	 * 
	 * @param move_y Movimento efetuado na horizontal
	 */
	public void MoveObject(int move_x, int move_y){
		column += move_x;
		line += move_y;
	}
	
	
	
	/** 
	 * Define a posicao dum objeto pelo seu simbolo 
	 */
	public void SetSymbol(char maze[][]){
		maze[column][line] = symbol;
	}
	
	
}
