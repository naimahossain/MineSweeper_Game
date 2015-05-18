/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Naima
 */
public interface IBoxButton {

    public int GetCol();

    public int GetRow();

    public void SetVisible(int v);

    public void ToggleFlag();
}
