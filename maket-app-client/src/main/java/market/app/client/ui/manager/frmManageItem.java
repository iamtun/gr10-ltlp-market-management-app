/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package market.app.client.ui.manager;

import entity.Account;
import entity.Product;
import entity.ProductType;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import market.app.client.Config;
import market.app.client.connect.ConnectServer;
import service.IProductService;
import service.IProductTypeService;

/**
 *
 * @author Le Tuan
 */
public class frmManageItem extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmManagemeItem
     */
    private IProductService productService;
    private IProductTypeService productTypeService;
    private final DefaultTableModel modelTableProductList = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    private String[] colums = new String[]{"STT", "Tên mặt hàng", "Loại mặt hàng", "Đơn vị tính", "Số lượng tồn", "Giá mặt hàng "};

    public frmManageItem() {
        initComponents();

        // connect rmi
        productService = ConnectServer.getInstance().getProductService();
        productTypeService = ConnectServer.getInstance().getProductTypeService();

        Config.hideTitleBarInternalFrame(this);
        Config.initColTable(tblProductList, modelTableProductList, colums);

        // load data
        loadDataToCombobox();
        loadDataToListView();
    }

    // fix server
    private List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        try {
            for (Product pt : productService.getAllProduct()) {
                Product prod = productService.findProductById(pt.getId());
                list.add(prod);
            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // convert to vnd
    private String formatVND(double price) {
        String pat = "###.### " + "VNÐ";
        DecimalFormat df = new DecimalFormat(pat);
        String format = df.format(price);

        return format;
    }

    // load data to list view
    private void loadDataToListView() {
        modelTableProductList.setRowCount(0);

        try {
            int i = 1;
            for (Product prod : getProducts()) {
                Object[] obj = new Object[]{
                    i++,
                    prod.getName(),
                    prod.getType().getName(),
                    prod.getType().getUnit(),
                    prod.getNumber(),
                    String.format(formatVND(prod.getPrice()), 5)
                };
                modelTableProductList.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelTableProductList.fireTableDataChanged();
    }

    // load data to combobox
    private void loadDataToCombobox() {
        // event close frmItemType       
        try {
            for (ProductType prod : productTypeService.getAllProductType()) {
                cboProductType.addItem(prod.getName());
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // clear inputs
    private void clearInputs() {
        txtProductName.setText("");
        cboProductType.setSelectedIndex(0);
        cboItemUnit.setSelectedIndex(0);
        txtNumber.setText("");
        txtPrice.setText("");
        txtProductName.requestFocus();
    }

    // check inputs
    private boolean checkInputs() {
        String productName = txtProductName.getText();
        String number = txtNumber.getText();
        String price = txtPrice.getText();

        if (productName.equals("") || number.equals("") || price.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn cần phải nhập đầy đủ thông tin!");
            return true;
        }

        return false;
    }

    /// vaildate ten san pham
    private boolean regexName(String name) {
        String reg = "^([aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n"
                + "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n"
                + "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ123456789]+)"
                + "((\\s{1}[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n"
                + "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n"
                + "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ0123456789]*){0,})$";
        Pattern pattern = Pattern.compile(reg);
        if (pattern.matcher(name).find()) {
            return true;
        }
//        String firstLetter="[A-EGHIK-VXYÂĐỔÔÚỨ]";
//        String firstLetter1="[a-zâđổôúứ]";
//      	String otherLetters="[a-zàáâãèéêìíòóôõùúýỳỹỷỵựửữừứưụủũợởỡờớơộổỗồốọỏịỉĩệểễềếẹẻẽặẳẵằắăậẩẫầấạảđ₫]";
//      	String regexString="^"
//                 +firstLetter+otherLetters+"+\\s"
//                 +"("+firstLetter1+otherLetters+"+\\s)*"
//                 +firstLetter1+otherLetters+"+$";        
//        if(name.matches(regexString)) {
//            return true;
//        }

        return false;
    }

    // handle search
    private void searchFilter(String val) {
        TableRowSorter<DefaultTableModel> row = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tblProductList.getModel());
        tblProductList.setRowSorter(row);
        row.setRowFilter(RowFilter.regexFilter("(?i)" + val));
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
        txtProductName = new javax.swing.JTextField();
        lblItemType = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblItemPrice = new javax.swing.JLabel();
        cboProductType = new javax.swing.JComboBox<>();
        lblItemNumber = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        lblItemUnit = new javax.swing.JLabel();
        cboItemUnit = new javax.swing.JComboBox<>();
        pnAction = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnItemList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductList = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        btnOpenFrmItemType = new javax.swing.JButton();

        pnItemInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Thông tin mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblItemName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemName.setText("Tên mặt hàng: ");

        lblItemType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemType.setText("Loại mặt hàng:");

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        lblItemPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemPrice.setText("Giá mặt hàng: ");

        cboProductType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProductTypeItemStateChanged(evt);
            }
        });
        cboProductType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductTypeActionPerformed(evt);
            }
        });

        lblItemNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemNumber.setText("Số lượng:");

        txtNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumberKeyTyped(evt);
            }
        });

        lblItemUnit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemUnit.setText("Đơn vị tính:");

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
                        .addComponent(txtNumber))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addComponent(lblItemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addComponent(lblItemPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblItemType)
                            .addComponent(lblItemUnit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboProductType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboItemUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnItemInforLayout.setVerticalGroup(
            pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemType))
                .addGap(13, 13, 13)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemNumber)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItemPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tblProductList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductList);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearch.setText("Tìm kiếm: ");

        javax.swing.GroupLayout pnItemListLayout = new javax.swing.GroupLayout(pnItemList);
        pnItemList.setLayout(pnItemListLayout);
        pnItemListLayout.setHorizontalGroup(
            pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addGroup(pnItemListLayout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)))
                .addContainerGap())
        );
        pnItemListLayout.setVerticalGroup(
            pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItemListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnItemList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 996, Short.MAX_VALUE)
                        .addComponent(btnOpenFrmItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOpenFrmItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    // button add product
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // check inputs
        if (checkInputs()) {
            return;
        }

        String productName = txtProductName.getText();
        String productTypeName = cboProductType.getSelectedItem().toString();
        String productUnit = cboItemUnit.getSelectedItem().toString();
        int number = Integer.parseInt(txtNumber.getText());
        double price = Double.parseDouble(txtPrice.getText());

        // check name product
        if (!regexName(productName)) {
            JOptionPane.showMessageDialog(this, "Tên mặt hàng không hợp lệ. Vui lòng kiểm tra lại!");
            return;
        }

        try {
            // check exits product productService.getAllProduct()
            for (Product prod : getProducts()) {
                if (productName.equals(prod.getName()) && productTypeName.equals(prod.getType().getName())) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại. Bạn có thể thực hiện chức năng sửa số lượng sản phẩm!");
                    clearInputs();
                    return;
                }
            }

            // add product
            for (ProductType proType : productTypeService.getAllProductType()) {
                if (productTypeName.equals(proType.getName()) && productUnit.equals(proType.getUnit())) {
                    ProductType productType = productTypeService.findProductTypeById(proType.getId());

                    Product product = new Product(productName, number, price, productType);

                    productService.addOrUpdateProduct(product);
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.");
                    clearInputs();
                    loadDataToListView();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnOpenFrmItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFrmItemTypeActionPerformed
        // TODO add your handling code here:
        frmItemType forder = new frmItemType();
        forder.setVisible(true);
        forder.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    cboProductType.removeAllItems();
                    for (ProductType prod : productTypeService.getAllProductType()) {
                        cboProductType.addItem(prod.getName());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_btnOpenFrmItemTypeActionPerformed

    // clicked list view
    private void tblProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductListMouseClicked
        int selected = tblProductList.getSelectedRow();
        Product product = null;

        if (selected >= 0) {
            try {
                product = getProducts().get(selected);

                if (product != null) {
                    txtProductName.setText(product.getName());
                    cboProductType.setSelectedItem(product.getType().getName());
                    cboItemUnit.setSelectedItem(product.getType().getUnit());
                    txtNumber.setText(product.getNumber() + "");
                    txtPrice.setText(formatVND(product.getPrice()).split(" ")[0]);

                    cboProductType.setEnabled(false);
                    cboItemUnit.setEnabled(false);
                }
            } catch (Exception ex) {
                Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_tblProductListMouseClicked

    // button delete product
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selected = tblProductList.getSelectedRow();
        if(selected < 0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mặt hàng cần xóa");
            return;
        }

        // check inputs
        if (checkInputs()) {
            return;
        }
        
        Product product = null;

        try {
            if (selected >= 0) {
                product = getProducts().get(selected);
                int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm này không?", "Thông báo", JOptionPane.YES_NO_OPTION);

                for (Product prod : productService.getAllProduct()) {
                    if (product.getId() == prod.getId()) {
                        if (choise == JOptionPane.YES_OPTION) {
                            product.setSelling(false);
                            productService.addOrUpdateProduct(product);

                            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công.");
                            clearInputs();
                            loadDataToListView();
                        }
                    }
                }
            }

            cboProductType.setEnabled(true);
            cboItemUnit.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // button update product
    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        int selected = tblProductList.getSelectedRow();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mặt hàng cần sửa");
            return;
        }

        // check inputs
        if (checkInputs()) {
            return;
        }

        String productName = txtProductName.getText();
        //String productTypeName = cboProductType.getSelectedItem().toString();
        //String unit = cboItemUnit.getSelectedItem().toString();
        int number = Integer.parseInt(txtNumber.getText());
        double price = Double.parseDouble(txtPrice.getText());
        Product product = null;

        try {
            product = getProducts().get(selected);

            if (product != null) {
                product.setName(productName);
                product.setNumber(number);
                product.setPrice(price);

                productService.addOrUpdateProduct(product);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm.");
                loadDataToListView();
                clearInputs();

                cboProductType.setEnabled(true);
                cboItemUnit.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật không thành công sản phẩm!");
                clearInputs();
            }
        } catch (Exception e) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    // selected change items
    private void cboProductTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProductTypeItemStateChanged

    }//GEN-LAST:event_cboProductTypeItemStateChanged

    private void cboProductTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductTypeActionPerformed
        try {
            String productType = cboProductType.getSelectedItem().toString();
            System.out.println("market.app.client.ui.manager.frmManageItem.cboProductTypeActionPerformed()" + productType);
            //ProductType prodType = productTypeService.findProductTypeById(prodType.getId());;

            for (ProductType prodType : productTypeService.getAllProductType()) {
                if (productType.equals(prodType.getName())) {
                    cboItemUnit.removeAllItems();
                    for (ProductType pt : productTypeService.findListProductTypeByName(productType)) {
                        cboItemUnit.addItem(pt.getUnit());
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboProductTypeActionPerformed

    // search filter
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchVal = txtSearch.getText();
        searchFilter(searchVal);
    }//GEN-LAST:event_txtSearchKeyReleased

    // No character
    private void txtNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumberKeyTyped

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpenFrmItemType;
    private javax.swing.JComboBox<String> cboItemUnit;
    private javax.swing.JComboBox<String> cboProductType;
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
    private javax.swing.JTable tblProductList;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
