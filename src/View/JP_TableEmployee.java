package View;

import Model.Rol;
import View.TableCustom.TableCustom;

public class JP_TableEmployee extends View.swing.RoundPanel{

    public JP_TableEmployee() {
        initComponents();
        TextPrompt textPrompt = new TextPrompt("Search employee...",txt_employee_search);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND,btn_employee_register);
        btn_employee_register.setUI(roundUI);
        TableCustom.apply(jScrollPane4, TableCustom.TableType.DEFAULT);
        this.table_employee.getColumnModel().getColumn(0).setMaxWidth(0);
        this.table_employee.getColumnModel().getColumn(0).setMinWidth(0);
        this.table_employee.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.table_employee.getColumnModel().getColumn(7).setMaxWidth(0);
        this.table_employee.getColumnModel().getColumn(7).setMinWidth(0);
        this.table_employee.getColumnModel().getColumn(7).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRound1 = new LIB.JPanelRound();
        jLabel32 = new javax.swing.JLabel();
        txt_employee_search = new javax.swing.JTextField();
        btn_employee_register = new javax.swing.JButton();
        tableScrollButton1 = new View.TableCustom.TableScrollButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_employee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmb_employee_rol = new View.ComboBoxSuggestion<>();

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.x32png.png"))); // NOI18N
        jPanelRound1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 40));

        txt_employee_search.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_employee_search.setBorder(null);
        txt_employee_search.setOpaque(false);
        jPanelRound1.add(txt_employee_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 180, 30));

        btn_employee_register.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btn_employee_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_employee_register.setText("REGISTER");
        btn_employee_register.setBorder(null);
        btn_employee_register.setBorderPainted(false);
        btn_employee_register.setHideActionText(true);
        btn_employee_register.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        table_employee.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        table_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fullname", "Username", "Address", "Telephone", "Email", "Role", "Id_Rol", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_employee.setMinimumSize(new java.awt.Dimension(120, 40));
        table_employee.setRowHeight(40);
        jScrollPane4.setViewportView(table_employee);
        if (table_employee.getColumnModel().getColumnCount() > 0) {
            table_employee.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_employee.getColumnModel().getColumn(1).setPreferredWidth(90);
            table_employee.getColumnModel().getColumn(2).setPreferredWidth(70);
            table_employee.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_employee.getColumnModel().getColumn(4).setPreferredWidth(70);
            table_employee.getColumnModel().getColumn(5).setPreferredWidth(140);
            table_employee.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        tableScrollButton1.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("EMPLOYEE");

        cmb_employee_rol.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmb_employee_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_employee_register, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_employee_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_employee_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_employee_register;
    public View.ComboBoxSuggestion<Rol> cmb_employee_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private LIB.JPanelRound jPanelRound1;
    private javax.swing.JScrollPane jScrollPane4;
    private View.TableCustom.TableScrollButton tableScrollButton1;
    public javax.swing.JTable table_employee;
    public javax.swing.JTextField txt_employee_search;
    // End of variables declaration//GEN-END:variables
}
