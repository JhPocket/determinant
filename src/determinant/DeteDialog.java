package determinant;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * ���"����"�Ի���:һ���ı�����һ��ȷ����ť �ı������������ⲿ�ı��ļ�����
 */

public class DeteDialog extends JDialog {

	private static final int WIDTH = 360;
	private static final int HEIGHT = 280;

	private JTextArea textArea;

	public DeteDialog(Frame parent) {
		super(parent);

		setSize(WIDTH, HEIGHT);
		setTitle("����ʽ������ʹ��˵��");

		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dime.width - WIDTH) / 2, (dime.height - HEIGHT) / 2);

		createPanel();

		setVisible(true);
	}

	/**
	 * �����Ի������
	 */

	private void createPanel() {

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("aFont", Font.PLAIN, 12));

		receiveTxt();

		JPanel panel = new JPanel();
		JButton button = new JButton("ȷ��");
		panel.add(button);

		add(textArea, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		button.addActionListener((ActionEvent e) -> {
			setVisible(false);
		});
	}

	/**
	 * ����IO�������ⲿ���ı��ļ�
	 */

	private void receiveTxt() {

		InputStream txtPath = DeteDialog.class.getResourceAsStream("help.txt");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					txtPath));
			String line;
			while ((line = in.readLine()) != null) {
				textArea.append(line + "\n");
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
