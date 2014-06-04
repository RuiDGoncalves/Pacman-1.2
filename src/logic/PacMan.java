package logic;

public class PacMan extends PacObject{
	boolean alive;
	boolean high;

	public PacMan(char maze[][], int lin, int col) {
		super('P', lin, col);
	}
	
	public void OnDrugs(){
		high = true;
		symbol = 'F';
	}
	
	public void Dead(){
		alive = false;
	}
}
