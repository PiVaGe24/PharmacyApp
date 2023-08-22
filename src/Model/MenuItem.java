/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.Icon;

/**
 *
 * @author PIERO
 */
public class MenuItem {
    private String name;
    private String icon;
    private int index;

    public MenuItem() {
    }

    public MenuItem(String name, String icon, int index) {
        this.name = name;
        this.icon = icon;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
    
