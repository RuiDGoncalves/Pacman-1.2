package test;

import logic.PacWorld;
import logic.PacObject;

public class Special {
	PacWorld x;
	PacObject d, g;
	char maze[][];
	
	public Special(){
		x = new PacWorld();
		maze = x.pacmaze;
		d = new PacObject('D');
		g = new PacObject('G');
	}
	
	public int testX(char p){
		int x = 0;

		switch (p)
		{
			case 'w':
				x = -1;
				break;
			case 's':
				x = 1;
				break;
			case 'a':
				x = 0;
				break;
			case 'd':
				x = 0;
				break;
		}
		
		return x;
	}
	
	public int testY(char p){
		int y = 0;

		switch (p)
		{
			case 'w':
				y = 0;
				break;
			case 's':
				y = 0;
				break;
			case 'a':
				y = -1;
				break;
			case 'd':
				y = 1;
				break;
		}
		
		return y;
	}
	
	public void move_ghost_spec(char p, int i, int j){
		if (p == 'w'){
			if (maze[i][j-1] != 'X'){
				maze[i][j] = ' ';
				maze[i][j-1] = g.symbol;
			}
		}
		if (p == 'a'){
			if (maze[i+1][j] != 'X'){
				maze[i][j] = ' ';
				maze[i+1][j] = g.symbol;
			}
		}
		if (p == 's'){
			if (maze[i][j+1] != 'X'){
				maze[i][j] = ' ';
				maze[i][j+1] = g.symbol;
			}
		}
		if (p == 'd'){
			if (maze[i-1][j] != 'X'){
				maze[i][j] = ' ';
				maze[i-1][j] = g.symbol;
			}
		}
	}

	public void dot_exterminator(){
		for ( int i = 1; i < maze.length; i++ )
		{
			for( int j = 1; j < maze[i].length; j++ )
			{
				if ( maze[i][j] == d.symbol )
					maze[i][j] = ' ';
			}
		}
		}
}
