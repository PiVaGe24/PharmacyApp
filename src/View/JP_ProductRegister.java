package View;

import Model.Category;

public class JP_ProductRegister extends javax.swing.JPanel {

    public JP_ProductRegister() {
        initComponents();
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_product_add);
        btn_product_add.setUI(roundUI);
        
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_product_update);
        btn_product_update.setUI(roundUI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_product_code = new View.TextField();
        txt_product_name = new View.TextField();
        txt_product_price = new View.TextField();
        txt_product_description = new View.TextField();
        txt_product_id = new View.TextField();
        cmb_product_category = new View.ComboBoxSuggestion<>();
        btn_product_cancel = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        btn_product_update = new javax.swing.JButton();
        btn_product_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_product_code.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_product_code.setLabelText("Code");
        txt_product_code.setLineColor(new java.awt.Color(119, 153, 60));
        txt_product_code.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_product_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_product_codeKeyTyped(evt);
            }
        });

        txt_product_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_product_name.setLabelText("Name");
        txt_product_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_product_name.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_product_price.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_product_price.setLabelText("Unit Price");
        txt_product_price.setLineColor(new java.awt.Color(119, 153, 60));
        txt_product_price.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_product_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_product_priceKeyTyped(evt);
            }
        });

        txt_product_description.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_product_description.setLabelText("Description");
        txt_product_description.setLineColor(new java.awt.Color(119, 153, 60));
        txt_product_description.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_product_id.setEditable(false);
        txt_product_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_product_id.setLabelText("N° Identificación");
        txt_product_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_product_id.setSelectionColor(new java.awt.Color(213, 234, 218));

        cmb_product_category.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        btn_product_cancel.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_product_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_product_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/returnx32.png"))); // NOI18N
        btn_product_cancel.setBorder(null);
        btn_product_cancel.setBorderPainted(false);
        btn_product_cancel.setContentAreaFilled(false);
        btn_product_cancel.setFocusPainted(false);
        btn_product_cancel.setFocusable(false);
        btn_product_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return2x32.png"))); // NOI18N

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_product_update.setFont(new java.awt.Font("Lucida Sans", 0, 22)); // NOI18N
        btn_product_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_product_update.setText("UPDATE");
        btn_product_update.setBorder(null);
        jPanel21.add(btn_product_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        btn_product_add.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        btn_product_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_product_add.setText("ADD");
        btn_product_add.setBorder(null);
        btn_product_add.setBorderPainted(false);
        btn_product_add.setHideActionText(true);
        btn_product_add.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel21.add(btn_product_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("PRODUCT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btn_product_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(221, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_product_price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_product_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_product_code, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                    .addGap(156, 156, 156)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmb_product_category, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_product_description, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(txt_product_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_product_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_product_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_product_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_product_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_product_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_codeKeyTyped
       char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        if(txt_product_code.getText().length()>15){
            evt.consume();
        }
    }//GEN-LAST:event_txt_product_codeKeyTyped

    private void txt_product_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_priceKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }else{
            try {
                Double.parseDouble(txt_product_price.getText()+evt.getKeyChar());
            } catch (NumberFormatException e) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_product_priceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_product_add;
    public javax.swing.JButton btn_product_cancel;
    public javax.swing.JButton btn_product_update;
    public View.ComboBoxSuggestion<Category> cmb_product_category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel21;
    public View.TextField txt_product_code;
    public View.TextField txt_product_description;
    public View.TextField txt_product_id;
    public View.TextField txt_product_name;
    public View.TextField txt_product_price;
    // End of variables declaration//GEN-END:variables
}
