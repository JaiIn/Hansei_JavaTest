import java.awt.*; // AWT 컨포넌트 사용하기 위해
import java.awt.event.*; // 이벤트 처리하기 위해

public class Location extends Frame {
	Label l1;
	
	Location(String title) {
		setLayout(null);
		setBounds(200, 200, 400, 300);
		setBackground(Color.yellow);
		
		l1 = new Label("Mouse Location: ");
		l1.setBounds(7, 30, 200, 20);
		l1.setBackground(Color.yellow);
		
		addMouseMotionListener(new MouseMotionListener() { 
			public void mouseDragged(MouseEvent e) {}
			public void mouseMoved(MouseEvent e) {
				l1.setText("Mouse Location: (" + e.getX() + ", " + e.getY() + ")");	
			}
		});
		
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		add(l1);
		setVisible(true);
	}
	
}




