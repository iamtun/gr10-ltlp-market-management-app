/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package market.app.client.connect;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import market.app.client.ui.frmLogin;
import service.IAccountService;
import service.IOrderDetailService;
import service.IOrderService;
import service.IProductService;
import service.IProductTypeService;
import service.IStaffService;

/**
 *
 * @author Le Tuan
 */
public class ConnectServer {

    private static ConnectServer instance;
    private IOrderService orderService;
    private IAccountService accountService;
    private IOrderDetailService orderDetailService;
    private IProductService productService;
    private IProductTypeService productTypeService;
    IStaffService staffService;

    private ConnectServer() {
        try {
            orderService = (IOrderService) Naming.lookup("rmi://localhost:8989/IOrderService");
            accountService = (IAccountService) Naming.lookup("rmi://localhost:8989/IAccountService");
            orderDetailService = (IOrderDetailService) Naming.lookup("rmi://localhost:8989/IOrderDetailService");
            productService = (IProductService) Naming.lookup("rmi://localhost:8989/IProductService");
            productTypeService = (IProductTypeService) Naming.lookup("rmi://localhost:8989/IProductTypeService");
            staffService = (IStaffService) Naming.lookup("rmi://localhost:8989/IStaffService");

            System.out.println("Connect server successfully ...");
            java.awt.EventQueue.invokeLater(() -> {
                new frmLogin().setVisible(true);
            });
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Connect server fail ...");
            JOptionPane.showMessageDialog(null, "Không kết nối được với server, vui lòng thử lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }

    public static ConnectServer getInstance() {
        if (instance == null) {
            instance = new ConnectServer();
        }
        return instance;
    }

    public IOrderService getOrderService() {
        return orderService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public IOrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    public IProductService getProductService() {
        return productService;
    }

    public IProductTypeService getProductTypeService() {
        return productTypeService;
    }

    public IStaffService getStaffService() {
        return staffService;
    }

}
