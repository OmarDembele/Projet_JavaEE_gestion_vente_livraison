package sn.esmt.models;

import java.util.Date;

public class Commande {
	private int idCmd;
	private int idProd;
	private int codeCmd;
	private int codeProd;
	private String nomProd;
	private String categorieProd;
	private int qtiteProd;
	private double prixUnitaire;
	private Date dateFab;
	private Date dateExp;
	private String typeCmd;
	private Date dateCmd;
	
	public Commande() {
		
	}
	
	public Commande(int idProd, int codeProd, String nomProd, String categorieProd, int qtiteProd, double prixUnitaire, Date dateFab,
			Date dateExp) {
		this.setIdProd(idProd);
		this.codeProd = codeProd;
		this.nomProd = nomProd;
		this.categorieProd = categorieProd;
		this.qtiteProd = qtiteProd;
		this.prixUnitaire = prixUnitaire;
		this.dateFab = dateFab;
		this.dateExp = dateExp;
	}
	
	public Commande(int codeProd, String nomProd, String categorieProd, int qtiteProd, double prixUnitaire, Date dateFab,
			Date dateExp) {
		this.codeProd = codeProd;
		this.nomProd = nomProd;
		this.categorieProd = categorieProd;
		this.qtiteProd = qtiteProd;
		this.prixUnitaire = prixUnitaire;
		this.dateFab = dateFab;
		this.dateExp = dateExp;
	}
	public int getCodeProd() {
		return codeProd;
	}
	public void setCodeProd(int codeProd) {
		this.codeProd = codeProd;
	}
	
	public String getNomProd() {
		return nomProd;
	}
	
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public String getCategorieProd() {
		return categorieProd;
	}
	public void setCategorieProd(String categorieProd) {
		this.categorieProd = categorieProd;
	}
	public int getQtiteProd() {
		return qtiteProd;
	}
	public void setQtiteProd(int qtiteProd) {
		this.qtiteProd = qtiteProd;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Date getDateFab() {
		return dateFab;
	}
	public void setDateFab(Date dateFab) {
		this.dateFab = dateFab;
	}
	public Date getDateExp() {
		return dateExp;
	}
	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getCodeCmd() {
		return codeCmd;
	}

	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}

	public String getTypeCmd() {
		return typeCmd;
	}

	public void setTypeCmd(String typeCmd) {
		this.typeCmd = typeCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}
	
	

}
