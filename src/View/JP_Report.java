package View;

import View.TableCustom.TableCustom;

public class JP_Report extends javax.swing.JPanel {

    /**
     * Creates new form JP_Report
     */
    public JP_Report() {
        initComponents();
        TableCustom.apply(jScrollPane7, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane8, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
        new TextPrompt("Search customer...",txt_customer_search);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_sale_report);
        btn_sale_report.setUI(roundUI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_all_sale = new javax.swing.JTable();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_all_purchase = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmb_month = new View.ComboBoxSuggestion<>();
        cmb_periodo = new View.ComboBoxSuggestion<>();
        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_customer_search = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_customer = new javax.swing.JTable();
        txt_id_customer = new View.TextField();
        txt_customer_name = new View.TextField();
        btn_sale_report = new javax.swing.JButton();

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("PURCHASES");
        jLabel44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 370, -1));

        table_all_sale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Sale", "Customer", "Employee", "Total", "Sale Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_all_sale.setRowSelectionAllowed(false);
        jScrollPane7.setViewportView(table_all_sale);

        jPanel10.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 925, 220));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("SALES");
        jLabel62.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 156, 30));

        table_all_purchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Purchase", "Supplier", "Total", "Sale Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_all_purchase.setRowSelectionAllowed(false);
        jScrollPane8.setViewportView(table_all_purchase);

        jPanel10.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 925, 220));

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("REPORT");

        cmb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre" }));
        cmb_month.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        cmb_periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2" }));
        cmb_periodo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

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

        table_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_customer.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(table_customer);

        txt_id_customer.setEditable(false);
        txt_id_customer.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_id_customer.setLabelText("Document");
        txt_id_customer.setLineColor(new java.awt.Color(119, 153, 60));
        txt_id_customer.setSelectionColor(new java.awt.Color(213, 234, 218));
        txt_id_customer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_customerKeyTyped(evt);
            }
        });

        txt_customer_name.setEditable(false);
        txt_customer_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_customer_name.setLabelText("Customer Name");
        txt_customer_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_customer_name.setSelectionColor(new java.awt.Color(213, 234, 218));

        btn_sale_report.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_sale_report.setForeground(new java.awt.Color(255, 255, 255));
        btn_sale_report.setText("SALE REPORT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btn_sale_report, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb_month, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_id_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_sale_report, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_customerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_customerKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'||txt_id_customer.getText().length()>9){
            evt.consume();
        }
    }//GEN-LAST:event_txt_id_customerKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_sale_report;
    public View.ComboBoxSuggestion<String> cmb_month;
    public View.ComboBoxSuggestion<String> cmb_periodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel10;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTable table_all_purchase;
    public javax.swing.JTable table_all_sale;
    public javax.swing.JTable table_customer;
    public View.TextField txt_customer_name;
    public javax.swing.JTextField txt_customer_search;
    public View.TextField txt_id_customer;
    // End of variables declaration//GEN-END:variables
}
