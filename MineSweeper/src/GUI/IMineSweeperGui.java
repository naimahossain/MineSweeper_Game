/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Naima
 */
public interface IMineSweeperGui {
       
    public void InitGame(int row, int col, int mine);
    
    public void Update(int row, int col, int val);
    
    public void ToggleFlagged(int row, int col);
    
    public boolean IsFirstClick();
    
    public void GameStarted();
    
    public void SetTime(String s);
    
    public String GetClockTime();
    
    public void SetFlagLeft(String s);
    
    public String GetFlagLeft();
    
    public void Win();
    
    public void Lost();
}
