package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GymDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField delete;
	private JTextField update;
	JButton DeleteButton;
	private JTextField updateq;
	private JLabel lblNewLabel_3;
	private JTextField updatemn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GymDelete frame = new GymDelete();
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
	public GymDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		delete = new JTextField();
		delete.setBounds(156, 174, 86, 20);
		contentPane.add(delete);
		delete.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Id");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBounds(10, 176, 94, 17);
		contentPane.add(lblNewLabel);
		
		 DeleteButton = new JButton("Delete");
		 DeleteButton.setBackground(new Color(0, 255, 0));
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				id=Integer.parseInt(delete.getText());
//				ConnectionDB cdb=new ConnectionDB();
//				cdb.createConnection();
//				AllGymMethod agm= new AllGymMethod();
//				agm.deletedata();
				try
				{
				ConnectionDB cdb=new ConnectionDB();
				cdb.createConnection();
				PreparedStatement ps;
				String querry="delete from equipment where id='"+delete.getText()+"' ";
				
				ps=cdb.con.prepareStatement(querry);
				int r=ps.executeUpdate();
				System.out.println("tttt"+r);
				
				if(r==1)
				{
					JOptionPane.showMessageDialog(DeleteButton, "Data Deleted Succesfully");
				}	
				else if(delete.getText().isBlank() )
					{
						JOptionPane.showMessageDialog(DeleteButton, "Insert Data In Field");	
					}
				else
				{
					JOptionPane.showMessageDialog(DeleteButton, "Data Not Deleted");
				}
				
				
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
				
			}
		});
		DeleteButton.setBounds(271, 173, 89, 23);
		contentPane.add(DeleteButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Id");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBounds(10, 30, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		update = new JTextField();
		update.setBounds(153, 27, 86, 20);
		contentPane.add(update);
		update.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				int uid=Integer.parseInt(update.getText());
				String mn= updatemn.getText();
				String q=updateq.getText();
				
//				boolean a=mn.isBlank();
//				System.out.println("hasranga"+a);
				AllGymMethod agm= new AllGymMethod();
				agm.gymupdate(uid, mn, q);
			}
		});
		btnNewButton.setBounds(271, 62, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(10, 103, 46, 17);
		contentPane.add(lblNewLabel_2);
		
		updateq = new JTextField();
		updateq.setBounds(153, 101, 86, 20);
		contentPane.add(updateq);
		updateq.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Machine Name");
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setBounds(10, 66, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		updatemn = new JTextField();
		updatemn.setColumns(10);
		updatemn.setBounds(153, 58, 86, 20);
		contentPane.add(updatemn);
		
		JLabel lblNewLabel_4 = new JLabel("Data Delete Section");
		lblNewLabel_4.setForeground(new Color(0, 255, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 149, 434, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Update Section");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 255, 0));
		lblNewLabel_5.setBounds(0, 5, 424, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GymMain g= new GymMain();
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setBounds(156, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
