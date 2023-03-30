package sn.esmt.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao {
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
	
		 public static int save(Produit e){ 
			 int status=0; 
			 try{ 
				 Connection con=ProduitDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement( "insert into produit(idProd,codeProd,nomProd,categorieProd,qtiteProd, prixUnitaire, dateFab, dateExp) values (?,?,?,?,?,?,?,?)"); 
				 ps.setInt(1, e.getIdProd());
				 ps.setInt(2,e.getCodeProd()); 
				 ps.setString(3,e.getNomProd()); 
				 ps.setString(4,e.getCategorieProd()); 
				 ps.setInt(5,e.getQtiteProd());
				 ps.setDouble(6,e.getPrixUnitaire());
				 ps.setDate(7,(Date) e.getDateFab());
				 ps.setDate(8,(Date) e.getDateExp());
				 status=ps.executeUpdate(); 
				 con.close(); 
			 }catch(Exception ex){
				 ex.printStackTrace();
			} 
			 return status; 
		 } 
		 
		 public static int update(Produit e){ 
		 int status=0; 
		 try{ 
			 Connection con=ProduitDao.getConnection(); 
			 PreparedStatement ps=con.prepareStatement( "update produit set codeProd=?, nomProd=?, categorieProd=?, qtiteProd=?, prixUnitaire=?, dateFab=?, dateExp=? where idProd=?"); 
			 ps.setInt(8, e.getIdProd());
			 ps.setInt(1,e.getCodeProd()); 
			 ps.setString(2,e.getNomProd()); 
			 ps.setString(3,e.getCategorieProd()); 
			 ps.setInt(4,e.getQtiteProd());
			 ps.setDouble(5,e.getPrixUnitaire());
			 ps.setDate(6,(Date) e.getDateFab());
			 ps.setDate(7,(Date) e.getDateExp()); 
			 status=ps.executeUpdate(); 
			 con.close(); 
		 }catch(Exception ex){
			 ex.printStackTrace();
		}
		return status; 
	}
		 
		 
		public static Produit getProduitById(int id){ 
			Produit e=new Produit(); 
			try{ 
				Connection con=ProduitDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from produit where idProd=?"); 
				ps.setInt(1,id); 
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					e.setIdProd(rs.getInt(1));
					e.setCodeProd(rs.getInt(2));
					e.setNomProd(rs.getString(3)); 
					e.setCategorieProd(rs.getString(4));
					e.setQtiteProd(rs.getInt(5)); 
					e.setPrixUnitaire(rs.getDouble(6)); 
					e.setDateFab(rs.getDate(7));
					e.setDateExp(rs.getDate(8));
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
				 Connection con=ProduitDao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement("delete from produit where idProd=?"); 
				 ps.setInt(1,id); 
				 status=ps.executeUpdate(); 
				 con.close(); 
			  }catch(Exception e){e.printStackTrace();} 
				 return status; 
			 } 
		
		public static List<Produit> getAllProduits(){ 
			List<Produit> l=new ArrayList<Produit>(); 
			try{ 
				Connection con=ProduitDao.getConnection(); 
				PreparedStatement ps=con.prepareStatement("select * from produit"); 
				ResultSet rs=ps.executeQuery(); 
				 
				while(rs.next()){ 
					Produit e=new Produit();
					e.setIdProd(rs.getInt(1));
					e.setCodeProd(rs.getInt(2));
					e.setNomProd(rs.getString(3)); 
					e.setCategorieProd(rs.getString(4));
					e.setQtiteProd(rs.getInt(5)); 
					e.setPrixUnitaire(rs.getDouble(6)); 
					e.setDateFab(rs.getDate(7));
					e.setDateExp(rs.getDate(8)); 
					l.add(e); 
				} 
					con.close(); 
				}catch(Exception e){e.printStackTrace();} 
					return l; 
			} 
}
