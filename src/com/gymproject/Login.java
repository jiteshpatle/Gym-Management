


package com.gymproject;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtl1;
	private JPasswordField txtl2;
	
	Connection con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 314);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO ZORO FITNESS");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 434, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("This is Login Page");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(91, 53, 196, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usen Name");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(34, 89, 106, 31);
		contentPane.add(lblNewLabel_2);
		
		txtl1 = new JTextField();
		txtl1.setBackground(new Color(0, 255, 0));
		txtl1.setForeground(new Color(0, 0, 0));
		txtl1.setBounds(150, 94, 137, 20);
		contentPane.add(txtl1);
		txtl1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setBounds(34, 143, 106, 31);
		contentPane.add(lblNewLabel_3);
		
		txtl2 = new JPasswordField();
		txtl2.setBackground(new Color(0, 255, 0));
		txtl2.setBounds(150, 148, 137, 20);
		contentPane.add(txtl2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					//connection
					ConnectionDB cb=new ConnectionDB();
					cb.createConnection();
					
					// login connect to db
					String nm=txtl1.getText();
					String pas=txtl2.getText();
					
					int res = cb.checkLogin(nm,pas);//method calling 
					System.out.println(res);
					
					if(res == 1)
					{
						dispose();
						Mainpg obj1 = new Mainpg();
						obj1.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(btnLogin,"the entered usermae or password is wrong ");
						txtl1.setText("");
						txtl2.setText("");
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				
			}
		});
		btnLogin.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setForeground(new Color(0, 255, 0));
		btnLogin.setBounds(105, 197, 89, 31);
		contentPane.add(btnLogin);
		
		JButton btncancle = new JButton("Register");
		btncancle.setBackground(new Color(0, 0, 0));
		btncancle.setForeground(new Color(0, 255, 0));
		btncancle.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btncancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterForm rfm= new RegisterForm();
				rfm.setVisible(true);
				dispose();
			}
		});
		btncancle.setBounds(204, 197, 94, 31);
		contentPane.add(btncancle);
		
		JLabel Imglabel = new JLabel();
		ImageIcon ig= new ImageIcon(this.getClass().getResource("/zzoro.jpg"));
		Imglabel.setIcon(ig);
		Imglabel.setForeground(new Color(255, 255, 255));
		Imglabel.setBackground(new Color(255, 255, 255));
		Imglabel.setBounds(101, 11, 518, 264);
		contentPane.add(Imglabel);
	}
}
