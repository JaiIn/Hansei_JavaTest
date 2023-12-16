import java.awt.*;
import java.awt.event.*;

public class BgColor extends Frame {
	CheckboxGroup cbg;
	Checkbox cb1, cb2, cb3, cb4;

	BgColor(String title) {
		super(title);
		
		cbg = new CheckboxGroup();
		cb1 = new Checkbox("red", cbg, true);
		cb2 = new Checkbox("green", cbg, false);
		cb3 = new Checkbox("blue", cbg, false);
		cb4 = new Checkbox("random", cbg, false);

		cb1.addItemListener(new Event3());
		cb2.addItemListener(new Event3());
		cb3.addItemListener(new Event3());
		cb4.addItemListener(new Event3());
		
		setBackground(Color.red);
		setBounds(200, 200, 400, 400);
		setLayout(new FlowLayout());
		
		add(cb1); add(cb2); add(cb3); add(cb4); 

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	class Event3 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource();
			String color = cb.getLabel();
			
			int r, g, b;
			
			if(color.equals("red")) {
				setBackground(Color.red);
				cb1.setBackground(Color.red);
				cb2.setBackground(Color.red);
				cb3.setBackground(Color.red);
				cb4.setBackground(Color.red);
			} else if(color.equals("green")) {
				setBackground(Color.green);
				cb1.setBackground(Color.green);
				cb2.setBackground(Color.green);
				cb3.setBackground(Color.green);
				cb4.setBackground(Color.green);
			} else if(color.equals("blue")) {
				setBackground(Color.blue);
				cb1.setBackground(Color.blue);
				cb2.setBackground(Color.blue);
				cb3.setBackground(Color.blue);
				cb4.setBackground(Color.blue);
			} else if(color.equals("random")) {
				r = (int)(Math.random() * 256);
				g = (int)(Math.random() * 256);
				b = (int)(Math.random() * 256);
				
				setBackground(new Color(r,g,b));
				cb1.setBackground(new Color(r,g,b));
				cb2.setBackground(new Color(r,g,b));
				cb3.setBackground(new Color(r,g,b));
				cb4.setBackground(new Color(r,g,b));
			}
		}
	}
}




