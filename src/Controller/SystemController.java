/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.JF_System;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author PIERO
 */
public class SystemController implements MouseListener{

    private JF_System jfSystem;
    
    public SystemController(JF_System jfSystem){
        this.jfSystem=jfSystem;
        this.jfSystem.lbl_products.addMouseListener(this);
        this.jfSystem.lbl_purchases.addMouseListener(this);
        this.jfSystem.lbl_sales.addMouseListener(this);
        this.jfSystem.lbl_customers.addMouseListener(this);
        this.jfSystem.lbl_employees.addMouseListener(this);
        this.jfSystem.lbl_suppliers.addMouseListener(this);
        this.jfSystem.lbl_categories.addMouseListener(this);
        this.jfSystem.lbl_reports.addMouseListener(this);
        this.jfSystem.lbl_settings.addMouseListener(this);
    }
            
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==jfSystem.lbl_products){
            jfSystem.JP_Products.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_purchases){
            jfSystem.JP_Purchases.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_sales){
            jfSystem.JP_Sales.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_customers){
            jfSystem.JP_Customers.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_employees){
            jfSystem.JP_Employees.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_suppliers){
            jfSystem.JP_Suppliers.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_categories){
            jfSystem.JP_Categories.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_reports){
            jfSystem.JP_Reports.setBackground(new Color(153, 203, 203));
        }else if(e.getSource()==jfSystem.lbl_settings){
            jfSystem.JP_Settings.setBackground(new Color(153, 203, 203));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==jfSystem.lbl_products){
            jfSystem.JP_Products.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_purchases){
            jfSystem.JP_Purchases.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_sales){
            jfSystem.JP_Sales.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_customers){
            jfSystem.JP_Customers.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_employees){
            jfSystem.JP_Employees.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_suppliers){
            jfSystem.JP_Suppliers.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_categories){
            jfSystem.JP_Categories.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_reports){
            jfSystem.JP_Reports.setBackground(new Color(18,45,61));
        }else if(e.getSource()==jfSystem.lbl_settings){
            jfSystem.JP_Settings.setBackground(new Color(18,45,61));
        }
    }
    
    
}
