/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package market.app.client.ui.manager;

import entity.Account;
import market.app.client.ui.frmViewInfor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import market.app.client.Config;
import market.app.client.ui.frmLogin;

/**
 *
 * @author Le Tuan
 */
public class frmMenuManager extends javax.swing.JFrame {
    private Account _account;
    /**
     * Creates new form frmHomeManager
     */
    //buttons support handle click menu item
    private JButton[] buttons = null;
    
    public frmMenuManager(Account account) {
        initComponents();
        Config.startPanel(new frmManageItem(), pnContent, btnManageItem);
        this.buttons = new JButton[]{btnLogout, btnManageItem, btnManageOrder, btnManageStaff, btnViewInfor};
        this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        //login send;
        _account = account;
        lblNameAndID.setText(_account.getStaff().getId() + " - " + account.getStaff().getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        pnMenu = new javax.swing.JPanel();
        btnManageItem = new javax.swing.JButton();
        btnManageStaff = new javax.swing.JButton();
        btnManageOrder = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblNameAndID = new javax.swing.JLabel();
        btnViewInfor = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnContent = new javax.swing.JPanel();
        pnMenuSale = new javax.swing.JPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnMenu.setBackground(new java.awt.Color(214, 229, 227));
        pnMenu.setPreferredSize(new java.awt.Dimension(250, 0));

        btnManageItem.setText("Quản lý mặt hàng");
        btnManageItem.setPreferredSize(new java.awt.Dimension(80, 22));
        btnManageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageItemActionPerformed(evt);
            }
        });

        btnManageStaff.setText("Quản lý nhân viên");
        btnManageStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStaffActionPerformed(evt);
            }
        });

        btnManageOrder.setText("Quản lý hóa đơn");
        btnManageOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrderActionPerformed(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carbon_user-avatar-filled-alt.png"))); // NOI18N

        lblPosition.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosition.setText("Quản lý");

        lblNameAndID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNameAndID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameAndID.setText("QL001 - Jone");

        btnViewInfor.setText("Xem thông tin");
        btnViewInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewInforActionPerformed(evt);
            }
        });

        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameAndID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(btnManageItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPosition, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameAndID)
                .addGap(18, 18, 18)
                .addComponent(btnManageItem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        getContentPane().add(pnMenu, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout pnMenuSaleLayout = new javax.swing.GroupLayout(pnMenuSale);
        pnMenuSale.setLayout(pnMenuSaleLayout);
        pnMenuSaleLayout.setHorizontalGroup(
            pnMenuSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        pnMenuSaleLayout.setVerticalGroup(
            pnMenuSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnContentLayout = new javax.swing.GroupLayout(pnContent);
        pnContent.setLayout(pnContentLayout);
        pnContentLayout.setHorizontalGroup(
            pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMenuSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnContentLayout.setVerticalGroup(
            pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContentLayout.createSequentialGroup()
                .addComponent(pnMenuSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageItemActionPerformed
        // TODO add your handling code here:
        Config.startPanel(new frmManageItem(), pnContent, btnManageItem);
        Config.handleButtonClick(buttons, btnManageItem);
    }//GEN-LAST:event_btnManageItemActionPerformed

    private void btnManageStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStaffActionPerformed
        // TODO add your handling code here:
        Config.startPanel(new frmManageStaff(), pnContent, btnManageItem);
        Config.handleButtonClick(buttons, btnManageStaff);
        
    }//GEN-LAST:event_btnManageStaffActionPerformed

    private void btnManageOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrderActionPerformed
        // TODO add your handling code here:
        frmManageOrder order = new frmManageOrder();
        Config.openComponent(order, pnContent);
        Config.handleButtonClick(buttons, btnManageOrder);
        
    }//GEN-LAST:event_btnManageOrderActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Config.closeForm(this);
    }//GEN-LAST:event_formWindowClosing

    private void btnViewInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewInforActionPerformed
        // TODO add your handling code here:
        frmViewInfor viewInfor = new frmViewInfor();
        Config.openComponent(viewInfor, pnContent);
        Config.handleButtonClick(buttons, btnViewInfor);
    }//GEN-LAST:event_btnViewInforActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Config.handleButtonClick(buttons, btnLogout);
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất?", "Thông báo",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choose == JOptionPane.YES_OPTION){
            new frmLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmMenuManager().setVisible(true);
//            }
//        });
//    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageItem;
    private javax.swing.JButton btnManageOrder;
    private javax.swing.JButton btnManageStaff;
    private javax.swing.JButton btnViewInfor;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNameAndID;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnMenuSale;
    // End of variables declaration//GEN-END:variables
}
