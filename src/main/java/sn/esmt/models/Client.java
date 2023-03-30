package sn.esmt.models;

public class Client extends Utilisateur{
	private int idClient;
	private String nomClient;
	private String typeClient;
	private String adresseClient;
	private String specialiteClient;
	
	public Client() {
		
	}
	
	public Client(String login, String password, String profil) {
		super(login, password, profil);	
	}

	public Client(String login, String password, String profil,int idClient, String nomClient,String typeClient, String adresseClient, String specialiteClient) {
		super(login, password, profil);
		this.idClient=idClient;
		this.nomClient=nomClient;
		this.typeClient=typeClient;
		this.adresseClient=adresseClient;
		this.specialiteClient=specialiteClient;
	}
	
	public Client(String login, String password, String profil, String nomClient,String typeClient, String adresseClient, String specialiteClient) {
		super(login, password, profil);
		this.nomClient=nomClient;
		this.typeClient=typeClient;
		this.adresseClient=adresseClient;
		this.specialiteClient=specialiteClient;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getSpecialiteClient() {
		return specialiteClient;
	}

	public void setSpecialiteClient(String specialiteClient) {
		this.specialiteClient = specialiteClient;
	}
	
	
}
