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
    private static final String baseDir = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "GUI" + File.separator + "Images" + File.separator;
    
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
        UNCLICKED = new ImageIcon(baseDir + "unclicked.GIF");
        BLANK = new ImageIcon(baseDir + "blank.GIF");
        MINE = new ImageIcon(baseDir + "mine.GIF");
        ONE = new ImageIcon(baseDir + "one.GIF");
        TWO = new ImageIcon(baseDir + "two.GIF");
        THREE = new ImageIcon(baseDir + "three.GIF");
        FOUR = new ImageIcon(baseDir + "four.GIF");
        FIVE = new ImageIcon(baseDir + "five.GIF");
        SIX = new ImageIcon(baseDir + "six.GIF");
        SEVEN = new ImageIcon(baseDir + "seven.GIF");
        EIGHT = new ImageIcon(baseDir + "eight.GIF");
        FLAG = new ImageIcon(baseDir + "flag.GIF");
        EXPLODED = new ImageIcon(baseDir + "exploded.GIF");
        NOTMINE = new ImageIcon(baseDir + "notmine.GIF");
        YELLOWFACE = new ImageIcon(baseDir + "yellowface.GIF");
        DEADFACE = new ImageIcon(baseDir + "deadface.GIF");
        SUNGLASSFACE = new ImageIcon(baseDir + "sunglassface.GIF");
        HAPPY = new ImageIcon(baseDir + "happy_yippee.GIF");
        SAD = new ImageIcon(baseDir + "Sad.GIF");
    }
}


