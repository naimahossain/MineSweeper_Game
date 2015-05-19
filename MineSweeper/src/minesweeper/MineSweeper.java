/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Naima
 */
public class MineSweeper implements IMineSweeper{

    private ISquareBox[][] _board;
    private int _totalMines;
    private int _totalVisibleBoxes;
    private int _totalBoxes;
    private boolean _lost;
    private static MineSweeper _obj;
    
    //for testing purpose, send board
    public MineSweeper(boolean[][] board){
        InitBoard(board);
        Init();
    }
    
    private void InitBoard(boolean[][] board){
        int row = board.length;
        int col = board[0].length;
        _totalMines = 0;
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
    private MineSweeper(){
        
    }
    
    private void InitGame(int row, int col, int mines){
        InitBoard(row, col);
        SetMines(mines, row, col);
        Init();
    }
    
    public static MineSweeper GetObject(int row, int col, int mines){
        if(_obj == null)
            _obj = new MineSweeper();
        _obj.InitGame(row, col, mines);
        return _obj;
    }
    
    private void InitBoard(int row, int col){
        _totalBoxes = row * col;
        _board = new ISquareBox[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                _board[i][j] = new SquareBox(i, j, row, col);
        }
    }
    
    private void SetMines(int mines, int row, int col){
        _totalMines = 0;
        while(_totalMines < mines){
            int x = (int)Math.floor(Math.random() * row);
            int y = (int)Math.floor(Math.random() * col);
            if(_board[x][y].IsMine()) continue;
            _totalMines++;
            _board[x][y].SetMine();
        }
    }
    
    private void Init(){
        _lost = false;
        _totalVisibleBoxes = 0;
        SetAdjacentMines();
    }
    
    @Override
    public ArrayList<IPosition> Click(int row, int col) {
        ISquareBox box = _board[row][col];
        ArrayList<IPosition> updatedBoxes = new ArrayList<>();
        if(box.IsVisible() || box.IsFlagged())
            return updatedBoxes;
        if(box.IsMine()){
            updatedBoxes.addAll(Lost());
            return updatedBoxes;
        }
        int neighborMines = box.GetAdjacentMines();
        if(neighborMines > 0){
            box.SetVisible();
            updatedBoxes.add(new Position(box.GetRow(), box.GetCol()));
            _totalVisibleBoxes++;
        }
        else
            updatedBoxes.addAll(Expand(box));
        return updatedBoxes;
    }
    
    private ArrayList<IPosition> Expand(ISquareBox box){
        ArrayList<IPosition> expandedBoxes = new ArrayList<>();
        Stack stack = new Stack();
        box.SetVisible();
        expandedBoxes.add(new Position(box.GetRow(), box.GetCol()));
        _totalVisibleBoxes++;
        stack.push(box);
        expandedBoxes.addAll(Expand(stack));
        return expandedBoxes;
    }
    
    private ArrayList<IPosition> Expand(Stack stack){
        ArrayList<IPosition> expandedBoxes = new ArrayList<>();
        while(!stack.isEmpty()){
            ISquareBox curBox = (ISquareBox)stack.pop();
            if(curBox.GetAdjacentMines() != 0) continue;
            for(IPosition pos : curBox.GetNeighbors()){
                ISquareBox nBox = _board[pos.GetRow()][pos.GetCol()];
                if(nBox.IsFlagged() || nBox.IsVisible() || nBox.IsMine()) continue;
                nBox.SetVisible();
                expandedBoxes.add(pos);
                _totalVisibleBoxes++;
                stack.push(nBox);
            }
        }
        return expandedBoxes;
    }
    
    private ArrayList<IPosition> Lost(){
        _lost = true;
        ArrayList<IPosition> mineBoxes = new ArrayList<>();
        for(ISquareBox[] boxes : _board){
            for(ISquareBox box : boxes){
                if((!box.IsMine() || box.IsFlagged()) && (!box.IsFlagged() || box.IsMine()))continue;
                mineBoxes.add(new Position(box.GetRow(), box.GetCol()));
                box.SetVisible();
            }
        }
        return mineBoxes;
    }
    
    private void SetAdjacentMines(){
        for(ISquareBox[] boxes : _board){
            for(ISquareBox box : boxes){
                if(box.IsMine()){
                    box.SetAdjacentMines(-1);
                    continue;
                }
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
    public ArrayList<IPosition> DoubleClick(int row, int col){
        ISquareBox box = _board[row][col];
        int neighborMines = box.GetAdjacentMines();
        ArrayList<IPosition> updatedBoxes = new ArrayList<>();
        if(!box.IsVisible() || box.IsFlagged() || neighborMines<=0)
            return updatedBoxes;
        
        Stack stack = new Stack();
        stack.push(box);
        box.GetNeighbors().stream().forEach((neighbor)->{
            ISquareBox nBox = _board[neighbor.GetRow()][neighbor.GetCol()];
            if(!nBox.IsFlagged() && !nBox.IsVisible()) {
                if(nBox.IsMine())
                    updatedBoxes.addAll(Lost());
                nBox.SetVisible();
                updatedBoxes.add(neighbor);
                _totalVisibleBoxes++;
                stack.push(nBox);
            }    
        });
        updatedBoxes.addAll(Expand(stack));
        return updatedBoxes;
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
    public boolean ToggleFlagged(int row, int col){
        ISquareBox box = _board[row][col];
        if(box.IsVisible()) return false;
        box.ToggleFlagged();
        return true;
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
        if(_totalVisibleBoxes == (_totalBoxes - _totalMines)) return true;
        return false;
    }
    
    @Override
    public boolean IsLost(){
        return _lost;
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
