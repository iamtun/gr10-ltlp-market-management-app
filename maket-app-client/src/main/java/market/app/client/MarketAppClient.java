/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package market.app.client;

import entity.Order;
import java.rmi.Naming;
import market.app.client.ui.frmLogin;
import service.IOrderService;


/**
 *
 * @author Le Tuan
 */
public class MarketAppClient {

    public static void main(String[] args) {
        /* Set the FlatLaf look and feel */
        Config.setLookAndFeelUI();
        try {
            IOrderService service = (IOrderService) Naming.lookup("rmi://DESKTOP-7A8D61I:8989/IOrderService");
             Order order =  service.findOrderById(1);
             System.err.println(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new frmLogin().setVisible(true);
        });
        
    }
}
