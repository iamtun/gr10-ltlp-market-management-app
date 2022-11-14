/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package market.app.client;

import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import entity.OrderDetail;
import entity.Product;
import entity.ProductType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import market.app.client.ui.manager.frmManageItem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Le Tuan
 */
// Variables and functions use in app
public class Config {

	public static final Color colorButtonClick = new Color(69, 123, 157);
	public static final Color colorButtonUnClick = new Color(255, 255, 255);
	public static final String ARIALFONT = "src/resources/fonts/arial.ttf";

	// functions:
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
		// hide title bar
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

	// sale - order
	// cal money
	public static double calTotalMoneyByListOrderDetail(List<OrderDetail> details) {
		double total = 0;
		for (OrderDetail detail : details) {
			total += detail.getTotalOrderDetail();
		}

		return total;
	}

	// load order detail to list
	public static void loadOrderDetailToList(DefaultTableModel model, List<OrderDetail> details) {
		model.setRowCount(0);
		for (int i = 0; i < details.size(); ++i) {
			Product product = details.get(i).getProduct();
			Object[] objects = new Object[] { i + 1, product.getName(), product.getType().getUnit(),
					formatMoney(details.get(i).getProduct().getPrice()), details.get(i).getQuantity(),
					formatMoney(details.get(i).getTotalOrderDetail()) };
			model.addRow(objects);
		}
	}

	// load cbo product
//    public static void loadDataToCombobox() {
//        try {
//            for (ProductType prod : productTypeService.getAllProductType()) {
//                cboProductType.addItem(prod.getName());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(frmManageItem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
	public static String converDateToString(Date date) {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String dateFormated = format.format(date);
		return dateFormated;
	}

	public static Date convertStringToDate(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			return formatter.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String convertDateToStringSql(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormated = format.format(date);
		return dateFormated;
	}

	// oclock
	public static void timeChange(JLabel label) {
		Runnable runnable = () -> {
			while (true) {
				Date date = new Date();
				String dateTime = Config.converDateToString(date);
				label.setText(dateTime);
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	// format money
	public static String formatMoney(Double money) {
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		String moneyFormated = decimalFormat.format(money);
		return moneyFormated;
	}

	// print order
	public static void printOrder(Date now, List<OrderDetail> _details, int numberOrder, String nameStaff) {
		try {
			File directory = new File("C:/k-mart/orders");
			if (!directory.exists()) {
				if (directory.mkdir()) {
					System.err.println("create folder success!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Bạn cần tạo folder [k-mart/orders] trong ổ đĩa C để chứa hóa đơn", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			String dest = "C:/k-mart/orders/" + Config.converDateToString(now).replace(":", "_") + ".pdf";
			PdfWriter writer = new PdfWriter(dest);

			PdfDocument pdfDocument = new PdfDocument(writer);
			pdfDocument.addNewPage();

			Document document = new Document(pdfDocument);

			// Settings font -> UTF8
			FontProgram fontProgram = FontProgramFactory.createFont(ARIALFONT);
			PdfFont font = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
			document.setFont(font);
			float columWith[] = { 280F, 280F };

			Table table = new Table(columWith);
			table.addCell(new Cell(1, 2).add(
					new Paragraph("Siêu Thị Kmart").setFontSize(24).setTextAlignment(TextAlignment.CENTER).setBold())
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell(1, 2).add(new Paragraph("22 Nguyễn Văn Bảo, Q. Gò Vấp,  TP. HCM").setFontSize(16)
					.setTextAlignment(TextAlignment.CENTER)).setBorder(Border.NO_BORDER));
			table.addCell(new Cell(1, 2)
					.add(new Paragraph("ĐT: 0343237897").setFontSize(16).setTextAlignment(TextAlignment.CENTER))
					.setBorder(Border.NO_BORDER));

			table.addCell(new Cell(3, 2).add(
					new Paragraph("Hóa đơn bán lẻ").setFontSize(24).setTextAlignment(TextAlignment.CENTER).setBold())
					.setBorder(Border.NO_BORDER));

			table.addCell(new Cell()
					.add(new Paragraph("HĐ số: " + numberOrder).setFontSize(14).setTextAlignment(TextAlignment.LEFT))
					.setBorder(Border.NO_BORDER));

			table.addCell(new Cell().add(new Paragraph("Ngày: " + converDateToString(now)).setFontSize(14)
					.setTextAlignment(TextAlignment.RIGHT)).setBorder(Border.NO_BORDER));

			table.addCell(new Cell(1, 2)
					.add(new Paragraph("Bán hàng: " + nameStaff).setFontSize(14).setTextAlignment(TextAlignment.LEFT))
					.setBorder(Border.NO_BORDER));

			// list order detail:
			float columWithOrderDetails[] = { 60F, 125F, 125F, 125F, 125F };
			Table orderDetails = new Table(columWithOrderDetails);
			orderDetails.addCell(new Cell().add(new Paragraph("STT")))
					.addCell(new Cell().add(new Paragraph("Tên mặt hàng")))
					.addCell(new Cell().add(new Paragraph("Đơn vị tính")))
					.addCell(new Cell().add(new Paragraph("Số lượng")))
					.addCell(new Cell().add(new Paragraph("Thành tiền")));

			for (int i = 0; i < _details.size(); ++i) {
				orderDetails.addCell(new Cell().add(new Paragraph(i + 1 + "")))
						.addCell(new Cell().add(new Paragraph(_details.get(i).getProduct().getName())))
						.addCell(new Cell().add(new Paragraph(_details.get(i).getProduct().getType().getUnit())))
						.addCell(new Cell().add(new Paragraph(_details.get(i).getQuantity() + ""))).addCell(
								new Cell().add(new Paragraph(formatMoney(_details.get(i).getTotalOrderDetail()) + "")));
			}
			table.addCell(new Cell(1, 2).add(orderDetails));
			table.addCell(new Cell(1, 2)
					.add(new Paragraph("Tổng tiền:        " + formatMoney(calTotalMoneyByListOrderDetail(_details)))
							.setFontSize(14).setBold().setTextAlignment(TextAlignment.RIGHT))
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell(1, 2)
					.add(new Paragraph("Cảm ơn Quý Khách!").setFontSize(18).setTextAlignment(TextAlignment.CENTER))
					.setBorder(Border.NO_BORDER));
			document.add(table);
			document.close();
			JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi in hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
}
