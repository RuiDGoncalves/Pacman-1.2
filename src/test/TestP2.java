package test;

import static org.junit.Assert.*;
import org.junit.Test;

import test.Special;

import logic.PacWorld;
import logic.PacObject;

public class TestP2 {
	
	Special s = new Special();
	char position = ' ';

	@Test
	public void testPacmanMov() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 1, 2);
		char[][] maze = x.pacmaze;
		position = 'd';
		x.MovePacman(s.testX(position), s.testY(position));
		assertEquals(p.line, 1);
		assertEquals(p.column, 3);
		assertTrue(x.SearchPacdot(maze));
	}
	
	@Test
	public void testPacmanImov() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 1, 2);
		char[][] maze = x.pacmaze;
		position = 'w';
		x.MovePacman(s.testX(position), s.testY(position));
		assertEquals(p.line, 1);
		assertEquals(p.column, 2);
		assertTrue(x.SearchPacdot(maze));
	}
	
	@Test
	public void testGetPowerPellet() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 1, 2);
		PacObject o = new PacObject('S', 1, 1);
		char[][] maze = x.pacmaze;
		position = 'a';
		x.MovePacman(s.testX(position), s.testY(position));
		assertEquals(p.line, 1);
		assertEquals(p.column, 1);
		assertEquals(p.symbol, 'Z');
		assertTrue(x.SearchPacdot(maze));
	}
	
	@Test
	public void testGhostMov() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 1, 2);
		PacObject g = new PacObject('G', 1, 18);
		char[][] maze = x.pacmaze;
		position = 'w';
		s.move_ghost_spec(position, 1, 18);
		assertEquals(g.line, 1);
		assertEquals(g.column, 17);
		assertTrue(x.SearchPacdot(maze));
	}
	
	@Test
	public void testGhostImov() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 1, 2);
		PacObject g = new PacObject('G', 1, 18);
		char[][] maze = x.pacmaze;
		position = 'd';
		s.move_ghost_spec(position, 1, 18);
		assertEquals(g.line, 1);
		assertEquals(g.column, 18);
		assertTrue(x.SearchPacdot(maze));
	}
	
	@Test
	public void testEatGhost() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('Z', 1, 2);
		PacObject g = new PacObject('G', 1, 3);
		char[][] maze = x.pacmaze;
		position = 'd';
		x.MovePacman(s.testX(position), s.testY(position));
		assertEquals(p.line, 1);
		assertEquals(p.column, 3);
		assertEquals(g.line, 1);
		assertEquals(g.column, 3);
		assertTrue(x.SearchPacdot(maze));
		assertTrue(x.SamePosition());
	}
	
	@Test
	public void testDefeat() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 1, 2);
		PacObject g = new PacObject('G', 1, 3);
		char[][] maze = x.pacmaze;
		position = 'd';
		x.MovePacman(s.testX(position), s.testY(position));
		assertEquals(p.line, 1);
		assertEquals(p.column, 3);
		assertEquals(g.line, 1);
		assertEquals(g.column, 3);
		assertTrue(x.SearchPacdot(maze));
		assertTrue(x.SamePosition());
	}
	
	@Test
	public void testVictory() {
		PacWorld x = new PacWorld();
		PacObject p = new PacObject('P', 4, 1);
		s.dot_exterminator();
		PacObject d = new PacObject('D', 5, 1);
		char[][] maze = x.pacmaze;
		position = 's';
		x.MovePacman(s.testX(position), s.testY(position));
		assertEquals(p.line, 5);
		assertEquals(p.column, 1);
		assertFalse(x.SearchPacdot(maze));
	}
	

}

