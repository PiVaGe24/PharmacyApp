package View;

import java.awt.Image;
import java.awt.Toolkit;

public class JF_Login extends javax.swing.JFrame {
    /**
     * Creates new form JF_Login
     */
    public JF_Login() {
        initComponents();
        new TextPrompt("@username", txt_username);
        new TextPrompt("Password", txt_password);
        txt_username.setText("PiVaGe");
        txt_password.setText("123");
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ShapedButton.ButtonShape.ROUND, btn_login);
        btn_login.setUI(roundUI);
        //btn_login.setBorder(new RoundedBorder(40));
    }

    @Override
    public Image getIconImage() {
        Image reValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/sucess.png"));
        return reValue; //To change body of generated methods, choose Tools | Templates.
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanelRound2 = new LIB.JPanelRound();
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jPanelRound1 = new LIB.JPanelRound();
        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_imgbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(227, 239, 222));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome !");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 300, -1));

        btn_login.setFont(new java.awt.Font("Lucida Sans", 0, 22)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("LOGIN");
        btn_login.setBorder(null);
        btn_login.setBorderPainted(false);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 210, 50));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/closex35.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 40, 40));

        jPanelRound2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound2.setForeground(new java.awt.Color(0, 0, 0));
        jPanelRound2.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound2.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanelRound2.setOpaque(true);
        jPanelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/passwordx32.png"))); // NOI18N
        jPanelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        txt_password.setFont(new java.awt.Font("Swis721 Lt BT", 0, 22)); // NOI18N
        txt_password.setBorder(null);
        txt_password.setOpaque(false);
        jPanelRound2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 280, 40));

        panel.add(jPanelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 380, 60));

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setForeground(new java.awt.Color(0, 0, 0));
        jPanelRound1.setColorPrimario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setColorSecundario(new java.awt.Color(255, 255, 255));
        jPanelRound1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanelRound1.setOpaque(true);
        jPanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 22)); // NOI18N
        txt_username.setBorder(null);
        txt_username.setOpaque(false);
        jPanelRound1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 280, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usernamex32.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        panel.add(jPanelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 380, 60));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 490, 420));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_imgbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/WallPaperLogin.PNG"))); // NOI18N
        jPanel2.add(lbl_imgbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -50, 510, 510));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    private javax.swing.JLabel lbl_imgbackground;
    public javax.swing.JPanel panel;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
