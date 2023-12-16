import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends Frame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); // 화면에 너비, 높이 정보를 screenSize에 대입!
	Image img;
	
	Help(String title) {
		super(title);
		
		setIconImage(new ImageIcon("images/icon.jpg").getImage());
		setLocation(screenSize.width/2-250, screenSize.height/2-250);
		setSize(500, 500);
		
		img = tk.getImage("images/icon.png");
		
		// 프레임 닫기 이벤트
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				dispose(); // 메모리에서 삭제
			}	
		});
		
		setVisible(true);
	}
	public void paint(Graphics g) { // 오버라이딩해서 사용!
		g.drawImage(img, 30, 30, this);
	}
	/*public static void main(String[] args) {
		new Help("Program Info");
	}*/
}
