package sn.esmt.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {
	public static Connection getConnection(){ 
		 Connection con=null; 
		 try{ 
			 Class.forName ("com.mysql.cj.jdbc.Driver");
			 
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdProjetExamen2023", "root", "");; 
		 }catch(Exception e){
			 System.out.println(e);
		 } 
		 return con; 
	}
	
		 public static int save(Contact e){ 
			 int status=0; 
			 try{ 
				 Connection con=ContactDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into contact(id,name,email,numero,message) values (?,?,?,?,?)"); 
				 ps.setInt(1, e.getId());
				 ps.setString(2,e.getName()); 
				 ps.setString(3,e.getEmail());
				 ps.setInt(4, e.getNumero());
				 ps.setString(5,e.getMessage()); 			
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 } 
		 
		 public static int delete(int id){ 
			 int status=0; 
			 try{ 
				 Connection con=ContactDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement("delete from contact where id=?"); 
				 ps.setInt(1,id); 
				 status=ps.executeUpdate(); 
				 con.close(); 
			  }catch(Exception e){e.printStackTrace();} 
				 return status; 
			 } 
		 
		 public static List<Contact> getAllContacts(){ 
				List<Contact> list=new ArrayList<Contact>(); 
				try{ 
					Connection con=ContactDao.getConnection(); 
					PreparedStatement ps=con.prepareStatement("select * from contact"); 
					ResultSet rs=ps.executeQuery(); 
					while(rs.next()){ 
						Contact e=new Contact();
						e.setId(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setEmail(rs.getString(3));
						e.setNumero(rs.getInt(4));
						e.setMessage(rs.getString(5)); 
						list.add(e); 
					} 
						con.close(); 
					}catch(Exception e){e.printStackTrace();} 
						return list; 
				} 
		 
	
}
