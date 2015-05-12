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
    
    public MineSweeperTest() {
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
     * Test of Click method, of class MineSweeper.
     */
    @Test
    public void testClick() {
//        System.out.println("Click");
//        int row = 0;
//        int col = 0;
//        MineSweeper instance = null;
//        instance.Click(row, col);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAdjacentMines method, of class MineSweeper.
     */
    @Test
    public void testGetAdjacentMines() {
//        System.out.println("GetAdjacentMines");
//        int row = 0;
//        int col = 0;
//        MineSweeper instance = null;
//        int expResult = 0;
//        int result = instance.GetAdjacentMines(row, col);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of IsFlagged method, of class MineSweeper.
     */
    @Test
    public void testIsFlagged() {
//        System.out.println("IsFlagged");
//        int row = 0;
//        int col = 0;
//        MineSweeper instance = null;
//        boolean expResult = false;
//        boolean result = instance.IsFlagged(row, col);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ToggleFlagged method, of class MineSweeper.
     */
    @Test
    public void testToggleFlagged() {
//        System.out.println("ToggleFlagged");
//        int row = 0;
//        int col = 0;
//        MineSweeper instance = null;
//        instance.ToggleFlagged(row, col);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of IsMine method, of class MineSweeper.
     */
    @Test
    public void testIsMine() {
//        System.out.println("IsMine");
//        int row = 0;
//        int col = 0;
//        MineSweeper instance = null;
//        boolean expResult = false;
//        boolean result = instance.IsMine(row, col);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of IsVisible method, of class MineSweeper.
     */
    @Test
    public void testIsVisible() {
//        System.out.println("IsVisible");
//        int row = 0;
//        int col = 0;
//        MineSweeper instance = null;
//        boolean expResult = false;
//        boolean result = instance.IsVisible(row, col);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of IsWin method, of class MineSweeper.
     */
    @Test
    public void testIsWin() {
//        System.out.println("IsWin");
//        MineSweeper instance = null;
//        boolean expResult = false;
//        boolean result = instance.IsWin();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ToString method, of class MineSweeper.
     */
    @Test
    public void testToString() {
//        System.out.println("ToString");
//        MineSweeper instance = null;
//        String expResult = "";
//        String result = instance.ToString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetAdjacentMinesWithAGivenTwodArrayOfBooleans() {

        boolean[][] b1 =

        { { false, false, false, false, false },
          { false, false, true,  true,  false },
          { false, false, false, true,  false }, };

        // Use the non-random constructor when testing to avoid random mine placement.
        MineSweeper ms = new MineSweeper(b1);

        // Check adjacent mines around every possible GameSquare
        assertEquals(0, ms.GetAdjacentMines(0, 0));
        assertEquals(1, ms.GetAdjacentMines(0, 1));
        assertEquals(2, ms.GetAdjacentMines(0, 2));
        assertEquals(2, ms.GetAdjacentMines(0, 3));
        assertEquals(1, ms.GetAdjacentMines(0, 4));

        assertEquals(0, ms.GetAdjacentMines(1, 0));
        assertEquals(1, ms.GetAdjacentMines(1, 1));
        assertEquals(2, ms.GetAdjacentMines(1, 2)); 
        assertEquals(2, ms.GetAdjacentMines(1, 3));
        assertEquals(2, ms.GetAdjacentMines(1, 4));

        assertEquals(0, ms.GetAdjacentMines(2, 0));
        assertEquals(1, ms.GetAdjacentMines(2, 1));
        assertEquals(3, ms.GetAdjacentMines(2, 2));
        assertEquals(2, ms.GetAdjacentMines(2, 3));
        assertEquals(2, ms.GetAdjacentMines(2, 4));
    }
}
