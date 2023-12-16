import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Info extends Frame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	Image img;
	
	Info(String title) {
		super(title);
		
		setIconImage(new ImageIcon("images/icon.jpg").getImage());
		setLocation(screenSize.width/2-250, screenSize.height/2-265);
		setSize(500, 530);
		
		img = tk.getImage("images/info.jpg");

		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				dispose();
			}	
		});
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 30, this);
	}
}
