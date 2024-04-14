package com.gymproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class UpdateData1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	
	JCheckBox checkn;
	JCheckBox checka;
	JCheckBox checkpno;
	JCheckBox checkw;
	JCheckBox checkh;
	private JTextField id;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateData1 frame = new UpdateData1();
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
	public UpdateData1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("PLEASE SELECT THE FIELDS");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 43, 518, 42);
		contentPane.add(lblNewLabel_2);
		
		checkn = new JCheckBox("Name");
		checkn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		checkn.setBackground(new Color(0, 0, 0));
		checkn.setForeground(new Color(0, 255, 0));
		checkn.setHorizontalAlignment(SwingConstants.CENTER);
		checkn.setBounds(106, 134, 122, 26);
		contentPane.add(checkn);
		
		checka = new JCheckBox("Address");
		checka.setHorizontalAlignment(SwingConstants.CENTER);
		checka.setFont(new Font("Sitka Text", Font.BOLD, 20));
		checka.setBackground(new Color(0, 0, 0));
		checka.setForeground(new Color(0, 255, 0));
		checka.setBounds(117, 179, 122, 26);
		contentPane.add(checka);
		
		checkpno = new JCheckBox("PhoneNo");
		checkpno.setHorizontalAlignment(SwingConstants.CENTER);
		checkpno.setFont(new Font("Sitka Text", Font.BOLD, 20));
		checkpno.setBackground(new Color(0, 0, 0));
		checkpno.setForeground(new Color(0, 255, 0));
		checkpno.setBounds(106, 222, 154, 26);
		contentPane.add(checkpno);
		
		checkw = new JCheckBox("Weight");
		checkw.setHorizontalAlignment(SwingConstants.CENTER);
		checkw.setFont(new Font("Sitka Text", Font.BOLD, 20));
		checkw.setBackground(new Color(0, 0, 0));
		checkw.setForeground(new Color(0, 255, 0));
		checkw.setBounds(106, 265, 138, 26);
		contentPane.add(checkw);
		
		checkh = new JCheckBox("Height");
		checkh.setHorizontalAlignment(SwingConstants.CENTER);
		checkh.setFont(new Font("Sitka Text", Font.BOLD, 20));
		checkh.setBackground(new Color(0, 0, 0));
		checkh.setForeground(new Color(0, 255, 0));
		checkh.setBounds(96, 310, 154, 26);
		contentPane.add(checkh);
		
		JButton btnNewButton = new JButton("PROCEED");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try
			{
				if( checkn.isSelected() || checka.isSelected() || checkpno.isSelected() || checkw.isSelected() || checkh.isSelected())
				{
					
				Update2 u=new Update2();
				u.setVisible(true);
				dispose();
				
				if (checkn.isSelected()) 
				{
					u.l1.setVisible(true);
			        u.t1.setVisible(true);
			    } 
				else 
			    {
					u.l1.setVisible(false);
			        u.t1.setVisible(false);
			    }
				
				if (checka.isSelected()) 
				{
					u.l2.setVisible(true);
			        u.t2.setVisible(true);
			    } 
				else 
				{
					u.l2.setVisible(false);
			        u.t2.setVisible(false);
			    }
				
				if (checkpno.isSelected()) 
				{
					u.l3.setVisible(true);
			        u.t3.setVisible(true);
			    } 
				else 
			    {
					u.l3.setVisible(false);
			        u.t3.setVisible(false);
			    }
				
				if (checkw.isSelected()) 
				{
					u.l4.setVisible(true);
			        u.t4.setVisible(true);
			    }
				else 
			    {
					u.l4.setVisible(false);
			        u.t4.setVisible(false);
			    }
				
				if (checkh.isSelected()) 
				{
					u.l5.setVisible(true);
			        u.t5.setVisible(true);
			    } 
				else 
			    {
					u.l5.setVisible(false);
			        u.t5.setVisible(false);
			    }
				
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton,"PLEASE SELECT THE FIELD","Error",JOptionPane.ERROR_MESSAGE);
				}
				
						
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		});
		btnNewButton.setBounds(174, 372, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmissionDetails mpg= new AdmissionDetails();
				mpg.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(286, 372, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jitup\\Downloads\\r1.jpg"));
		lblNewLabel.setBounds(-107, -28, 691, 652);
		contentPane.add(lblNewLabel);
		

		}
	}

