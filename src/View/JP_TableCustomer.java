package View;

import View.TableCustom.TableCustom;

public class JP_TableCustomer extends javax.swing.JPanel {

    public JP_TableCustomer() {
        initComponents();
        new TextPrompt("Search customer...",txt_customer_search);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_customer_register);
        btn_customer_register.setUI(roundUI);

        TableCustom.apply(jScrollPane3, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_customer_search = new javax.swing.JTextField();
        btn_customer_register = new javax.swing.JButton();
        tableScrollButton1 = new View.TableCustom.TableScrollButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_customer = new javax.swing.JTable();
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

        txt_customer_search.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_customer_search.setBorder(null);
        txt_customer_search.setOpaque(false);
        jPanelRound1.add(txt_customer_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 180, 30));

        btn_customer_register.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_customer_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_customer_register.setText("REGISTER");
        btn_customer_register.setBorder(null);
        btn_customer_register.setBorderPainted(false);
        btn_customer_register.setHideActionText(true);
        btn_customer_register.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tableScrollButton1.setPreferredSize(new java.awt.Dimension(450, 400));

        table_customer.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        table_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Full Name", "Telephone", "Address", "Emai", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_customer);
        if (table_customer.getColumnModel().getColumnCount() > 0) {
            table_customer.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_customer.getColumnModel().getColumn(1).setPreferredWidth(170);
            table_customer.getColumnModel().getColumn(2).setPreferredWidth(70);
            table_customer.getColumnModel().getColumn(3).setPreferredWidth(140);
            table_customer.getColumnModel().getColumn(4).setPreferredWidth(170);
        }

        tableScrollButton1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("CUSTOMER");

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
                .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_customer_register, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customer_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_customer_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane3;
    private View.TableCustom.TableScrollButton tableScrollButton1;
    public javax.swing.JTable table_customer;
    public javax.swing.JTextField txt_customer_search;
    // End of variables declaration//GEN-END:variables
}
