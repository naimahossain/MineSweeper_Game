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
public class MineSweeper implements IMineSweeper{

    SquareBox[][] _board;
    
    //for testing purpose, send board
    public MineSweeper(SquareBox[][] board){
        int row = board.length;
        int col = board[0].length;
        _board = new SquareBox[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                _board[i][j] = new SquareBox(i, j, board[i][j]._isMine);
            }
        }
    }
    
    //create random board
    public MineSweeper(int mines, int row, int col){
        
    }
    
    @Override
    public void Click(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void SetAdjacentMines(){
        
    }

    @Override
    public int GetAdjacentMines(int row, int col) {
        return _board[row][col].getAdjacentMines();
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
        for(SquareBox[] boxes : _board){
            for(SquareBox box : boxes){
                strB.append(box.ToString()).append(" ");
            }
            strB.append("\n");
        }
        return strB.toString();
    }
    
    private class SquareBox{
        private final int _row;
        private final int _col;
        private final boolean _isMine;
        private int _neighborMines;
        private boolean _isFlagged;
        private boolean _isVisible;
        
        public SquareBox(int row, int col, boolean mine){
            this._row = row;
            this._col = col;
            this._isMine = mine;
            this._isFlagged = false;
            this._isVisible = false;
            this._neighborMines = 0;
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
        
        public int getAdjacentMines(){
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
}
