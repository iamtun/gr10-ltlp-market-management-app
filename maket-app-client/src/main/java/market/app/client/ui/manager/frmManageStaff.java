/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package market.app.client.ui.manager;

import entity.Account;
import entity.Staff;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import market.app.client.Config;
import market.app.client.connect.ConnectServer;
import service.IStaffService;

/**
 *
 * @author Le Tuan
 */
public class frmManageStaff extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmManageItem
     */
    private IStaffService staffService;
    private Account _account;
    private DefaultTableModel modelTableStaffList = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    private String[] colums = new String[]{"Mã nhân viên", "Tên nhân viên", "CMND/ CCCD", "Số điện thoại", "Địa chỉ", "Giới tính", "Chức vụ", "Trạng thái"};

    public frmManageStaff(Account _account) {
        initComponents();

        // connect rmi
        staffService = ConnectServer.getInstance().getStaffService();
        this._account = _account;
        
        Config.initColTable(tblStaffList, modelTableStaffList, colums);
        Config.hideTitleBarInternalFrame(this);

        // load data
        loadDataToCbo();
        loadDataToListView();
    }
    //Regex phone
    private boolean regexPhone(String phone){
        String reg = "^((09|03|07|08|06|05)+([0-9]{8}))$";
        Pattern pattern = Pattern.compile(reg);
        if(pattern.matcher(phone).find()){
            return true;
        }
        return false;
    }
    
    //Regex CMND
    private boolean regexCMND(String cmnd){
        String reg = "[0-9]{9}";
        if(cmnd.matches(reg)){
            return true;
        }
        return false;
    }
    
    // load data to combobox
    private void loadDataToCbo() {
        cboGender.addItem("Nam");
        cboGender.addItem("Nữ");
        if(_account.getStaff().getId().equals("admin")) {     
            cboPosition.addItem("Nhân viên");
            cboPosition.addItem("Quản lý");
        } else {     
            cboPosition.addItem("Nhân viên");
        }
        cboStatus.addItem("Ðang làm");
        cboStatus.addItem("Ðã nghỉ");
    }

    // load data to list view
    private void loadDataToListView() {
        System.out.println("market.app.client.ui.manager.frmManageStaff.loadDataToListView()"+ _account);
        modelTableStaffList.setRowCount(0);
        try {
            for (Staff staff : staffService.getAllStaff()) {
                if (staff.isStatus() && !staff.isPosition()) {
                    if(staff.getId().equals("admin")) {
                        return;
                    }
                    Object[] obj = new Object[]{
                        staff.getId(),
                        staff.getName(),
                        staff.getIdentify(),
                        staff.getPhone(),
                        staff.getAddress(),
                        staff.isGender() == true ? "Nam" : "Nữ",
                        staff.isPosition() == true ? "Quản lý" : "Nhân viên",
                        staff.isStatus() == true ? "Ðang làm" : "Ðã nghỉ"
                    };
                    modelTableStaffList.addRow(obj);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelTableStaffList.fireTableDataChanged();
    }

    // check inputs
    private boolean checkInputs() {
        String staffName = txtStaffName.getText();
        String identification = txtIdentification.getText();
        String phone = txtPhoneNumber.getText();
        String address = txtAddress.getText();
        String gender = cboGender.getSelectedItem().toString();
        String position = cboPosition.getSelectedItem().toString();
        String status = cboStatus.getSelectedItem().toString();

        if (staffName.equals("") || identification.equals("") || phone.equals("") || address.equals("") || gender.equals("")
                || position.equals("") || status.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn cần phải nhập đầy đủ thông tin!");
            return true;
        }

        return false;
    }
    
    // clear inputs
    private void clearInputs() {
        txtStaffName.setText("");
        txtIdentification.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
        cboGender.setSelectedIndex(0);
        cboPosition.setSelectedIndex(0);
        cboStatus.setSelectedIndex(0);
        txtStaffName.requestFocus();
    }

    // create staff id
    private String createStaffId() {
        String start = "NV";
        try {
            int number = staffService.getAllStaff().size();

            if (number < 9) {
                start = start + "00" + (number + 1);
            } else {
                start = start + "0" + (number + 1);
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

        return start;
    }
    
        // handle search
    private void searchFilter(String val) {
        TableRowSorter<DefaultTableModel> row = new TableRowSorter<DefaultTableModel>((DefaultTableModel)tblStaffList.getModel());
        tblStaffList.setRowSorter(row);
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

        pnStaffInfor = new javax.swing.JPanel();
        lblStaffName = new javax.swing.JLabel();
        txtStaffName = new javax.swing.JTextField();
        lblIdentification = new javax.swing.JLabel();
        txtIdentification = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        cboGender = new javax.swing.JComboBox<>();
        lblPosition = new javax.swing.JLabel();
        cboPosition = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        pnAction = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnStaffList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaffList = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnStaffInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblStaffName.setText("Tên nhân viên:");

        txtStaffName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStaffNameKeyTyped(evt);
            }
        });

        lblIdentification.setText("CMND/CCCD:");

        txtIdentification.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificationKeyTyped(evt);
            }
        });

        lblPhoneNumber.setText("Số điện thoại:");

        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyTyped(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddress.setText("Địa chỉ: ");

        lblGender.setText("Giới tính: ");

        lblPosition.setText("Chức vụ: ");

        lblStatus.setText("Trạng thái: ");

        javax.swing.GroupLayout pnStaffInforLayout = new javax.swing.GroupLayout(pnStaffInfor);
        pnStaffInfor.setLayout(pnStaffInforLayout);
        pnStaffInforLayout.setHorizontalGroup(
            pnStaffInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnStaffInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnStaffInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddress)
                    .addComponent(txtPhoneNumber)
                    .addComponent(txtIdentification)
                    .addComponent(txtStaffName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnStaffInforLayout.createSequentialGroup()
                        .addGroup(pnStaffInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStaffName)
                            .addComponent(lblIdentification)
                            .addComponent(lblPhoneNumber)
                            .addComponent(lblAddress)
                            .addComponent(lblGender)
                            .addComponent(lblPosition)
                            .addComponent(lblStatus))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnStaffInforLayout.setVerticalGroup(
            pnStaffInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStaffInforLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdentification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhoneNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
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

        pnStaffList.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 123, 157), 3, true), "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

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
        tblStaffList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaffList);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearch.setText("Tìm kiếm: ");

        javax.swing.GroupLayout pnStaffListLayout = new javax.swing.GroupLayout(pnStaffList);
        pnStaffList.setLayout(pnStaffListLayout);
        pnStaffListLayout.setHorizontalGroup(
            pnStaffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStaffListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnStaffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(pnStaffListLayout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)))
                .addContainerGap())
        );
        pnStaffListLayout.setVerticalGroup(
            pnStaffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnStaffListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnStaffListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnStaffInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnStaffList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnStaffList, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnStaffInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // button add staff
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // check inputs
        if (checkInputs()) {
            return;
        }
        
        String staffName = txtStaffName.getText();
        String identification = txtIdentification.getText();
        String phone = txtPhoneNumber.getText().trim();
        String address = txtAddress.getText();
        String gender = cboGender.getSelectedItem().toString();
        String position = cboPosition.getSelectedItem().toString();
        boolean gen = false;
        boolean pos = false;
        
        // check status
        if(cboStatus.getSelectedItem().equals("Ðã nghỉ")) {
            JOptionPane.showMessageDialog(this, "Không thể thêm nhân viên ở trạng thái đã nghỉ. Vui lòng kiểm tra lại!");
            return;
        }
        
        if(!regexCMND(identification)){
            JOptionPane.showMessageDialog(this, "Số CMND || CCCD sai định dạng.Vui lòng kiểm tra lại!");
            return;   
        }
        
        if(!regexPhone(phone)){
            JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng. Vui lòng kiểm tra lại!");
            return;
        }
        
        if(gender.equals("Nam")) {
            gen = true;
        } else if(gender.equals("Nữ")) {
            gen = false;
        }
        
        if(position.equals("Quản lý")) {
            pos = true;
        } else if(position.equals("Nhân viên")) {
            pos = false;
        }

        Staff staff = new Staff(createStaffId(), staffName, identification, phone, address, gen, pos);
        try {
            // check exits staff
            for(Staff st : staffService.getAllStaff()) {
                if(identification.equals(st.getIdentify()) || phone.equals(st.getPhone())) {
                    JOptionPane.showMessageDialog(this, "Căn cước công dân hoặc số điện thoại này đã tồn tại!");
                    return;
                }
            }
            staffService.addOrUpdateStaff(staff);

            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công.");
            clearInputs();
            loadDataToListView();
        } catch (Exception ex) {
            Logger.getLogger(frmManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // clicked list view
    private void tblStaffListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffListMouseClicked
        int selected = tblStaffList.getSelectedRow();
        Staff staff = null;

        if (selected >= 0) {
            String index = (String) tblStaffList.getValueAt(selected, 0);

            try {
                staff = staffService.findStaffById(index);

                if (staff != null) {
                    txtStaffName.setText(staff.getName());
                    txtIdentification.setText(staff.getIdentify());
                    txtPhoneNumber.setText(staff.getPhone());
                    txtAddress.setText(staff.getAddress());
                    cboGender.setSelectedItem(staff.isGender() == true ? "Nam" : "Nữ");
                    cboPosition.setSelectedItem(staff.isPosition() == true ? "Quản lý" : "Nhân viên");
                    cboStatus.setSelectedItem(staff.isStatus() == true ? "Ðang làm" : "Ðã nghỉ");
                }
            } catch (Exception ex) {
                Logger.getLogger(frmManageStaff.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (staff != null) {

            }
        }
    }//GEN-LAST:event_tblStaffListMouseClicked

    // button delete staff
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // check inputs
        if (checkInputs()) {
            return;
        }

        int selected = tblStaffList.getSelectedRow();
        Staff staff = null;

        try {
            if (selected >= 0) {
                String index = (String) tblStaffList.getValueAt(selected, 0);
                int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                staff = staffService.findStaffById(index);

                for (Staff st : staffService.getAllStaff()) {
                    if (st.getId().equals(staff.getId())) {
                        if (choise == JOptionPane.YES_OPTION) {
                            staff.setStatus(false);
                            staffService.addOrUpdateStaff(staff);

                            JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công.");
                            clearInputs();
                            loadDataToListView();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // button update staff
    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        // check inputs
        if (checkInputs()) {
            return;
        }

        String staffName = txtStaffName.getText();
        String identification = txtIdentification.getText();
        String phone = txtPhoneNumber.getText();
        String address = txtAddress.getText();
        
        String gender = cboGender.getSelectedItem().toString();
        boolean gen = false;
        if(gender.equals("Nam")) {
            gen = true;
        } else if(gender.equals("Nữ")) {
            gen = false;
        }
        
        String position = cboPosition.getSelectedItem().toString();
        boolean pos = false;
        if(position.equals("Quản lý")) {
            pos = true;
        } else if(position.equals("Nhân viên")) {
            pos = false;
        }

        String status = cboStatus.getSelectedItem().toString();
        boolean sta = false;
        if(status.equals("Ðang làm")) {
            sta = true;
        } else if(status.equals("Ðã nghỉ")) {
            sta = false;
        }
        
        int selected = tblStaffList.getSelectedRow();
        Staff staff = null;

        try {
            if (selected >= 0) {
                String index = (String) tblStaffList.getValueAt(selected, 0);
                staff = staffService.findStaffById(index);

                if (staff != null) {
                    for (Staff st : staffService.getAllStaff()) {
                        if (staff.getId().equals(st.getId())) {
                            staff.setName(staffName);
                            staff.setIdentify(identification);
                            staff.setPhone(phone);
                            staff.setAddress(address);
                            staff.setGender(gen);
                            staff.setPosition(pos);
                            staff.setStatus(sta);

                            staffService.addOrUpdateStaff(staff);
                            System.out.println("[staff]: " + staff);
                            JOptionPane.showMessageDialog(this, "Cập nhật thành công nhân viên.");
                            loadDataToListView();
                            clearInputs();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật không thành công nhân viên!");
                    clearInputs();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    // search filter
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchVal = txtSearch.getText();
        searchFilter(searchVal);
    }//GEN-LAST:event_txtSearchKeyReleased

    // No char
    private void txtPhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyTyped
         char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneNumberKeyTyped

    private void txtIdentificationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificationKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificationKeyTyped

    private void txtStaffNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffNameKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStaffNameKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboPosition;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIdentification;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblStaffName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnStaffInfor;
    private javax.swing.JPanel pnStaffList;
    private javax.swing.JTable tblStaffList;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtIdentification;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStaffName;
    // End of variables declaration//GEN-END:variables
}
