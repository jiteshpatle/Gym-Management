package com.gymproject;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionDB {
	Connection con;
	JTable showdata; 
	Statement st;
	
	 
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymmanagement", "root", "");
			System.out.println("CONNECTION ESTABLISHED...");
			//st=con.createStatement();
			} 
		catch (Exception e) {
			System.out.println(e);
		}

	}
	

	public int checkLogin(String nm, String pas) {
		int flag = 0;
		try {
			st = con.createStatement();
			String str = "select * from gymlogin where uname = '" + nm + "'and upass='" + pas + "'";
			ResultSet rs = st.executeQuery(str);

			while (rs.next()) {
				flag = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public int registerform(String nm1, String pass1, int age1, String g, String gt, int fp) {
		int res = 0;
		try {

			PreparedStatement ps;

			String sql = "insert into gymlogin value(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, nm1);
			ps.setString(2, pass1);
			ps.setInt(3, age1);
			ps.setString(4, g);
			ps.setString(5, gt);
			ps.setInt(6, fp);
			res = ps.executeUpdate();
			// System.out.println("res : "+res);
			// System.out.println(nm1+pass1+age1+fp);
		} catch (Exception ex) 
		{
			ex.printStackTrace();
		}

		return res;
	}

	public int addadmissiondata(int id, String nm, String add, String pno, String gen, String wt, String ht,
			String workt) {
		int res = 0;

		try {

			PreparedStatement ps;
			String st = "insert into admissiondetails value(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(st);
			ps.setInt(1, id);
			ps.setString(2, nm);
			ps.setString(3, add);
			ps.setString(4, pno);
			ps.setString(5, gen);
			ps.setString(6, wt);
			ps.setString(7, ht);
			ps.setString(8, workt);

			res = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return res;
	}

	
	public void updatedata(int id,String nmu,String passu,String pnou,String wu,String hu)
	{
		Update2 u2=new Update2();
		 String uid=u2.t0.getText();
		try {
			st=con.createStatement();
			String querry="select * from admissiondetails where aRegId='"+id+"'";
			ResultSet y=st.executeQuery(querry);
			if(y.next())
			{
				
				int flag = 0;
				if( uid.length()!=0 || nmu.length() != 0 || passu.length() != 0 || pnou.length() != 0 || wu.length() != 0 || hu.length() != 0)
				{
					//System.out.println(nmu);
					if(nmu.length() != 0)
					{
						PreparedStatement ps;
						String sql="update admissiondetails set aName='"+nmu+"' where aRegId='"+id+"' ";
					try 
						{
							ps=con.prepareStatement(sql);
							ps.executeUpdate();
							
						}
					catch (Exception e1) 
						{
							
							e1.printStackTrace();
						}
					}
					
					//System.out.println(passu.length());
					if(passu.length() != 0)
					{
						PreparedStatement ps;
						String sql="update admissiondetails set aAddress='"+passu+"' where aRegId='"+id+"' ";
					try 
						{
							ps=con.prepareStatement(sql);
							ps.executeUpdate();
							
						}
					catch (Exception e1) 
						{
							
							e1.printStackTrace();
						}
					}
					
					
					if(pnou.length() != 0)
					{
						PreparedStatement ps;
						String sql="update admissiondetails set aPhoneNo='"+pnou+"' where aRegId='"+id+"' ";
					try 
						{
							ps=con.prepareStatement(sql);
							ps.executeUpdate();
							
						}
					catch (Exception e1) 
						{
							
							e1.printStackTrace();
						}
					}
					
					if(wu.length() != 0)
					{
						PreparedStatement ps;
						String sql="update admissiondetails set aWeight='"+wu+"' where aRegId='"+id+"' ";
					try 
						{
							ps=con.prepareStatement(sql);
							ps.executeUpdate();
							
						}
					catch (Exception e1) 
						{
							
							e1.printStackTrace();
						}
					}
					
					if(hu.length() != 0)
					{
						PreparedStatement ps;
						String sql="update admissiondetails set aHeight='"+hu+"' where aRegId='"+id+"' ";
					try 
						{
							ps=con.prepareStatement(sql);
							ps.executeUpdate();
							
						}
					catch (Exception e1) 
						{
							
							e1.printStackTrace();
						}
					}
					
					
					flag = 1;
				}
				
				if(flag == 1)
				{
					JOptionPane.showMessageDialog(u2, "Data Inserted");
				}
				else
				{
					JOptionPane.showMessageDialog(u2, "Enter all details");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(u2, "wrong id");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
			
	}
	
}
