package View;

import Model.MenuItem;
import Model.MenuItemDao;
import View.event.EventMenu;
import View.swing.ButtonMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
/**
 *
 * @author PIERO
 */
public class JP_Menu extends javax.swing.JPanel {

    private EventMenu event;
    private MenuItemDao menuItemDao = new MenuItemDao();

    public JP_Menu() {
        initComponents();
        setOpaque(false);
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        jScrollPane1.setVerticalScrollBar(sb);
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
    }

    public void initMenu(EventMenu event,int id,String name,String rol) {
        this.event = event;
        List<MenuItem> listdash = menuItemDao.ListPermissionsQuery(id);
        for(int i=0;i<listdash.size();i++){
            addMenu(new MenuItem(listdash.get(i).getName(),listdash.get(i).getIcon(), i));
            if(i == listdash.size()-2){
                addEmpty();
            }
        }
        lbl_username.setText(name);
        lbl_rol.setText(rol);
        //addMenu(, "Dashboard", 0);
        /*addMenu(new ImageIcon(getClass().getResource("/com/icon/employeex20.png")), "Employee", 1);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/customerx20.png")), "Customer", 2);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/7.png")), "Supplier", 3);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/5.png")), "Product", 4);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/categoryx20.png")), "Category", 5);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/forktruckx20.png")), "Purchase", 6);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/salex20.png")), "Sale", 7);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/reportx20.png")), "Report", 8);
        addMenu(new ImageIcon(getClass().getResource("/com/icon/8.png")), "Profile", 9);
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/com/icon/logout.png")), "Logout", 10);*/
    }

    public void ClearMenu() {
        panelMenu.removeAll();
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    private void addEmpty() {
        panelMenu.add(new JLabel(), "push");
    }
    
    private void addMenu(MenuItem item) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(new ImageIcon(getClass().getResource(item.getIcon())));
        menu.setText("  " + item.getName());
        panelMenu.add(menu);
        menu.setFocusPainted(false);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(item);
                setSelected(menu);
            }
        });
    }

    private void setSelected(ButtonMenu menu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel5 = new View.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        roundPanel4 = new View.swing.RoundPanel();
        imageAvatar1 = new View.swing.ImageAvatar();
        lbl_username = new javax.swing.JLabel();
        lbl_rol = new javax.swing.JLabel();

        roundPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelMenu);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        roundPanel4.setBackground(new java.awt.Color(51, 51, 51));

        imageAvatar1.setBorderSize(2);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/profilex479.png"))); // NOI18N

        lbl_username.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Username");

        lbl_rol.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_rol.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rol.setText("Admin");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_rol)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.swing.ImageAvatar imageAvatar1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbl_rol;
    public javax.swing.JLabel lbl_username;
    public javax.swing.JPanel panelMenu;
    private View.swing.RoundPanel roundPanel4;
    private View.swing.RoundPanel roundPanel5;
    // End of variables declaration//GEN-END:variables
}
