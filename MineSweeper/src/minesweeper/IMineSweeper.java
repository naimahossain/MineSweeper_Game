/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;

/**
 *
 * @author Naima
 */
public interface IMineSweeper {
    
    public ArrayList<IPosition> Click(int row, int col);
    
    public ArrayList<IPosition> DoubleClick(int row, int col);
    
    public int GetAdjacentMines(int row, int col);
    
    public boolean IsFlagged(int row, int col);
    
    public boolean ToggleFlagged(int row, int col);
    
    public boolean IsMine(int row, int col);
    
    public boolean IsVisible(int row, int col);
    
    public boolean IsWin();
    
    public boolean IsLost();
    
    public String ToString();
    
}
