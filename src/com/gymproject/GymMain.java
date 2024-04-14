package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class GymMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GymMain frame = new GymMain();
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
	public GymMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 492);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Machine");
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gymadd ga =new Gymadd();
				ga.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(0, 192, 269, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update,Delete");
		btnNewButton_1.setForeground(new Color(0, 255, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GymDelete gd= new GymDelete();
				gd.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(0, 298, 269, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show Machines Data");
		btnNewButton_2.setForeground(new Color(0, 255, 0));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConnectionDB cdb=new ConnectionDB();
				cdb.createConnection();
				Statement st;
				try
				{
					st=cdb.con.createStatement();
					String sql="select * from equipment";
					ResultSet rs=st.executeQuery(sql);
					ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
					DefaultTableModel dtm=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String [] colname=new String[cols];
					for(int i=0;i<cols;i++)
					{
						colname[i]=rsmd.getColumnName(i+1);
						dtm.setColumnIdentifiers(colname);
						String id,equipnents,quantity;
						while(rs.next())
						{
							id=rs.getString(1);
							equipnents=rs.getString(2);
							quantity=rs.getString(3);
							String[] row= {id,equipnents,quantity};
							dtm.addRow(row);
						}
					}
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton_2.setBounds(0, 79, 269, 58);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 80, 345, 282);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mainpg ad=new Mainpg();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(0, 255, 0));
		btnNewButton_3.setBounds(236, 395, 140, 47);
		contentPane.add(btnNewButton_3);
	}
}
