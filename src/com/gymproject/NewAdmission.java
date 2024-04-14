package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NewAdmission extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtid;
	public JTextField txtname;
	public JTextField txtaddress;
	public JTextField txtpno;
	public JTextField txtweight;
	public JTextField txtheight;
	JComboBox txtwt;
	JRadioButton male;
	JRadioButton female;
	ButtonGroup bg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAdmission frame = new NewAdmission();
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
	public NewAdmission() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW ADDMISSION ");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 688, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("reg ID");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(57, 87, 206, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(57, 143, 206, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(57, 196, 206, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone No");
		lblNewLabel_4.setForeground(new Color(0, 255, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(57, 253, 206, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setForeground(new Color(0, 255, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(57, 313, 205, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Weight");
		lblNewLabel_6.setForeground(new Color(0, 255, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(57, 372, 212, 23);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Height [CM]");
		lblNewLabel_7.setForeground(new Color(0, 255, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(57, 426, 212, 23);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Workout Type");
		lblNewLabel_8.setForeground(new Color(0, 255, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(57, 479, 212, 23);
		contentPane.add(lblNewLabel_8);
		
		JButton submit = new JButton("Submit");
		submit.setBackground(new Color(0, 255, 0));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nm=txtname.getText();
				String add=txtaddress.getText();
				String pno=txtpno.getText();
				String wt=txtweight.getText();
				String ht=txtheight.getText();
		
				String workt=txtwt.getSelectedItem().toString();
				
				
				
				
					
					String gender;
					if(male.isSelected())
					{
						gender = "male";	
					}
					else
					{
						gender = "Female";
					}
					
					//System.out.println("msd : "+gender);
					
					//boolean a=nm.isEmpty();
					//System.out.println("BOOLEAN"+a);
					
					if((nm.isEmpty()==false) && (add.isEmpty()==false) && (pno.isEmpty()==false) && (wt.isEmpty()==false) && (ht.isEmpty()==false) && (workt.isEmpty()==false) && (gender.isEmpty() == false))
			{
						int id=Integer.parseInt(txtid.getText());

						if(pno.length()==10)
						{
						ConnectionDB cdb=new ConnectionDB();	
						cdb.createConnection();
						cdb.addadmissiondata(id, nm, add, pno,gender,wt, ht, workt);
						JOptionPane.showMessageDialog(submit, "Data Inserted Succesfully");
						Mainpg mp =new Mainpg();
						mp.setVisible(true);
						dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(submit,"Please Enter 10 Digits In Pho ne No");
						}
									
			}
					else
					{
						JOptionPane.showMessageDialog(submit,"Enter All details");
					}
					
					
					
					male.setActionCommand("male");
					female.setActionCommand("female");
					bg.getSelection().getActionCommand();
					
			}
		});
		submit.setBounds(168, 563, 141, 39);
		contentPane.add(submit);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtid.setBounds(339, 90, 182, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtname.setBounds(339, 144, 182, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtaddress.setBounds(339, 197, 182, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		txtpno = new JTextField();
		txtpno.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpno.setBounds(339, 254, 182, 20);
		contentPane.add(txtpno);
		txtpno.setColumns(10);
		
		male = new JRadioButton("Male");
		male.setForeground(new Color(0, 0, 0));
		male.setFont(new Font("Tahoma", Font.BOLD, 15));
		male.setBounds(280, 313, 66, 23);
		contentPane.add(male);
		
		female = new JRadioButton("Female");
		female.setForeground(new Color(0, 0, 0));
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		female.setBounds(395, 313, 86, 23);
		contentPane.add(female);
		
		bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		txtweight = new JTextField();
		txtweight.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtweight.setBounds(339, 373, 182, 20);
		contentPane.add(txtweight);
		txtweight.setColumns(10);
		
		txtheight = new JTextField();
		txtheight.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtheight.setBounds(339, 427, 182, 20);
		contentPane.add(txtheight);
		txtheight.setColumns(10);
		
		txtwt = new JComboBox();
		txtwt.setForeground(new Color(0, 0, 0));
		txtwt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtwt.setModel(new DefaultComboBoxModel(new String[] {"Enter here", "cardio", "weight ", "full body "}));
		txtwt.setBounds(339, 479, 182, 22);
		contentPane.add(txtwt);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\jitup\\Downloads\\newAdd (1).jpg"));
		lblNewLabel_9.setBounds(97, 8, 330, 544);
		contentPane.add(lblNewLabel_9);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mainpg mpg= new Mainpg();
				mpg.setVisible(true);
				dispose();
				
				
			}
		});
		btnBack.setBackground(new Color(0, 255, 0));
		btnBack.setBounds(365, 563, 141, 39);
		contentPane.add(btnBack);
	}
}
