import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Racing extends Frame {
	
	
	int EndTrack = 300;
	int Rank = 1;
	
	Label[] RList = null;
	Label[] TList = null;
	
	int RacerNum = 2;
	
	Racer[] Racers;
	 
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	
	Racing(String title)
	{
		super(title);
		setLayout(null);
		setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 400, 400);

		Label MainLabel = new Label("Input How many Racer", Label.CENTER);
		MainLabel.setBackground(Color.LIGHT_GRAY);
		MainLabel.setBounds(100, 100, 200, 50);
		
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
				Starting(RacerNum);
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
	public void Starting(int mem)
	{
		Frame Rf = new Frame("Racing");
		Rf.setLayout(null);
		Rf.setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 400, 400);
		
		Ready(Rf,mem);
		
		Rf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { Rf.setVisible(false); }	
			});
		
		Rf.setVisible(true);
		
		for (int i = 0; i < mem; ++i) 
		{new Thread(Racers[i]).start();}
	}
	public void Ready(Frame f,int mem)
	{
		String name ="";
		RList =  new Label[mem];
		TList =  new Label[mem];
		int height = screenSize.height / (mem + 3);
		for(int i =0;i<mem;++i)
		{
			int Where = Racers[i].StartTrack;
			String sWhere = String.valueOf(Where);
			name = Racers[i].name;
			
			RList[i] = new Label(name,Label.CENTER);
			RList[i].setBounds(130, height, 30, 30);
			
			TList[i] = new Label(sWhere,Label.CENTER);
			TList[i].setBounds(230, height, 30, 30);
			
			height += 50;
			
			f.add(RList[i]);
			f.add(TList[i]);
		}
		
	}
	public class Racer implements Runnable
	{
		private int StartTrack = 0;
		private Random Cm = new Random();
		private int Speed = 5;
		private String name = "1";
		
		Racer(String name){this.name = name;}
		
		public void run() {
            while (StartTrack < EndTrack) {
                Running();
                updateUI();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
		
		public void Running()
		{
			int iCm = Cm.nextInt(2);
			int rCm = (iCm == 0) ? 1 : -1;
			int ASpeed = (int)(Math.random() * 3 + 1);
			if(this.Speed > 0 && this.Speed < 10)
			{
				this.Speed += (rCm) * (ASpeed);
				if(this.Speed > 10)
				{this.Speed = 10;}
				else if(this.Speed <= 0)
				{this.Speed = 1;}
			}
			this.StartTrack += this.Speed;
		}
        public void updateUI() 
        {
            EventQueue.invokeLater(() -> 
            {
                for (int i = 0; i < RList.length; ++i) 
                {
                    if (Racers[i] == this) 
                    {
                    	if(StartTrack >= EndTrack)
                    	{
                    		TList[i].setText(String.valueOf(Rank));
                    		++Rank;
                    		break;
                    	}
                    }
                }
            });
        }
	}
}
