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
public class MineSweeper implements IMineSweeper{

    ISquareBox[][] _board;
    
    //for testing purpose, send board
    public MineSweeper(boolean[][] board){
        int row = board.length;
        int col = board[0].length;
        _board = new ISquareBox[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                _board[i][j] = new SquareBox(i, j, board[i][j], row, col);
            }
        }
        SetAdjacentMines();
    }
    
    //create random board
    public MineSweeper(int mines, int row, int col){
        
    }
    
    @Override
    public void Click(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void SetAdjacentMines(){
        for(ISquareBox[] boxes : _board){
            for(ISquareBox box : boxes){
                int numOfMines = 0;
                for(IPosition pos : box.GetNeighbors()){
                    if(_board[pos.GetRow()][pos.GetCol()].IsMine())
                        numOfMines++;
                }
                box.SetAdjacentMines(numOfMines);
            }
        }
    }

    @Override
    public int GetAdjacentMines(int row, int col) {
        return _board[row][col].GetAdjacentMines();
    }

    @Override
    public boolean IsFlagged(int row, int col) {
        return _board[row][col].IsFlagged();
    }

    @Override
    public void ToggleFlagged(int row, int col) {
        _board[row][col].ToggleFlagged();
    }

    @Override
    public boolean IsMine(int row, int col) {
        return _board[row][col].IsMine();
    }

    @Override
    public boolean IsVisible(int row, int col) {
        return _board[row][col].IsVisible();
    }

    @Override
    public boolean IsWin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ToString() {
        StringBuilder strB = new StringBuilder();
        for(ISquareBox[] boxes : _board){
            for(ISquareBox box : boxes){
                strB.append(box.ToString()).append(" ");
            }
            strB.append("\n");
        }
        return strB.toString();
    }
}
