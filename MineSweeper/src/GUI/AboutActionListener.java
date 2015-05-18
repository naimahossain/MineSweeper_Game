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
class AboutActionListener implements ActionListener {

    public AboutActionListener() {
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem aboutMenu = (JMenuItem)e.getSource();
        Container container = aboutMenu.getParent().getParent();
        JOptionPane.showMessageDialog(container,
              "MinesSeeper v1.0\nAuthor: Naima Hossain\nCreated: 05/18/2015");
        
    }
}
