package determinant;

import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * ����NetBeans����UI�����
 * 
 */
public class UIPanel extends javax.swing.JPanel {

	Determinant dete;

	/**
	 * Creates new formUIPanel
	 */
	public UIPanel(Determinant dete) {
		this.dete = dete;
		initComponents();
		addAction();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		jScrollPane1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("��������ʽ"));

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jButton1.setText("����");

		jButton2.setText("����");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										262,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										26, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(79, 79, 79)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(35, 35, 35)
								.addComponent(jButton2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1).addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;

	// End of variables declaration//GEN-END:variables

	private void addAction() {

		jButton1.addActionListener((ActionEvent e) -> {

			String infor = jTextArea1.getText();
			StringTokenizer inforToken = new StringTokenizer(infor, " \n");
			int length = (int) Math.sqrt(inforToken.countTokens());
			float[][] inforArray = new float[length][length];

			try {
				for (int i = 0; i < length; i++)
					for (int j = 0; j < length; j++) {

						inforArray[i][j] = Float.parseFloat(inforToken
								.nextToken());

					}

				JOptionPane.showMessageDialog(this,
						"����ʽ��ֵΪ: " + dete.dealDate(inforArray), "�������",
						JOptionPane.DEFAULT_OPTION);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "�����������������롣", "��ʾ",
						JOptionPane.DEFAULT_OPTION);
			}

			/**
			 * for (float[] a : inforArray) { for (float b : a)
			 * System.out.print(b + " ");
			 * 
			 * System.out.println(); }
			 * 
			 * System.out.println(dete.dealDate(inforArray));
			 */

		});

		jButton2.addActionListener((ActionEvent e) -> {
			new DeteDialog(null);
		});

	}

}