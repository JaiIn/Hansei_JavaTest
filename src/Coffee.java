import java.awt.*;
import java.awt.event.*;

public class Coffee extends Frame {

	Coffee(String title) {
		super(title);

		Font f1 = new Font("Serif", Font.BOLD, 20);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setBounds(screenSize.width / 2 - 200, screenSize.height / 2 - 200, 400, 400);

		setBackground(new Color(210, 250, 234));
		setLayout(null);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1, 3));
		p1.setBounds(25, 80, 350, 160);

		Button b1 = new Button("Americano");
		Button b2 = new Button("Caffe latte");
		Button b3 = new Button("Cappuccino");

		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);

		Label l1 = new Label("Choice Coffee", Label.CENTER);
		l1.setBackground(Color.pink);
		l1.setBounds(25, 285, 350, 50);
		l1.setFont(f1);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText("You Choose " + b1.getLabel());
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText("You Choose " + b2.getLabel());
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText("You Choose " + b3.getLabel());
			}
		});

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		add(p1);
		add(l1);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}
}
