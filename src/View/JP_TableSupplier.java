package View;

import View.TableCustom.TableCustom;

public class JP_TableSupplier extends javax.swing.JPanel {

    public JP_TableSupplier() {
        initComponents();
        new TextPrompt("Search supplier...",txt_supplier_search);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_supplier_register);
        btn_supplier_register.setUI(roundUI);
        TableCustom.apply(jScrollPane5, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_supplier_search = new javax.swing.JTextField();
        btn_supplier_register = new javax.swing.JButton();
        tableScrollButton1 = new View.TableCustom.TableScrollButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_supplier = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmb_supplier_city = new View.ComboBoxSuggestion<>();

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.x32png.png"))); // NOI18N
        jPanelRound1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 40));

        txt_supplier_search.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_supplier_search.setBorder(null);
        txt_supplier_search.setOpaque(false);
        jPanelRound1.add(txt_supplier_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 180, 30));

        btn_supplier_register.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_supplier_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier_register.setText("REGISTER");
        btn_supplier_register.setBorder(null);
        btn_supplier_register.setBorderPainted(false);
        btn_supplier_register.setHideActionText(true);
        btn_supplier_register.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        table_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Description", "Address", "Telephone", "Email", "City", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table_supplier);
        if (table_supplier.getColumnModel().getColumnCount() > 0) {
            table_supplier.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_supplier.getColumnModel().getColumn(1).setPreferredWidth(140);
            table_supplier.getColumnModel().getColumn(2).setPreferredWidth(170);
            table_supplier.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_supplier.getColumnModel().getColumn(4).setPreferredWidth(60);
            table_supplier.getColumnModel().getColumn(5).setPreferredWidth(100);
            table_supplier.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        tableScrollButton1.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("SUPPLIER");

        cmb_supplier_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Ica", "Lima" }));
        cmb_supplier_city.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmb_supplier_city, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_supplier_register, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_supplier_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_supplier_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_supplier_register;
    public View.ComboBoxSuggestion<String> cmb_supplier_city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane5;
    private View.TableCustom.TableScrollButton tableScrollButton1;
    public javax.swing.JTable table_supplier;
    public javax.swing.JTextField txt_supplier_search;
    // End of variables declaration//GEN-END:variables
}
