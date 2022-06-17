package com.akash.atmproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JLayeredPane;
import java.awt.Color;

public class AtmOperationWindow extends JFrame {

	private JPanel contentPane;
	
	AtmOperations op = new AtmOperationImpl();


	public AtmOperationWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_2 = new Label("Welcome to My Bank");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		label_2.setAlignment(Label.CENTER);
		label_2.setSize(new Dimension(5, 5));
		label_2.setBounds(79, 21, 274, 28);
		label_2.setFont(new Font("Cambria Math", Font.BOLD, 25));
		contentPane.add(label_2);
				
		Button button = new Button("View Balance");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Your account has Balance "+Double.toString(op.viewBalance()));
			}
		});
		button.setBounds(79, 92, 87, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Deposit");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getMessage = JOptionPane.showInputDialog(contentPane, "Enter Amount");
				try {
					if(Double.parseDouble(getMessage)>0)
					{
                op.depositAmount(Double.parseDouble(getMessage));
		        JOptionPane.showMessageDialog(contentPane, "Amount deposited successfully. Current Balance is "+op.viewBalance());
			}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Please Enter Valid Amount");
					}
				}
				catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(contentPane, "Please Enter Valid Amount");
				}
				
			}
		});
		button_1.setBounds(276, 92, 87, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Withdraw");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(79, 172, 86, 22);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getMessage = JOptionPane.showInputDialog(contentPane, "Enter Amount to withdraw");
				try {
					if(Double.parseDouble(getMessage)%500==0)
					{
						if(Double.parseDouble(getMessage)<op.viewBalance())
						{
		                op.withdrawAmount(Double.parseDouble(getMessage));
				        JOptionPane.showMessageDialog(contentPane, "Collect your cash. Current Balance is "+op.viewBalance());
					    }
						else
						{
							JOptionPane.showMessageDialog(contentPane, "Insufficient fund !");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Please Enter Amount in multiple of 500");
					}
				}
				catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(contentPane, "Please Enter Valid Amount");
				}
				
			
			}
		});
		
	

		Button button_3 = new Button("Mini Statement");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,op.viewMiniStatement(),"mini statement",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		button_3.setBounds(276, 172, 87, 22);
		contentPane.add(button_3);
		
		
}
}
