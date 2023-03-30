package sn.esmt.models;

import java.util.ArrayList;
import java.util.List;

public class Fournisseur extends Utilisateur{
	private int id;
	private int codeFour;
	private String nomFour;
	private String adresseFour;
	private String nationalityFour;
	private List<Produit> produitsFournis;
	
	public Fournisseur() {
		
	}
	
	public Fournisseur(int id, String login, String password, String profil,int codeFour,String nomFour,String adresseFour,String nationalityFour) {
		super(login, password, profil);
		this.id=id;
		this.codeFour=codeFour;
		this.nomFour=nomFour;
		this.adresseFour=adresseFour;
		this.nationalityFour=nationalityFour;
		this.produitsFournis = new ArrayList<>();
	}
	
	public Fournisseur(String login, String password, String profil,int codeFour,String nomFour,String adresseFour,String nationalityFour) {
		super(login, password, profil);
		this.codeFour=codeFour;
		this.nomFour=nomFour;
		this.adresseFour=adresseFour;
		this.nationalityFour=nationalityFour;
		this.produitsFournis = new ArrayList<>();
	}
	
    public void ajouterProduit(Produit produit) {
        produitsFournis.add(produit);
    }

    public void retirerProduit(Produit produit) {
        produitsFournis.remove(produit);
    }

	public int getCodeFour() {
		return codeFour;
	}

	public void setCodeFour(int codeFour) {
		this.codeFour = codeFour;
	}

	public String getNomFour() {
		return nomFour;
	}

	public void setNomFour(String nomFour) {
		this.nomFour = nomFour;
	}

	public String getAdresseFour() {
		return adresseFour;
	}

	public void setAdresseFour(String adresseFour) {
		this.adresseFour = adresseFour;
	}

	public String getNationalityFour() {
		return nationalityFour;
	}

	public void setNationalityFour(String nationalityFour) {
		this.nationalityFour = nationalityFour;
	}
	
	public List<Produit> getProduitsFournis() {
        return produitsFournis;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduitsFournis(List<Produit> produitsFournis) {
		this.produitsFournis = produitsFournis;
	}
	
	
	
}
