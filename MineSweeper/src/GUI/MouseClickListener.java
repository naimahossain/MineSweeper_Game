/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.MineSweeperMain;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Naima
 */
class MouseClickListener implements MouseListener {
    private final MineSweeperMain _main;

    public MouseClickListener(MainActions act) {
        _main = act.GetMain();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BoxButton b = (BoxButton)e.getSource();
        int clickCount = e.getClickCount();
        if(SwingUtilities.isLeftMouseButton(e) )
            _main.Click(b.GetRow(), b.GetCol(), clickCount);
        else
            _main.ToggleFlag(b.GetRow(), b.GetCol());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
