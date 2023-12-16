import java.awt.*;
import java.awt.event.*;

public class BloodTest extends Frame {

	Label l1, l2;
	Panel p1;
	CheckboxGroup cbg;
	Checkbox cb1, cb2, cb3, cb4;
	Font f1 = new Font("Serif", Font.BOLD, 20);

	BloodTest(String title) {
		super(title);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 150, 400, 300);

		setLayout(null);

		l1 = new Label("Blood Test", Label.CENTER);
		l1.setBounds(50, 50, 300, 30);
		l1.setFont(f1);
		l1.setForeground(Color.blue);

		l2 = new Label("What is your Bloodtype?", Label.CENTER);
		l2.setBounds(50, 100, 300, 30);
		l2.setFont(f1);
		l2.setBackground(Color.black);
		l2.setForeground(Color.YELLOW);

		p1 = new Panel();
		p1.setBounds(50, 150, 300, 100);
		p1.setBackground(Color.orange);

		cbg = new CheckboxGroup();
		cb1 = new Checkbox("A", cbg, true);
		cb2 = new Checkbox("B", cbg, false);
		cb3 = new Checkbox("AB", cbg, false);
		cb4 = new Checkbox("0", cbg, false);

		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);

		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is" + cb1.getLabel());
			}
		});

		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is" + cb2.getLabel());
			}
		});

		cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is " + cb3.getLabel());
			}
		});

		cb4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is" + cb4.getLabel());
			}
		});

		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);

		add(l1);
		add(l2);
		add(p1);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setVisible(true);
	}
}
