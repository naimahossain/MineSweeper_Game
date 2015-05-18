/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Naima
 */
public class Values {
    public static int Rows;
    public static int Cols;
    public static int Mines;
    
    public static void SetDefault(){
        Rows = 16;
        Cols = 16;
        Mines = 40;
    }
    
    public static void SetBeginner(){
        Rows = 9;
        Cols = 9;
        Mines = 10;
    }
    
    public static void SetIntermediate(){
        Rows = 16;
        Cols = 16;
        Mines = 40;
    }
    
    public static void SetExpert(){
        Rows = 16;
        Cols = 30;
        Mines = 99;
    }
    
    public static void SetCustom(int row, int col, int mine){
        Rows = row;
        Cols = col;
        Mines = mine;
    }
}
