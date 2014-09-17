package determinant;

import java.awt.*;

import javax.swing.*;

/**
 * 图形界面
 *
 */

public class DeteUI extends JFrame {

	private static final int WIDTH = 370;
	private static final int HEIGHT = 317;

	public DeteUI() {

		setSize(WIDTH, HEIGHT);
		setTitle("行列式计算器");

		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dime.width - WIDTH) / 2, (dime.height - HEIGHT) / 2);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new UIPanel(new Determinant()));

		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		new DeteUI();
	}
}
