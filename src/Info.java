import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Info extends Frame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); // 화면에 너비, 높이 정보를 screenSize에 대입!
	Image img;
	
	Info(String title) {
		super(title);
		
		setIconImage(new ImageIcon("images/icon.jpg").getImage());
		setLocation(screenSize.width/2-250, screenSize.height/2-265);
		setSize(500, 530);
		
		img = tk.getImage("images/info.jpg");

		// 프레임 닫기 이벤트
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				dispose(); // 메모리에서 삭제
			}	
		});
		
		setVisible(true);
	}
	
	// paint() 호출시점 3가지
	// 1. 화면이 처음 보여지는 순간
	// 2. 화면이 다른화면에 가려졌다가 다시 보여지는 순간
	// 3. 최소화에서 다시 보여지는 순간
	public void paint(Graphics g) { // 오버라이딩해서 사용!
		g.drawImage(img, 0, 30, this);
	}

	// 테스트할 경우 빠르게 결과를 확인하기 위해 각 클래스에 메인메소드를 작성함!
	// 테스트가 완료되어 배포시에는 프로젝트내에 메인메소드는 딱 1개만 있어야 함!!
	//public static void main(String[] args) {
	//	new Info("개발자 소개");
	//}
}
