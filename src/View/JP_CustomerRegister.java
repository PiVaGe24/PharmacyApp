package View;

public class JP_CustomerRegister extends javax.swing.JPanel {

    public JP_CustomerRegister() {
        initComponents();
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_customer_update);
        btn_customer_update.setUI(roundUI);
        
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_customer_add);
        btn_customer_add.setUI(roundUI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_customer_id = new View.TextField();
        txt_customer_fullname = new View.TextField();
        txt_customer_address = new View.TextField();
        txt_customer_telephone = new View.TextField();
        txt_customer_email = new View.TextField();
        btn_customer_cancel = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        btn_customer_update = new javax.swing.JButton();
        btn_customer_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_customer_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_customer_id.setLabelText("N° Identificación");
        txt_customer_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_customer_id.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_customer_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_customer_idKeyTyped(evt);
            }
        });

        txt_customer_fullname.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_customer_fullname.setLabelText("Full Name");
        txt_customer_fullname.setLineColor(new java.awt.Color(119, 153, 60));
        txt_customer_fullname.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_customer_address.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_customer_address.setLabelText("Address");
        txt_customer_address.setLineColor(new java.awt.Color(119, 153, 60));
        txt_customer_address.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_customer_telephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_customer_telephone.setLabelText("Telephone");
        txt_customer_telephone.setLineColor(new java.awt.Color(119, 153, 60));
        txt_customer_telephone.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_customer_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_customer_telephoneKeyTyped(evt);
            }
        });

        txt_customer_email.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_customer_email.setLabelText("E-mail");
        txt_customer_email.setLineColor(new java.awt.Color(119, 153, 60));
        txt_customer_email.setSelectionColor(new java.awt.Color(213, 234, 218));

        btn_customer_cancel.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_customer_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_customer_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/returnx32.png"))); // NOI18N
        btn_customer_cancel.setBorder(null);
        btn_customer_cancel.setBorderPainted(false);
        btn_customer_cancel.setContentAreaFilled(false);
        btn_customer_cancel.setFocusPainted(false);
        btn_customer_cancel.setFocusable(false);
        btn_customer_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return2x32.png"))); // NOI18N

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_customer_update.setFont(new java.awt.Font("Lucida Sans", 0, 22)); // NOI18N
        btn_customer_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_customer_update.setText("UPDATE");
        btn_customer_update.setBorder(null);
        jPanel21.add(btn_customer_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        btn_customer_add.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_customer_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_customer_add.setText("ADD");
        btn_customer_add.setBorder(null);
        btn_customer_add.setBorderPainted(false);
        btn_customer_add.setHideActionText(true);
        btn_customer_add.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel21.add(btn_customer_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("CUSTOMER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_customer_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(156, 156, 156)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_customer_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_customer_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_customer_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_customer_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_customer_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(txt_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_customer_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customer_telephoneKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        if(txt_customer_telephone.getText().length()>15){
            evt.consume();
        }
    }//GEN-LAST:event_txt_customer_telephoneKeyTyped

    private void txt_customer_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customer_idKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        if(txt_customer_id.getText().length()>15){
            evt.consume();
        }
    }//GEN-LAST:event_txt_customer_idKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_customer_add;
    public javax.swing.JButton btn_customer_cancel;
    public javax.swing.JButton btn_customer_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel21;
    public View.TextField txt_customer_address;
    public View.TextField txt_customer_email;
    public View.TextField txt_customer_fullname;
    public View.TextField txt_customer_id;
    public View.TextField txt_customer_telephone;
    // End of variables declaration//GEN-END:variables
}
