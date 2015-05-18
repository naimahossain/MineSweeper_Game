/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.Values;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Naima
 */
public class Options extends javax.swing.JFrame {

    /**
     * Creates new form Options
     */
    
    private JTextField _tRows;
    private JTextField _tCols;
    private JTextField _tMines;
    
    private JButton _bEasy;
    private JButton _bMedium;
    private JButton _bExpert;  
    
    private void SetFrame(){
        setLocation(100, 100);
        setSize(330, 140);

        JTextField jTextRows = new JTextField("Rows: ");
        jTextRows.setEditable(false);
        JTextField jTextCols = new JTextField("Columns: ");
        jTextCols.setEditable(false);
        JTextField jTextMines = new JTextField("Mines: ");
        jTextMines.setEditable(false);
        
        _tRows = new JTextField("" + Values.Rows);
        _tCols = new JTextField("" + Values.Cols);
        _tMines = new JTextField("" + Values.Mines);
        
        JPanel values = new JPanel();
        values.setLayout(new GridLayout(3, 2));        
        values.add(jTextRows);
        values.add(_tRows);
        values.add(jTextCols);
        values.add(_tCols);
        values.add(jTextMines);
        values.add(_tMines);
        
        getContentPane().add(values, BorderLayout.NORTH);

        _bEasy = new JButton("Beginner");
        _bMedium = new JButton("Intermediate");
        _bExpert = new JButton("Expert");
        _bEasy.addActionListener(new ModeListener());
        _bMedium.addActionListener(new ModeListener());
        _bExpert.addActionListener(new ModeListener());
        
        JPanel modes = new JPanel();
        modes.setLayout(new GridLayout(1, 3));
        modes.add(_bEasy);
        modes.add(_bMedium);
        modes.add(_bExpert);

        getContentPane().add(modes, BorderLayout.CENTER);
        
        JButton okay = new JButton("OK");
        okay.addActionListener(new OkayListener(this));
        getContentPane().add(okay, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
    }
    
    public Options() {
        Values.SetDefault();
        SetFrame();
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private class ModeListener  implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(_bEasy))
                Values.SetBeginner();
            else if(e.getSource().equals(_bMedium))
                Values.SetIntermediate();
            else if(e.getSource().equals(_bExpert))
                Values.SetExpert();
            
            _tRows.setText("" + Values.Rows);
            _tCols.setText("" + Values.Cols);
            _tMines.setText("" + Values.Mines);
        }
    }
    
    private class OkayListener implements ActionListener {

        private final JFrame _optionWindow;

        public OkayListener(JFrame window) {
            this._optionWindow = window;
        }

        public void actionPerformed(ActionEvent arg0) {
            try {
                int r = Integer.parseInt(_tRows.getText());
                int c = Integer.parseInt(_tCols.getText());
                int m = Integer.parseInt(_tMines.getText());
                if (r > 0 && c > 0 && m < r * c) {
                    Values.Rows = r;
                    Values.Cols = c;
                    Values.Mines = m;
                } else
                    throw new NumberFormatException();
                _optionWindow.dispose();
            } catch (NumberFormatException nfe) {
            JOptionPane
                .showMessageDialog(_optionWindow,
                    "Please enter valid numbers (positive rows/columns and less than rows * columns mines");
          }
        }
      }
}
