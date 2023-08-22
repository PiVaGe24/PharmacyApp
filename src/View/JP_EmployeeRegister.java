package View;

import Model.Rol;

public class JP_EmployeeRegister extends View.swing.RoundPanel {

    public JP_EmployeeRegister() {
        initComponents();
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_employee_add);
        btn_employee_add.setUI(roundUI);
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_employee_update);
        btn_employee_update.setUI(roundUI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_employee_id = new View.TextField();
        txt_employee_fullname = new View.TextField();
        txt_employee_username = new View.TextField();
        cmb_employee_rol = new View.ComboBoxSuggestion<>();
        txt_employee_password = new View.PasswordField();
        txt_employee_email = new View.TextField();
        txt_employee_telephone = new View.TextField();
        txt_employee_address = new View.TextField();
        jPanel21 = new javax.swing.JPanel();
        btn_employee_update = new javax.swing.JButton();
        btn_employee_add = new javax.swing.JButton();
        btn_employee_cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_employee_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_id.setLabelText("N° Identificación");
        txt_employee_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_id.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_employee_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_employee_idKeyTyped(evt);
            }
        });

        txt_employee_fullname.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_fullname.setLabelText("Full Name");
        txt_employee_fullname.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_fullname.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_employee_username.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_username.setLabelText("Username");
        txt_employee_username.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_username.setSelectionColor(new java.awt.Color(213, 234, 218));

        cmb_employee_rol.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txt_employee_password.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_password.setLabelText("Password");
        txt_employee_password.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_password.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_employee_password.setShowAndHide(true);

        txt_employee_email.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_email.setLabelText("Email");
        txt_employee_email.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_email.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_employee_telephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_telephone.setLabelText("Telephone");
        txt_employee_telephone.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_telephone.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_employee_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_employee_telephoneKeyTyped(evt);
            }
        });

        txt_employee_address.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_employee_address.setLabelText("Address");
        txt_employee_address.setLineColor(new java.awt.Color(119, 153, 60));
        txt_employee_address.setSelectionColor(new java.awt.Color(213, 234, 218));

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_employee_update.setFont(new java.awt.Font("Lucida Sans", 0, 22)); // NOI18N
        btn_employee_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_employee_update.setText("UPDATE");
        btn_employee_update.setBorder(null);
        btn_employee_update.setContentAreaFilled(false);
        jPanel21.add(btn_employee_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        btn_employee_add.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_employee_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_employee_add.setText("ADD");
        btn_employee_add.setBorder(null);
        btn_employee_add.setBorderPainted(false);
        btn_employee_add.setContentAreaFilled(false);
        btn_employee_add.setHideActionText(true);
        btn_employee_add.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel21.add(btn_employee_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        btn_employee_cancel.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_employee_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_employee_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/returnx32.png"))); // NOI18N
        btn_employee_cancel.setBorder(null);
        btn_employee_cancel.setBorderPainted(false);
        btn_employee_cancel.setContentAreaFilled(false);
        btn_employee_cancel.setFocusPainted(false);
        btn_employee_cancel.setFocusable(false);
        btn_employee_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return2x32.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("EMPLOYEE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_employee_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_employee_fullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_employee_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_employee_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_employee_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_employee_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_employee_password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txt_employee_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txt_employee_telephone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_employee_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_employee_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_employee_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_employee_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_employee_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_employee_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_employee_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_employee_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_employee_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employee_idKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        if(txt_employee_id.getText().length()>15){
            evt.consume();
        }
    }//GEN-LAST:event_txt_employee_idKeyTyped

    private void txt_employee_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employee_telephoneKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        if(txt_employee_telephone.getText().length()>15){
            evt.consume();
        }
    }//GEN-LAST:event_txt_employee_telephoneKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_employee_add;
    public javax.swing.JButton btn_employee_cancel;
    public javax.swing.JButton btn_employee_update;
    public View.ComboBoxSuggestion<Rol> cmb_employee_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel21;
    public View.TextField txt_employee_address;
    public View.TextField txt_employee_email;
    public View.TextField txt_employee_fullname;
    public View.TextField txt_employee_id;
    public View.PasswordField txt_employee_password;
    public View.TextField txt_employee_telephone;
    public View.TextField txt_employee_username;
    // End of variables declaration//GEN-END:variables
}
