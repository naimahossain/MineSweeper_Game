/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.MineSweeperMain;

/**
 *
 * @author Naima
 */
class MainActions {

    private final MineSweeperMain _main;
    public MainActions(final MineSweeperMain main) {
        _main = main;
    }
    
    public MineSweeperMain GetMain(){
        return _main;
    }
}
