package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JButton;

public class manHinhVao extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField txtplayer1;
	private JTextField txtplayer2;
	private JButton btnOK;
	private GameCoCaRo gameCoCaRo;
	private JButton btnExit;

	public manHinhVao() {
		this.setGiaoDien();
		btnOK.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void setGiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 393);
		contentPane = new JPanel();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Enter name");
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblplayer1 = new JLabel("Player 1");
		lblplayer1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblplayer1.setForeground(Color.GREEN);
		lblplayer1.setBounds(45, 147, 103, 25);
		contentPane.add(lblplayer1);

		JLabel lblPlayer2 = new JLabel("Player 2");
		lblPlayer2.setForeground(Color.RED);
		lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPlayer2.setBounds(45, 207, 103, 25);
		contentPane.add(lblPlayer2);

		txtplayer1 = new JTextField();
		txtplayer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtplayer1.setBounds(145, 146, 350, 31);
		contentPane.add(txtplayer1);
		txtplayer1.setColumns(10);

		JLabel lblTieuDe = new JLabel(" Player name");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTieuDe.setForeground(Color.YELLOW);
		lblTieuDe.setBounds(153, 57, 223, 43);
		contentPane.add(lblTieuDe);

		JLabel lbltitleTenGame = new JLabel("G   A   M    E      C   A   R   O");
		lbltitleTenGame.setForeground(Color.LIGHT_GRAY);
		lbltitleTenGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltitleTenGame.setBounds(163, 10, 213, 25);
		contentPane.add(lbltitleTenGame);
		
		JLabel lblChuY = new JLabel("! Player name is required ");
		lblChuY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChuY.setForeground(Color.LIGHT_GRAY);
		lblChuY.setBounds(184, 248, 174, 15);
		contentPane.add(lblChuY);

		btnOK = new JButton("OK");
		btnOK.setForeground(Color.WHITE);
		btnOK.setBackground(Color.BLUE);
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOK.setBounds(178, 273, 85, 50);
		btnOK.setBorder(null);
		contentPane.add(btnOK);

		txtplayer2 = new JTextField();
		txtplayer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtplayer2.setColumns(10);
		txtplayer2.setBounds(145, 207, 350, 31);
		contentPane.add(txtplayer2);

		btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(273, 273, 85, 50);
		btnExit.setBorder(null);
		contentPane.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK && txtplayer1.getText().compareTo("") != 0
				&& txtplayer2.getText().compareTo("") != 0) {
			gameCoCaRo = new GameCoCaRo(txtplayer1.getText().trim(), txtplayer2.getText().trim());
			gameCoCaRo.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnExit)
			System.exit(0);
	}
}
