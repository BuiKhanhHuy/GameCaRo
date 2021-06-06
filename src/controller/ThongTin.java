package controller;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ThongTin extends JPanel {
	public JLabel nguoiChoi;
	public JLabel info;
	public JLabel tenNguoiChoi1;
	public JLabel tenNguoiChoi2;
	private JTable table;
	private JScrollPane scrollPane_Xem;
	public ArrayList<String> dsTen = new ArrayList<>();

	public ThongTin() {
		this.khoiTaoJPanelThongTin();

		nguoiChoi();
		this.hienThiThongTin();
	}

	public void khoiTaoJPanelThongTin() {
		this.setBounds(0, 0, 680, 80);
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setBorder(new LineBorder(new Color(255, 165, 0), 2));
	}

	public void nguoiChoi() {
		nguoiChoi = new JLabel("PLAYER 1");
		nguoiChoi.setFont(new Font("Arial", Font.BOLD, 25));
		nguoiChoi.setForeground(Color.GREEN);
		nguoiChoi.setBounds(15, 25, 130, 20);
		this.add(nguoiChoi);

		JLabel info = new JLabel("VS");
		info.setFont(new Font("Arial", Font.BOLD, 18));
		info.setForeground(Color.LIGHT_GRAY);
		info.setBounds(210, 50, 50, 20);
		this.add(info);

		tenNguoiChoi1 = new JLabel("");
		tenNguoiChoi1.setFont(new Font("Arial", Font.BOLD, 15));
		tenNguoiChoi1.setForeground(Color.GREEN);
		tenNguoiChoi1.setHorizontalAlignment(SwingConstants.RIGHT);
		tenNguoiChoi1.setBounds(5, 50, 200, 20);
		this.add(tenNguoiChoi1);

		tenNguoiChoi2 = new JLabel("");
		tenNguoiChoi2.setFont(new Font("Arial", Font.BOLD, 15));
		tenNguoiChoi2.setForeground(Color.RED);
		tenNguoiChoi2.setHorizontalAlignment(SwingConstants.LEFT);
		tenNguoiChoi2.setBounds(240, 50, 180, 20);
		this.add(tenNguoiChoi2);

	}

	public void hienThiThongTin() {
		try {
			this.docFile("D:/CARO4/controller/danhsachnguoichoi.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Loi doc file!!!");
			e.printStackTrace();
		}

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "WINNER", "LOSER" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(158);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		table.setBorder(null);
		table.setRowHeight(30);
		table.setEnabled(false);
		table.setFont(new Font("Arial", Font.PLAIN, 10));
		for (String ten : dsTen) {
			String s[] = ten.split("#");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { s[0], s[1] });
		}

		scrollPane_Xem = new JScrollPane(table);
		scrollPane_Xem.setBorder(new LineBorder(new Color(255, 165, 0), 2));
		scrollPane_Xem.setViewportBorder(null);
		scrollPane_Xem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_Xem.setBounds(455, 0, 225, 78);
		this.add(scrollPane_Xem);

	}

	public void docFile(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		while (scanner.hasNextLine()) {
			dsTen.add(0, scanner.nextLine());
		}
		scanner.close();
	}

}
