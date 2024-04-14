package com.gymproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class AllGymMethod {
	
	
	
	ConnectionDB cdb= new ConnectionDB();
	
	public int addGymData(int id,String eq,String qu)
	{
		int s = 0;
	
	cdb.createConnection();
	String querry="insert into equipment values(?,?,?)";
	try {
		PreparedStatement ps;
		ps=cdb.con.prepareStatement(querry);
		ps.setInt(1, id);
		ps.setString(2, eq);
		ps.setString(3, qu);
		ps.executeUpdate();
		//System.out.println("inside s  ;"+s);
		JOptionPane.showMessageDialog(null, "done");
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	
	return s;
	}
	
public void deletedata()
	{
//
//		
//		
//		try
//		{
//			cdb.createConnection();
//			GymDelete gd=new GymDelete();
//			PreparedStatement ps;
//			String querry="delete from equipment where id='"+gd.delete.getText()+"' ";
//			
//			ps=cdb.con.prepareStatement(querry);
//			int r=ps.executeUpdate();
//			System.out.println("tttt"+r);
//			
//			 if(gd.delete.getText().isBlank())
//			{
//				JOptionPane.showMessageDialog(gd.DeleteButton, "Insert Data In Field");	
//			}
//			
//			if(r==1)
//			{
//				JOptionPane.showMessageDialog(gd.DeleteButton, "Data Deleted Succesfully");
//			}	
//			
//			else
//			{
//				JOptionPane.showMessageDialog(gd.DeleteButton, "Data Not Deleted");
//			}
//			
//			
//			
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
	}

public void gymupdate(int uid,String mn,String q)
	{		
	ConnectionDB c= new ConnectionDB();
	c.createConnection();
	Statement ps;
	int flag=0;
	
	if(q.length()!=0 || mn.length()!=0)
	{
		if(q.length()!=0)
		{
		try
		{
			ps = c.con.createStatement();
		String sql="update equipment set quantity='"+q+"' where id='"+uid+"' ";
		System.out.println(sql);
		System.out.println("Virat"+ps);
		int res=ps.executeUpdate(sql);
		System.out.println(res);
		//JOptionPane.showMessageDialog(null, "Submited");	
		} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
		}
		
	if(mn.length()!=0)
	{
	try
	{
		ps = c.con.createStatement();
		String sql="update equipment set equipnents='"+mn+"' where id='"+uid+"'  ";
		System.out.println(sql);
		System.out.println("Dhoni"+ps);
		int r=ps.executeUpdate(sql);
		System.out.println(r);
		//
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	flag=1;
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Enter All Details");
	}
	
	if(flag==1)
	{
		JOptionPane.showMessageDialog(null, "Submitted");
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Not Submited");
	}

	}	

}
