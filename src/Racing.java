import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Racing extends Frame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	
	int RacerNum = 0;
	
	Racing(String title)
	{
		super(title);
		setLayout(null);
		setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 400, 400);
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { dispose(); }	
			});
		
		setVisible(true);
	}
	
	public class Racer 
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		private double Speed = 5.0;
		private String name = "Frist";
		
		public void setName(String n){this.name = n;}
		public void setSpeed(double s)
		{
			if(0.0 < s && s <10.0){Speed = s;}
			else 
			{
				Frame Warn = new Frame("Warning");
				Warn.setBounds
				(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 300, 50);
				
				Label Wl = new Label("Input 0.0 ~ 10.0 !",Label.CENTER);
				
				Warn.add(Wl);
				
				Warn.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) { Warn.setVisible(false); }	
					});
				
				Warn.setVisible(true);
			}
		}
	}
}
