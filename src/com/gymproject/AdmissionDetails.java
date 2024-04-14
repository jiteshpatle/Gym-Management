package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.DataStoreMetadata;
import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
//import net.proteanit.sql.DbUtils;

public class AdmissionDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private JTable showdata;
	
	private JTextField txtid;
	
	int cnt = 1;
	private JTextField deletef;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmissionDetails frame = new AdmissionDetails();
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
	public AdmissionDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMISSION DATA");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 1150, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("See All Data");
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(cnt == 1)
				{
					cnt++;
					ConnectionDB obj= new ConnectionDB();
					obj.createConnection();
					//System.out.println("Spark");
					try
					{
						Statement st=obj.con.createStatement();
						String sql= "select * from admissiondetails";
						ResultSet rs=st.executeQuery(sql);
						ResultSetMetaData rsmd=rs.getMetaData();
						DefaultTableModel dtm=(DefaultTableModel) showdata.getModel();
						
						int cols=rsmd.getColumnCount();
						String[] cn=new String[cols];
						
						for(int i=0;i<cols;i++)
						{
							cn[i]=rsmd.getColumnName(i+1);
							dtm.setColumnIdentifiers(cn);
							
							String aRegId, aName,aAddress,aPhoneNo,aGender,aWeight,aHeight,aWorkoutType;		
							
							while (rs.next()) 
							{
								aRegId=rs.getString(1);
								aName=rs.getString(2);
								aAddress=rs.getString(3);
								aPhoneNo=rs.getString(4);
								aGender=rs.getString(5);
								aWeight=rs.getString(6);
								aHeight=rs.getString(7);
								aWorkoutType=rs.getString(8);
								
								String []  row = {aRegId,aName,aAddress,aPhoneNo,aGender,aWeight,aHeight,aWorkoutType};	
								dtm.addRow(row);								
							}
							
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Already all data has been shown!!!");
				}

			}
		});
		btnNewButton.setBounds(31, 111, 204, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 111, 925, 255);
		contentPane.add(scrollPane);
		
		showdata = new JTable();
		showdata.setForeground(new Color(255, 255, 255));
		showdata.setBackground(new Color(0, 0, 0));
		scrollPane.setViewportView(showdata);
		showdata.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		JButton btnNewButton_1 = new JButton("Update Data");
		btnNewButton_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateData1 up1= new UpdateData1();
				up1.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(31, 330, 200, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Data");
		btnNewButton_2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					ConnectionDB obj= new ConnectionDB();
					obj.createConnection();
					String str="delete from admissiondetails where aRegId= '"+deletef.getText()+"' ";
					System.out.println("strrr   "+str);
					PreparedStatement ps=obj.con.prepareStatement(str);
					int res = ps.executeUpdate();
					System.out.println("res   "+res);
					
					if(res == 1)
					{
						JOptionPane.showMessageDialog(btnNewButton_2,"Data Deleted Succefully");
						
						
						DefaultTableModel dt=(DefaultTableModel) showdata.getModel();
						dt.setRowCount(0);
						dt.setColumnCount(0);
						
						Statement st=obj.con.createStatement();
						String sql= "select * from admissiondetails";
						ResultSet rs=st.executeQuery(sql);
						ResultSetMetaData rsmd=rs.getMetaData();
						DefaultTableModel dtm=(DefaultTableModel) showdata.getModel();
						
						int cols=rsmd.getColumnCount();
						String[] cn=new String[cols];
						
						for(int i=0;i<cols;i++)
						{
							cn[i]=rsmd.getColumnName(i+1);
							dtm.setColumnIdentifiers(cn);
							
							String aRegId, aName,aAddress,aPhoneNo,aGender,aWeight,aHeight,aWorkoutType;		
							
							while (rs.next()) 
							{
								aRegId=rs.getString(1);
								aName=rs.getString(2);
								aAddress=rs.getString(3);
								aPhoneNo=rs.getString(4);
								aGender=rs.getString(5);
								aWeight=rs.getString(6);
								aHeight=rs.getString(7);
								aWorkoutType=rs.getString(8);
								
								String []  row = {aRegId,aName,aAddress,aPhoneNo,aGender,aWeight,aHeight,aWorkoutType};	
								dtm.addRow(row);								
							}
							
						}
						
						
					}
					else if(deletef.getText().isBlank())
					{
						JOptionPane.showMessageDialog(btnNewButton_2,"Empty Text field");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_2,"Data Deleted UnSuccefully");	
					}
					
					
					
					
					
				}
				catch(Exception r)
				{
					r.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(31, 207, 204, 36);
		contentPane.add(btnNewButton_2);
		
		deletef = new JTextField();
		deletef.setFont(new Font("Sylfaen", Font.BOLD, 15));
		deletef.setForeground(new Color(0, 0, 0));
		deletef.setBackground(new Color(255, 255, 255));
		deletef.setBounds(89, 254, 132, 20);
		contentPane.add(deletef);
		deletef.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Id");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 254, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("GO BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mainpg mp=new Mainpg();
				mp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(573, 392, 137, 36);
		contentPane.add(btnNewButton_3);
	}
}
