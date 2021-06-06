package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;

public class manHinhKetThuc extends JFrame implements ActionListener {
	private JButton btnStart;
	private JButton btnExit;
	private JLabel lblWinName;
	private JLabel lblLoserName;
	private JPanel contentPane;
	private manHinhVao quayLai;

	public manHinhKetThuc(String name1, String name2) {
		this.khoiTao();
		this.lblWinName.setText(name1);
		this.lblLoserName.setText(name2);
		try {
			this.ghiFile("D:/CARO4/controller/danhsachnguoichoi.txt", name1, name2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		btnStart.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void ghiFile(String path, String s1, String s2) throws IOException {
		FileWriter w = new FileWriter(new File(path), true);
		try (PrintWriter write = new PrintWriter(w)) {
			write.println(s1 + "#" + s2);
			write.close();
		} catch (Exception e) {
			System.out.println("Loi ghi file!!!");
		}

	}

	public void khoiTao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 393);
		contentPane = new JPanel();
		this.setTitle("Close game");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbltitleTenGame = new JLabel("G   A   M    E      C   A   R   O");
		lbltitleTenGame.setForeground(Color.LIGHT_GRAY);
		lbltitleTenGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltitleTenGame.setBounds(173, 10, 203, 25);
		contentPane.add(lbltitleTenGame);

		JLabel lblTieuDe = new JLabel("GAME OVER");
		lblTieuDe.setForeground(SystemColor.control);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTieuDe.setBounds(183, 45, 203, 43);
		contentPane.add(lblTieuDe);

		JLabel lblWin = new JLabel("WINS");
		lblWin.setForeground(new Color(64, 224, 208));
		lblWin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWin.setBounds(103, 118, 74, 36);
		contentPane.add(lblWin);

		JLabel lblLoser = new JLabel("LOSER");
		lblLoser.setForeground(new Color(178, 34, 34));
		lblLoser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLoser.setBounds(359, 118, 82, 36);
		contentPane.add(lblLoser);

		lblWinName = new JLabel("");
		lblWinName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinName.setForeground(new Color(0, 255, 255));
		lblWinName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWinName.setBounds(10, 164, 265, 36);
		contentPane.add(lblWinName);

		lblLoserName = new JLabel("");
		lblLoserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoserName.setForeground(new Color(178, 34, 34));
		lblLoserName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLoserName.setBounds(285, 164, 231, 36);
		contentPane.add(lblLoserName);

		btnStart = new JButton("START");
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStart.setBackground(Color.GREEN);
		btnStart.setBounds(233, 236, 85, 50);
		btnStart.setBorder(null);
		contentPane.add(btnStart);

		btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(233, 296, 85, 50);
		btnExit.setBorder(null);
		contentPane.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit)
			System.exit(0);
		else if (e.getSource() == btnStart) {
			quayLai = new manHinhVao();
			quayLai.setVisible(true);
			this.dispose();
		}
	}
}
