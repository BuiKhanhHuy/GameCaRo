package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

class GameGreen extends JPanel {
	private int[][] danhDauO = new int[34][34];
	public Point[] toaDoThang = new Point[] { new Point(0, 0), new Point(0, 0) };
	public ToMauO toMauO;
	private int phim = -1;
	private int danhDau = -1;
	private int thang = -1;

	public GameGreen() {
		this.khoiTaoJPanelGreen();
		toMauO = new ToMauO();
	}

	public void khoiTaoJPanelGreen() {
		this.setBounds(0, 80, 680, 680);
		this.setLayout(null);
		for (int i = 0; i < 34; i++)
			for (int j = 0; j < 34; j++)
				danhDauO[i][j] = -1;
	}

	@Override
	public void paint(Graphics g) {
		veLuoiBackground(g);
		veCacDauDaDanh(g);
		veDuongChienThang(g);
		toMauO.setNguoiChoi(toMauO.getNguoiChoi());
		toMauO.danhDauMauO(g);
		if(getThang() != -1)
			ghiChu(g);
	}

	public void veLuoiBackground(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 800, 800);
		for (int i = 0; i < 34; i++)
			for (int j = 0; j < 34; j++) {
				g.setColor(Color.black);
				g.fillRect(i * 20 + 1, j * 20 + 1, 19, 19);
			}
	}

	public void veCacDauDaDanh(Graphics g) {
		for (int i = 0; i < 34; i++)
			for (int j = 0; j < 34; j++)
				if (danhDauO[i][j] == 4) {
					// dien dau X
					g.setColor(Color.green);
					g.setFont(new Font("Arial", Font.BOLD, 20));
					g.drawString("X", i * 20 + 3, j * 20 + 18);
				} else if (danhDauO[i][j] == 5) {
					// dien dau O
					g.setColor(Color.red);
					g.setFont(new Font("Arial", Font.BOLD, 20));
					g.drawString("O", i * 20 + 3, j * 20 + 18);
				}
	}

	public void veDuongChienThang(Graphics g) {
		g.setColor(Color.blue);
		g.drawLine(toaDoThang[0].getX() * 20 + 9, toaDoThang[0].getY() * 20 + 10, toaDoThang[1].getX() * 20 + 10,
				toaDoThang[1].getY() * 20 + 9);
		g.drawLine(toaDoThang[0].getX() * 20 + 10, toaDoThang[0].getY() * 20 + 10, toaDoThang[1].getX() * 20 + 10,
				toaDoThang[1].getY() * 20 + 10);
		g.drawLine(toaDoThang[0].getX() * 20 + 11, toaDoThang[0].getY() * 20 + 10, toaDoThang[1].getX() * 20 + 10,
				toaDoThang[1].getY() * 20 + 11);
	}
	
	public void ghiChu(Graphics g)
	{
		g.setColor(Color.white);
		g.drawString("Press any key to continue...", 200, 297);
	}


	public int gameWin() {
		// ngang
		for (int j = 0; j <= 33; j++)
			for (int i = 0; i <= 29; i++)
				if (danhDauO[i][j] + danhDauO[i + 1][j] + danhDauO[i + 2][j] + danhDauO[i + 3][j]
						+ danhDauO[i + 4][j] == 25) {
					toaDoThang[0].setXY(i, j);
					toaDoThang[1].setXY(i + 4, j);
					return 1;
				} else if (danhDauO[i][j] + danhDauO[i + 1][j] + danhDauO[i + 2][j] + danhDauO[i + 3][j]
						+ danhDauO[i + 4][j] == 20) {
					toaDoThang[0].setXY(i, j);
					toaDoThang[1].setXY(i + 4, j);
					return 0;
				}
		// doc
		for (int i = 0; i <= 33; i++)
			for (int j = 0; j <= 29; j++)
				if (danhDauO[i][j] + danhDauO[i][j + 1] + danhDauO[i][j + 2] + danhDauO[i][j + 3]
						+ danhDauO[i][j + 4] == 25) {
					toaDoThang[0].setXY(i, j);
					toaDoThang[1].setXY(i, j + 4);
					return 1;
				} else if (danhDauO[i][j] + danhDauO[i][j + 1] + danhDauO[i][j + 2] + danhDauO[i][j + 3]
						+ danhDauO[i][j + 4] == 20) {
					toaDoThang[0].setXY(i, j);
					toaDoThang[1].setXY(i, j + 4);
					return 0;
				}
		// tren '/'
		int tam = 33;
		int d1 = 0;
		int d2 = 0;

		for (int i = 33; i >= 0; i--) {
			for (int j = 0; j <= tam; j++) {
				if (danhDauO[i - j][j] == 5) {
					d2++;
					d1 = 0;
				} else if (danhDauO[i - j][j] == 4) {
					d1++;
					d2 = 0;
				} else {
					d1 = 0;
					d2 = 0;
				}
				if (d2 >= 5) {
					toaDoThang[0].setXY(i - j, j);
					toaDoThang[1].setXY(i - j + 4, j - 4);
					return 1;
				} else if (d1 >= 5) {
					toaDoThang[0].setXY(i - j, j);
					toaDoThang[1].setXY(i - j + 4, j - 4);
					return 0;
				}
			}
			tam--;
		}

		// duoi \

		tam = 32;
		d1 = 0;
		d2 = 0;
		for (int j = 1; j <= 33; j++) {
			for (int i = 0; i <= tam; i++) {
				if (danhDauO[i][i + j] == 5) {
					d2++;
					d1 = 0;
				} else if (danhDauO[i][i + j] == 4) {
					d1++;
					d2 = 0;
				} else {
					d1 = 0;
					d2 = 0;
				}
				if (d2 >= 5) {
					toaDoThang[0].setXY(i, i + j);
					toaDoThang[1].setXY(i - 4, i + j - 4);
					return 1;
				} else if (d1 >= 5) {
					toaDoThang[0].setXY(i, i + j);
					toaDoThang[1].setXY(i - 4, i + j - 4);
					return 0;
				}
			}
			tam--;
		}

		// tren \
		tam = 33;
		d1 = 0;
		d2 = 0;
		for (int i = 0; i <= 33; i++) {
			for (int j = 0; j <= tam; j++)
			{
				if (danhDauO[i + j][j] == 5) {
					d2++;
					d1 = 0;
				} else if (danhDauO[i + j][j] == 4) {
					d1++;
					d2 = 0;
				} else {
					d1 = 0;
					d2 = 0;
				} 
				if (d2 >= 5) {
					toaDoThang[0].setXY(i + j, j);
					toaDoThang[1].setXY(i + j - 4, j - 4);
					return 1;
				} else if (d1 >= 5) {
					toaDoThang[0].setXY(i + j, j);
					toaDoThang[1].setXY(i + j - 4, j - 4);
					return 0;
				}
			}
			tam--;
		}

		// duoi /
		tam = 1;
		d1 = 0;
		d2 = 0;
		for (int i = 1; i <= 33; i++) {
			for (int j = 33; j >= tam; j--) {
				if (danhDauO[33 + i - j][j] == 5) {
					d2++;
					d1 = 0;
				} else if (danhDauO[33 + i - j][j] == 4) {
					d1++;
					d2 = 0;
				} else {
					d1 = 0;
					d2 = 0;
				}
				if (d2 >= 5) {
					toaDoThang[0].setXY(33 + i - j, j);
					toaDoThang[1].setXY(33 + i - j - 4, j + 4);
					return 1;
				} else if (d1 >= 5) {
					toaDoThang[0].setXY(33 + i - j, j);
					toaDoThang[1].setXY(33 + i - j - 4, j + 4);
					return 0;
				}
			}
			tam++;
		}
		return -1;
	}

	public boolean capNhatDanhDau() {
		if (danhDauO[toMauO.getX()][toMauO.getY()] == -1)
		{
			danhDauO[toMauO.getX()][toMauO.getY()] = danhDau;
			return true;
		}
		return false;
	}

	public int getDanhDau() {
		return danhDau;
	}

	public void setDanhDau(int danhDau) {
		this.danhDau = danhDau;
	}

	public int getPhim() {
		return phim;
	}

	public void setPhim(int phim) {
		this.phim = phim;
	}

	public  int getThang() {
		return thang;
	}

	public  void setThang(int thang) {
		this.thang = thang;
	}
	

}
