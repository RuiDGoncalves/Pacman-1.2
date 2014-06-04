package logic;

public class PacObject {
	
	public char symbol;
	int line;
	int column;
	
	public PacObject(char simbolo, int linha, int coluna)
	{
		symbol = simbolo;
		line = linha;
		column = coluna;
	}
	
	public PacObject(char simbolo)
	{
		symbol = simbolo;
	}
	
	
	//Funcao que verifica se há parede
	public boolean CheckWall(char maze[][], int move_x, int move_y){
		
		if ( maze[column+move_x][line+move_y] != 'X' )			
			return true;
		else
			return false;
	}
	
	//Funcao que verifica se a proxima posicao é spawn dos fantasmas
	public boolean CheckNFloor(char maze[][], int move_x, int move_y){
			
		if ( maze[column+move_x][line+move_y] != 'N' )			
			return true;
		else
			return false;
	}
	
	
	
	//Funcao base para o movimento dos objetos
	public void MoveObject(int move_x, int move_y){
		column += move_x;
		line += move_y;
	}
	
	
	
	//Define a posicao dum objeto pelo seu simbolo
	public void SetSymbol(char maze[][]){
		maze[column][line] = symbol;
	}
	
	
	//Procura a matriz por algum pacdot
	public boolean SearchPacdot(char maze[][]){
		for ( int i = 1; i < maze.length-1; i++ )
		{
			for( int j = 1; j < maze[i].length-1; j++ )
			{
				if ( maze[i][j] == 'D' )
					return true;
			}		
		}
		
		return false;
	}	
	
}
