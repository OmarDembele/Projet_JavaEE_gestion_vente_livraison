package sn.esmt.models;

public class Utilisateur {
	private int id;
	protected String login;
	protected String password;
	protected String profil;
	
	public Utilisateur(int id, String login, String password, String profil) {
		this.id=id;
		this.login = login;
		this.password = password;
		this.profil = profil;
	}
	
	public Utilisateur(String login, String password, String profil) {
		this.login = login;
		this.password = password;
		this.profil = profil;
	}
	
	public Utilisateur() {

	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
