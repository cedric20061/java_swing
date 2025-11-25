package gui.windows;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	public Window(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void display() {
		this.setVisible(true);
	}
}
