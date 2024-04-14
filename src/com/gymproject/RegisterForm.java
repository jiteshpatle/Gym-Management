package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.OptionalDataException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

public class RegisterForm extends JFrame {
	Connection con;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rtxtn;
	private JTextField rtxtp;
	private JTextField rtxta;
	private JTextField rtxtfp;
	JLabel lblNewLabel_5 ;
	
	JComboBox rtxtgt;
	
	ButtonGroup bg=new ButtonGroup();
	JRadioButton male;
	JRadioButton female;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 534, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBounds(10, 69, 112, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(10, 114, 112, 27);
		contentPane.add(lblNewLabel_2);
		
		rtxtn = new JTextField();
		rtxtn.setBackground(new Color(0, 255, 0));
		rtxtn.setForeground(new Color(0, 0, 0));
		rtxtn.setBounds(161, 71, 86, 20);
		contentPane.add(rtxtn);
		rtxtn.setColumns(10);
		
		rtxtp = new JTextField();
		rtxtp.setBackground(new Color(0, 255, 0));
		rtxtp.setForeground(new Color(0, 0, 0));
		rtxtp.setBounds(161, 117, 86, 20);
		contentPane.add(rtxtp);
		rtxtp.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
					String nm1=rtxtn.getText();
					String pass1=rtxtp.getText();
					String a = rtxta.getText();
					String gt = rtxtgt.getSelectedItem().toString();
					String fess = rtxtfp.getText();
					
					 
					
	
					//method to find value in true and false
					boolean y=fess.isEmpty();
					System.out.println("fees : "+y);
					
		
					if((a.isEmpty() == false) && (fess.isEmpty() == false) && (nm1.isEmpty() == false) && (pass1.isEmpty() == false) && (gt.isEmpty() == false))
					{
						int age1=Integer.parseInt(rtxta.getText());
						int fp=Integer.parseInt(rtxtfp.getText());
						
						
						
					
						if(age1 >= 15)
						{
							if(fp >= 500)
							{
								ConnectionDB cdn=new ConnectionDB();
								cdn.createConnection();

								//code for entering the radiobutton into db;
								male.setActionCommand("male");
								female.setActionCommand("female");	
								String g=bg.getSelection().getActionCommand();
								
								int res = cdn.registerform(nm1, pass1, age1,g, gt, fp);
								System.out.println("res :"+res);
									
								if(res == 1)
								{
									JOptionPane.showMessageDialog(btnNewButton, "Registration seccesfull");
								}
								else
								{
									JOptionPane.showMessageDialog(btnNewButton, "Registration Failed");
								}
							
							}
							else
							{
								JOptionPane.showMessageDialog(btnNewButton, "Please pay minimum 500rs");
			
							}
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "Your age is below 15... You are not eligible");
						}
							
							
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Enter all details!!!");
					}
					

			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setBounds(98, 393, 89, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rtxtn.setText("");
				rtxtp.setText("");
				rtxta.setText("");
				
								
				
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(0, 255, 0));
		btnNewButton_1.setBounds(350, 393, 89, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setBounds(10, 164, 112, 27);
		contentPane.add(lblNewLabel_3);
		
		rtxta = new JTextField();
		rtxta.setBackground(new Color(0, 255, 0));
		rtxta.setBounds(161, 167, 86, 20);
		contentPane.add(rtxta);
		rtxta.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(new Color(0, 255, 0));
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 221, 112, 27);
		contentPane.add(lblNewLabel_4);
		
		
		male = new JRadioButton("Male");
		male.setForeground(new Color(0, 255, 0));
		male.setBackground(new Color(0, 0, 0));
		male.setBounds(128, 221, 59, 23);
		contentPane.add(male);
		
		female = new JRadioButton("Female");
		female.setBackground(new Color(0, 0, 0));
		female.setForeground(new Color(0, 255, 0));
		female.setBounds(211, 221, 76, 23);
		contentPane.add(female);
		
		bg.add(male);
		bg.add(female);
		
		
		
		lblNewLabel_5 = new JLabel("Gym Timing");
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_5.setForeground(new Color(0, 255, 0));
		lblNewLabel_5.setBounds(10, 284, 112, 27);
		contentPane.add(lblNewLabel_5);
		
		rtxtgt = new JComboBox();
		rtxtgt.setForeground(new Color(0, 255, 0));
		rtxtgt.setBackground(new Color(0, 0, 0));
		rtxtgt.setModel(new DefaultComboBoxModel(new String[] {"", "Between 6AM -10AM", "Between 4PM-10PM"}));
		rtxtgt.setBounds(161, 284, 129, 22);
		contentPane.add(rtxtgt);
		
		JLabel lblNewLabel_6 = new JLabel("Fees Paid");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(0, 255, 0));
		lblNewLabel_6.setBounds(20, 328, 102, 27);
		contentPane.add(lblNewLabel_6);
		
		rtxtfp = new JTextField();
		rtxtfp.setBackground(new Color(0, 255, 0));
		rtxtfp.setBounds(161, 329, 86, 20);
		contentPane.add(rtxtfp);
		rtxtfp.setColumns(10);
		ImageIcon ig=new ImageIcon(this.getClass().getResource("/zororegister.jpg"));
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lo=new Login();
				lo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(0, 255, 0));
		btnNewButton_2.setBounds(225, 393, 89, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(372, 131, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\jitup\\Downloads\\r1.jpg"));
		lblNewLabel_8.setBounds(-31, 0, 575, 472);
		contentPane.add(lblNewLabel_8);
		
		
	}
}
