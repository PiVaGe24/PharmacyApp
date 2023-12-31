package View;

public class JP_SupplierRegister extends javax.swing.JPanel {

    /**
     * Creates new form JP_SupplierRegister
     */
    public JP_SupplierRegister() {
        initComponents();
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_supplier_update);
        btn_supplier_update.setUI(roundUI);
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_add_supplier);
        btn_add_supplier.setUI(roundUI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_supplier_cancel = new javax.swing.JButton();
        txt_supplier_name = new View.TextField();
        txt_supplier_address = new View.TextField();
        txt_supplier_telephone = new View.TextField();
        txt_supplier_email = new View.TextField();
        txt_supplier_description = new View.TextField();
        txt_supplier_id = new View.TextField();
        cmb_supplier_city = new View.ComboBoxSuggestion<>();
        jPanel21 = new javax.swing.JPanel();
        btn_supplier_update = new javax.swing.JButton();
        btn_add_supplier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btn_supplier_cancel.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_supplier_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/returnx32.png"))); // NOI18N
        btn_supplier_cancel.setBorder(null);
        btn_supplier_cancel.setBorderPainted(false);
        btn_supplier_cancel.setContentAreaFilled(false);
        btn_supplier_cancel.setFocusPainted(false);
        btn_supplier_cancel.setFocusable(false);
        btn_supplier_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return2x32.png"))); // NOI18N

        txt_supplier_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_supplier_name.setLabelText("Name");
        txt_supplier_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_supplier_name.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_supplier_address.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_supplier_address.setLabelText("Address");
        txt_supplier_address.setLineColor(new java.awt.Color(119, 153, 60));
        txt_supplier_address.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_supplier_telephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_supplier_telephone.setLabelText("Telephone");
        txt_supplier_telephone.setLineColor(new java.awt.Color(119, 153, 60));
        txt_supplier_telephone.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_supplier_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_supplier_telephoneKeyTyped(evt);
            }
        });

        txt_supplier_email.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_supplier_email.setLabelText("E-mail");
        txt_supplier_email.setLineColor(new java.awt.Color(119, 153, 60));
        txt_supplier_email.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_supplier_description.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_supplier_description.setLabelText("Description");
        txt_supplier_description.setLineColor(new java.awt.Color(119, 153, 60));
        txt_supplier_description.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_supplier_id.setEditable(false);
        txt_supplier_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_supplier_id.setLabelText("N° Identificación");
        txt_supplier_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_supplier_id.setSelectionColor(new java.awt.Color(213, 234, 218));

        cmb_supplier_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ica", "Lima" }));
        cmb_supplier_city.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_supplier_update.setFont(new java.awt.Font("Lucida Sans", 0, 22)); // NOI18N
        btn_supplier_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier_update.setText("UPDATE");
        btn_supplier_update.setBorder(null);
        jPanel21.add(btn_supplier_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        btn_add_supplier.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_add_supplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_add_supplier.setText("ADD");
        btn_add_supplier.setBorder(null);
        btn_add_supplier.setBorderPainted(false);
        btn_add_supplier.setHideActionText(true);
        btn_add_supplier.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel21.add(btn_add_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("SUPPLIER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_supplier_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_supplier_email, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txt_supplier_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_supplier_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txt_supplier_description, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(156, 156, 156)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_supplier_city, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_supplier_telephone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txt_supplier_address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_supplier_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_supplier_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_supplier_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_supplier_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_supplier_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_supplier_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(txt_supplier_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_supplier_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_supplier_telephoneKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'||txt_supplier_telephone.getText().length()>15){
            evt.consume();
        }
    }//GEN-LAST:event_txt_supplier_telephoneKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_add_supplier;
    public javax.swing.JButton btn_supplier_cancel;
    public javax.swing.JButton btn_supplier_update;
    public View.ComboBoxSuggestion<String> cmb_supplier_city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel21;
    public View.TextField txt_supplier_address;
    public View.TextField txt_supplier_description;
    public View.TextField txt_supplier_email;
    public View.TextField txt_supplier_id;
    public View.TextField txt_supplier_name;
    public View.TextField txt_supplier_telephone;
    // End of variables declaration//GEN-END:variables
}
