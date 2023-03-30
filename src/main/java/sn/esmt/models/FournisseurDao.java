package sn.esmt.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDao {
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
	
		 public static int save1(Fournisseur e){ 
			 int status=0; 
			 try{ 
				 Connection con=FournisseurDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into fournisseur(id,login,password,profil, codeFour,nomFour, adresseFour, nationalityFour) values (?,?,?,?,?,?,?,?)"); 
				 ps.setInt(1, e.getId());
				 ps.setString(2,e.getLogin()); 
				 ps.setString(3,e.getPassword()); 
				 ps.setString(4,e.getProfil());
				 ps.setInt(5, e.getCodeFour());
				 ps.setString(6,e.getNomFour());
				 ps.setString(7,e.getAdresseFour());
				 ps.setString(8,e.getNationalityFour());
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 } 
		 
		 public static int update(Fournisseur e){ 
		 int status=0; 
		 try{ 
			 Connection con=FournisseurDao.getConnection(); 
			 PreparedStatement ps=con.prepareStatement( "update fournisseur set login=?, password=?, profil=?, codeFour=?, nomFour=?, adresseFour=?, nationalityFour=? where idC=?"); 
			 ps.setInt(8, e.getId());
			 ps.setInt(1, e.getCodeFour());
			 ps.setString(2,e.getLogin()); 
			 ps.setString(3,e.getPassword()); 
			 ps.setString(4,e.getProfil()); 
			 ps.setString(5,e.getNomFour());
			 ps.setString(6,e.getAdresseFour());
			 ps.setString(7,e.getNationalityFour());; 
			 status=ps.executeUpdate(); 
			 con.close(); 
		 }catch(Exception ex){
			 ex.printStackTrace();
		}
		return status; 
	}
		 
		 
		public static Fournisseur getFournisseurById(int id){ 
			Fournisseur e=new Fournisseur(); 
			try{ 
				Connection con=FournisseurDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from fournisseur where id=?"); 
				ps.setInt(1,id); 
				ResultSet rs=ps.executeQuery();
				if(rs.next()){ 
					e.setId(rs.getInt(1));
					e.setLogin(rs.getString(2));
					e.setPassword(rs.getString(3));
					e.setProfil(rs.getString(4));
					e.setCodeFour(rs.getInt(5));
					e.setNomFour(rs.getString(6)); 
					e.setAdresseFour(rs.getString(7));
					e.setNationalityFour(rs.getString(8));
					} 
					 con.close(); 
				}catch(Exception ex){
					 ex.printStackTrace();
				} 
				 return e; 
			} 
		public static List<Fournisseur> getAllFournisseurs(){ 
			List<Fournisseur> list=new ArrayList<Fournisseur>(); 
			try{ 
				Connection con=FournisseurDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from client"); 
				ResultSet rs=ps.executeQuery(); 
				while(rs.next()){ 
				Fournisseur e=new Fournisseur(); 
				e.setId(rs.getInt(1));
				e.setLogin(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setProfil(rs.getString(4));
				e.setCodeFour(rs.getInt(5));
				e.setNomFour(rs.getString(6)); 
				e.setAdresseFour(rs.getString(7));
				e.setNationalityFour(rs.getString(8));
				list.add(e); 
				} 
				con.close(); 
				}catch(Exception e){e.printStackTrace();} 
					return list; 
			} 
		} 


