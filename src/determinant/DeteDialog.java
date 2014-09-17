package determinant;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * 设计"帮助"对话框:一个文本区，一个确定按钮 文本区的数据由外部文本文件输入
 */

public class DeteDialog extends JDialog {

	private static final int WIDTH = 360;
	private static final int HEIGHT = 280;

	private JTextArea textArea;

	public DeteDialog(Frame parent) {
		super(parent);

		setSize(WIDTH, HEIGHT);
		setTitle("行列式计算器使用说明");

		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dime.width - WIDTH) / 2, (dime.height - HEIGHT) / 2);

		createPanel();

		setVisible(true);
	}

	/**
	 * 创建对话框面板
	 */

	private void createPanel() {

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("aFont", Font.PLAIN, 12));

		receiveTxt();

		JPanel panel = new JPanel();
		JButton button = new JButton("确定");
		panel.add(button);

		add(textArea, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		button.addActionListener((ActionEvent e) -> {
			setVisible(false);
		});
	}

	/**
	 * 利用IO流接受外部的文本文件
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
