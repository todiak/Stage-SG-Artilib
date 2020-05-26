package models;

public class Particulier extends Utilisateur {
	private int idParticulier;
	private String nomParticulier; 
	private String prenomParticulier;
	
	public Particulier(int idUtilisateur, String loginUtilisateur, String mdpUtilisateur, String typeUtilisateur,
			String mailUtilisateur, int telUtilisateur, int codePostalUtilisateur, String villeUtilisateur,
			String adresseUtilisateur, int idParticulier, String nomParticulier, String prenomParticulier) {
		super(idUtilisateur, loginUtilisateur, mdpUtilisateur, typeUtilisateur, mailUtilisateur, telUtilisateur,
				codePostalUtilisateur, villeUtilisateur, adresseUtilisateur);
		// TODO Auto-generated constructor stub
		
		this.idParticulier = idParticulier;
		this.nomParticulier = nomParticulier;
		this.prenomParticulier = prenomParticulier;
	}

	@Override
	public Object[] data() {
		// TODO Auto-generated method stub
		Object[] data = new Object[12];
		data[0] = getIdUtilisateur();
		data[1] = getLoginUtilisateur();
		data[2] = getMdpUtilisateur();
		data[3] = getTypeUtilisateur();
		data[4] = getMailUtilisateur();
		data[5] = getTelUtilisateur();
		data[6] = getCodePostalUtilisateur();
		data[7] = getVilleUtilisateur();
		data[8] = getAdresseUtilisateur();
		data[9] = idParticulier;
		data[10] = nomParticulier;
		data[11] = prenomParticulier;
		return data;
	}

}
