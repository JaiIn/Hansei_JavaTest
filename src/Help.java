import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends Frame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	Image img;
	
	Help(String title) {
		super(title);
		
		setIconImage(new ImageIcon("images/icon.jpg").getImage());
		setLocation(screenSize.width/2-250, screenSize.height/2-250);
		setSize(500, 500);
		
		img = tk.getImage("images/icon.png");
		
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				dispose();
			}	
		});
		
		setVisible(true);
	}
	public void paint(Graphics g) {
		g.drawImage(img, 30, 30, this);
	}
}
