package View;

import Model.Purchase;
import Model.PurchaseDao;
import View.TableCustom.TableCustom;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class JF_Print extends javax.swing.JFrame {

    NumberFormat formatoNumero = NumberFormat.getInstance();
    NumberFormat formatoDinero = NumberFormat.getCurrencyInstance();
    Purchase  purchase = new Purchase();
    PurchaseDao purchaseDao = new PurchaseDao();
    DefaultTableModel modelTablePurchase = new DefaultTableModel();
    
    public JF_Print(int id) {
        initComponents();      
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        txt_invoice.setText(""+id);
        ListAllPurchaseDetail(id);
        CalculatePurchase();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);

    }
    
    public void ListAllPurchaseDetail(int id){
        List<Purchase> listPurchase = purchaseDao.ListPurchaseDetailQuery(id);
        modelTablePurchase = (DefaultTableModel) table_purchase_detail.getModel();
        Object[] row = new Object[4];
        String fecha ="2023-03-31 15:35:22";
        for (int i = 0; i < listPurchase.size(); i++) {
            row[0] = listPurchase.get(i).getPurchase_amount();
            row[1] = listPurchase.get(i).getProduct_name();
            row[2] = listPurchase.get(i).getPurchase_price();
            row[3] = listPurchase.get(i).getPurchase_subtotal();
            modelTablePurchase.addRow(row);
            lbl_supplier.setText(String.valueOf(listPurchase.get(i).getSupplier_name_product()));
            fecha = String.valueOf(listPurchase.get(i).getCreated());   
        }
        table_purchase_detail.setModel(modelTablePurchase);
            try {
               SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               Date fechaConvertida = format.parse(fecha);
               SimpleDateFormat formatoFechaPersonal = new SimpleDateFormat("EEEE d 'de' MMMM 'de' YYYY");
               lbl_date.setText(formatoFechaPersonal.format(fechaConvertida));
            } catch (Exception e) {
               System.err.println("No se ha podido convertir la fecha");
            }
        
    }
    
    public void CalculatePurchase(){
        double total=0.0;
        int row = table_purchase_detail.getRowCount();
        for (int i = 0; i < row; i++) {
            total = total +Double.parseDouble(String.valueOf(table_purchase_detail.getValueAt(i, 3).toString()));
        }
        txt_total.setText(""+formatoDinero.format(total));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Print = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_purchase_detail = new rojerusan.RSTableMetro();
        txt_total = new javax.swing.JTextField();
        jPanelRound1 = new LIB.JPanelRound();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_invoice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelRound2 = new LIB.JPanelRound();
        jLabel10 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jPanelRound3 = new LIB.JPanelRound();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_supplier = new javax.swing.JLabel();
        btn_print_purchase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logox240.png"))); // NOI18N
        jLabel1.setText("Logo_icon");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 120));

        Print.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 250, 120));

        jPanel1.setBackground(new java.awt.Color(18, 45, 61));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Jr. Pedro Conde 310");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fax: 123-1234");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Of 302 Lince ");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Telf.: 987654321");

        jPanel5.setBackground(new java.awt.Color(123, 207, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Print.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 170, 120));

        table_purchase_detail.setForeground(new java.awt.Color(51, 51, 51));
        table_purchase_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Description", "Unit Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_purchase_detail.setAltoHead(25);
        table_purchase_detail.setColorBackgoundHead(new java.awt.Color(255, 204, 204));
        table_purchase_detail.setColorFilasForeground1(new java.awt.Color(60, 63, 65));
        table_purchase_detail.setColorFilasForeground2(new java.awt.Color(60, 63, 65));
        table_purchase_detail.setColorForegroundHead(new java.awt.Color(51, 51, 51));
        table_purchase_detail.setColorSelBackgound(new java.awt.Color(18, 45, 61));
        table_purchase_detail.setEnabled(false);
        table_purchase_detail.setFuenteFilas(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        table_purchase_detail.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        table_purchase_detail.setFuenteHead(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        table_purchase_detail.setGrosorBordeFilas(0);
        table_purchase_detail.setMultipleSeleccion(false);
        jScrollPane1.setViewportView(table_purchase_detail);
        if (table_purchase_detail.getColumnModel().getColumnCount() > 0) {
            table_purchase_detail.getColumnModel().getColumn(0).setMinWidth(100);
            table_purchase_detail.getColumnModel().getColumn(0).setPreferredWidth(10);
            table_purchase_detail.getColumnModel().getColumn(1).setPreferredWidth(300);
            table_purchase_detail.getColumnModel().getColumn(2).setMinWidth(30);
            table_purchase_detail.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_purchase_detail.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        Print.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 760, 200));

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        txt_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Print.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 120, 30));

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(123, 207, 255));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Purchase Detail");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        txt_invoice.setEditable(false);
        txt_invoice.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        txt_invoice.setForeground(new java.awt.Color(0, 0, 0));
        txt_invoice.setBorder(null);
        txt_invoice.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("R.U.C. 20987654321");

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("001 - ");

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        Print.add(jPanelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 270, 120));

        jPanel4.setBackground(new java.awt.Color(18, 45, 61));
        jPanel4.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ventas@com.pe");

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("www.ventas.com.pe");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Print.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 210, 40));

        jPanelRound2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRound2.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound2.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound2.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Date :");

        lbl_date.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        Print.add(jPanelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 270, 40));

        jPanelRound3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRound3.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound3.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound3.setOpaque(true);

        jLabel14.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Address :");

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("R.U.C. :");

        jLabel13.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("From :");

        lbl_supplier.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelRound3Layout = new javax.swing.GroupLayout(jPanelRound3);
        jPanelRound3.setLayout(jPanelRound3Layout);
        jPanelRound3Layout.setHorizontalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanelRound3Layout.setVerticalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(10, 10, 10))
        );

        Print.add(jPanelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 450, -1));

        getContentPane().add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 560));

        btn_print_purchase.setText("PRINT");
        btn_print_purchase.setBorder(null);
        btn_print_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_purchaseActionPerformed(evt);
            }
        });
        getContentPane().add(btn_print_purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_print_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_purchaseActionPerformed
        Toolkit tk = this.getToolkit();
        PrintJob pj = tk.getPrintJob(this, null, null);
        Graphics graphics = pj.getGraphics();
        this.print(graphics);
        graphics.dispose();
        pj.end();
    }//GEN-LAST:event_btn_print_purchaseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Print;
    private javax.swing.JButton btn_print_purchase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    private LIB.JPanelRound jPanelRound3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_supplier;
    public rojerusan.RSTableMetro table_purchase_detail;
    private javax.swing.JTextField txt_invoice;
    public javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
