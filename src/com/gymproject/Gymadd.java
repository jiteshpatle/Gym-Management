package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class Gymadd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gymadd frame = new Gymadd();
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
	public Gymadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD DATA");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 19));
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 424, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Machine name");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBounds(10, 116, 112, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(10, 162, 112, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String i=t0.getText();
//				System.out.println(id);
				String eq=t1.getText();
				System.out.println(eq);
				String qu=t2.getText();
				System.out.println(qu);
				
				boolean b=eq.isEmpty();
				System.out.println("aaaaS"+b);
				
				if(eq.isEmpty()==false && qu.isEmpty()==false && i.isEmpty()==false)
				{
					int id=Integer.parseInt(t0.getText());
					AllGymMethod agm=new AllGymMethod();
					agm.addGymData(id, eq, qu);	
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton,"Enter all details");
				}
				
			}
		});
		btnNewButton.setBounds(96, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GymMain gm=new GymMain();
				gm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(213, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		t1 = new JTextField();
		t1.setBounds(180, 117, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(180, 166, 86, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Id No");
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setBounds(10, 69, 112, 23);
		contentPane.add(lblNewLabel_3);
		
		t0 = new JTextField();
		t0.setBounds(180, 70, 86, 20);
		contentPane.add(t0);
		t0.setColumns(10);
	}
}
