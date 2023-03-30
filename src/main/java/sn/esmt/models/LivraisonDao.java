package sn.esmt.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivraisonDao {
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
	
		 public static int save(Livraison e){ 
			 int status=0;	 
			 try{ 
				 Connection con=LivraisonDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into livraison(idLiv,codeLiv,codeCmd,dateLiv) values (?,?,?,?)"); 
				 ps.setInt(1, e.getIdLiv());
				 ps.setInt(2, e.getCodeLiv());
				 ps.setInt(3, e.getCodeCmd());
				 ps.setDate(4, (Date) e.getDateLiv()); 
				 
				 
				 status=ps.executeUpdate();  
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 }
		 
		 public static Livraison getLivraisonById(int id){ 
				Livraison e=new Livraison(); 
				try{ 
					Connection con=LivraisonDao.getConnection(); 
					PreparedStatement ps=con.prepareStatement("select * from livraison where idCmd=?"); 
					ps.setInt(1,id); 
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						e.setIdLiv(rs.getInt(1));
						e.setCodeLiv(rs.getInt(2));
						e.setCodeCmd(rs.getInt(3));
						e.setDateLiv(rs.getDate(4));
						} 
						 con.close(); 
					}catch(Exception ex){
						 ex.printStackTrace();
					} 
					 return e; 
				}
			
			 public static int delete(int id){ 
				 int status=0; 
				 try{ 
					 Connection con=CommandeDao.getConnection(); 
					 PreparedStatement ps=con.prepareStatement("delete from livraison where idLiv=?"); 
					 ps.setInt(1,id); 
					 status=ps.executeUpdate(); 
					 con.close(); 
				  }catch(Exception e){e.printStackTrace();} 
					 return status; 
				 } 
			
			public static List<Livraison> getAllLivraisons(){ 
				List<Livraison> list=new ArrayList<Livraison>(); 
				try{ 
					Connection con=LivraisonDao.getConnection(); 
					PreparedStatement ps=con.prepareStatement("select * from livraison"); 
					ResultSet rs=ps.executeQuery(); 
					while(rs.next()){ 
						Livraison e=new Livraison();
						e.setIdLiv(rs.getInt(1));
						e.setCodeLiv(rs.getInt(2));
						e.setCodeCmd(rs.getInt(3));
						e.setDateLiv(rs.getDate(4));
						
						list.add(e); 
					} 
						con.close(); 
					}catch(Exception e){e.printStackTrace();} 
						return list; 
				} 
}
