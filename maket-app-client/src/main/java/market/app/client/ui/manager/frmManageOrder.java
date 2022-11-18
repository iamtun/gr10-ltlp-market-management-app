/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package market.app.client.ui.manager;

import com.raven.datechooser.SelectedDate;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import market.app.client.Config;
import market.app.client.connect.ConnectServer;
import market.app.client.ui.frmOrder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.IOrderDetailService;
import service.IOrderService;

/**
 *
 * @author Le Tuan
 */
public class frmManageOrder extends javax.swing.JInternalFrame {

    private List<OrderDetail> _details;
    private List<Order> _orders;
    private Account _account;
    private IOrderService orderService;
    private IOrderDetailService detailService;
    private int indexSelected = -1;
    /**
     * Creates new form frmManageOrder
     */
    private final DefaultTableModel modelTableOrderDetail = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    private final DefaultTableModel modelTableOrder = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    private final String[] colums = new String[]{"STT", "Tên hàng", "Đơn vị tính", "Số lượng", "Thành tiền"};
    private final String[] orderColumns = new String[]{"STT", "Ngày Lập HD", "Tổng Tiền"};

    public frmManageOrder(Account _account1) {
        initComponents();
        _account = _account1;

        Config.hideTitleBarInternalFrame(this);
        Config.initColTable(tblOrderDetail, modelTableOrderDetail, colums);
        Config.initColTable(tblOrderList, modelTableOrder, orderColumns);

        //logic
        orderService = ConnectServer.getInstance().getOrderService();
        detailService = ConnectServer.getInstance().getOrderDetailService();
        _orders = getAllOrderNowFromServer();
        loadDataToOrderTable(_orders);

        btnChange.setEnabled(false);
    }

    private List<Order> getAllOrderNowFromServer() {
        List<Order> orders = new ArrayList<>();
        String dateNow = Config.convertDateToStringSql(new Date());
        try {
            orderService.getAllOrderDateNow(dateNow).forEach(order -> {
                try {
                    //System.err.println(order);
                    orders.add(orderService.findOrderById(order.getId()));
                } catch (Exception ex) {
                    System.err.println("Lỗi đọc hóa đơn!");
                    Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (Exception e) {
            Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, e);
        }

        return orders;
    }

    private List<Order> getOrderDetailFromOrder(List<Order> orders) {
        List<Order> __orders = new ArrayList<>();
        //System.err.println(orders);
        try {
            orders.forEach(order -> {
                try {
                    Order _order = orderService.findOrderById(order.getId());
                    if (_order != null) {
                        //System.err.println(_order.getDetails());
                        __orders.add(_order);
                    }

                } catch (Exception ex) {
                    System.err.println("Lỗi đọc hóa đơn!");
                    Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (Exception e) {
            Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, e);
        }

        return __orders;
    }

    private void loadDataToOrderTable(List<Order> orders) {
        double sales = 0;
        modelTableOrder.setRowCount(0);

        for (int i = 0; i < orders.size(); ++i) {
            sales += orders.get(i).getTotal();
            modelTableOrder.addRow(new Object[]{i + 1, Config.converDateToString(orders.get(i).getDate()), Config.formatMoney(orders.get(i).getTotal())});
        }
        modelTableOrder.fireTableDataChanged();
        lblSales.setText(Config.formatMoney(sales));
    }

    private void loadDataToOrderDetailList(List<OrderDetail> details) {
        double total = 0;
        modelTableOrderDetail.setRowCount(0);
        for (int i = 0; i < details.size(); ++i) {
            modelTableOrderDetail.addRow(new Object[]{i + 1, details.get(i).getProduct().getName(), details.get(i).getProduct().getType().getUnit(), details.get(i).getQuantity(), Config.formatMoney(details.get(i).getTotalOrderDetail())});
            total += details.get(i).getTotalOrderDetail();
        }
        modelTableOrderDetail.fireTableDataChanged();
        lblTotalMoney.setText(Config.formatMoney(total));
    }

    private void clearInput() {
        txtCode.setText("");
        txtItemName.setText("");
        txtItemNumber.setText("");
        txtSearch.setText("");

        btnChange.setEnabled(false);
    }

    private void exportReport(JTable table, String path) {
        try {
            TableModel model = table.getModel();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            Row row;
            Cell cell;

            // write the column headers
            row = sheet.createRow(0);
            for (int c = 0; c < model.getColumnCount(); c++) {
                cell = row.createCell(c);
                cell.setCellValue(model.getColumnName(c));
            }

            // write the data rows
            for (int r = 0; r < model.getRowCount(); r++) {
                row = sheet.createRow(r + 1);
                for (int c = 0; c < model.getColumnCount(); c++) {
                    cell = (Cell) row.createCell(c);
                    Object value = model.getValueAt(r, c);
                    if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    }
                }
            }

            FileOutputStream out = new FileOutputStream(path);
            workbook.write(out);
            out.close();
            workbook.close();
            JOptionPane.showMessageDialog(null, "Xuất báo cáo thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        pnOrderList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderList = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtDateStart = new javax.swing.JTextField();
        btnDateStart = new javax.swing.JButton();
        txtDateEnd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnFillter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblSales = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        pnOrderDetailList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderDetail = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTotalMoney = new javax.swing.JLabel();
        pnItemInfor = new javax.swing.JPanel();
        lblItemName = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        lblItemNumber = new javax.swing.JLabel();
        txtItemNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        pnAction = new javax.swing.JPanel();
        btnChange = new javax.swing.JButton();

        dateChooser1.setTextRefernce(txtDateStart);

        dateChooser2.setTextRefernce(txtDateEnd);

        pnOrderList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblOrderList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrderList);

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearch.setText("Tìm kiếm: ");

        btnSearch.setBackground(new java.awt.Color(69, 123, 157));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm");
        btnSearch.setToolTipText("Để trống sẽ tải lại danh sách hóa đơn hôm nay");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDateStart.setText("...");
        btnDateStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateStartActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFillter.setBackground(new java.awt.Color(69, 123, 157));
        btnFillter.setForeground(new java.awt.Color(255, 255, 255));
        btnFillter.setText("Thống kê");
        btnFillter.setToolTipText("Thống kê hóa đơn theo khoảng thời gian");
        btnFillter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillterActionPerformed(evt);
            }
        });

        jLabel2.setText("Doanh thu:");

        lblSales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSales.setText("7.000.000 VNĐ");

        btnExport.setBackground(new java.awt.Color(69, 123, 157));
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setText("Xuất báo cáo");
        btnExport.setToolTipText("Xuất ra file excel");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnOrderListLayout = new javax.swing.GroupLayout(pnOrderList);
        pnOrderList.setLayout(pnOrderListLayout);
        pnOrderListLayout.setHorizontalGroup(
            pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOrderListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnOrderListLayout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnOrderListLayout.createSequentialGroup()
                                .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFillter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOrderListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSales, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnOrderListLayout.setVerticalGroup(
            pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOrderListLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnOrderListLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDateStart)
                    .addComponent(txtDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFillter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSales)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnOrderDetailList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Danh sách mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

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
        tblOrderDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrderDetail);

        btnAdd.setBackground(new java.awt.Color(69, 123, 157));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("In lại hóa đơn");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Tổng tiền:");

        lblTotalMoney.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnOrderDetailListLayout = new javax.swing.GroupLayout(pnOrderDetailList);
        pnOrderDetailList.setLayout(pnOrderDetailListLayout);
        pnOrderDetailListLayout.setHorizontalGroup(
            pnOrderDetailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOrderDetailListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOrderDetailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOrderDetailListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnOrderDetailListLayout.setVerticalGroup(
            pnOrderDetailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOrderDetailListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnOrderDetailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnItemInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Thông tin mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblItemName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemName.setText("Tên mặt hàng: ");

        lblItemNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemNumber.setText("Số lượng:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã mặt hàng: ");

        pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btnChange.setBackground(new java.awt.Color(69, 123, 157));
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("Sửa");
        btnChange.setToolTipText("Cập nhật số lượng hóa đơn khi khách hàng phản hồi");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
        pnAction.setLayout(pnActionLayout);
        pnActionLayout.setHorizontalGroup(
            pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnActionLayout.setVerticalGroup(
            pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnItemInforLayout = new javax.swing.GroupLayout(pnItemInfor);
        pnItemInfor.setLayout(pnItemInforLayout);
        pnItemInforLayout.setHorizontalGroup(
            pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(txtCode))
                    .addGroup(pnItemInforLayout.createSequentialGroup()
                        .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblItemName)
                            .addComponent(lblItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemNumber)
                            .addComponent(txtItemName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnItemInforLayout.setVerticalGroup(
            pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItemInforLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(pnItemInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(pnItemInforLayout.createSequentialGroup()
                .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnItemInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnOrderList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnOrderDetailList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnOrderList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnOrderDetailList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnItemInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (_details == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn!!");
        } else {
            new frmOrder(_details, _account, false).setVisible(true);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblOrderListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderListMouseClicked
        // TODO add your handling code here:
        int index = tblOrderList.getSelectedRow();
        indexSelected = index;
        if (index > -1) {
            modelTableOrderDetail.setRowCount(0);
            Order order = _orders.get(index);
            try {
                _details = orderService.findOrderById(order.getId()).getDetails();
                loadDataToOrderDetailList(_details);
            } catch (Exception ex) {
                Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tblOrderListMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        List<Order> _orders = getAllOrderNowFromServer();
        boolean check = false;
        String _text = txtSearch.getText().trim();
        if (!_text.equals("")) {
            for (int i = 0; i < _orders.size(); ++i) {
                Order order = _orders.get(i);
                if (Integer.parseInt(_text) == order.getId()) {
                    modelTableOrder.setRowCount(0);
                    modelTableOrder.addRow(new Object[]{i + 1, _orders.get(i).getDate(), _orders.get(i).getTotal()});
                    check = true;
                    return;
                }
            }
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Hóa đơn không tồn tại. Vui lòng kiểm tra lại!");
                return;
            }
        } else {
            loadDataToOrderTable(_orders);
            dateChooser1.setSelectedDate(new Date());
            dateChooser2.setSelectedDate(new Date());
        }
        clearInput();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        // TODO add your handling code here:
        int index = tblOrderDetail.getSelectedRow();
        if (index > -1) {
            if (txtItemNumber.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng!");
            } else {
                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Bạn có chắc muốn sửa?",
                        "Hỏi",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    OrderDetail detail = _details.get(index);
                    try {
                        int _newQuantity = Integer.parseInt(txtItemNumber.getText());
                        if (_newQuantity > 0) {
                            if (_newQuantity <= detail.getProduct().getNumber()) {
                                detail.setQuantity(_newQuantity);
                                boolean _check = detailService.addOrUpdateOrderDetail(detail);
                                if (_check) {
                                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                                    List<OrderDetail> details = orderService.findOrderById(_orders.get(indexSelected).getId()).getDetails();
                                    loadDataToOrderDetailList(details);

                                    //get date
                                    Date start = Config.convertStringToDate(txtDateStart.getText());
                                    Date end = Config.convertStringToDate(txtDateEnd.getText());

                                    String _start = Config.convertDateToStringSql(start);
                                    String _end = Config.convertDateToStringSql(end);

                                    System.err.println(start + "-" + end);
                                    if (_start.equals(_end)) {
                                        _orders = getAllOrderNowFromServer();
                                    } else {
                                        List<Order> orders = orderService.filter(_start, _end);
                                        _orders = getOrderDetailFromOrder(orders);
                                    }
                                    loadDataToOrderTable(_orders);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Số lượng bạn nhập lớn " + detail.getProduct().getNumber() + " hiện có, vui lòng nhập lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Số lượng phải là số!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        clearInput();
    }//GEN-LAST:event_btnChangeActionPerformed

    private void tblOrderDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderDetailMouseClicked
        // TODO add your handling code here:
        int index = tblOrderDetail.getSelectedRow();

        btnChange.setEnabled(true);
        if (index > -1) {
            OrderDetail detail = _details.get(index);
            txtCode.setText(String.valueOf(detail.getProduct().getId()));
            txtItemName.setText(detail.getProduct().getName());
            txtItemNumber.setText(String.valueOf(detail.getQuantity()));
            txtCode.setEnabled(false);
            txtItemName.setEnabled(false);
        }
    }//GEN-LAST:event_tblOrderDetailMouseClicked

    private void btnDateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateStartActionPerformed
        // TODO add your handling code here:
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnDateStartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dateChooser2.showPopup();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFillterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillterActionPerformed
        // TODO add your handling code here:
        Date start = Config.convertStringToDate(txtDateStart.getText());
        Date end = Config.convertStringToDate(txtDateEnd.getText());
        if (end.before(start)) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc phải lớn hơn ngày bắt đầu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String _start = Config.convertDateToStringSql(start);
            String _end = Config.convertDateToStringSql(end);
            try {
                List<Order> orders = orderService.filter(_start, _end);
                _orders = getOrderDetailFromOrder(orders);
                //System.out.println(_orders);

                loadDataToOrderTable(_orders);
            } catch (Exception ex) {
                Logger.getLogger(frmManageOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnFillterActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        if (tblOrderList.getRowCount() > 0) {
            String path = "C:/k-mart/reports/report_" + txtDateStart.getText() + "_" + txtDateEnd.getText() + ".xlsx";
            exportReport(tblOrderList, path);
        }else {
            JOptionPane.showMessageDialog(null, "Không có gì để xuất báo cáo!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDateStart;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFillter;
    private javax.swing.JButton btnSearch;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblItemNumber;
    private javax.swing.JLabel lblSales;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnItemInfor;
    private javax.swing.JPanel pnOrderDetailList;
    private javax.swing.JPanel pnOrderList;
    private javax.swing.JTable tblOrderDetail;
    private javax.swing.JTable tblOrderList;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDateEnd;
    private javax.swing.JTextField txtDateStart;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemNumber;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
