/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.JF_Main;
import View.JP_Menu;
import View.ScrollBarCustom;
import View.event.EventMenu;
import View.swing.ButtonMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PIERO
 */
public class Maincontrol {
    private JF_Main jfMain;
    private JP_Menu jpMenu;
    private EventMenu event;
    
    public Maincontrol(JF_Main jfMain, JP_Menu jpMenu) {
        this.jfMain = jfMain;
        this.jpMenu = jpMenu;
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        jpMenu.jScrollPane1.setVerticalScrollBar(sb);
        jpMenu.panelMenu.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
    }
    
    public void initMenu(EventMenu evt){
        this.event=evt; 
        addMenu(new ImageIcon(getClass().getResource("/com/icon/1.png")), "Dashboard", 0);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/2.png")), "Aplication", 1);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/3.png")), "Staff", 2);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/4.png")), "Report", 3);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/5.png")), "Note", 4);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/6.png")), "Export", 5);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/7.png")), "Import", 6);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/8.png")), "Setting", 7);
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/com/icon/logout.png")), "Logout", 8);             
    }
    
    private void addEmpty(){
        jpMenu.panelMenu.add(new JLabel(),"push");
    }
    
    private void addMenu(Icon icon,String strg,int index){
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        menu.setText(strg);
        jpMenu.panelMenu.add(menu);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
                setSelected(menu);
            }
        });
    }
    
    private void setSelected(ButtonMenu menu){
        for (Component com:jpMenu.panelMenu.getComponents()) {
            if(com instanceof ButtonMenu){
                ButtonMenu b = (ButtonMenu)com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }
    
}
