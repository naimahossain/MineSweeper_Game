/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.MineSweeperMain;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Naima
 */
public class MineSweeperGui extends JFrame implements IMineSweeperGui{

    private final static int SQUARESIZE = 20;
    private static MineSweeperMain _main;
    
    
    private int _rows;
    private int _cols;
    private int _mines;
    private boolean _firstClick;
    private BoxButton[][] _boxes;
    
    
    //FRAME
    private Container _container;
    private JPanel _buttonPanel;
    private JButton _yellowFace;
    private JTextField _clock;
    private JTextField _flagsLeft;
    
    
    private static MineSweeperGui _obj;
    

    private MineSweeperGui(final MineSweeperMain main) {
        _main = main;
    } 
    
    public static MineSweeperGui GetObj(final MineSweeperMain main){
        if(_obj == null)
            _obj = new MineSweeperGui(main);
        
        return _obj;
    }
    
    @Override
    public void InitGame(int row, int col, int mine) {
        _rows = row;
        _cols = col;
        _mines = mine;
        _firstClick = true;
        
        SetFrame();
        InitButtonBoxes();
        setVisible(true);
    }
    
    private void SetFrame(){
        this.setTitle("MineSweeper");
        setLocation(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _container = this.getContentPane();
        _container.removeAll();
        this.setSize(_cols * SQUARESIZE, _rows * SQUARESIZE + 120);
        
        JPanel scoreTray = GetScorePane();
        JMenuBar menuBar = GetMenuBar();
        JPanel north = new JPanel();
        north.setSize(_cols * SQUARESIZE, 20);
        north.setLayout(new BoxLayout(north, 1));
        menuBar.setSize(_cols * SQUARESIZE, 10);
        north.add(menuBar);
        scoreTray.setSize(_cols * SQUARESIZE, 10);
        north.add(scoreTray);
        _container.add(north, BorderLayout.NORTH);
    } 
    
    private JPanel GetScorePane(){
        _clock = new JTextField("" + 0);
        _clock.setColumns(3);
        _clock.setEditable(false);
        _flagsLeft = new JTextField("" + _mines);
        _flagsLeft.setColumns(3);
        _flagsLeft.setEditable(false);
        _yellowFace = new JButton(Image.YELLOWFACE);
        JPanel scoreTray = new JPanel();
        scoreTray.add(_clock);
        scoreTray.add(_yellowFace);
        scoreTray.add(_flagsLeft);
        return scoreTray;
    }
    
    private JMenuBar GetMenuBar(){
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new InitGameActionListener(new MainActions(_main)));
        JMenuItem options = new JMenuItem("Options");
        options.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Options options = new Options(_main);
            }
        });
        JMenu game = new JMenu("Game");
        game.add(newGame);
        game.add(options);
        
        JMenuItem how2 = new JMenuItem("How To");
        how2.addActionListener(new HelpActionListener());
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new AboutActionListener());
        JMenu help = new JMenu("Help");
        help.add(how2);
        help.add(about);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(game);
        menuBar.add(help);
        setJMenuBar(menuBar);
        return menuBar;
    } 
    
    private void InitButtonBoxes(){
        if (_buttonPanel != null)
            this.remove(_buttonPanel);
        _boxes = new BoxButton[_rows][_cols];
        _buttonPanel = new JPanel();
        _buttonPanel.setLocation(0, 0);
        _buttonPanel.setPreferredSize(new Dimension(_cols * SQUARESIZE, _rows * SQUARESIZE));
        GridLayout layoutBoxGrids = new GridLayout(_rows, _cols);
        _buttonPanel.setLayout(layoutBoxGrids);
        for(int i = 0; i < _rows ; i++){
            for(int j = 0; j < _cols; j++){
                _boxes[i][j] = new BoxButton(i, j);
                _boxes[i][j].addMouseListener(new MouseClickListener(new MainActions(_main))); 
                _buttonPanel.add(_boxes[i][j]);
            }
        }
        _container.add(_buttonPanel, BorderLayout.CENTER);
        validate();
    }
    
    @Override
    public void Update(int row, int col, int val) {
        _boxes[row][col].SetVisible(val);
    }

    @Override
    public void ToggleFlagged(int row, int col) {
        _boxes[row][col].ToggleFlag();
    }
    
    @Override
    public boolean IsFirstClick(){
        return _firstClick;
    }
    
    @Override
    public void GameStarted(){
        _firstClick = false;
    }
    
    @Override
    public void SetTime(String s){
        _clock.setText(s);
    }
    
    @Override
    public String GetClockTime(){
        return _clock.getText();
    }
    
    @Override
    public void SetFlagLeft(String s){
        _flagsLeft.setText(s);
    }
    
    @Override
    public String GetFlagLeft(){
        return _flagsLeft.getText();
    }

    @Override
    public void Win() {
        _yellowFace.setIcon(Image.SUNGLASSFACE);
        ShowUpdate("Congratulation. You won the game.","Game Win", Image.HAPPY);
    }
    
    @Override
    public void Lost(){
        _yellowFace.setIcon(Image.DEADFACE);
        ShowUpdate("Sorry. You lost the game.","Game Lost", Image.SAD);
    }
    
    private void ShowUpdate(String msg, String title, ImageIcon icon){
        int result = JOptionPane.showConfirmDialog(this, msg + "\nDo you want to play again?", 
                            title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if(result == JOptionPane.YES_OPTION)
            _main.InitGame();
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
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
