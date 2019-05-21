package es.codeurjc.ais.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class BoardTest {
	private Board mesa;
	
	public void mark(String label, int cell) {
		mesa.getCell(cell).value = label;
		mesa.getCell(cell).active = false;
	}
	
	@Before
	public void setUp() {
		this.mesa = new Board();
		this.mesa.enableAll();
		assertFalse(mesa.checkDraw());
		assertNull(mesa.getCellsIfWinner("X"));
		assertNull(mesa.getCellsIfWinner("O"));
		mark("X",4);
		mark("O",2);
		mark("X",0);
		assertFalse(mesa.checkDraw());
		assertNull(mesa.getCellsIfWinner("X"));
		assertNull(mesa.getCellsIfWinner("O"));
	}
	
	
	@Test
	public void ganaPrimero() {
		mark("O",5);
		mark("X",8);
		assertFalse(mesa.checkDraw());
		assertArrayEquals(new int[] {0,4,8}, mesa.getCellsIfWinner("X"));
		assertNull(mesa.getCellsIfWinner("O"));
	}
	
	@Test
	public void pierdePrimero() {
		mark("O",8);
		mark("X",3);
		mark("O",5);
		assertFalse(mesa.checkDraw());
		assertNull(mesa.getCellsIfWinner("X"));
		assertArrayEquals(new int[] {2,5,8}, mesa.getCellsIfWinner("O"));
	}
	
	@Test
	public void empate() {
		mark("O",8);
		mark("X",6);
		mark("O",1);
		mark("X",5);
		mark("O",3);
		mark("X",7);
		assertTrue(mesa.checkDraw());
		assertNull(mesa.getCellsIfWinner("X"));
		assertNull(mesa.getCellsIfWinner("O"));
	}
}
