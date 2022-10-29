/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package market.app.client.ui.manager;

import entity.ProductType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import market.app.client.Config;
import market.app.client.connect.ConnectServer;
import service.IProductTypeService;

/**
 *
 * @author Le Tuan
 */
public class frmItemType extends javax.swing.JFrame {

    /**
     * Creates new form frmItemType
     */
    private IProductTypeService productTypeService;
    private final DefaultTableModel modelTableProductTypeList = new DefaultTableModel();
    private final String[] colums = new String[]{"Số thứ tự", "Tên loại mặt hàng", "Đơn vị"};

    public frmItemType() {
        initComponents();

        // connect RMI
        productTypeService = ConnectServer.getInstance().getProductTypeService();

        setLocationRelativeTo(null);
        Config.initColTable(tblItemTypeList, modelTableProductTypeList, colums);

        // load data
        loadDataToListView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAction = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblIItemTypeName = new javax.swing.JLabel();
        txtProductType = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        pnItemTypeList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemTypeList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

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
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(69, 123, 157));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblIItemTypeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIItemTypeName.setText("Tên loại mặt hàng: ");

        btnSearch.setBackground(new java.awt.Color(69, 123, 157));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm");
        btnSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Đơn vị:");

        javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
        pnAction.setLayout(pnActionLayout);
        pnActionLayout.setHorizontalGroup(
            pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnActionLayout.createSequentialGroup()
                        .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUnit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProductType)
                            .addGroup(pnActionLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                    .addGroup(pnActionLayout.createSequentialGroup()
                        .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIItemTypeName)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnActionLayout.setVerticalGroup(
            pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActionLayout.createSequentialGroup()
                .addComponent(lblIItemTypeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtProductType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnItemTypeList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Danh sách loại mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblItemTypeList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblItemTypeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemTypeListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItemTypeList);

        javax.swing.GroupLayout pnItemTypeListLayout = new javax.swing.GroupLayout(pnItemTypeList);
        pnItemTypeList.setLayout(pnItemTypeListLayout);
        pnItemTypeListLayout.setHorizontalGroup(
            pnItemTypeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemTypeListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnItemTypeListLayout.setVerticalGroup(
            pnItemTypeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItemTypeListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnItemTypeList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(pnItemTypeList, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Load data to list
    private void loadDataToListView() {
        try {
            modelTableProductTypeList.setRowCount(0);

            for (ProductType prod : productTypeService.getAllProductType()) {
                Object[] obj = new Object[]{prod.getId(), prod.getName(), prod.getUnit()};
                modelTableProductTypeList.addRow(obj);
            }

            modelTableProductTypeList.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // clear input
    private void clearInputs() {
        txtProductType.setText("");
        txtUnit.setText("");
        txtProductType.requestFocus();
    }

    // Check inputs
    private boolean checkInputs() {
        String prodType = txtProductType.getText();
        String unit = txtUnit.getText();

        if (prodType.equals("") || unit.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn cần phải nhập đầy đủ thông tin!");
            return true;
        }

        return false;
    }

    // Button add product type
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String prodType = txtProductType.getText();
        String unit = txtUnit.getText();

        // check inputs
        if (checkInputs()) {
            return;
        }

        ProductType productType = new ProductType(prodType, unit);

        try {
            // check exist product type
            for (ProductType prod : productTypeService.getAllProductType()) {
                if (prodType.equals(prod.getName()) && unit.equals(prod.getUnit())) {
                    JOptionPane.showMessageDialog(this, "Loại sản phẩm này đã tồn tại. Vui lòng nhập loại sản phẩm khác!");
                    clearInputs();
                    return;
                }
            }

            productTypeService.addOrUpdateProductType(productType);

            JOptionPane.showMessageDialog(this, "Thêm loại sản phẩm thành công.");
            clearInputs();
            loadDataToListView();
        } catch (Exception ex) {
            Logger.getLogger(frmItemType.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnAddActionPerformed

    // Button update
    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        String prodType = txtProductType.getText();
        String unit = txtUnit.getText();
        int selected = tblItemTypeList.getSelectedRow();
        ProductType productType = null;

        // check inputs
        if (checkInputs()) {
            return;
        }

        try {
            if (selected >= 0) {
                int index = (int) tblItemTypeList.getValueAt(selected, 0);
                productType = productTypeService.findProductTypeById(index);

                if (productType != null) {
                    productType.setName(prodType);
                    productType.setUnit(unit);

                    // check exist product type
                    for (ProductType prod : productTypeService.getAllProductType()) {
                        if (prodType.equals(prod.getName()) && unit.equals(prod.getUnit())) {
                            JOptionPane.showMessageDialog(this, "Loại sản phẩm này đã tồn tại. Vui lòng nhập loại sản phẩm khác!");
                            clearInputs();
                            return;
                        }
                    }

                    productTypeService.addOrUpdateProductType(productType);
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công loại sản phẩm.");
                    loadDataToListView();
                    clearInputs();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    // Button delete
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selected = tblItemTypeList.getSelectedRow();
        ProductType productType = null;

        // check inputs
        if (checkInputs()) {
            return;
        }

        try {
            if (selected >= 0) {
                int index = (int) tblItemTypeList.getValueAt(selected, 0);
                int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa loại sản phẩm này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                productType = productTypeService.findProductTypeById(index);

                for (ProductType prod : productTypeService.getAllProductType()) {
                    if (productType.getId() == prod.getId()) {
                        if (choise == JOptionPane.YES_OPTION) {
                            productType.setBuying(false);
                            productTypeService.addOrUpdateProductType(productType);

                            JOptionPane.showMessageDialog(this, "Xóa loại sản phẩm thành công.");
                            clearInputs();
                            loadDataToListView();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmItemType.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Cliked list view
    private void tblItemTypeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemTypeListMouseClicked
        int selected = tblItemTypeList.getSelectedRow();

        if (selected >= 0) {
            int index = (int) tblItemTypeList.getValueAt(selected, 0);
            ProductType productType = null;

            try {
                productType = productTypeService.findProductTypeById(index);

                if (productType != null) {
                    txtProductType.setText(productType.getName());
                    txtUnit.setText(productType.getUnit());
                }
            } catch (Exception ex) {
                Logger.getLogger(frmItemType.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblItemTypeListMouseClicked

    private void btnSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSearchKeyReleased
        
    }//GEN-LAST:event_btnSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmItemType().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIItemTypeName;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnItemTypeList;
    private javax.swing.JTable tblItemTypeList;
    private javax.swing.JTextField txtProductType;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
