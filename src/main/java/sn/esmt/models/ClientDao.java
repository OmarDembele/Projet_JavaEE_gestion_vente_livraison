package sn.esmt.models;

import java.util.*; 
import java.sql.*;

public class ClientDao {
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
	
		 public static int save(Client e){ 
			 int status=0; 
			 try{ 
				 Connection con=ClientDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into client(idClient,login,password,profil,nomClient, typeClient, adresseClient, specialiteClient) values (?,?,?,?,?,?,?,?)"); 
				 ps.setInt(1, e.getIdClient());
				 ps.setString(2,e.getLogin()); 
				 ps.setString(3,e.getPassword()); 
				 ps.setString(4,e.getProfil()); 
				 ps.setString(5,e.getNomClient());
				 ps.setString(6,e.getTypeClient());
				 ps.setString(7,e.getAdresseClient());
				 ps.setString(8,e.getSpecialiteClient());
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 } 
		 
		 public static int update(Client e){ 
		 int status=0; 
		 try{ 
			 Connection con=ClientDao.getConnection(); 
			 PreparedStatement ps=con.prepareStatement( "update client set login=?, password=?, profil=?, nomClient=?, TypeClient=?, adresseClient=?, specialiteClient=? where idClient=?"); 
			 ps.setInt(8, e.getIdClient());
			 ps.setString(1,e.getLogin()); 
			 ps.setString(2,e.getPassword()); 
			 ps.setString(3,e.getProfil()); 
			 ps.setString(4,e.getNomClient());
			 ps.setString(5,e.getTypeClient());
			 ps.setString(6,e.getAdresseClient());
			 ps.setString(7,e.getSpecialiteClient()); 
			 status=ps.executeUpdate(); 
			 con.close(); 
		 }catch(Exception ex){
			 ex.printStackTrace();
		}
		return status; 
	}
		 
		 
		public static Client getClientById(int id){ 
			Client e=new Client(); 
			try{ 
				Connection con=ClientDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from client where idClient=?"); 
				ps.setInt(1,id); 
				ResultSet rs=ps.executeQuery();
				if(rs.next()){ 
					e.setIdClient(rs.getInt(1));
					e.setLogin(rs.getString(2));
					e.setPassword(rs.getString(3)); 
					e.setNomClient(rs.getString(4));
					e.setTypeClient(rs.getString(5)); 
					e.setAdresseClient(rs.getString(6)); 
					e.setSpecialiteClient(rs.getString(7));
					} 
					 con.close(); 
				}catch(Exception ex){
					 ex.printStackTrace();
				} 
				 return e; 
			}
		
		public static List<Client> getAllClients(){ 
			List<Client> list=new ArrayList<Client>(); 
			try{ 
				Connection con=ClientDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from client"); 
				ResultSet rs=ps.executeQuery(); 
				while(rs.next()){ 
				Client e=new Client(); 
				e.setIdClient(rs.getInt(1));
				e.setLogin(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setProfil(rs.getString(4));
				e.setNomClient(rs.getString(5));
				e.setTypeClient(rs.getString(6)); 
				e.setAdresseClient(rs.getString(7)); 
				e.setSpecialiteClient(rs.getString(8)); 
				list.add(e); 
				} 
				con.close(); 
				}catch(Exception e){e.printStackTrace();} 
					return list; 
			} 
		} 
