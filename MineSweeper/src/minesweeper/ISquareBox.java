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
public interface ISquareBox {
    public ArrayList<IPosition> GetNeighbors();
    
    public int GetRow();
    
    public int GetCol();
    
    public void SetMine();
    
    public boolean IsMine();
    
    public void SetVisible();
    
    public boolean IsVisible();
    
    public void ToggleFlagged();
    
    public boolean IsFlagged();
    
    public void SetAdjacentMines(int n);
    
    public int GetAdjacentMines();
    
    public String ToString();
}
