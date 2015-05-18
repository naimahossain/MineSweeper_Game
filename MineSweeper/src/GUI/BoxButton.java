/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JButton;

/**
 *
 * @author Naima
 */
public class BoxButton extends JButton implements IBoxButton{
    private boolean _flagged;
    private final int _row;
    private final int _col;
    
    public BoxButton(int row, int col){
        super();
        _row = row;
        _col = col;
        _flagged = false;
        setIcon(Image.UNCLICKED);
    }
    
    @Override
    public int GetRow(){
        return _row;
    }
    
    @Override
    public int GetCol(){
        return _col;
    }
    
    @Override
    public void SetVisible(int v){
        if(_flagged && v>-1){
            this.setIcon(Image.NOTMINE);
            return;
        }
        switch(v){
            case -1:
                this.setIcon(Image.EXPLODED);
                break;
            case 0:
                this.setIcon(Image.BLANK);
                break;
            case 1:
                this.setIcon(Image.ONE);
                break;
            case 2:
                this.setIcon(Image.TWO);
                break;
            case 3:
                this.setIcon(Image.THREE);
                break;
            case 4:
                this.setIcon(Image.FOUR);
                break;
            case 5:
                this.setIcon(Image.FIVE);
                break;
            case 6:
                this.setIcon(Image.SIX);
                break;
            case 7:
                this.setIcon(Image.SEVEN);
                break;
            case 8:
                this.setIcon(Image.EIGHT);
                break;
        }
    } 
    
    @Override
    public void ToggleFlag(){
        if(_flagged)
            this.setIcon(Image.UNCLICKED);
        else
            this.setIcon(Image.FLAG);
            
        _flagged = !_flagged;
    }
}
