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
          //Test thì chạy cái này
          //position true -> manager
//            IStaffService staffService = ConnectServer.getInstance().getStaffService();
//            Staff admin = staffService.findStaffById("admin");
//            Staff staff = new Staff("US001", "Lê Tuấn Anh", "12354685", "0353810412", "278 Quang Trung", true, false);
//            staff.setManager(admin);
//            staffService.addOrUpdateStaff(staff);
////////
//            Account account = new Account(staff, "123456");
//            IAccountService accountService = ConnectServer.getInstance().getAccountService();
//            accountService.addAccount(account);
//            
//            ProductType productType = new ProductType("Snack", "Bịch");
////            IProductTypeService productTypeService = ConnectServer.getInstance().getProductTypeService();
////            ProductType productType = productTypeService.findProductTypeById(1);
//            Product product = new Product("Oxi Cay", 100, 5000, productType);
//            IProductService productService = ConnectServer.getInstance().getProductService();
//            productService.addOrUpdateProduct(product);
            
//            Order order = new Order(new Date(), staff);
//            IOrderService orderService = ConnectServer.getInstance().getOrderService();
//            orderService.addOrUpdateOrder(order);
//
//            Order _order = orderService.findOrderById(1);
//            System.err.println(_order.getTotal());
//            double total = Config.calTotalMoneyByListOrderDetail(_order.getDetails());
//            System.err.println(total);
//            Product _product = productService.findProductById(1);
//            System.err.println(_product);
//            IOrderDetailService orderDetailService = ConnectServer.getInstance().getOrderDetailService();
//            OrderDetail detail = orderDetailService.findOrderDetailById(1, 1);
//            detail.setQuantity(3);
//            OrderDetail detail = new OrderDetail(_product, _order, 3);
//            orderDetailService.addOrderDetail(detail);
//             main run
            ConnectServer.getInstance();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
