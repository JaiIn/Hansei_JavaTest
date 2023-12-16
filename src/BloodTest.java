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

		// 프레임 위치 설정 (중앙에 위치 시키기)
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

		p1 = new Panel(); // 컨테이너, Panel의 기본레이아웃은 FlowLayout(왼->오른, 위->아래, 가운데정렬)
		p1.setBounds(50, 150, 300, 100);
		p1.setBackground(Color.orange);

		cbg = new CheckboxGroup();
		cb1 = new Checkbox("A", cbg, true); // 1. 이벤트 대상(소스)
		cb2 = new Checkbox("B", cbg, false);
		cb3 = new Checkbox("AB", cbg, false);
		cb4 = new Checkbox("0", cbg, false);

		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);

		// cb1에 감지기 달기! 2. 이벤트 감지기(리스너)
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is" + cb1.getLabel());
				// System.out.println(cb1.getLabel());
			}
		});

		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is" + cb2.getLabel());
				// System.out.println(cb1.getLabel());
			}
		});

		cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is " + cb3.getLabel());
				// System.out.println(cb1.getLabel());
			}
		});

		cb4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("Your Blood Type is" + cb4.getLabel());
				// System.out.println(cb1.getLabel());
			}
		});

		// 패널에 체크박스 추가
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);

		// 프레임에 붙이기
		add(l1);
		add(l2);
		add(p1);

		// 프레임 닫기 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); // 메모리에서 해제
			}
		});
		setVisible(true);
	}
}
