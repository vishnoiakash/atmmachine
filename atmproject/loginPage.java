package com.akash.atmproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class loginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;


	public loginPage() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_2 = new Label("Welcome to ATM Machine");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_2.setAlignment(Label.CENTER);
		label_2.setSize(new Dimension(5, 5));
		label_2.setBounds(79, 21, 274, 28);
		label_2.setFont(new Font("Consolas", Font.BOLD, 20));
		contentPane.add(label_2);
		
		Label label = new Label("Enter Card No :");
		label.setBounds(108, 75, 89, 22);
		contentPane.add(label);
		
		TextField textField = new TextField();
		textField.setBounds(224, 75, 116, 22);
		contentPane.add(textField);
		
		Label label_1 = new Label("Enter ATM Pin :");
		label_1.setBounds(108, 122, 89, 22);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(224, 122, 116, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(180, 175, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String card = textField.getText();
				String pass = passwordField.getText();
				if(Integer.parseInt(card)==1234 && Integer.parseInt(pass)==1234)
				{
					AtmOperationWindow frame = new AtmOperationWindow();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Incorrect Card Number or Pin !");
				}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(contentPane, "Card Number or Pin Field can't be blank.");
					
				}
			}
		});
	}
}
