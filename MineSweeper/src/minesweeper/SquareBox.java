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
public class SquareBox implements ISquareBox{
    private final int _row;
    private final int _col;
    private final int _totalRow;
    private final int _totalCol;
    private final boolean _isMine;

    private int _neighborMines;
    private boolean _isFlagged;
    private boolean _isVisible;
    private ArrayList<IPosition> _neighbors;

    public SquareBox(int row, int col, boolean mine, int totalRow, int totalCol){
        this._row = row;
        this._col = col;
        this._totalRow = totalRow;
        this._totalCol = totalCol;
        this._isMine = mine;
        this._isFlagged = false;
        this._isVisible = false;
        this._neighborMines = 0;
        SetNeighbors();
    }

    private void SetNeighbors(){
        _neighbors = new ArrayList<>();
        for(int i = _row-1; i <= _row+1; i++)
        {
            for(int j = _col-1; j<=_col+1; j++){
                if(i==_row && j==_col)continue;
                if(i>=0 && j>=0 && i<_totalRow && j<_totalCol ){
                    IPosition p = new Position(i, j);
                    _neighbors.add(p);
                }
            }
        }
    }
    
    public ArrayList<IPosition> GetNeighbors(){
        return _neighbors;
    }

    public int GetRow(){
        return _row;
    }

    public int GetCol(){
        return _col;
    }

    public boolean IsMine(){
        return _isMine;
    }

    public void SetVisible(){
        _isVisible = true;
    }

    public boolean IsVisible(){
        return _isVisible;
    }

    public void ToggleFlagged(){
        _isFlagged = !_isFlagged;
    }

    public boolean IsFlagged(){
        return _isFlagged;
    }

    public void SetAdjacentMines(int n){
        _neighborMines = n;
    }

    public int GetAdjacentMines(){
        return _neighborMines;
    }

    public String ToString(){
        if(_isMine)
            return "*";
        if (_neighborMines == 0)
            return " ";
        return Integer.toString(_neighborMines);
    }
}
