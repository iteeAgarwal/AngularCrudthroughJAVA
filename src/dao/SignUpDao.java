package dao;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Data;
public class SignUpDao {
static Connection con=null;  
	
	public static Connection getConn()
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","rootroot");  
			System.out.println(con);
		}
		catch(Exception e)
		{ 
		 	System.out.println(e);
		 } 
		return con;
			} 
	
	
	public static boolean registration(String name, String email, String pnumber, String pass) {
		// TODO Auto-generated method stub
		boolean reg=false;
	
		System.out.println("Name"+name+"Phon"+pnumber);
		try{  
			Connection conn=getConn();
			PreparedStatement ps=conn.prepareStatement("insert into signup1(name,email,pnumber,pass) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pnumber);
			ps.setString(4, pass);
			int p=ps.executeUpdate();
			if(p>0)
			{
				reg=true;
			}
		}
		catch(Exception e)
		{
 		System.out.println(e);
 		e.printStackTrace();
 		}
		
		return reg;
	}

	public static List<Data> getAllUserDetail(String pnumber) {
		// TODO Auto-generated method stub
		List<Data> list=new ArrayList<>();
		try
		{
			Connection conp=getConn(); 
			System.out.println(con);
			String str1="select name,email,pnumber,pass from signup1";
			PreparedStatement pst=conp.prepareStatement(str1);
			/*pst.setString(1, pnumber);*/
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{   Data data = new Data();
			    data.setUser(rs.getString(1));
			    data.setEmail(rs.getString(2));
			   data.setPnumber(rs.getString(3));
			    data.setPass(rs.getString(4));
			    list.add(data);
				System.out.println("Email"+rs.getString(2));
				System.out.println("UserName"+rs.getString(1));
			}
		}
		catch(Exception e)
		{
 		System.out.println(e);
 		e.printStackTrace();
 		}
		
		return list;
	}

	public static int delete(String pnumber) {
		// TODO Auto-generated method stub
		int rowDeleted = 0;
		try
		{
			Connection conw=getConn();
			System.out.println("fkg"+pnumber);
			String del="delete from signup1 where pnumber=?";
			PreparedStatement pst1=conw.prepareStatement(del);
			pst1.setString(1, pnumber);
			 rowDeleted=pst1.executeUpdate();
			 System.out.println(rowDeleted);
		}
		catch(Exception e)
		{
 		System.out.println(e);
 		e.printStackTrace();
 		}

		return rowDeleted;
	}


	public static List<Data> getAlldata(String phonenumber) {
		// TODO Auto-generated method stub
		List<Data> list=new ArrayList<>();
		try
		{
			Connection conp=getConn(); 
			System.out.println(con+"pnumber:-"+phonenumber);
			String str1="select name,email,pnumber,pass from signup1 where pnumber=?";
			PreparedStatement pst=conp.prepareStatement(str1);
			pst.setString(1, phonenumber);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{   Data data = new Data();
			    data.setUser(rs.getString(1));
			    data.setEmail(rs.getString(2));
			   data.setPnumber(rs.getString(3));
			    data.setPass(rs.getString(4));
			    list.add(data);
				System.out.println("Email Selected"+rs.getString(2));
				System.out.println("UserNamefor selected"+rs.getString(1));
			}
		}
		catch(Exception e)
		{
 		System.out.println(e);
 		e.printStackTrace();
 		}
		
		return list;
	}


	public static int update(String name, String ppnumber, String email) {
		// TODO Auto-generated method stub
		int status=0;
		try
		{
			Connection conp=getConn(); 
			 PreparedStatement ps=con.prepareStatement(  
					 "update signup1 set name=?,email=? where pnumber=?");  
					         ps.setString(1,name);  
					         ps.setString(2,email);  
					         ps.setString(3,ppnumber);
					         status=ps.executeUpdate();  
					         System.out.println("Updation Status"+status);
		}
		catch(Exception e)
		{
 		System.out.println(e);
 		e.printStackTrace();
 		}
		
		return status;
	}

}
