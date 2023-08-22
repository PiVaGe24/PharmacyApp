package View;

public class JP_Profile extends javax.swing.JPanel {

    /**
     * Creates new form JP_Profile
     */
    public JP_Profile() {
        initComponents();
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_profile_update);
        btn_profile_update.setUI(roundUI);
        txt_profile_name.setEditable(false);
        txt_profile_telephone.setEditable(false);
        txt_profile_id.setEditable(false);
        txt_profile_address.setEditable(false);
        txt_profile_email.setEditable(false);
        txt_profile_rol.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_profile_modify_password = new View.PasswordField();
        txt_profile_confirm_password = new View.PasswordField();
        btn_profile_update = new javax.swing.JButton();
        jPanelRound2 = new LIB.JPanelRound();
        txt_profile_name = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanelRound3 = new LIB.JPanelRound();
        txt_profile_telephone = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanelRound4 = new LIB.JPanelRound();
        txt_profile_id = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanelRound5 = new LIB.JPanelRound();
        txt_profile_address = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanelRound6 = new LIB.JPanelRound();
        txt_profile_email = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanelRound7 = new LIB.JPanelRound();
        txt_profile_rol = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanelRound8 = new LIB.JPanelRound();
        jLabel25 = new javax.swing.JLabel();
        cmb_profile_languaje = new View.ComboBoxSuggestion<>();
        jLabel1 = new javax.swing.JLabel();

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/userx256.png"))); // NOI18N
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 240));

        txt_profile_modify_password.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txt_profile_modify_password.setLabelText("Modify Password");
        txt_profile_modify_password.setLineColor(new java.awt.Color(119, 153, 60));
        txt_profile_modify_password.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_profile_modify_password.setShowAndHide(true);
        jPanel11.add(txt_profile_modify_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 220, -1));

        txt_profile_confirm_password.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txt_profile_confirm_password.setLabelText("Confirm Password");
        txt_profile_confirm_password.setLineColor(new java.awt.Color(119, 153, 60));
        txt_profile_confirm_password.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_profile_confirm_password.setShowAndHide(true);
        jPanel11.add(txt_profile_confirm_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 220, -1));

        btn_profile_update.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_profile_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_profile_update.setText("UPDATE");
        jPanel11.add(btn_profile_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 170, 40));

        jPanelRound2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound2.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound2.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound2.setOpaque(true);

        txt_profile_name.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_profile_name.setBorder(null);
        txt_profile_name.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(180, 180, 180));
        jLabel19.setText("Full Name");

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txt_profile_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel19)
                .addGap(3, 3, 3)
                .addComponent(txt_profile_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel11.add(jPanelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, 55));

        jPanelRound3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound3.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound3.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound3.setOpaque(true);

        txt_profile_telephone.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_profile_telephone.setBorder(null);
        txt_profile_telephone.setOpaque(false);

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(180, 180, 180));
        jLabel20.setText("Telephone");

        javax.swing.GroupLayout jPanelRound3Layout = new javax.swing.GroupLayout(jPanelRound3);
        jPanelRound3.setLayout(jPanelRound3Layout);
        jPanelRound3Layout.setHorizontalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txt_profile_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound3Layout.setVerticalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel20)
                .addGap(3, 3, 3)
                .addComponent(txt_profile_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel11.add(jPanelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 230, -1));

        jPanelRound4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound4.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound4.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound4.setOpaque(true);

        txt_profile_id.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_profile_id.setBorder(null);
        txt_profile_id.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(180, 180, 180));
        jLabel21.setText("N° Identificación");

        javax.swing.GroupLayout jPanelRound4Layout = new javax.swing.GroupLayout(jPanelRound4);
        jPanelRound4.setLayout(jPanelRound4Layout);
        jPanelRound4Layout.setHorizontalGroup(
            jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txt_profile_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound4Layout.setVerticalGroup(
            jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel21)
                .addGap(3, 3, 3)
                .addComponent(txt_profile_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel11.add(jPanelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 230, -1));

        jPanelRound5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound5.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound5.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound5.setOpaque(true);

        txt_profile_address.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_profile_address.setBorder(null);
        txt_profile_address.setOpaque(false);

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(180, 180, 180));
        jLabel22.setText("Address");

        javax.swing.GroupLayout jPanelRound5Layout = new javax.swing.GroupLayout(jPanelRound5);
        jPanelRound5.setLayout(jPanelRound5Layout);
        jPanelRound5Layout.setHorizontalGroup(
            jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txt_profile_address, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound5Layout.setVerticalGroup(
            jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel22)
                .addGap(3, 3, 3)
                .addComponent(txt_profile_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel11.add(jPanelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 230, -1));

        jPanelRound6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound6.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound6.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound6.setOpaque(true);

        txt_profile_email.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_profile_email.setBorder(null);
        txt_profile_email.setOpaque(false);

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(180, 180, 180));
        jLabel23.setText("E-mail");

        javax.swing.GroupLayout jPanelRound6Layout = new javax.swing.GroupLayout(jPanelRound6);
        jPanelRound6.setLayout(jPanelRound6Layout);
        jPanelRound6Layout.setHorizontalGroup(
            jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txt_profile_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound6Layout.setVerticalGroup(
            jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel23)
                .addGap(3, 3, 3)
                .addComponent(txt_profile_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel11.add(jPanelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 230, -1));

        jPanelRound7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound7.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound7.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound7.setOpaque(true);

        txt_profile_rol.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_profile_rol.setBorder(null);
        txt_profile_rol.setOpaque(false);

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(180, 180, 180));
        jLabel24.setText("Rol");

        javax.swing.GroupLayout jPanelRound7Layout = new javax.swing.GroupLayout(jPanelRound7);
        jPanelRound7.setLayout(jPanelRound7Layout);
        jPanelRound7Layout.setHorizontalGroup(
            jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txt_profile_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound7Layout.setVerticalGroup(
            jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel24)
                .addGap(3, 3, 3)
                .addComponent(txt_profile_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel11.add(jPanelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 230, -1));

        jPanelRound8.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound8.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound8.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound8.setOpaque(true);

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(180, 180, 180));
        jLabel25.setText("Language");

        cmb_profile_languaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Español" }));
        cmb_profile_languaje.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelRound8Layout = new javax.swing.GroupLayout(jPanelRound8);
        jPanelRound8.setLayout(jPanelRound8Layout);
        jPanelRound8Layout.setHorizontalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel25)
                .addGap(154, 154, 154))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmb_profile_languaje, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelRound8Layout.setVerticalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_profile_languaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.add(jPanelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("PROFILE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_profile_update;
    public View.ComboBoxSuggestion<String> cmb_profile_languaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel11;
    private LIB.JPanelRound jPanelRound2;
    private LIB.JPanelRound jPanelRound3;
    private LIB.JPanelRound jPanelRound4;
    private LIB.JPanelRound jPanelRound5;
    private LIB.JPanelRound jPanelRound6;
    private LIB.JPanelRound jPanelRound7;
    private LIB.JPanelRound jPanelRound8;
    public javax.swing.JTextField txt_profile_address;
    public View.PasswordField txt_profile_confirm_password;
    public javax.swing.JTextField txt_profile_email;
    public javax.swing.JTextField txt_profile_id;
    public View.PasswordField txt_profile_modify_password;
    public javax.swing.JTextField txt_profile_name;
    public javax.swing.JTextField txt_profile_rol;
    public javax.swing.JTextField txt_profile_telephone;
    // End of variables declaration//GEN-END:variables
}
