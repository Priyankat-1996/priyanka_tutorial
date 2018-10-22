package com.jdbc;
import java.sql.*;
import java.util.Scanner;

public class JDBC_Example 
{
	public Connection connect() throws ClassNotFoundException, SQLException 
	{
		 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","password");   
			if(con == null)
			{
				System.out.println("No Connection...");
			}
		
		
		return con;
		
	}
	@SuppressWarnings("resource")
	public void checkById() throws SQLException
	{
		Scanner in=new Scanner(System.in);
		int flag=0;
		String condition = "",cust_id="",cust_name="";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Statement st=null;
		String nm="";
		int ans,quantity,product_id,delcustid;
		try {
			conn = connect();
			if(conn != null)
			{
				System.out.println("\nConnection Successful...");
				System.out.println("Insertion...");
				System.out.println("\nEnter ID to be search: ");
				condition=in.next();

				String selectSQL = "SELECT * FROM customer WHERE cust_id = ?";
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1,condition);

				 rs = pstmt.executeQuery();

				while (rs.next()) 
				{

					cust_id = rs.getString("cust_id");
					cust_name = rs.getString("cust_name");

					System.out.println("userid : " + cust_id);
					System.out.println("username : " + cust_name);
					flag=1;
				}
				if(flag==0)
				{
					System.out.println("Enter Name: ");
					nm=in.next();
					String s="insert into customer values(?,?)";
					pstmt = conn.prepareStatement(s);
					pstmt.setString(1, condition);
					pstmt.setString(2, nm);
					pstmt.executeUpdate();
					flag=1;
					if(flag==1)
					{
						String s2="select * from customer";
						st=conn.createStatement();
						rs=st.executeQuery(s2);
						System.out.println("CustID"+"\t"+"CustName");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2));
						}
						System.out.println("Inserted Successfully...");
					}
				}
				
				String sql3="select * from product";
				st=conn.createStatement();
				rs=st.executeQuery(sql3);
				System.out.println("ProdID\t"+"ProdName\t\t"+"Category");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t\t"+ rs.getString(3));
					
				}
				do 
				{
					System.out.println("Enter Product ID : ");
					product_id=in.nextInt();
					System.out.println("Enter Quanntity: ");
					quantity=in.nextInt();
					System.out.println("Do you want more Products..?");
					ans=in.nextInt();
				}while(ans==0);
				String sql4="insert into orderdet(cust_id,quantity,product_id) values(?,?,?)";
				pstmt=conn.prepareStatement(sql4, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1,cust_id);
				pstmt.setInt(2, quantity);
				pstmt.setInt(3, product_id);
				pstmt.executeUpdate();
				 
				String sql5="select * from orderdet";
				st=conn.createStatement();
				rs=st.executeQuery(sql5);
				System.out.println("OrderID\t"+"CustID\t"+"Quantity\t"+"ProductID");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t\t"+rs.getInt(4));
				}
				System.out.println("--------------------------------------------");
				System.out.println("Updation...");
				System.out.println("Enter Customer ID: ");
				delcustid=in.nextInt();
				System.out.println("Enter quantity to reduce: ");
				int quant=in.nextInt();
				System.out.println("Enter Order ID: ");
				int ordid=in.nextInt();
				String sql6="update orderdet set quantity=quantity-? where cust_id=? and orderid=?";
				pstmt = conn.prepareStatement(sql6);
				pstmt.setInt(1, quant);
				pstmt.setInt(2,delcustid);
				pstmt.setInt(3, ordid);
				pstmt.executeUpdate();
				String sql7="select * from orderdet";
				st=conn.createStatement();
				rs=st.executeQuery(sql7);
				System.out.println("OrderID\t"+"CustID\t"+"Quantity\t"+"ProductID");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t\t"+rs.getInt(4));
				}
				 System.out.println("--------------------------------------------");
				System.out.println("Deletion...");
				System.out.println("Enter order to be delete: ");
				int ordi=in.nextInt();
				String sql8="delete from orderdet where orderid=?";
				pstmt = conn.prepareStatement(sql8);
				pstmt.setInt(1, ordi);
				pstmt.executeUpdate();
				String sql9="select * from orderdet";
				st=conn.createStatement();
				rs=st.executeQuery(sql9);
				System.out.println("OrderID\t"+"CustID\t"+"Quantity\t"+"ProductID");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t\t"+rs.getInt(4));
				}
				
			}
			else
			{
				System.out.println("No connection...");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	   
		finally {

			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
	}
	
		public static void main(String args[]) throws SQLException
		{  
			Scanner in=new Scanner(System.in);
			JDBC_Example obj= new JDBC_Example();
			obj.checkById();
			//obj.search();
			
		}
}
/*
create table orderdet(orderid int(11) NOT NULL AUTO_INCREMENT, cust_id int,quantity int(5),product_id int,FOREIGN KEY (cust_id) REFERENCES customer(cust_id),PRIMARY KEY(orderid),FOREIGN KEY (product_id) REFERENCES product(product_id));
create table product(product_id int NOT NULL AUTO_INCREMENT ,product_name varchar(25), product_cat varchar(35),PRIMARY KEY(product_id));
create table customer(cust_id varchar(15),cust_name varchar(30));
 */
