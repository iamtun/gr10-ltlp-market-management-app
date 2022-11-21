/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package market.app.client;


import market.app.client.connect.ConnectServer;

/**
 *
 * @author Le Tuan
 */
public class MarketAppClient {

    public static void main(String[] args) {
        /* Set the FlatLaf look and feel */
        Config.setLookAndFeelUI();
        try {
//             main run
            ConnectServer.getInstance();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
