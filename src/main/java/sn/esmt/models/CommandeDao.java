package sn.esmt.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class CommandeDao {
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
	
		 public static int save(Commande e){ 
			 int status=0;	 
			 try{ 
				 Connection con=PanierDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into commande(idCmd,idProd,codeCmd,codeProd,nomProd,categorieProd,qtiteProd, prixUnitaire, dateFab, dateExp, typeCmd, dateCmd) values (?,?,?,?,?,?,?,?,?,?,?,?)"); 
				 ps.setInt(1, e.getIdCmd());
				 ps.setInt(2, e.getIdProd());
				 ps.setInt(3, e.getCodeCmd());
				 ps.setInt(4, e.getCodeProd()); 
				 ps.setString(5, e.getNomProd());  
				 ps.setString(6, e.getCategorieProd()); 
				 ps.setInt(7,    e.getQtiteProd());
				 ps.setDouble(8, e.getPrixUnitaire());
				 ps.setDate(9,(Date)  e.getDateFab());
				 ps.setDate(10,(Date) e.getDateExp());
				 ps.setString(11, e.getTypeCmd());
				 ps.setDate(12, (Date)e.getDateCmd());
				 
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 }
		 
		 public static int update(Commande e){ 
			 int status=0; 
			 try{ 
				 Connection con=ProduitDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "update commande set typeCmd=?  where idCmd=?"); 
				 ps.setString(1, e.getTypeCmd());
				 ps.setInt(2, e.getIdCmd());
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			}
			return status; 
		}
		 
		 public static Commande getCommandeById(int id){ 
				Commande e=new Commande(); 
				try{ 
					Connection con=CommandeDao.getConnection(); 
					PreparedStatement ps=con.prepareStatement("select * from commande where idCmd=?"); 
					ps.setInt(1,id); 
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						e.setIdCmd(rs.getInt(1));
						e.setIdProd(rs.getInt(2));
						e.setCodeCmd(rs.getInt(3));
						e.setCodeProd(rs.getInt(4));
						e.setNomProd(rs.getString(5)); 
						e.setCategorieProd(rs.getString(6));
						e.setQtiteProd(rs.getInt(7)); 
						e.setPrixUnitaire(rs.getDouble(8)); 
						e.setDateFab(rs.getDate(9));
						e.setDateExp(rs.getDate(10));
						e.setTypeCmd(rs.getString(11));
						e.setDateCmd(rs.getDate(12));
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
					 PreparedStatement ps=con.prepareStatement("delete from commande where idCmd=?"); 
					 ps.setInt(1,id); 
					 status=ps.executeUpdate(); 
					 con.close(); 
				  }catch(Exception e){e.printStackTrace();} 
					 return status; 
				 } 
			
			public static List<Commande> getAllCommandes(){ 
				List<Commande> list=new ArrayList<Commande>(); 
				try{ 
					Connection con=CommandeDao.getConnection(); 
					PreparedStatement ps=con.prepareStatement("select * from commande"); 
					ResultSet rs=ps.executeQuery(); 
					while(rs.next()){ 
						Commande e=new Commande();
						e.setIdCmd(rs.getInt(1));
						e.setIdProd(rs.getInt(2));
						e.setCodeCmd(rs.getInt(3));
						e.setCodeProd(rs.getInt(4));
						e.setNomProd(rs.getString(5)); 
						e.setCategorieProd(rs.getString(6));
						e.setQtiteProd(rs.getInt(7)); 
						e.setPrixUnitaire(rs.getDouble(8)); 
						e.setDateFab(rs.getDate(9));
						e.setDateExp(rs.getDate(10));
						e.setTypeCmd(rs.getString(11));
						e.setDateCmd(rs.getDate(12));
						list.add(e); 
					} 
						con.close(); 
					}catch(Exception e){e.printStackTrace();} 
						return list; 
				} 
		
}
