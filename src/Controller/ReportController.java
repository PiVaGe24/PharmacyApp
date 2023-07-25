/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Chart.ModelChart;
import Model.ConnectionMySQL;
import Model.Customer;
import Model.CustomerDao;
import Model.Product;
import Model.PurchaseDao;
import Model.SaleDao;
import View.JF_Print;
import View.JP_Dashboard;
import View.JP_Report;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PIERO
 */
public class ReportController implements ActionListener,MouseListener,ItemListener,KeyListener{
    private JP_Report jpReport;
    private JP_Dashboard jpDashboard;
    private JF_Print jfPrint;
    private SaleDao objsaleDao;
    private PurchaseDao objPurchaseDao;
    NumberFormat formatoNumero = NumberFormat.getInstance();
    NumberFormat formatoDinero = NumberFormat.getCurrencyInstance();
    PurchaseDao purchaseDao = new PurchaseDao();
    DefaultTableModel modelTablePurchase = new DefaultTableModel();
    DefaultTableModel modelTableProductxPrice= new DefaultTableModel();
    DefaultTableModel modelTableProductxQuantity= new DefaultTableModel();
    DefaultTableModel modelTableCustomer= new DefaultTableModel();
    private int mes;
    double [] purchase = new double[6];
    double [] sale = new double[6];
    Calendar calendar=Calendar.getInstance();
    Date now = calendar.getTime();
    CustomerDao customerDao = new CustomerDao();
    List<Customer> nameCustomer = customerDao.ListCustomerQuery("");
    DefaultTableModel ModelTableCustomer = new DefaultTableModel();
    ConnectionMySQL conexion = new ConnectionMySQL();
    Connection con;  
        
    public ReportController(JP_Report jpReport,JP_Dashboard jpDashboard,JF_Print jfPrint,SaleDao objsaleDao,PurchaseDao objPurchaseDao) {
        this.jpReport=jpReport;
        this.jpDashboard=jpDashboard;
        this.jfPrint = jfPrint;
        this.objsaleDao=objsaleDao;
        this.objPurchaseDao = objPurchaseDao;
        this.jpReport.table_all_purchase.addMouseListener(this);
        this.jpDashboard.cmb_progress_month.addItemListener(this);
        this.jpReport.cmb_month.addItemListener(this);
        this.jpReport.txt_customer_search.addKeyListener(this);
        this.jpReport.table_customer.addMouseListener(this);
        this.jpReport.btn_sale_report.addActionListener(this);
        //ProgressSaleMonth();
        
        sale = objsaleDao.TotalSaleMonth();
        purchase = objPurchaseDao.TotalPurchaseMonth();
        //this.jpDashboard.progress2.setValue(80);
        //this.jpDashboard.progress3.setValue(53);
                
        /*jpDashboard.chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        jpDashboard.chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        jpDashboard.chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        jpDashboard.chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        jpDashboard.chart.addData(new ModelChart("January", new double[]{200, 120, 100,200}));
        //jpDashboard.chart.addData(new ModelChart("January", new double[]{objPurchaseDao.TotalPurchaseMonth()[0], 200, 80, 89}));
        jpDashboard.chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        jpDashboard.chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        jpDashboard.chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        jpDashboard.chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        jpDashboard.chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));*/
                
        /*jpDashboard.lineChart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        jpDashboard.lineChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        jpDashboard.lineChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        jpDashboard.lineChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        jpDashboard.lineChart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        jpDashboard.lineChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        jpDashboard.lineChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        jpDashboard.lineChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        jpDashboard.lineChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        jpDashboard.lineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
*/
        
                
        //jpDashboard.chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        //jpDashboard.chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        jpDashboard.chart.addLegend("Purchase", new Color(186, 37, 37), new Color(241, 100, 120));
        jpDashboard.chart.addLegend("Sale", new Color(5, 125, 0), new Color(95, 209, 69));

        jpDashboard.chart.addData(new ModelChart("January", new double[]{purchase[0],sale[0]}));
        jpDashboard.chart.addData(new ModelChart("February", new double[]{ purchase[1], sale[1]}));
        jpDashboard.chart.addData(new ModelChart("March", new double[]{ purchase[2], sale[2]}));
        jpDashboard.chart.addData(new ModelChart("April", new double[]{ purchase[3], sale[3]}));
        jpDashboard.chart.addData(new ModelChart("May", new double[]{ purchase[4], sale[4]}));
        jpDashboard.chart.addData(new ModelChart("June", new double[]{purchase[5], sale[5]}));
        
        formatoDinero.setMaximumFractionDigits(1);

        ListSaleTopProductxPrice();
        ListSaleTopProductxQuantity();
        ListSaleTopCustomer();
        calendar.setTime(now);
        try{
            mes=calendar.get(Calendar.MONTH)+1;
        }catch(Exception ex){   
        } 
        
        //System.out.println(purchaseDao.TotalPurchaseMonth()[0]);;
        //for (int i = 0; i < objPurchaseDao.TotalPurchaseMonth().length; i++) {
        //    System.out.print(objPurchaseDao.TotalPurchaseMonth()[i]);
        //}
        //System.out.println(objPurchaseDao.TotalPurchaseMonth().clone());
    }
    
    public void ProgressSaleMonth(){
        //Month mes = LocalDate.now().getMonth();
 

        //System.out.println(mes);
        
        //System.out.println("MES ACTUALE"+mes);
        
        int month = jpDashboard.cmb_progress_month.getSelectedIndex();
        
        //System.out.println(jpDashboard.cmb_progress_month.getSelectedIndex()==0);
//        System.out.println("Mes CMBOX "+month);
        //jpDashboard.progress1.setValue(0);
        //System.out.println((int)objsaleDao.ProgressSale(0)==0);
        //jpDashboard.progress1.setValue((int)objsaleDao.ProgressSale(month));
        jpDashboard.progress1.setValueWithAnimation((int)objsaleDao.ProgressSale(month));
        
        //jpDashboard.progress1.start();
       /* if((int)objsaleDao.ProgressSale(month)==0){
            jpDashboard.progress1.setValue(0);
            jpDashboard.progress1.start();
        }else{
            //jpDashboard.progress1.setValue((int)objsaleDao.ProgressSale(month));
            jpDashboard.progress1.start();
        }*/ 
    }
    
    public void ProgressSaleMothActual(){
        //SETEAMOS MES ACTUAL
        jpDashboard.cmb_progress_month.setSelectedIndex(mes);
        jpDashboard.progress1.setValue(0);
        jpDashboard.progress1.setValueWithAnimation((int)objsaleDao.ProgressSale(mes));
    }
    
    public void ReportMonthActual(){
        jpReport.cmb_month.setSelectedIndex(mes);
        jpReport.cmb_periodo.setSelectedIndex(0);
    }
    
  public void ListSaleTopProductxPrice(){
        ClearTableProductxPrice();
        int month = jpDashboard.cmb_progress_month.getSelectedIndex();
        List <Product> listCustomer = objsaleDao.listTop3ProductSalesPriceQuery(month);
        modelTableProductxPrice= (DefaultTableModel) jpDashboard.table_sale_product.getModel();
        Object[] row = new Object[3];
        for(int i=0;i<listCustomer.size();i++){
            row[0]=formatoDinero.format(listCustomer.get(i).getUnit_price());
            row[1]=listCustomer.get(i).getName();
            row[2]=listCustomer.get(i).getCategory_name();
            modelTableProductxPrice.addRow(row);
        }
        jpDashboard.table_sale_product.setModel(modelTableProductxPrice);
        jpDashboard.lbl_total_price_merchandise.setText(String.valueOf(formatoDinero.format(objsaleDao.TotalSalePrice())));
        jpDashboard.lbl_total_product.setText(String.valueOf(formatoNumero.format(objsaleDao.TotalQuantiyProductQuery())));
    }
  
    public void ListSaleTopProductxQuantity(){
        ClearTableProductxQuantity();
        int month = jpDashboard.cmb_progress_month.getSelectedIndex();
        List <Product> listCustomer = objsaleDao.listTop3ProductSalesQuantityQuery(month);
        modelTableProductxQuantity= (DefaultTableModel) jpDashboard.table_sale_product1_quantity.getModel();
        Object[] row = new Object[3];
        for(int i=0;i<listCustomer.size();i++){
            row[0]=formatoNumero.format(listCustomer.get(i).getProduct_quantity());
            row[1]=listCustomer.get(i).getName();
            row[2]=listCustomer.get(i).getCategory_name();
            modelTableProductxQuantity.addRow(row);
        }
        jpDashboard.table_sale_product1_quantity.setModel(modelTableProductxQuantity);
    }
    
    
    public void ListSaleTopCustomer(){
        ClearTableCustomer();
        int month = jpDashboard.cmb_progress_month.getSelectedIndex();
        List <Product> listCustomer = objsaleDao.listTop3Customer(month);
        modelTableCustomer= (DefaultTableModel) jpDashboard.table_sale_customer.getModel();
        Object[] row = new Object[2];
        for(int i=0;i<listCustomer.size();i++){
            row[0]=listCustomer.get(i).getName();
            row[1]=formatoDinero.format(listCustomer.get(i).getUnit_price());
            modelTableCustomer.addRow(row);
        }
        jpDashboard.table_sale_customer.setModel(modelTableCustomer);
    }
    
    public void ClearTableCustomer(){
        for(int i=0;i<modelTableCustomer.getRowCount();i++){
            modelTableCustomer.removeRow(i);
            i--;
        }
    }
    
    public void ClearTableCustomerSearch(){
        for(int i=0;i<ModelTableCustomer.getRowCount();i++){
            ModelTableCustomer.removeRow(i);
            i--;
        }
    }
    private void ListCustomer() {
        ClearTableCustomerSearch();
        //jpSale.table_customer.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        List <Customer> listCustomer = customerDao.ListCustomer5Query(jpReport.txt_customer_search.getText());
        ModelTableCustomer = (DefaultTableModel) jpReport.table_customer.getModel();
        Object[] row = new Object[2];
        for(int i=0;i<listCustomer.size();i++){
            row[0]=listCustomer.get(i).getId();
            row[1]=listCustomer.get(i).getFull_name();
            /*row[2]=listCustomer.get(i).getTelephone();
            row[3]=listCustomer.get(i).getAddress();
            row[4]=listCustomer.get(i).getEmail();*/
            ModelTableCustomer.addRow(row);
        }
        jpReport.table_customer.setModel(ModelTableCustomer);
    }
    
    public void ClearTableProductxPrice(){
        for(int i=0;i<modelTableProductxPrice.getRowCount();i++){
            modelTableProductxPrice.removeRow(i);
            i--;
        }
    }
    
    public void ClearTableProductxQuantity(){
        for(int i=0;i<modelTableProductxQuantity.getRowCount();i++){
            modelTableProductxQuantity.removeRow(i);
            i--;
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
           jfPrint.dispose();
        if(e.getSource()==jpReport.table_all_purchase){
            int row = jpReport.table_all_purchase.rowAtPoint(e.getPoint());
            int id = Integer.parseInt(jpReport.table_all_purchase.getValueAt(row, 0).toString());
            jfPrint = new JF_Print(id);
            jfPrint.setVisible(true);
        }else if(e.getSource()==jpReport.table_customer){
            jpReport.txt_id_customer.setText(String.valueOf(ModelTableCustomer.getValueAt(jpReport.table_customer.getSelectedRow(),0)));
            jpReport.txt_customer_name.setText(String.valueOf(ModelTableCustomer.getValueAt(jpReport.table_customer.getSelectedRow(),1)));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         if(e.getStateChange() == ItemEvent.SELECTED){
            String item = (String) e.getItem();
            if(e.getSource()==jpDashboard.cmb_progress_month){
                ProgressSaleMonth();
                ListSaleTopProductxQuantity();
                ListSaleTopCustomer();
                ListSaleTopProductxPrice();
            }
            System.out.println(item);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==jpReport.txt_customer_search){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&jpReport.table_customer.getRowCount()>0) {
                jpReport.txt_id_customer.setText(String.valueOf(ModelTableCustomer.getValueAt(0,0)));
                jpReport.txt_customer_name.setText(String.valueOf(ModelTableCustomer.getValueAt(0,1)));
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==jpReport.txt_customer_search){
            ListCustomer();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpReport.btn_sale_report){
            String id_customer= jpReport.txt_id_customer.getText();
            String month = String.valueOf(jpReport.cmb_month.getSelectedIndex());
            String fortnight = String.valueOf(jpReport.cmb_periodo.getSelectedIndex());
            if(!id_customer.equals("")&&Integer.parseInt(month)>0){
                JasperReport reporte=null;
                String path= "src\\iReport\\ReportSale.jasper";
                Map parametro= new HashMap();
                parametro.put("customer_id",id_customer);
                parametro.put("month",month);
                if(fortnight.equals("0")){
                    parametro.put("first","1");
                    parametro.put("last","31");
                }else if(fortnight.equals("1")){
                    parametro.put("first","1");
                    parametro.put("last","15");
                }else if(fortnight.equals("2")){
                    parametro.put("first","16");
                    parametro.put("last","31");
                }
            try {
                reporte=(JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint= JasperFillManager.fillReport(reporte,parametro,conexion.getConnection());
                JasperViewer view =new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    String Npag=""+jprint.getPages();
                    if(Npag.equals("[]")){
                        //new Alertas.AlertaNoHayReporte(null, true).setVisible(true);
                    }else{
                        view.setVisible(true);
                    }
            } catch (JRException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
         
        }
   
        
    }

}
