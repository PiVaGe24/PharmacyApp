package View.TableCustomButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAction extends javax.swing.JPanel {

    /**
     * Creates new form PanelAction
     */
    public PanelAction() {
        initComponents();
        cmdView.setVisible(false);
    }
    
    public void initEvent(TableActionEvent event, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onEdit(row);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onDelete(row);
            }
        });
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onView(row);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new View.TableCustomButton.ActionButton();
        cmdDelete = new View.TableCustomButton.ActionButton();
        cmdView = new View.TableCustomButton.ActionButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        add(cmdEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, -1));

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        add(cmdDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 30, -1));

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/view.png"))); // NOI18N
        add(cmdView, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 0, 48, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.TableCustomButton.ActionButton cmdDelete;
    private View.TableCustomButton.ActionButton cmdEdit;
    private View.TableCustomButton.ActionButton cmdView;
    // End of variables declaration//GEN-END:variables
}
