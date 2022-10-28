/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package market.app.client;

import entity.Account;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.ProductType;
import entity.Staff;
import java.rmi.Naming;
import java.util.Date;
import market.app.client.connect.ConnectServer;
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
public class MarketAppClient {

    public static void main(String[] args) {
        /* Set the FlatLaf look and feel */
        Config.setLookAndFeelUI();
        try {
//            // Test thì chạy cái này
//            Staff staff = new Staff("QL001", "Lê Tuấn", "123321", "0343220577", "255 Quang Trung", true, true, true);
//            IStaffService staffService = ConnectServer.getInstance().getStaffService();
//            staffService.addStaff(staff);
//
//            Account account = new Account(staff, "121312");
//            IAccountService accountService = ConnectServer.getInstance().getAccountService();
//            accountService.addAccount(account);
//            ProductType productType = new ProductType("Bánh", "Bịch");
//            Product product = new Product("Oxi Cay", 100, 5000, productType);
//            IProductService productService = ConnectServer.getInstance().getProductService();
//            productService.addProduct(product);
//            Order order = new Order(new Date(), staff);
//            IOrderService orderService = ConnectServer.getInstance().getOrderService();
//            orderService.addOrder(order);

//            Order _order = orderService.findOrderById(1);
//            System.err.println(_order.getTotal());
//
//            Product _product = productService.findProductById(2);
//            System.err.println(_product);
//            IOrderDetailService orderDetailService = ConnectServer.getInstance().getOrderDetailService();
//            OrderDetail detail = orderDetailService.findOrderDetailById(1, 1);
//            detail.setQuantity(3);
//            OrderDetail detail = new OrderDetail(_product, _order, 3);
////            orderDetailService.addOrderDetail(detail);
            ConnectServer.getInstance();
            java.awt.EventQueue.invokeLater(() -> {
                new frmLogin().setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
