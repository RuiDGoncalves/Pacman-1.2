package cli;

import logic.PacWorld;

/** 
 * Classe que contem o main
 */
public class run {
	
	/**	
	 * Corre o jogo em modo de consola
	 */
	public static void main(String[] args){
		PacWorld pacworld = new PacWorld();
		pacworld.PacPlay();
	}
}
