package sn.esmt.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDao {
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
	
		 public static int save2(Utilisateur e){ 
			 int status=0; 
			 try{ 
				 Connection con=UtilisateurDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into Utilisateur(id,login,password,profil) values (?,?,?,?)"); 
				 ps.setInt(1, e.getId());
				 ps.setString(2,e.getLogin()); 
				 ps.setString(3,e.getPassword()); 
				 ps.setString(4,e.getProfil()); 
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 } 
		 
		 public static int update(Utilisateur e){ 
		 int status=0; 
		 try{ 
			 Connection con=UtilisateurDao.getConnection(); 
			 PreparedStatement ps=con.prepareStatement( "update Utilisateur set login=?, password=?, profil=? where id=?"); 
			 ps.setInt(4, e.getId());
			 ps.setString(1,e.getLogin()); 
			 ps.setString(2,e.getPassword()); 
			 ps.setString(3,e.getProfil()); 
			 status=ps.executeUpdate(); 
			 con.close(); 
		 }catch(Exception ex){
			 ex.printStackTrace();
		}
		return status; 
	}
		 
		 
		public static Utilisateur getUtilisateurById(int id){ 
			Utilisateur e=new Utilisateur(); 
			try{ 
				Connection con=ClientDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from Utilisateur where id=?"); 
				ps.setInt(1,id); 
				ResultSet rs=ps.executeQuery();
				if(rs.next()){ 
					e.setId(rs.getInt(1));
					e.setLogin(rs.getString(2));
					e.setPassword(rs.getString(3)); 
					e.setProfil(rs.getString(4));
					} 
					 con.close(); 
				}catch(Exception ex){
					 ex.printStackTrace();
				} 
				 return e; 
			} 
		public List<Utilisateur> getAllUtilisateurs(){ 
			List<Utilisateur> list=new ArrayList<Utilisateur>(); 
			try{ 
				Connection con=ClientDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from Utilisateur"); 
				ResultSet rs=ps.executeQuery(); 
				while(rs.next()){ 
				Utilisateur e=new Utilisateur();
				e.setId(rs.getInt(1)); 
				e.setLogin(rs.getString(2));
				e.setPassword(rs.getString(3)); 
				e.setProfil(rs.getString(4)); 
				list.add(e); 
				} 
				con.close(); 
				}catch(Exception e){e.printStackTrace();} 
					return list; 
			} 
		} 


