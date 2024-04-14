package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Mainpg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpg frame = new Mainpg();
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
	public Mainpg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE FITNESS CLUB");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 937, 36);
		contentPane.add(lblNewLabel);
		
		JButton logoutbtn = new JButton("LogOut");
		logoutbtn.setForeground(new Color(0, 255, 0));
		logoutbtn.setBackground(new Color(0, 0, 0));
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=JOptionPane.showConfirmDialog(logoutbtn, "Do you Really want to LogOut","Select",JOptionPane.YES_NO_OPTION);
				System.out.println(i);
				if(i==0)
				{
					setVisible(false);
				Login lg=new Login();
				lg.setVisible(true);
				}
				else{}
			}
		});
		logoutbtn.setBounds(301, 491, 111, 36);
		contentPane.add(logoutbtn);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int i=JOptionPane.showConfirmDialog(btnNewButton,"Do you really want to exit","Select",JOptionPane.YES_NO_OPTION);
				System.out.println(i);
				if(i==0)
				{
					setVisible(false);
					
				}
			}
		});
		btnNewButton.setBounds(482, 491, 111, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admission Details");
		btnNewButton_1.setForeground(new Color(0, 255, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmissionDetails ad=new AdmissionDetails();
				ad.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(707, 148, 200, 87);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("Gym Equipments");
		btnNewButton_6.setBackground(new Color(0, 0, 0));
		btnNewButton_6.setForeground(new Color(0, 255, 0));
		btnNewButton_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GymMain gm= new GymMain();
				gm.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		btnNewButton_6.setBounds(578, 265, 200, 93);
		contentPane.add(btnNewButton_6);
		
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 255, 0));
		label.setBackground(new Color(0, 0, 0));
		label.setIcon(new ImageIcon("C:\\Users\\jitup\\Downloads\\11 (1).jpg"));
		label.setBounds(-28, 38, 542, 474);
		contentPane.add(label);
		
		JButton btnNewButton_2_1 = new JButton("New Admission");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewAdmission na=new NewAdmission();
				na.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(new Color(0, 255, 0));
		btnNewButton_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_2_1.setBackground(new Color(0, 0, 0));
		btnNewButton_2_1.setBounds(455, 148, 200, 87);
		contentPane.add(btnNewButton_2_1);
		
		ImageIcon ig=new ImageIcon(this.getClass().getResource("/zoro.jpg"));
	}
}
