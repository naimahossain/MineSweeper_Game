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
    private static final String baseDir = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "GUI" + File.separator + "Images" + File.separator;
    
    public final static ImageIcon UNCLICKED = new ImageIcon(baseDir + "unclicked.GIF");
    public final static ImageIcon BLANK = new ImageIcon(baseDir + "blank.GIF");
    public final static ImageIcon MINE = new ImageIcon(baseDir + "mine.GIF");
    public final static ImageIcon ONE = new ImageIcon(baseDir + "one.GIF");
    public final static ImageIcon TWO = new ImageIcon(baseDir + "two.GIF");
    public final static ImageIcon THREE = new ImageIcon(baseDir + "three.GIF");
    public final static ImageIcon FOUR = new ImageIcon(baseDir + "four.GIF");
    public final static ImageIcon FIVE = new ImageIcon(baseDir + "five.GIF");
    public final static ImageIcon SIX = new ImageIcon(baseDir + "six.GIF");
    public final static ImageIcon SEVEN = new ImageIcon(baseDir + "seven.GIF");
    public final static ImageIcon EIGHT = new ImageIcon(baseDir + "eight.GIF");
    public final static ImageIcon FLAG = new ImageIcon(baseDir + "flag.GIF");
    public final static ImageIcon EXPLODED = new ImageIcon(baseDir + "exploded.GIF");
    public final static ImageIcon NOTMINE = new ImageIcon(baseDir + "notmine.GIF");
    public final static ImageIcon YELLOWFACE = new ImageIcon(baseDir + "yellowface.GIF");
    public final static ImageIcon DEADFACE = new ImageIcon(baseDir + "deadface.GIF");
    public final static ImageIcon SUNGLASSFACE = new ImageIcon(baseDir + "sunglassface.GIF");
    public final static ImageIcon HAPPY = new ImageIcon(baseDir + "happy_yippee.GIF");
    public final static ImageIcon SAD = new ImageIcon(baseDir + "Sad.GIF");
}
