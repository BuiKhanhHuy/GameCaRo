package controller;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ToMauO extends JPanel {
	private int x = 20;
	private int y = 20;
	private int nguoiChoi = 0;
    private int dv = 20;

	public ToMauO() {
	}

	@Override
	public void paint(Graphics g) {
		this.danhDauMauO(g);
	}

	public void danhDauMauO(Graphics g) {
		if (nguoiChoi == 0)
			g.setColor(Color.GREEN);
		else
			g.setColor(Color.RED);
		g.fillRect(this.getX() * this.getDv() + 1,this.getY()*this.getDv() + 1 , 19, 19);
	}

	// phim: w||<-: 0; d||->: 1; w||len: 2; s||xuong:3
	public void CapNhatToaDo(int phim) {
		switch (phim) {
		case 0:
			if (this.getX() == 0)
				this.setX(33);
			else
				this.setX(this.getX() - 1);
			break;
		case 1:
			if (this.getX() == 33)
				this.setX(0);
			else
				this.setX(this.getX() + 1);
			break;
		case 2:
			if (this.getY() == 0)
				this.setY(33);
			else
				this.setY(this.getY() - 1);
			break;
		case 3:
			if (this.getY() == 33)
				this.setY(0);
			else
				this.setY(this.getY() + 1);
			break;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setXY(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNguoiChoi() {
		return nguoiChoi;
	}

	public void setNguoiChoi(int nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
	}

	public  int getDv() {
		return dv;
	}

	public  void setDv(int dv) {
		this.dv = dv;
	}

}
