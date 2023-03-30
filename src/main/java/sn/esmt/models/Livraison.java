package sn.esmt.models;

import java.sql.Date;

public class Livraison {
	private int idLiv;
	private int codeLiv;
	private int codeCmd;
	private Date dateLiv;
	
	public Livraison() {
		
	}
	
	public Livraison(int codeLiv, Date dateLiv) {
		this.codeLiv = codeLiv;
		this.dateLiv = dateLiv;
	}
	
	public int getCodeLiv() {
		return codeLiv;
	}
	
	public void setCodeLiv(int codeLiv) {
		this.codeLiv = codeLiv;
	}
	
	public Date getDateLiv() {
		return dateLiv;
	}
	
	public void setDateLiv(Date dateLiv) {
		this.dateLiv = dateLiv;
	}

	public int getCodeCmd() {
		return codeCmd;
	}

	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}

	public int getIdLiv() {
		return idLiv;
	}

	public void setIdLiv(int idLiv) {
		this.idLiv = idLiv;
	}
	
}
