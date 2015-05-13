/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naima
 */
public class SquareBoxTest {
    
    public SquareBoxTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetNeighbors method, of class SquareBox.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("GetNeighbors");
        ISquareBox b = new SquareBox(1, 1, 3, 3);
        ArrayList<IPosition> neighbors = new ArrayList<>();
        neighbors.add(new Position(0, 0));
        neighbors.add(new Position(0, 1));
        neighbors.add(new Position(0, 2));
        neighbors.add(new Position(1, 0));
        neighbors.add(new Position(1, 2));
        neighbors.add(new Position(2, 0));
        neighbors.add(new Position(2, 1));
        neighbors.add(new Position(2, 2));
        ArrayList<IPosition> res1 = b.GetNeighbors();
        assertEquals(neighbors.size(), res1.size());
        for(int i=0; i<res1.size(); i++){
            assertEquals(neighbors.get(i).GetCol(), res1.get(i).GetCol());
            assertEquals(neighbors.get(i).GetRow(), res1.get(i).GetRow());
        }
        
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        ArrayList<IPosition> neighborList = new ArrayList<>();
        neighborList.add(new Position(0, 0));
        neighborList.add(new Position(0, 1));
        neighborList.add(new Position(1, 0));
        ArrayList<IPosition> res2 = bx.GetNeighbors();
        assertEquals(neighborList.size(), res2.size());
        for(int i=0; i<res2.size(); i++){
            assertEquals(neighborList.get(i).GetCol(), res2.get(i).GetCol());
            assertEquals(neighborList.get(i).GetRow(), res2.get(i).GetRow());
        }
    }

    /**
     * Test of GetRow method, of class SquareBox.
     */
    @Test
    public void testGetRow() {
        System.out.println("GetRow");
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        assertEquals(1, bx.GetRow());
        ISquareBox b = new SquareBox(0, 1, 2, 2);
        assertEquals(0, b.GetRow());
    }

    /**
     * Test of GetCol method, of class SquareBox.
     */
    @Test
    public void testGetCol() {
        System.out.println("GetCol");
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        assertEquals(1, bx.GetCol());
        ISquareBox b = new SquareBox(0, 0, 2, 2);
        assertEquals(0, b.GetCol());
    }

    /**
     * Test of IsMine method, of class SquareBox.
     */
    @Test
    public void testIsMine() {
        System.out.println("IsMine");
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        assertEquals(false, bx.IsMine());
        bx.SetMine();
        assertEquals(true, bx.IsMine());
    }

    /**
     * Test of IsVisible method, of class SquareBox.
     */
    @Test
    public void testIsVisible() {
        System.out.println("IsVisible");
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        assertEquals(false, bx.IsVisible());
        bx.SetVisible();
        assertEquals(true, bx.IsVisible());
    }

    /**
     * Test of IsFlagged method, of class SquareBox.
     */
    @Test
    public void testIsFlagged() {
        System.out.println("IsFlagged");
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        assertEquals(false, bx.IsFlagged());
        bx.ToggleFlagged();
        assertEquals(true, bx.IsFlagged());
        bx.ToggleFlagged();
        assertEquals(false, bx.IsFlagged());
    }

    /**
     * Test of GetAdjacentMines method, of class SquareBox.
     */
    @Test
    public void testGetAdjacentMines() {
        System.out.println("GetAdjacentMines");
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        bx.SetAdjacentMines(3);
        assertEquals(3, bx.GetAdjacentMines());
    }

    /**
     * Test of ToString method, of class SquareBox.
     */
    @Test
    public void testToString() {
        ISquareBox bx = new SquareBox(1, 1, 2, 2);
        bx.SetAdjacentMines(3);
        assertEquals("3", bx.ToString());
        bx.SetAdjacentMines(0);
        assertEquals(" ", bx.ToString());
        bx.SetMine();
        assertEquals("*", bx.ToString());
    }
    
}
