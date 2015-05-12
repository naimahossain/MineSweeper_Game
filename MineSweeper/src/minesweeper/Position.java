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
public class Position implements IPosition{
    private final int _row;
    private final int _col;
    
    public Position(int row, int col){
        this._row = row;
        this._col = col;
    }
    
    public int GetRow(){
        return _row;
    }
    
    public int GetCol(){
        return _col;
    }
}
