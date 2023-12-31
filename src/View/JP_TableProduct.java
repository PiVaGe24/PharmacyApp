package View;

import Model.Category;
import View.TableCustom.TableCustom;

public class JP_TableProduct extends javax.swing.JPanel {

    public JP_TableProduct() {
        initComponents();
        new TextPrompt("Search product...",txt_product_search);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_product_register);
        btn_product_register.setUI(roundUI);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_product_category = new View.ComboBoxSuggestion<>();
        jLabel1 = new javax.swing.JLabel();
        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_product_search = new javax.swing.JTextField();
        btn_product_register = new javax.swing.JButton();
        tableScrollButton1 = new View.TableCustom.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();

        cmb_product_category.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("PRODUCT");

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.x32png.png"))); // NOI18N
        jPanelRound1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 40));

        txt_product_search.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_product_search.setBorder(null);
        txt_product_search.setOpaque(false);
        jPanelRound1.add(txt_product_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 180, 30));

        btn_product_register.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_product_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_product_register.setText("REGISTER");
        btn_product_register.setBorder(null);

        table_product.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Code", "Name", "Description", "Unit Price", "Amount", "Category", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_product);
        if (table_product.getColumnModel().getColumnCount() > 0) {
            table_product.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_product.getColumnModel().getColumn(1).setPreferredWidth(70);
            table_product.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_product.getColumnModel().getColumn(3).setPreferredWidth(170);
        }

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(cmb_product_category, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_product_register, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_product_register, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(cmb_product_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_product_register;
    public View.ComboBoxSuggestion<Category> cmb_product_category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane1;
    private View.TableCustom.TableScrollButton tableScrollButton1;
    public javax.swing.JTable table_product;
    public javax.swing.JTextField txt_product_search;
    // End of variables declaration//GEN-END:variables
}
