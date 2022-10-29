/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package market.app.client.ui.staff;

import entity.Account;
import entity.OrderDetail;
import entity.Product;
import entity.Staff;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import market.app.client.Config;
import market.app.client.connect.ConnectServer;
import market.app.client.ui.frmOrder;
import service.IProductService;

/**
 *
 * @author Le Tuan
 */
public class frmSale extends javax.swing.JInternalFrame {

    private IProductService productService;

    private Staff staff;
    private Account _account;
    private List<Product> products;
    private List<OrderDetail> details;
    /**
     * Creates new form frmSale
     */
    private final DefaultTableModel modelTableOrderDetail = new DefaultTableModel();
    private final String[] colums = new String[]{"STT", "Tên mặt hàng", "Đơn vị tính", "Số lượng", "Thành tiền"};

    public frmSale(Account account) {
        initComponents();
        Config.initColTable(tblOrderDetail, modelTableOrderDetail, colums);
        Config.hideTitleBarInternalFrame(this);
        productService = ConnectServer.getInstance().getProductService();
        details = new ArrayList<>();
        //give from login
        _account = account;
        products = getAllProduct();
        txtItemName.setEditable(false);
        getTextChangeInput(txtItemID);
    }

    private List<Product> getAllProduct() {
        try {
            return productService.getAllProduct();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ở lấy dữ liệu tất cả sản phẩm");
            e.printStackTrace();
        }

        return null;
    }

    //handle input value change
    private void handleGiveInput(JTextField field) {
        try {
            int id = Integer.parseInt(field.getText());
            try {
                Product product = productService.findProductById(id);
                if (product != null) {
                    txtItemName.setText(product.getName());
                    btnConfirm.setEnabled(true);
                } else {
                    txtItemName.setText("Sản phẩm này không tồn tại");
                    btnConfirm.setEnabled(false);
                }
            } catch (Exception ex) {
                System.err.println("Lỗi tìm kiếm sản phẩm trong event textChange");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    //give input value change
    private void getTextChangeInput(JTextField field) {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleGiveInput(field);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!field.getText().trim().equals("")) {
                    handleGiveInput(field);
                } else {
                    txtItemName.setText("");
                    btnConfirm.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //handleGiveInput(field);
                System.err.println("change update");
            }
        });
    }

    //load order detail to list
    private void loadOrderDetailToList(List<OrderDetail> details) {
        modelTableOrderDetail.setRowCount(0);
        for (int i = 0; i < details.size(); ++i) {
            Product product = details.get(i).getProduct();
            Object[] objects = new Object[]{i + 1, product.getName(), product.getType().getUnit(), details.get(i).getQuantity(), details.get(i).getTotalOrderDetail()};
            modelTableOrderDetail.addRow(objects);
        }
    }

    //cal money
    private double calTotalMoneyByListOrderDetail(List<OrderDetail> details) {
        double total = 0;
        for (OrderDetail detail : details) {
            total += detail.getTotalOrderDetail();
        }

        return total;
    }

    //check order detail exists then update quatity
    private OrderDetail isExist(List<OrderDetail> details, Product product, int number) {
        for (OrderDetail detail : details) {
            if (detail.getProduct().getId() == product.getId()) {
                detail.setQuantity(detail.getQuantity() + number);

                return detail;
            }
        }

        return null;
    }

    private void clearInput() {
        txtItemID.setText("");
        txtItemName.setText("");
        txtNumber.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnInput = new javax.swing.JPanel();
        lblItemID = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        lblItemName = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        lblNumber = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        pnItemList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderDetail = new javax.swing.JTable();
        btnCreateOrder = new javax.swing.JButton();
        lblTagTotalMoney = new javax.swing.JLabel();
        lblTotalMoney = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 800));

        pnInput.setBackground(new java.awt.Color(255, 255, 255));
        pnInput.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Thông tin mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblItemID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemID.setText("Nhập mã mặt hàng:");

        lblItemName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemName.setText("Tên mặt hàng: ");

        lblNumber.setText("Số lượng: ");

        btnConfirm.setBackground(new java.awt.Color(69, 123, 157));
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Xác nhận");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(69, 123, 157));
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("Xóa");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnInputLayout = new javax.swing.GroupLayout(pnInput);
        pnInput.setLayout(pnInputLayout);
        pnInputLayout.setHorizontalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtItemName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtItemID)
                    .addGroup(pnInputLayout.createSequentialGroup()
                        .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblItemID)
                            .addComponent(lblItemName)
                            .addComponent(lblNumber))
                        .addGap(0, 227, Short.MAX_VALUE))
                    .addComponent(btnDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnInputLayout.setVerticalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblItemID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnItemList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Danh sách mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOrderDetail);

        btnCreateOrder.setBackground(new java.awt.Color(69, 123, 157));
        btnCreateOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateOrder.setText("Tạo hóa đơn");
        btnCreateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateOrderActionPerformed(evt);
            }
        });

        lblTagTotalMoney.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTagTotalMoney.setText("Tổng tiền:");

        lblTotalMoney.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalMoney.setText("0,000 VNÐ");

        javax.swing.GroupLayout pnItemListLayout = new javax.swing.GroupLayout(pnItemList);
        pnItemList.setLayout(pnItemListLayout);
        pnItemListLayout.setHorizontalGroup(
            pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(btnCreateOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItemListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTagTotalMoney)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnItemListLayout.setVerticalGroup(
            pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalMoney)
                    .addComponent(lblTagTotalMoney))
                .addGap(12, 12, 12)
                .addComponent(btnCreateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnItemList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnItemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateOrderActionPerformed
        // TODO add your handling code here:
        new frmOrder().setVisible(true);
    }//GEN-LAST:event_btnCreateOrderActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        int id = Integer.parseInt(txtItemID.getText());
        try {
            int number = Integer.parseInt(txtNumber.getText());
            try {
                Product product = productService.findProductById(id);
                OrderDetail detail = isExist(details, product, number);
                if (detail == null) {
                    OrderDetail _detail = new OrderDetail(product, null, number);
                    details.add(_detail);
                }

                loadOrderDetailToList(details);
                lblTotalMoney.setText(calTotalMoneyByListOrderDetail(details) + "");
                clearInput();
            } catch (Exception ex) {
                System.err.println("Lỗi tìm kiếm sản phẩm khi xác nhận thêm sản phẩm vào chi tiết hóa đơn!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng số lượng là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int index = tblOrderDetail.getSelectedRow();
        if (index > -1) {
            details.remove(index);
            loadOrderDetailToList(details);
            lblTotalMoney.setText(calTotalMoneyByListOrderDetail(details) + "");
        }
    }//GEN-LAST:event_btnDelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnCreateOrder;
    private javax.swing.JButton btnDel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblTagTotalMoney;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JPanel pnInput;
    private javax.swing.JPanel pnItemList;
    private javax.swing.JTable tblOrderDetail;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
