package View;

import View.TableCustom.TableCustom;

public class JP_Sale extends javax.swing.JPanel {

    /**
     * Creates new form JP_Sale
     */
    public JP_Sale() {
        initComponents();
        btn_sale_delete.setVisible(false);
        ShapedButtonUICancel roundUIc = new ShapedButtonUICancel();
        roundUIc.setShape(ShapedButton.ButtonShape.ROUND, btn_sale_new);
        btn_sale_new.setUI(roundUIc);
        TableCustom.apply(jScrollPane9, TableCustom.TableType.DEFAULT);    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel19 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        table_sale = new javax.swing.JTable();
        txt_sale_product_code = new View.TextField();
        txt_sale_product_id = new View.TextField();
        txt_sale_product_name = new View.TextField();
        txt_sale_price = new View.TextField();
        txt_sale_subtotal = new View.TextField();
        txt_sale_stock = new View.TextField();
        txt_sale_quantity = new View.TextField();
        txt_sale_total_to_pay = new View.TextField();
        btn_sale_add_product = new javax.swing.JButton();
        btn_sale_confirm = new javax.swing.JButton();
        btn_sale_delete = new javax.swing.JButton();
        btn_sale_new = new javax.swing.JButton();
        tglbtn_quantity = new View.toggle.ToggleButton();
        jLabel1 = new javax.swing.JLabel();
        txt_sale_customer_document = new View.TextField();
        txt_sale_customer_name = new View.TextField();
        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_customer_search = new javax.swing.JTextField();
        txt_id_customer = new View.TextField();

        table_sale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Product", "Name", "Quantity", "Sale Price", "Subtotal", "Customer Name", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(table_sale);

        txt_sale_product_code.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_product_code.setLabelText("Product Code");
        txt_sale_product_code.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_product_code.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_sale_product_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sale_product_codeKeyTyped(evt);
            }
        });

        txt_sale_product_id.setEditable(false);
        txt_sale_product_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_product_id.setLabelText("N° Identificación");
        txt_sale_product_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_product_id.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_sale_product_name.setEditable(false);
        txt_sale_product_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_product_name.setLabelText("Product Name");
        txt_sale_product_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_product_name.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_sale_price.setEditable(false);
        txt_sale_price.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_price.setLabelText("Price");
        txt_sale_price.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_price.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_sale_subtotal.setEditable(false);
        txt_sale_subtotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_subtotal.setLabelText("Subtotal");
        txt_sale_subtotal.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_subtotal.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_sale_stock.setEditable(false);
        txt_sale_stock.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_stock.setLabelText("Stock");
        txt_sale_stock.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_stock.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_sale_quantity.setEditable(false);
        txt_sale_quantity.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_quantity.setLabelText("Quantity");
        txt_sale_quantity.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_quantity.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_sale_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sale_quantityKeyTyped(evt);
            }
        });

        txt_sale_total_to_pay.setEditable(false);
        txt_sale_total_to_pay.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_total_to_pay.setLabelText("Total to pay");
        txt_sale_total_to_pay.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_total_to_pay.setSelectionColor(new java.awt.Color(213, 234, 218));

        btn_sale_add_product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sale_add_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saleAddx64.png"))); // NOI18N
        btn_sale_add_product.setBorder(null);
        btn_sale_add_product.setContentAreaFilled(false);
        btn_sale_add_product.setFocusPainted(false);
        btn_sale_add_product.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saleAdd2x64.png"))); // NOI18N

        btn_sale_confirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sale_confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saleRegisterx64.png"))); // NOI18N
        btn_sale_confirm.setBorder(null);
        btn_sale_confirm.setContentAreaFilled(false);
        btn_sale_confirm.setFocusPainted(false);
        btn_sale_confirm.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saleRegister2x64.png"))); // NOI18N

        btn_sale_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sale_delete.setText("Delete");

        btn_sale_new.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        btn_sale_new.setForeground(new java.awt.Color(255, 255, 255));
        btn_sale_new.setText("CANCEL");
        btn_sale_new.setBorder(null);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(txt_sale_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txt_sale_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txt_sale_price, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btn_sale_add_product, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(tglbtn_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sale_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sale_total_to_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(210, 210, 210)
                        .addComponent(txt_sale_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btn_sale_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_sale_new, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(txt_sale_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(txt_sale_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btn_sale_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sale_add_product, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sale_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sale_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sale_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sale_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_sale_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_sale_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(btn_sale_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_sale_new, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_sale_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tglbtn_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(txt_sale_total_to_pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_sale_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("SALE");

        txt_sale_customer_document.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_customer_document.setLabelText("Document");
        txt_sale_customer_document.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_customer_document.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_sale_customer_document.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sale_customer_documentKeyTyped(evt);
            }
        });

        txt_sale_customer_name.setEditable(false);
        txt_sale_customer_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_sale_customer_name.setLabelText("Customer Name");
        txt_sale_customer_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_sale_customer_name.setSelectionColor(new java.awt.Color(213, 234, 218));

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.x32png.png"))); // NOI18N
        jPanelRound1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 40));

        txt_customer_search.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_customer_search.setBorder(null);
        txt_customer_search.setOpaque(false);
        jPanelRound1.add(txt_customer_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 180, 30));

        txt_id_customer.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_id_customer.setLabelText("Document");
        txt_id_customer.setLineColor(new java.awt.Color(119, 153, 60));
        txt_id_customer.setSelectionColor(new java.awt.Color(213, 234, 218));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278)
                .addComponent(txt_id_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(txt_sale_customer_document, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_sale_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_id_customer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sale_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sale_customer_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_sale_product_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sale_product_codeKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'||txt_sale_product_code.getText().length()>30){
            evt.consume();
        }
    }//GEN-LAST:event_txt_sale_product_codeKeyTyped

    private void txt_sale_quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sale_quantityKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'||txt_sale_quantity.getText().length()>4){
            evt.consume();
        }
    }//GEN-LAST:event_txt_sale_quantityKeyTyped

    private void txt_sale_customer_documentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sale_customer_documentKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'||txt_sale_customer_document.getText().length()>9){
            evt.consume();
        }
    }//GEN-LAST:event_txt_sale_customer_documentKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_sale_add_product;
    public javax.swing.JButton btn_sale_confirm;
    public javax.swing.JButton btn_sale_delete;
    public javax.swing.JButton btn_sale_new;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel19;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTable table_sale;
    public View.toggle.ToggleButton tglbtn_quantity;
    public javax.swing.JTextField txt_customer_search;
    public View.TextField txt_id_customer;
    public View.TextField txt_sale_customer_document;
    public View.TextField txt_sale_customer_name;
    public View.TextField txt_sale_price;
    public View.TextField txt_sale_product_code;
    public View.TextField txt_sale_product_id;
    public View.TextField txt_sale_product_name;
    public View.TextField txt_sale_quantity;
    public View.TextField txt_sale_stock;
    public View.TextField txt_sale_subtotal;
    public View.TextField txt_sale_total_to_pay;
    // End of variables declaration//GEN-END:variables
}
