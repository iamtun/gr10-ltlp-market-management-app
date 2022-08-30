/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package market.app.client;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Le Tuan
 */
public class Config {
    public static Color colorButtonClick = new Color(69,123,157);
    public static Color colorButtonUnClick = new Color(255, 255, 255);
    
    
    //functions:
    public static void closeForm(JFrame frame) {
        int choose = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn thoát không?", "Thông báo",  
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choose == JOptionPane.YES_OPTION){
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
}
