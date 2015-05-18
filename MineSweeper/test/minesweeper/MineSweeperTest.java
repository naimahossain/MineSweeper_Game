/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

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
public class MineSweeperTest {
    
        private final boolean[][] _board = {    { false, false, false, false, false },
                                                { false, false, true,  true,  false },
                                                { false, false, false, true,  false }, };
    

        // Use the non-random constructor when testing to avoid random mine placement.
        private MineSweeper _mineSweeper;
    
    public MineSweeperTest() {
    }
    
    private void InitBoard(){
        _mineSweeper = new MineSweeper(_board);
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
     * Test of GetAdjacentMines method, of class MineSweeper.
     */
    @Test
    public void testGetAdjacentMines() {
        System.out.println("GetAdjacentMines");
        InitBoard();
        // Check adjacent mines around every possible GameSquare
        assertEquals(0, _mineSweeper.GetAdjacentMines(0, 0));
        assertEquals(1, _mineSweeper.GetAdjacentMines(0, 1));
        assertEquals(2, _mineSweeper.GetAdjacentMines(0, 2));
        assertEquals(2, _mineSweeper.GetAdjacentMines(0, 3));
        assertEquals(1, _mineSweeper.GetAdjacentMines(0, 4));

        assertEquals(0, _mineSweeper.GetAdjacentMines(1, 0));
        assertEquals(1, _mineSweeper.GetAdjacentMines(1, 1));
        assertEquals(-1, _mineSweeper.GetAdjacentMines(1, 2)); //for mines the value is -1
        assertEquals(-1, _mineSweeper.GetAdjacentMines(1, 3));
        assertEquals(2, _mineSweeper.GetAdjacentMines(1, 4));

        assertEquals(0, _mineSweeper.GetAdjacentMines(2, 0));
        assertEquals(1, _mineSweeper.GetAdjacentMines(2, 1));
        assertEquals(3, _mineSweeper.GetAdjacentMines(2, 2));
        assertEquals(-1, _mineSweeper.GetAdjacentMines(2, 3));
        assertEquals(2, _mineSweeper.GetAdjacentMines(2, 4));
    }

    /**
     * Test of IsFlagged method, of class MineSweeper.
     */
    @Test
    public void testIsFlagged() {
        System.out.println("IsFlagged");
        InitBoard();
        _mineSweeper.Click(0, 0);
        assertEquals(false, _mineSweeper.IsFlagged(0, 0));
        _mineSweeper.ToggleFlagged(0, 0);
        assertEquals(false, _mineSweeper.IsFlagged(0, 0));
        _mineSweeper.ToggleFlagged(1, 2);
        assertEquals(true, _mineSweeper.IsFlagged(1, 2));
        _mineSweeper.ToggleFlagged(2, 2);
        assertEquals(true, _mineSweeper.IsFlagged(2, 2));
        _mineSweeper.ToggleFlagged(2, 2);
        assertEquals(false, _mineSweeper.IsFlagged(2, 2));
        _mineSweeper.ToggleFlagged(2, 3);
        assertEquals(true, _mineSweeper.IsFlagged(2, 3));
    }

    /**
     * Test of IsMine method, of class MineSweeper.
     */
    @Test
    public void testIsMine() {
        System.out.println("IsMine");
        InitBoard();
        
        assertEquals(false, _mineSweeper.IsMine(0, 0));
        assertEquals(false, _mineSweeper.IsMine(0, 1));
        assertEquals(false, _mineSweeper.IsMine(0, 2));
        assertEquals(false, _mineSweeper.IsMine(0, 3));
        assertEquals(false, _mineSweeper.IsMine(0, 4));
        
        assertEquals(false, _mineSweeper.IsMine(1, 0));
        assertEquals(false, _mineSweeper.IsMine(1, 1));
        assertEquals(true, _mineSweeper.IsMine(1, 2));
        assertEquals(true, _mineSweeper.IsMine(1, 3));
        assertEquals(false, _mineSweeper.IsMine(1, 4));
                      
        assertEquals(false, _mineSweeper.IsMine(2, 0));
        assertEquals(false, _mineSweeper.IsMine(2, 1));
        assertEquals(false, _mineSweeper.IsMine(2, 2));
        assertEquals(true, _mineSweeper.IsMine(2, 3));
        assertEquals(false, _mineSweeper.IsMine(2, 4));
    }

    /**
     * Test of IsVisible method, of class MineSweeper.
     */
    @Test
    public void testIsVisible() {
        System.out.println("IsVisible");
        InitBoard();
        
        _mineSweeper.Click(0, 0);
        assertEquals(true, _mineSweeper.IsVisible(0, 0));
        assertEquals(true, _mineSweeper.IsVisible(0, 1));
        assertEquals(true, _mineSweeper.IsVisible(1, 0));
        assertEquals(true, _mineSweeper.IsVisible(1, 1));
        assertEquals(true, _mineSweeper.IsVisible(2, 0));
        assertEquals(true, _mineSweeper.IsVisible(2, 1));
        assertEquals(false, _mineSweeper.IsVisible(0, 2));
        assertEquals(false, _mineSweeper.IsVisible(1, 2));
        assertEquals(false, _mineSweeper.IsVisible(2, 2));
        _mineSweeper.Click(0, 2);
        assertEquals(true, _mineSweeper.IsVisible(0, 2));
        assertEquals(false, _mineSweeper.IsVisible(0, 3));
        
        _mineSweeper.DoubleClick(0, 2);
        assertEquals(true, _mineSweeper.IsVisible(0, 3));
        assertEquals(true, _mineSweeper.IsVisible(1, 2));
        assertEquals(true, _mineSweeper.IsVisible(1, 3));
        assertEquals(true, _mineSweeper.IsLost());
        
        InitBoard();
        _mineSweeper.Click(0, 0);
        _mineSweeper.ToggleFlagged(1, 2);
        _mineSweeper.ToggleFlagged(1, 3);
        assertEquals(false, _mineSweeper.IsVisible(0, 2));
        _mineSweeper.Click(0, 2);
        assertEquals(true, _mineSweeper.IsVisible(0, 2));
        _mineSweeper.DoubleClick(0, 2);
        assertEquals(true, _mineSweeper.IsVisible(0, 3));
        assertEquals(false, _mineSweeper.IsVisible(1, 2));
        assertEquals(false, _mineSweeper.IsVisible(1, 3));
    }

    /**
     * Test of IsWin method, of class MineSweeper.
     */
    @Test
    public void testIsWin() {
        System.out.println("IsWin");
        InitBoard();
        assertEquals(false, _mineSweeper.IsWin());
        _mineSweeper.ToggleFlagged(1, 2);
        _mineSweeper.ToggleFlagged(1, 3);
        _mineSweeper.ToggleFlagged(2, 3);
        assertEquals(true, _mineSweeper.IsWin());
        
        //0 1 2 2 1
        //0 1 x x 2
        //0 1 3 x 2
        InitBoard();
        assertEquals(false, _mineSweeper.IsWin());
        _mineSweeper.Click(0, 0);
        _mineSweeper.Click(0, 2);
        assertEquals(false, _mineSweeper.IsWin());
        _mineSweeper.Click(0, 3);
        _mineSweeper.Click(0, 4);
        assertEquals(false, _mineSweeper.IsWin());
        _mineSweeper.Click(1, 4);
        _mineSweeper.Click(2, 4);
        assertEquals(false, _mineSweeper.IsWin());
        _mineSweeper.Click(2, 2);
        assertEquals(true, _mineSweeper.IsWin());
    }

    /**
     * Test of IsWin method, of class MineSweeper.
     */
    @Test
    public void testIsLost() {
        System.out.println("IsLost");
        InitBoard();
        //0 1 2 2 1
        //0 1 x x 2
        //0 1 3 x 2
        assertEquals(false, _mineSweeper.IsLost());
        _mineSweeper.ToggleFlagged(1, 2);
        _mineSweeper.ToggleFlagged(1, 3);
        _mineSweeper.ToggleFlagged(2, 3);
        assertEquals(false, _mineSweeper.IsLost());
        
        assertEquals(false, _mineSweeper.IsLost());
        _mineSweeper.Click(0, 0);
        _mineSweeper.Click(0, 2);
        assertEquals(false, _mineSweeper.IsLost());
        
        _mineSweeper.ToggleFlagged(2, 3);
        _mineSweeper.Click(2, 3);
        assertEquals(true, _mineSweeper.IsLost());
    }
    /**
     * Test of ToString method, of class MineSweeper.
     */
    @Test
    public void testToString() {
        System.out.println("ToString");
        InitBoard();
        //0 1 2 2 1
        //0 1 x x 2
        //0 1 3 x 2
        String res = "0 1 2 2 1 \n" + "0 1 * * 2 \n" + "0 1 3 * 2 \n";
        assertEquals(res, _mineSweeper.ToString());
    }
}
