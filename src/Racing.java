import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Racing extends Frame {
	
	private int Track = 100;
	
	Scanner sc = new Scanner(System.in);
	int RacerNum = 0;
	
	Racer[] Racers;
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	
	Racing(String title)
	{
		super(title);
		setLayout(null);
		setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 400, 400);
		
		// 버튼 1개
		/*
		 	1. 레이블로 위에 Racing! 띄우기
		 	2. 시작 버튼 띄우기
		 	3. 버튼을 누르면 Racer 생성창으로 이동
		 	4. 추가, 삭제, 시작 버튼
		 	5. 끝날때 까지 대기
		 	6. 끝나면 우승자 말해주기
		 	7. 닫기 버튼 활성화
		*/
		Label MainLabel = new Label("Welcome to Racing!", Label.CENTER);
		MainLabel.setBackground(Color.LIGHT_GRAY);
		MainLabel.setBounds(100, 100, 200, 50);

		Button SB = new Button("Start Racing!");
		
		SB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeforeStart();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { dispose(); }	
			});
		
		add(SB);
		add(MainLabel);
		setVisible(true);
	}
	public void BeforeStart()
	{
		
	}
	public class Racer 
	{
		private double Speed = 5.0;
		private String name = "1";
		
		Racer(String name){this.name = name;}
	}
}
