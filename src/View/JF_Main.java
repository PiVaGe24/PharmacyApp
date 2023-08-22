
package View;

public class JF_Main extends javax.swing.JFrame {


    public JF_Main() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new View.swing.RoundPanel();
        jP_Menu1 = new View.JP_Menu();
        header1 = new View.component.Header();
        body = new View.swing.RoundPanel();
        panelProfile = new javax.swing.JPanel();
        panelDashboard = new javax.swing.JPanel();
        panelSale = new javax.swing.JPanel();
        panelPurchase = new javax.swing.JPanel();
        panelReport = new javax.swing.JPanel();
        panelCategory = new javax.swing.JPanel();
        panelSlideProduct = new View.Slide.PanelSlide();
        panelSlideSupplier = new View.Slide.PanelSlide();
        panelSlideCustomer = new View.Slide.PanelSlide();
        panelSlideEmployee = new View.Slide.PanelSlide();
        panelPermission = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(21, 21, 21));
        roundPanel1.setMaximumSize(new java.awt.Dimension(500, 500));

        body.setBackground(new java.awt.Color(51, 51, 51));
        body.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panelProfileLayout = new javax.swing.GroupLayout(panelProfile);
        panelProfile.setLayout(panelProfileLayout);
        panelProfileLayout.setHorizontalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelProfileLayout.setVerticalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelProfile, "card8");

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelDashboard, "card13");

        javax.swing.GroupLayout panelSaleLayout = new javax.swing.GroupLayout(panelSale);
        panelSale.setLayout(panelSaleLayout);
        panelSaleLayout.setHorizontalGroup(
            panelSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelSaleLayout.setVerticalGroup(
            panelSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelSale, "card12");

        javax.swing.GroupLayout panelPurchaseLayout = new javax.swing.GroupLayout(panelPurchase);
        panelPurchase.setLayout(panelPurchaseLayout);
        panelPurchaseLayout.setHorizontalGroup(
            panelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelPurchaseLayout.setVerticalGroup(
            panelPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelPurchase, "card11");

        javax.swing.GroupLayout panelReportLayout = new javax.swing.GroupLayout(panelReport);
        panelReport.setLayout(panelReportLayout);
        panelReportLayout.setHorizontalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelReportLayout.setVerticalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelReport, "card10");

        javax.swing.GroupLayout panelCategoryLayout = new javax.swing.GroupLayout(panelCategory);
        panelCategory.setLayout(panelCategoryLayout);
        panelCategoryLayout.setHorizontalGroup(
            panelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelCategoryLayout.setVerticalGroup(
            panelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelCategory, "card9");

        javax.swing.GroupLayout panelSlideProductLayout = new javax.swing.GroupLayout(panelSlideProduct);
        panelSlideProduct.setLayout(panelSlideProductLayout);
        panelSlideProductLayout.setHorizontalGroup(
            panelSlideProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelSlideProductLayout.setVerticalGroup(
            panelSlideProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelSlideProduct, "card7");

        javax.swing.GroupLayout panelSlideSupplierLayout = new javax.swing.GroupLayout(panelSlideSupplier);
        panelSlideSupplier.setLayout(panelSlideSupplierLayout);
        panelSlideSupplierLayout.setHorizontalGroup(
            panelSlideSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelSlideSupplierLayout.setVerticalGroup(
            panelSlideSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelSlideSupplier, "card6");

        javax.swing.GroupLayout panelSlideCustomerLayout = new javax.swing.GroupLayout(panelSlideCustomer);
        panelSlideCustomer.setLayout(panelSlideCustomerLayout);
        panelSlideCustomerLayout.setHorizontalGroup(
            panelSlideCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelSlideCustomerLayout.setVerticalGroup(
            panelSlideCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelSlideCustomer, "card5");

        javax.swing.GroupLayout panelSlideEmployeeLayout = new javax.swing.GroupLayout(panelSlideEmployee);
        panelSlideEmployee.setLayout(panelSlideEmployeeLayout);
        panelSlideEmployeeLayout.setHorizontalGroup(
            panelSlideEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelSlideEmployeeLayout.setVerticalGroup(
            panelSlideEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelSlideEmployee, "card4");

        javax.swing.GroupLayout panelPermissionLayout = new javax.swing.GroupLayout(panelPermission);
        panelPermission.setLayout(panelPermissionLayout);
        panelPermissionLayout.setHorizontalGroup(
            panelPermissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
        );
        panelPermissionLayout.setVerticalGroup(
            panelPermissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        body.add(panelPermission, "card13");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP_Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public View.swing.RoundPanel body;
    public View.component.Header header1;
    public View.JP_Menu jP_Menu1;
    public javax.swing.JPanel panelCategory;
    public javax.swing.JPanel panelDashboard;
    public javax.swing.JPanel panelPermission;
    public javax.swing.JPanel panelProfile;
    public javax.swing.JPanel panelPurchase;
    public javax.swing.JPanel panelReport;
    public javax.swing.JPanel panelSale;
    public View.Slide.PanelSlide panelSlideCustomer;
    public View.Slide.PanelSlide panelSlideEmployee;
    public View.Slide.PanelSlide panelSlideProduct;
    public View.Slide.PanelSlide panelSlideSupplier;
    private View.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
