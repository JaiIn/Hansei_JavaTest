import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Racing extends Frame {
	
	private int Track = 100;
	
	Scanner sc = new Scanner(System.in);
	int RacerNum = 2;
	
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
		 	첫 창
		 	1. 레이블로 위에 Racing! 띄우기
		 	2. 시작 버튼 띄우기
		 	3. Racer 생성 버튼
		 	다음 창
		 	4. 끝날때 까지 대기
		 	5. 끝나면 우승자 말해주기
		 	6. 닫기 버튼 활성화
		*/
		Label MainLabel = new Label("Input How many Racer", Label.CENTER);
		MainLabel.setBackground(Color.LIGHT_GRAY);
		MainLabel.setBounds(100, 100, 200, 50);
		
		// Racer 생성 택스트 필드
		TextField InputNum = new TextField(5);
		InputNum.setBounds(150,210,50,30);
		
		Button Sub = new Button("Submit!");
		Sub.setBounds(230, 200, 50, 50);
		Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				RacerNum = Integer.parseInt(InputNum.getText());
				if(2 <= RacerNum && RacerNum <= 5 )
				{
					Racers = new Racer[RacerNum];
					for(int i =0; i<RacerNum;++i)
					{Racers[i] = new Racer("No." + (i+1));}
					MainLabel.setText("Setting "+Racers.length + " Racer");
				}
				else 
				{
					MainLabel.setText("Input 2 ~ 5, Defalut is 2");
					RacerNum = 2;
				}}catch(Exception e2) {MainLabel.setText("Input!");}
			}
		});
		
		Button SB = new Button("Start Racing!");
		SB.setBounds(100, 300, 200, 50);
		
		SB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeforeStart();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { dispose(); }	
			});
		
		add(InputNum);
		add(SB); add(Sub);
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
