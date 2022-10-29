/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package market.app.client;

import com.formdev.flatlaf.FlatLightLaf;
import entity.OrderDetail;
import entity.Product;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Le Tuan
 */
// Variables and functions use in app
public class Config {

    public static final Color colorButtonClick = new Color(69, 123, 157);
    public static final Color colorButtonUnClick = new Color(255, 255, 255);

    //functions:
    public static void closeForm(JFrame frame) {
        int choose = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn thoát không?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void setLookAndFeelUI() {
        try {
            FlatLightLaf.setup();
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    public static void handleButtonClick(JButton[] buttons, JButton button) {
        for (JButton btn : buttons) {
            if (btn.equals(button)) {
                btn.setBackground(Config.colorButtonClick);
            } else {
                btn.setBackground(Config.colorButtonUnClick);
            }
        }
    }

    public static void openComponent(JInternalFrame frame, JPanel pnParrent) {
        Component[] components = pnParrent.getComponents();
        Component component;
        for (Component component1 : components) {
            component = component1;
            if (component != null) {
                component.setVisible(false);
            }
        }
        frame.setSize(new Dimension(1285, 800));
        pnParrent.add(frame);
        frame.setVisible(true);
    }

    public static void startPanel(JInternalFrame frm, JPanel pnParrent, JButton btn) {
        openComponent(frm, pnParrent);
        btn.setBackground(Config.colorButtonClick);
    }

    public static void hideTitleBarInternalFrame(JInternalFrame frame) {
        //hide title bar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
    }

    public static void initColTable(JTable table, DefaultTableModel model, String[] names) {
        model.setColumnIdentifiers(names);
        table.setModel(model);
    }

    public static void initComboBox(JComboBox cbo, DefaultComboBoxModel model, String[] types) {
        for (String type : types) {
            model.addElement(type);
        }
        cbo.setModel(model);
    }

    //sale - order
    //cal money
    public static double calTotalMoneyByListOrderDetail(List<OrderDetail> details) {
        double total = 0;
        for (OrderDetail detail : details) {
            total += detail.getTotalOrderDetail();
        }

        return total;
    }

    //load order detail to list
    public static void loadOrderDetailToList(DefaultTableModel model, List<OrderDetail> details) {
        model.setRowCount(0);
        for (int i = 0; i < details.size(); ++i) {
            Product product = details.get(i).getProduct();
            Object[] objects = new Object[]{i + 1, product.getName(), product.getType().getUnit(), details.get(i).getQuantity(), details.get(i).getTotalOrderDetail()};
            model.addRow(objects);
        }
    }
    
    public static String converDateToString(Date date){
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String dateFormated = format.format(date);
        return dateFormated;
    }
}
