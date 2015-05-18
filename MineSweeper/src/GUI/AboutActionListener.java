/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Naima
 */
class AboutActionListener implements MenuListener {

    public AboutActionListener() {
    }

    @Override
    public void menuSelected(MenuEvent e) {
        JMenu aboutMenu = (JMenu)e.getSource();
        Container container = aboutMenu.getParent();
        JOptionPane.showMessageDialog(container,
              "MinesSeeper v1.0\nAuthor: Naima Hossain\nCreated: 05/18/2015");
        aboutMenu.setSelected(false);
    }

    @Override
    public void menuDeselected(MenuEvent e) {
    }

    @Override
    public void menuCanceled(MenuEvent e) {
    }
    
}
