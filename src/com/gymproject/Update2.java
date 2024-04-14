package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Update2 extends JFrame {
	
	public JTextField t1;
	public JTextField t2;
	public JTextField t3;
	public JTextField t4;
	public JTextField t5;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JLabel l4;
	public JLabel l5;
	public JButton btnNewButton_1;
	public JTextField t0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update2 frame = new Update2();
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
	public Update2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(229, 133, 125, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(229, 179, 125, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(229, 228, 125, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(226, 272, 128, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(226, 317, 128, 20);
		contentPane.add(t5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=Integer.parseInt(t0.getText());
				String nmu=t1.getText();
				String passu=t2.getText();
				String pnou=t3.getText();
				String wu=t4.getText();
				String hu=t5.getText();
		
				ConnectionDB co= new ConnectionDB();
				co.createConnection();
				co.updatedata(id,nmu, passu, pnou, wu, hu);
				
				
				
				
				
				
//					if(nmu.length()!=0)
//				{
//					PreparedStatement ps;
//					String sql="update admissiondetails set aName='"+nmu+"' where aRegId='"+id+"' ";
//				try 
//					{
//						ps=co.con.prepareStatement(sql);
//						ps.executeUpdate();
//						
//					}
//				catch (Exception e1) 
//					{
//						
//						e1.printStackTrace();
//					}
//				}
//					//JOptionPane.showMessageDialog(btnNewButton,"Data Updated Succesfully");
//				
//				if(passu.length()!=0)
//				{
//					PreparedStatement ps;
//					String sql="update admissiondetails set aAddress='"+passu+"' where aRegId='"+id+"' ";
//				try 
//					{
//						ps=co.con.prepareStatement(sql);
//						ps.executeUpdate();
//											}
//				catch (Exception e1) 
//					{
//						
//						e1.printStackTrace();
//					}
//				}
//				JOptionPane.showMessageDialog(btnNewButton,"Data Updated Succesfully");
//				
//				if(pnou.length()!=0)
//				{
//					PreparedStatement ps;
//					String sql="update admissiondetails set aPhoneNo='"+pnou+"' where aRegId='"+id+"' ";
//				try 
//					{
//						ps=co.con.prepareStatement(sql);
//						ps.executeUpdate();
//						
//					}
//				catch (Exception e1) 
//					{
//						
//						e1.printStackTrace();
//					}
//				}
//				
//				if(wu.length()!=0)
//				{
//					PreparedStatement ps;
//					String sql="update admissiondetails set aWeight='"+wu+"' where aRegId='"+id+"' ";
//				try 
//					{
//						ps=co.con.prepareStatement(sql);
//						ps.executeUpdate();
//						
//					}
//				catch (Exception e1) 
//					{
//						
//						e1.printStackTrace();
//					}
//				
//				}
//				
//				if(hu.length()!=0)
//				{
//					PreparedStatement ps;
//					String sql="update admissiondetails set aHeight='"+hu+"' where aRegId='"+id+"' ";
//				try 
//					{
//						ps=co.con.prepareStatement(sql);
//						ps.executeUpdate();
//						
//					}
//				catch (Exception e1) 
//					{
//						
//						e1.printStackTrace();
//					}
//				
//				}
//							
			}		
		});
		btnNewButton.setBounds(104, 384, 102, 32);
		contentPane.add(btnNewButton);
		
		l1 = new JLabel("Name");
		l1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		l1.setForeground(new Color(0, 255, 0));
		l1.setBounds(68, 125, 89, 32);
		contentPane.add(l1);
		
		l2 = new JLabel("Address");
		l2.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		l2.setForeground(new Color(0, 255, 0));
		l2.setBounds(68, 173, 96, 29);
		contentPane.add(l2);
		
		l3 = new JLabel("Phone No");
		l3.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		l3.setForeground(new Color(0, 255, 0));
		l3.setBounds(68, 222, 96, 29);
		contentPane.add(l3);
		
		l4 = new JLabel("Weight");
		l4.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		l4.setForeground(new Color(0, 255, 0));
		l4.setBounds(65, 264, 96, 32);
		contentPane.add(l4);
		
		l5 = new JLabel("Height");
		l5.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		l5.setForeground(new Color(0, 255, 0));
		l5.setBounds(65, 309, 96, 32);
		contentPane.add(l5);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateData1 ud= new UpdateData1();
				ud.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(226, 384, 102, 32);
		contentPane.add(btnNewButton_1);
		
		t0 = new JTextField();
		t0.setColumns(10);
		t0.setBounds(229, 89, 125, 20);
		contentPane.add(t0);
		
		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblId.setForeground(new Color(0, 255, 0));
		lblId.setBounds(68, 81, 89, 32);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("PLEASE ENTER DETAILS");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 32);
		contentPane.add(lblNewLabel);
		
		JLabel photo = new JLabel("");
		photo.setIcon(new ImageIcon("C:\\Users\\jitup\\Downloads\\newAdd (1).jpg"));
		photo.setBounds(41, 0, 393, 427);
		contentPane.add(photo);
	}
}
