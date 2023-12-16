import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuStart extends Frame {

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();

	MenuStart(String title) {
		super(title);

		setIconImage(new ImageIcon("images/icon.jpg").getImage());
		setLocation(screenSize.width / 2 - 340, screenSize.height / 2 - 235);
		setSize(680, 470);

		MenuBar mb = new MenuBar();

		Menu mFile = new Menu("File");
		MenuItem miJoin = new MenuItem("Join", new MenuShortcut('J', true));

		MenuItem miExit = new MenuItem("Exit", new MenuShortcut('E'));
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mFile.add(miJoin);
		mFile.addSeparator();
		mFile.add(miExit);

		Menu mEvent1 = new Menu("Event");
		MenuItem miCoffee = new MenuItem("Select Coffee");
		miCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Coffee("Select Coffee");
			}
		});

		MenuItem miBloodTest = new MenuItem("BloodTest");
		miBloodTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BloodTest("Blood Test");
			}
		});

		MenuItem miLocation = new MenuItem("Location");
		miLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Location("Mouse Location");
			}
		});

		MenuItem miBgColor = new MenuItem("Background Color");
		miBgColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BgColor("Background Color");
			}
		});

		mEvent1.add(miCoffee);
		mEvent1.add(miBloodTest);
		mEvent1.add(miLocation);
		mEvent1.add(miBgColor);

		// 내가 만든 이벤트를 붙일 공간
		Menu mEvent2 = new Menu("Choi Event");
		
		MenuItem miRM = new MenuItem("Random Menu");
		miRM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecommendMenu("Random Menu");
			}
		});
		
		MenuItem miRc = new MenuItem("Racing");
		miRc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Racing("Racing");
			}
		});

		mEvent2.add(miRM);
		mEvent2.add(miRc);

		Menu mHelp = new Menu("Help");
		MenuItem miHelp = new MenuItem("Program Info");
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("Program Info");
			}
		});

		MenuItem miInfo = new MenuItem("Developer Info");
		miInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Info("Developer Info");
			}
		});

		mHelp.add(miHelp);
		mHelp.add(miInfo);

		mb.add(mFile);
		mb.add(mEvent1);
		mb.add(mEvent2);
		mb.add(mHelp);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setMenuBar(mb);
		setVisible(true);
	}

	public void paint(Graphics g) {
		Image img = tk.getImage("images/back.jpg");
		g.drawImage(img, 0, 30, this);
	}

	public static void main(String[] args) {
		new MenuStart("Java Project_201910571_최동인");
	}
}