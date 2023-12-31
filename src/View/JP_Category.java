package View;

import View.TableCustom.TableCustom;

public class JP_Category extends javax.swing.JPanel {

    public JP_Category() {
        initComponents();
        new TextPrompt("Search customer...",txt_category_search);
        ShapedButtonUICancel roundUIc = new ShapedButtonUICancel();
        roundUIc.setShape(ShapedButton.ButtonShape.ROUND, btn_category_cancel);
        btn_category_cancel.setUI(roundUIc);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_category_register);
        btn_category_register.setUI(roundUI);
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_category_update);
        btn_category_update.setUI(roundUI);
        TableCustom.apply(jScrollPane6, TableCustom.TableType.DEFAULT);
        btn_category_update.setVisible(false);
        btn_category_delete.setVisible(false);
        btn_category_cancel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_category_search = new javax.swing.JTextField();
        tableScrollButton1 = new View.TableCustom.TableScrollButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_category = new javax.swing.JTable();
        txt_category_id = new View.TextField();
        txt_category_name = new View.TextField();
        btn_category_delete = new javax.swing.JButton();
        btn_category_cancel = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btn_category_update = new javax.swing.JButton();
        btn_category_register = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.x32png.png"))); // NOI18N
        jPanelRound1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 40));

        txt_category_search.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_category_search.setBorder(null);
        txt_category_search.setOpaque(false);
        jPanelRound1.add(txt_category_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 180, 30));

        table_category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(table_category);
        if (table_category.getColumnModel().getColumnCount() > 0) {
            table_category.getColumnModel().getColumn(0).setPreferredWidth(3);
            table_category.getColumnModel().getColumn(1).setPreferredWidth(200);
            table_category.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        tableScrollButton1.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        txt_category_id.setEditable(false);
        txt_category_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_category_id.setLabelText("N° Identificación");
        txt_category_id.setLineColor(new java.awt.Color(119, 153, 60));
        txt_category_id.setSelectionColor(new java.awt.Color(213, 234, 218));

        txt_category_name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_category_name.setLabelText("Name Category");
        txt_category_name.setLineColor(new java.awt.Color(119, 153, 60));
        txt_category_name.setSelectionColor(new java.awt.Color(213, 234, 218));

        btn_category_delete.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        btn_category_delete.setText("DELETE");
        btn_category_delete.setBorder(null);
        btn_category_delete.setContentAreaFilled(false);

        btn_category_cancel.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_category_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_category_cancel.setText("CANCEL");
        btn_category_cancel.setBorder(null);
        btn_category_cancel.setContentAreaFilled(false);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_category_update.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        btn_category_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_category_update.setText("UPDATE");
        btn_category_update.setBorder(null);
        btn_category_update.setContentAreaFilled(false);
        jPanel12.add(btn_category_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 170, 40));

        btn_category_register.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_category_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_category_register.setText("REGISTER");
        btn_category_register.setBorder(null);
        btn_category_register.setContentAreaFilled(false);
        jPanel12.add(btn_category_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 170, 40));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btn_category_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_category_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_category_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_category_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btn_category_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(25, 25, 25)
                                .addComponent(txt_category_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(txt_category_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(212, 212, 212))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)))
                        .addComponent(btn_category_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("CATEGORY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(673, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_category_cancel;
    public javax.swing.JButton btn_category_delete;
    public javax.swing.JButton btn_category_register;
    public javax.swing.JButton btn_category_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane6;
    private View.TableCustom.TableScrollButton tableScrollButton1;
    public javax.swing.JTable table_category;
    public View.TextField txt_category_id;
    public View.TextField txt_category_name;
    public javax.swing.JTextField txt_category_search;
    // End of variables declaration//GEN-END:variables
}
