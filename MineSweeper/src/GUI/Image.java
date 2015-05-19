/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Naima
 */
public class Image {
    
    private static Image _obj;
    
    public ImageIcon UNCLICKED;
    public ImageIcon BLANK;
    public ImageIcon MINE;
    public ImageIcon ONE;
    public ImageIcon TWO;
    public ImageIcon THREE;
    public ImageIcon FOUR;
    public ImageIcon FIVE;
    public ImageIcon SIX;
    public ImageIcon SEVEN;
    public ImageIcon EIGHT;
    public ImageIcon FLAG;
    public ImageIcon EXPLODED;
    public ImageIcon NOTMINE;
    public ImageIcon YELLOWFACE;
    public ImageIcon DEADFACE;
    public ImageIcon SUNGLASSFACE;
    public ImageIcon HAPPY;
    public ImageIcon SAD;
    
        
    private Image(){
        SetImageIcons();
    }    
    
    public static Image GetObj(){
        if(_obj == null)
            _obj = new Image();
        return _obj;
    }
    
    private void SetImageIcons(){
        UNCLICKED = new ImageIcon(Image.class.getResource("Images/unclicked.GIF"));
        BLANK = new ImageIcon(Image.class.getResource("Images/blank.GIF"));
        MINE = new ImageIcon(Image.class.getResource("Images/mine.GIF"));
        ONE = new ImageIcon(Image.class.getResource("Images/one.GIF"));
        TWO = new ImageIcon(Image.class.getResource("Images/two.GIF"));
        THREE = new ImageIcon(Image.class.getResource("Images/three.GIF"));
        FOUR = new ImageIcon(Image.class.getResource("Images/four.GIF"));
        FIVE = new ImageIcon(Image.class.getResource("Images/five.GIF"));
        SIX = new ImageIcon(Image.class.getResource("Images/six.GIF"));
        SEVEN = new ImageIcon(Image.class.getResource("Images/seven.GIF"));
        EIGHT = new ImageIcon(Image.class.getResource("Images/eight.GIF"));
        FLAG = new ImageIcon(Image.class.getResource("Images/flag.GIF"));
        EXPLODED = new ImageIcon(Image.class.getResource("Images/exploded.GIF"));
        NOTMINE = new ImageIcon(Image.class.getResource("Images/notmine.GIF"));
        YELLOWFACE = new ImageIcon(Image.class.getResource("Images/yellowface.GIF"));
        DEADFACE = new ImageIcon(Image.class.getResource("Images/deadface.GIF"));
        SUNGLASSFACE = new ImageIcon(Image.class.getResource("Images/sunglassface.GIF"));
        HAPPY = new ImageIcon(Image.class.getResource("Images/HappyDance.gif"));
        SAD = new ImageIcon(Image.class.getResource("Images/big-cry.gif"));
    }
}


