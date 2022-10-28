/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package market.app.client.ui.manager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import market.app.client.Config;

/**
 *
 * @author Le Tuan
 */
public class frmManageItem extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmManagemeItem
     */
    private final DefaultTableModel modelTableItemList = new DefaultTableModel();
    private final DefaultComboBoxModel<String> modelComboItemType = new DefaultComboBoxModel<>();
    private String[] colums = new String[] {"Mã mặt hàng", "Tên mặt hàng", "Loại mặt hàng", "Đơn vị tính", "Số lượng tồn", "Giá mặt hàng "};
    private String[] itemTypes = new String[] {"Bánh", "Nước ngọt"};//get from database
    
    public frmManageItem() {
        initComponents();
        Config.hideTitleBarInternalFrame(this);
        Config.initColTable(tblStaffList, modelTableItemList, colums);
        Config.initComboBox(cboItemType, modelComboItemType, itemTypes);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnItemInfor = new javax.swing.JPanel();
        lblItemName = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        lblItemType = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JTextField();
        lblItemPrice = new javax.swing.JLabel();
        cboItemType = new javax.swing.JComboBox<>();
        lblItemNumber = new javax.swing.JLabel();
        txtItemNumber = new javax.swing.JTextField();
        lblItemUnit = new javax.swing.JLabel();
        cboItemUnit = new javax.swing.JComboBox<>();
        pnAction = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnItemList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaffList = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnOpenFrmItemType = new javax.swing.JButton();

        pnItemInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Thông tin mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblItemName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemName.setText("Tên mặt hàng: ");

        lblItemType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemType.setText("Loại mặt hàng:");

        lblItemPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemPrice.setText("Giá mặt hàng: ");

        cboItemType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblItemNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemNumber.setText("Số lượng:");

        lblItemUnit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemUnit.setText("Đơn vị tính:");

        cboItemUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnItemInforLayout = new javax.swing.GroupLayout(pnItemInfor);
        pnItemInfor.setLayout(pnItemInforLayout);
        pnItemInforLayout.setHorizontalGroup(
            pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addComponent(lblItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txtItemNumber))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addComponent(lblItemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addComponent(lblItemPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtItemPrice))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblItemType)
                            .addComponent(lblItemUnit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboItemType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboItemUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnItemInforLayout.setVerticalGroup(
            pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemType))
                .addGap(13, 13, 13)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemNumber)
                    .addComponent(txtItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItemPrice)
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btnAdd.setBackground(new java.awt.Color(69, 123, 157));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnChange.setBackground(new java.awt.Color(69, 123, 157));
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("Sửa");

        btnDelete.setBackground(new java.awt.Color(69, 123, 157));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");

        javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
        pnAction.setLayout(pnActionLayout);
        pnActionLayout.setHorizontalGroup(
            pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnActionLayout.setVerticalGroup(
            pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActionLayout.createSequentialGroup()
                .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnItemList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Danh sách mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblStaffList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStaffList);

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearch.setText("Tìm kiếm: ");

        btnSearch.setBackground(new java.awt.Color(69, 123, 157));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm");

        javax.swing.GroupLayout pnItemListLayout = new javax.swing.GroupLayout(pnItemList);
        pnItemList.setLayout(pnItemListLayout);
        pnItemListLayout.setHorizontalGroup(
            pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGroup(pnItemListLayout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnItemListLayout.setVerticalGroup(
            pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItemListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        btnOpenFrmItemType.setBackground(new java.awt.Color(69, 123, 157));
        btnOpenFrmItemType.setForeground(new java.awt.Color(255, 255, 255));
        btnOpenFrmItemType.setText("Loại mặt hàng");
        btnOpenFrmItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFrmItemTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnItemInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pnItemList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOpenFrmItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOpenFrmItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnItemInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnOpenFrmItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFrmItemTypeActionPerformed
        // TODO add your handling code here:
        new frmItemType().setVisible(true);
    }//GEN-LAST:event_btnOpenFrmItemTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpenFrmItemType;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboItemType;
    private javax.swing.JComboBox<String> cboItemUnit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblItemNumber;
    private javax.swing.JLabel lblItemPrice;
    private javax.swing.JLabel lblItemType;
    private javax.swing.JLabel lblItemUnit;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnItemInfor;
    private javax.swing.JPanel pnItemList;
    private javax.swing.JTable tblStaffList;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemNumber;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}