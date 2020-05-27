package models;

public abstract class UtilisateurData implements site_interface.Utilisateur{
	
	private int idUtilisateur;
	private String mdpUtilisateur;
	private String typeUtilisateur;
	private String mailUtilisateur;
	private int telUtilisateur;
	private int codePostalUtilisateur;
	private String villeUtilisateur;
	private String adresseUtilisateur;
	  
	public UtilisateurData(int idUtilisateur, String mdpUtilisateur, String typeUtilisateur,
			String mailUtilisateur, int telUtilisateur, int codePostalUtilisateur, String villeUtilisateur,
			String adresseUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.mdpUtilisateur = mdpUtilisateur;
		this.typeUtilisateur = typeUtilisateur;
		this.mailUtilisateur = mailUtilisateur;
		this.telUtilisateur = telUtilisateur;
		this.codePostalUtilisateur = codePostalUtilisateur;
		this.villeUtilisateur = villeUtilisateur;
		this.adresseUtilisateur = adresseUtilisateur;
	}
	
	public abstract Object[] data();
	
	public boolean isArtisan() {
		if(!this.typeUtilisateur.equals("arti")) {
			return false;
		}
		return true;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public String getMailUtilisateur() {
		return mailUtilisateur;
	}

	public void setMailUtilisateur(String mailUtilisateur) {
		this.mailUtilisateur = mailUtilisateur;
	}

	public int getTelUtilisateur() {
		return telUtilisateur;
	}

	public void setTelUtilisateur(int telUtilisateur) {
		this.telUtilisateur = telUtilisateur;
	}

	public int getCodePostalUtilisateur() {
		return codePostalUtilisateur;
	}

	public void setCodePostalUtilisateur(int codePostalUtilisateur) {
		this.codePostalUtilisateur = codePostalUtilisateur;
	}

	public String getVilleUtilisateur() {
		return villeUtilisateur;
	}

	public void setVilleUtilisateur(String villeUtilisateur) {
		this.villeUtilisateur = villeUtilisateur;
	}

	public String getAdresseUtilisateur() {
		return adresseUtilisateur;
	}

	public void setAdresseUtilisateur(String adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}
}
