/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package market.app.client;

import market.app.client.ui.frmLogin;


/**
 *
 * @author Le Tuan
 */
public class MaketAppClient {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmLogin().setVisible(true);
        });
        
    }
}
