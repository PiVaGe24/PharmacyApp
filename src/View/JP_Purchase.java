package View;

import View.TableCustom.TableCustom;

public class JP_Purchase extends javax.swing.JPanel {

    /**
     * Creates new form JP_Purchase
     */
    public JP_Purchase() {
        initComponents();
        btn_remove_purchase.setVisible(false);
        ShapedButtonUICancel roundUIc = new ShapedButtonUICancel();
        roundUIc.setShape(ShapedButton.ButtonShape.ROUND, btn_new_purchase);
        btn_new_purchase.setUI(roundUIc);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        tableScrollButton2 = new View.TableCustom.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_purchase = new javax.swing.JTable();
        txt_purchase_product_code = new View.TextField();
        txt_purchase_product_name = new View.TextField();
        txt_purchase_amount = new View.TextField();
        cmb_product_supplier = new View.ComboBoxSuggestion<>();
        txt_purchase_price = new View.TextField();
        txt_purchase_id = new View.TextField();
        jPanelRound8 = new LIB.JPanelRound();
        txt_purchase_total_to_pay = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btn_add_product_to_buy = new javax.swing.JButton();
        btn_confirm_purchase = new javax.swing.JButton();
        btn_remove_purchase = new javax.swing.JButton();
        btn_new_purchase = new javax.swing.JButton();
        txt_purchase_subtotal = new View.TextField();
        jLabel1 = new javax.swing.JLabel();

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_purchase.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        table_purchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name Product", "Amount", "Price", "Subtotal", "Supplier", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_purchase);

        tableScrollButton2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.add(tableScrollButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 950, 160));

        txt_purchase_product_code.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_purchase_product_code.setLabelText("Code Product");
        txt_purchase_product_code.setLineColor(new java.awt.Color(119, 153, 60));
        txt_purchase_product_code.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_purchase_product_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_purchase_product_codeKeyTyped(evt);
            }
        });
        jPanel5.add(txt_purchase_product_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, -1));

        txt_purchase_product_name.setEditable(false);
        txt_purchase_product_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_purchase_product_name.setLabelText("Name Product");
        txt_purchase_product_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_purchase_product_name.setSelectionColor(new java.awt.Color(213, 234, 218));
        jPanel5.add(txt_purchase_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 180, -1));

        txt_purchase_amount.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_purchase_amount.setLabelText("Amount");
        txt_purchase_amount.setLineColor(new java.awt.Color(119, 153, 60));
        txt_purchase_amount.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_purchase_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_purchase_amountKeyTyped(evt);
            }
        });
        jPanel5.add(txt_purchase_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 180, -1));

        cmb_product_supplier.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel5.add(cmb_product_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 180, 35));

        txt_purchase_price.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_purchase_price.setLabelText("Purchase Price");
        txt_purchase_price.setLineColor(new java.awt.Color(119, 153, 60));
        txt_purchase_price.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_purchase_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_purchase_priceKeyTyped(evt);
            }
        });
        jPanel5.add(txt_purchase_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 210, -1));

        txt_purchase_id.setEditable(false);
        txt_purchase_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_purchase_id.setLabelText("N° Identificación");
        txt_purchase_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_purchase_id.setSelectionColor(new java.awt.Color(213, 234, 218));
        jPanel5.add(txt_purchase_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, -1));

        jPanelRound8.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound8.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound8.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound8.setOpaque(true);

        txt_purchase_total_to_pay.setEditable(false);
        txt_purchase_total_to_pay.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        txt_purchase_total_to_pay.setBorder(null);
        txt_purchase_total_to_pay.setOpaque(false);

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(180, 180, 180));
        jLabel25.setText("Total Price");

        javax.swing.GroupLayout jPanelRound8Layout = new javax.swing.GroupLayout(jPanelRound8);
        jPanelRound8.setLayout(jPanelRound8Layout);
        jPanelRound8Layout.setHorizontalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txt_purchase_total_to_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelRound8Layout.setVerticalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel25)
                .addGap(3, 3, 3)
                .addComponent(txt_purchase_total_to_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel5.add(jPanelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 230, -1));

        btn_add_product_to_buy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add_product_to_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addpurchasex64.png"))); // NOI18N
        btn_add_product_to_buy.setBorder(null);
        btn_add_product_to_buy.setContentAreaFilled(false);
        btn_add_product_to_buy.setFocusPainted(false);
        btn_add_product_to_buy.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addpurchase2x64.png"))); // NOI18N
        jPanel5.add(btn_add_product_to_buy, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 80, 70));

        btn_confirm_purchase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirm_purchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buyx64.png"))); // NOI18N
        btn_confirm_purchase.setBorder(null);
        btn_confirm_purchase.setContentAreaFilled(false);
        btn_confirm_purchase.setFocusPainted(false);
        btn_confirm_purchase.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buy2x64.png"))); // NOI18N
        jPanel5.add(btn_confirm_purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 80, 70));

        btn_remove_purchase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_remove_purchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/purchase_cancelx64.png"))); // NOI18N
        btn_remove_purchase.setBorder(null);
        btn_remove_purchase.setContentAreaFilled(false);
        jPanel5.add(btn_remove_purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 70, -1));

        btn_new_purchase.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        btn_new_purchase.setForeground(new java.awt.Color(255, 255, 255));
        btn_new_purchase.setText("CANCELAR");
        btn_new_purchase.setBorder(null);
        jPanel5.add(btn_new_purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 120, 30));

        txt_purchase_subtotal.setEditable(false);
        txt_purchase_subtotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_purchase_subtotal.setLabelText("Subtotal");
        txt_purchase_subtotal.setLineColor(new java.awt.Color(119, 153, 60));
        txt_purchase_subtotal.setSelectionColor(new java.awt.Color(213, 234, 218));
        jPanel5.add(txt_purchase_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 210, -1));

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("PURCHASE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_purchase_product_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_product_codeKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9' || txt_purchase_product_code.getText().length()>20){
            evt.consume();
        }
    }//GEN-LAST:event_txt_purchase_product_codeKeyTyped

    private void txt_purchase_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_amountKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9' || txt_purchase_amount.getText().length()>5){
            evt.consume();
        }
    }//GEN-LAST:event_txt_purchase_amountKeyTyped

    private void txt_purchase_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_priceKeyTyped
        if(Character.isLetter(evt.getKeyChar())||txt_purchase_price.getText().length()>5){
            evt.consume();
        }else{
            try {
                Double.parseDouble(txt_purchase_price.getText()+evt.getKeyChar());
            } catch (NumberFormatException e) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_purchase_priceKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_add_product_to_buy;
    public javax.swing.JButton btn_confirm_purchase;
    public javax.swing.JButton btn_new_purchase;
    public javax.swing.JButton btn_remove_purchase;
    public View.ComboBoxSuggestion<Model.Supplier> cmb_product_supplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel5;
    private LIB.JPanelRound jPanelRound8;
    private javax.swing.JScrollPane jScrollPane2;
    private View.TableCustom.TableScrollButton tableScrollButton2;
    public javax.swing.JTable table_purchase;
    public View.TextField txt_purchase_amount;
    public View.TextField txt_purchase_id;
    public View.TextField txt_purchase_price;
    public View.TextField txt_purchase_product_code;
    public View.TextField txt_purchase_product_name;
    public View.TextField txt_purchase_subtotal;
    public javax.swing.JTextField txt_purchase_total_to_pay;
    // End of variables declaration//GEN-END:variables
}
