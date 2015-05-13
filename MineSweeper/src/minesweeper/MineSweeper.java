/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Stack;

/**
 *
 * @author Naima
 */
public class MineSweeper implements IMineSweeper{

    private ISquareBox[][] _board;
    private int _collectedMines; 
    private int _totalMines;
    private int _totalVisibleBoxes;
    private int _totalBoxes;
    
    //for testing purpose, send board
    public MineSweeper(boolean[][] board){
        InitBoard(board);
        Init();
    }
    
    private void InitBoard(boolean[][] board){
        int row = board.length;
        int col = board[0].length;
        _board = new ISquareBox[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                _board[i][j] = new SquareBox(i, j, board[i][j], row, col);
                _totalBoxes++;
                if(board[i][j]) _totalMines++;
            }
        }
    }
    
    //create random board
    public MineSweeper(int mines, int row, int col){
        InitBoard(row, col);
        SetMines(mines, row, col);
        Init();
    }
    
    private void InitBoard(int row, int col){
        _board = new ISquareBox[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                _board[i][j] = new SquareBox(i, j, row, col);
        }
    }
    
    private void SetMines(int mines, int row, int col){
        int numOfMines = 0;
        while(numOfMines < mines){
            int x = (int)Math.floor(Math.random() * row);
            int y = (int)Math.floor(Math.random() * col);
            if(_board[x][y].IsMine()) continue;
            numOfMines++;
            _board[x][y].SetMine();
        }
    }
    
    private void Init(){
        _collectedMines = 0;
        SetAdjacentMines();
    }
    
    @Override
    public void Click(int row, int col) {
        ISquareBox box = _board[row][col];
        if(box.IsVisible() || box.IsFlagged())
            return;
        if(box.IsMine()){
            Lost();
            return;
        }
        int neighborMines = box.GetAdjacentMines();
        if(neighborMines > 0){
            box.SetVisible();
            _totalVisibleBoxes++;
        }
        else
            Expand(box);
    }
    
    private void Expand(ISquareBox box){
        Stack stack = new Stack();
        box.SetVisible();
        _totalVisibleBoxes++;
        stack.push(box);
        while(!stack.isEmpty()){
            ISquareBox curBox = (ISquareBox)stack.pop();
            if(curBox.GetAdjacentMines() == 0){
                for(IPosition pos : curBox.GetNeighbors()){
                    ISquareBox nBox = _board[pos.GetRow()][pos.GetCol()];
                    if(nBox.IsFlagged() || nBox.IsVisible() || nBox.IsMine()) continue;
                    nBox.SetVisible();
                    _totalVisibleBoxes++;
                    stack.push(nBox);
                }
            }
        }
    }
    
    private void Lost(){
        for(ISquareBox[] boxes : _board){
            for(ISquareBox box : boxes){
                if(box.IsMine() && !box.IsFlagged())
                    box.SetVisible();
            }
        }
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
    public void ToggleFlagged(int row, int col){
        ISquareBox box = _board[row][col];
        if(box.IsVisible()) return;
        if(box.IsFlagged() && box.IsMine()) 
            _collectedMines--;
        else if((!box.IsFlagged()) && box.IsMine())
            _collectedMines++;
        box.ToggleFlagged();
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
        if(_collectedMines == _totalMines) return true;
        if(_totalVisibleBoxes == (_totalBoxes - _totalMines)) return true;
        return false;
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
