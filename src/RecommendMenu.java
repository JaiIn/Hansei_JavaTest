import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RecommendMenu extends Frame{

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); // 화면에 너비, 높이 정보를 screenSize에 대입!
	
	String[] FoodList = {"햄버거","국밥","쌀국수","편의점","분식","마라탕","자장면",
			"뼈다귀","김치찌개","매밀면","돈가스"};
	
	int fLength = FoodList.length;
	int Key = (int)(Math.random()*fLength);
	
	Label l1 = new Label("RecommendMenu", Label.CENTER);
	Panel p1 = new Panel();
	
	RecommendMenu(String title) {
		super(title);
		setLayout(null);
		
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
		setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 400, 400);
		
		
		l1.setBackground(Color.white);
		l1.setBounds(25, 285, 350, 50);
		
		Button b1 = new Button("Start!");
		
		b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{RandMenu();} 
				catch (Exception e1) {e1.getMessage();}
			}
		});
		p1.setLayout(new GridLayout(1, 3));
		p1.setBounds(25, 80, 350, 160);
		
		p1.add(b1);
		
		addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { dispose(); }	});
		
		add(p1);
		add(l1);
		
		setVisible(true);
		
		this.setVisible(true);
	}
	public void RandMenu() 
	{
		try 
		{
			for(int i = 0; i<5;++i)
			{
				for(int j =0; j<FoodList.length ;++j)
				{
					l1.setText(FoodList[j]);
					Thread.sleep(50);
				}
			}
			for(int i = 0; i<Key; ++i)
			{
				l1.setText(FoodList[i]);
				Thread.sleep(50);
			}
			l1.setText(FoodList[Key]);
		}catch(Exception e) {System.out.println(e);}
	}
}