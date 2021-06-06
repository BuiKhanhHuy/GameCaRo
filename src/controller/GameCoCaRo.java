package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class GameCoCaRo extends JFrame {
	private GameGreen gameGreen;
	private ThongTin thongTin;
	private String player1name;
	private String player2name;
	private int flag = 0;

	public GameCoCaRo(String name1, String name2) {
		khoiTaoJframe();

		thongTin = new ThongTin();
		this.add(thongTin);
		player1name = name1;
		player2name = name2;
		this.thongTin.tenNguoiChoi1.setText(player1name);
		this.thongTin.tenNguoiChoi2.setText(player2name);
		gameGreen = new GameGreen();
		this.add(gameGreen);
		this.addKeyListener(new SuKienDiChuyen());
	}

	public void khoiTaoJframe() {
		this.setSize(696, 800);
		this.setLayout(null);
		this.setTitle("C A R O");
		this.setBackground(Color.pink);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	class SuKienDiChuyen implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT)
				gameGreen.setPhim(0);
			else if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT)
				gameGreen.setPhim(1);
			else if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
				gameGreen.setPhim(2);
			else if (e.getKeyChar() == 'S' || e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
				gameGreen.setPhim(3);
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
				gameGreen.setPhim(0);
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				gameGreen.setPhim(1);
			else if (e.getKeyCode() == KeyEvent.VK_UP)
				gameGreen.setPhim(2);
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				gameGreen.setPhim(3);
			else
				gameGreen.setPhim(-1);
			if ((e.getKeyChar() == 'f' || e.getKeyChar() == 'F') && gameGreen.toMauO.getNguoiChoi() == 0) {
				gameGreen.setDanhDau(4);
				if (gameGreen.capNhatDanhDau() == true) {
					gameGreen.toMauO.setNguoiChoi(1);
					thongTin.nguoiChoi.setForeground(Color.RED);
					thongTin.nguoiChoi.setText("PLAYER 2");
				}
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER && gameGreen.toMauO.getNguoiChoi() == 1) {
				gameGreen.setDanhDau(5);
				if (gameGreen.capNhatDanhDau() == true) {
					gameGreen.toMauO.setNguoiChoi(0);
					thongTin.nguoiChoi.setForeground(Color.GREEN);
					thongTin.nguoiChoi.setText("PLAYER 1");
				}
			}
			gameGreen.setDanhDau(-1);
			// cap nhat mang o day
			gameGreen.toMauO.CapNhatToaDo(gameGreen.getPhim());
			// kiem tra thang thua tai day
			int t = gameGreen.gameWin();
			gameGreen.setThang(t);
			gameGreen.repaint();
			if (flag == 1) {
				try {
					Thread.sleep(0);
				} catch (InterruptedException e1) {
					System.out.println("Loi luong!!!");
				}
				String s1, s2;
				if (t == 0) {
					s1 = player1name;
					s2 = player2name;
				} else {
					s1 = player2name;
					s2 = player1name;
				}
				manHinhKetThuc manHinh = new manHinhKetThuc(s1, s2);
				manHinh.setVisible(true);
				dispose();
			}
			if (t != -1) {
				flag = 1;
				gameGreen.toMauO.setDv(-1);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
}
