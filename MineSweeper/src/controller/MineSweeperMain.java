/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.IMineSweeperGui;
import GUI.MineSweeperGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import minesweeper.IMineSweeper;
import minesweeper.IPosition;
import minesweeper.MineSweeper;

/**
 *
 * @author Naima
 */
public class MineSweeperMain {

    private static IMineSweeperGui _gui;
    private static IMineSweeper _gameControl;
    
    private int _row;
    private int _col;
    private int _mine;
    
    private Timer _time;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MineSweeperMain ms = new MineSweeperMain();
        Values.SetDefault();
        ms.InitGame();
    }
    
    public void InitGame(){
        _gui = MineSweeperGui.GetObj(this);
        _row = Values.Rows;
        _col = Values.Cols;
        _mine = Values.Mines;
        _gui.InitGame(_row, _col, _mine);
        _gameControl = MineSweeper.GetObject(_row, _col, _mine);
        if(_time != null && _time.isRunning())
            _time.stop();
    }
    
    public void Click(int row, int col, int clickCount){
        InitiateClick();
        Update(row, col, clickCount);
        ClickProcessed();
    }
    
    private void Update(int row, int col, int clickCount){
        ArrayList<IPosition> poses;
        switch(clickCount){
            case 1: poses = _gameControl.Click(row, col);
                break;
            case 2: poses = _gameControl.DoubleClick(row, col);
                break;
            default:
                poses = new ArrayList<>();
        }
        
        poses.stream().forEach((item) -> {
            int r = item.GetRow();
            int c = item.GetCol();
            _gui.Update(r, c, _gameControl.GetAdjacentMines(r, c));
        });
    }
    
    public void ToggleFlag(int row, int col){
        InitiateClick();
        
        _gameControl.ToggleFlagged(row, col);
        _gui.ToggleFlagged(row, col);
        
        int n = Integer.parseInt(_gui.GetFlagLeft());
        n = _gameControl.IsFlagged(row, col)? n-1: n+1;
        _gui.SetFlagLeft(Integer.toString(n));
    }
    
    private void InitiateClick(){
        if(_gui.IsFirstClick())
            Start();
    }
    
    private void ClickProcessed(){
        if(_gameControl.IsLost()){
            _time.stop();
            _gui.Lost();
        }
        else if(_gameControl.IsWin()){
            _time.stop();
            _gui.Win();
        }
    }
    
    private void Start(){
        // Timer to tick every 1000ms (1 second)
        _time = new Timer(1000, new TimerListener());
        if(!_time.isRunning())
            _time.start();
        _gui.GameStarted();
    }

    private static class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String t = _gui.GetClockTime();
            if (t.compareTo("999") < 0)
                _gui.SetTime((Integer.parseInt(t) + 1) + "");
        }
    } 
}
