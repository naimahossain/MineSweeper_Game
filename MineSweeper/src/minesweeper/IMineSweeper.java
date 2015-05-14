/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Naima
 */
public interface IMineSweeper {
    
    public void Click(int row, int col);
    
    public int GetAdjacentMines(int row, int col);
    
    public boolean IsFlagged(int row, int col);
    
    public void ToggleFlagged(int row, int col);
    
    public boolean IsMine(int row, int col);
    
    public boolean IsVisible(int row, int col);
    
    public boolean IsWin();
    
    public boolean IsLost();
    
    public String ToString();
    
}
