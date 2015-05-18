/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Naima
 */
class HelpActionListener implements ActionListener {

    public HelpActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem helpMenu = (JMenuItem)e.getSource();
        Container container = helpMenu.getParent().getParent();
        JOptionPane.showMessageDialog(container,
            "To start, click a tile.\n" +
            "\n" +
            "The rules in Minesweeper are simple:\n" +
            "\n" +
            "1. Uncover a mine, and the game ends.\n" +
            "2. Uncover an empty square, and you keep playing.\n" +
            "3. Uncover a number, and it tells you how many mines lay hidden in the eight surrounding\n" +
            "squares—information you use to deduce which nearby squares are safe to click.\n" +
            "\n" +
            "Hints and tips:\n" + 
            "\n" +
            "1. Mark the mines. If you suspect a square conceals a mine, right-click it. This puts a flag \n" +
            "on the square. (If you're not sure, right-click again to make it unflagged.)\n" +
            "2. Study the patterns. If three squares in a row display 2-3-2, then you know three mines are \n" + 
            "probably lined up beside that row. If a square says 8, every surrounding square is mined.\n" +
            "3. Explore the unexplored. Not sure where to click next? Try clearing some unexplored territory.\n" + 
            "You're better off clicking in the middle of unmarked squares than in an area you suspect is mined.");
    }
    
}
