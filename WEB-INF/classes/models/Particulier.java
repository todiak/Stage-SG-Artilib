package models;

public class Particulier extends UtilisateurData {
	private int idParticulier;
	private String nomParticulier; 
	private String prenomParticulier;
	
	public Particulier(int idUtilisateur, String mdpUtilisateur, String typeUtilisateur,
			String mailUtilisateur, int telUtilisateur, int codePostalUtilisateur, String villeUtilisateur,
			String adresseUtilisateur, int idParticulier, String nomParticulier, String prenomParticulier) {
		super(idUtilisateur, mdpUtilisateur, typeUtilisateur, mailUtilisateur, telUtilisateur,
				codePostalUtilisateur, villeUtilisateur, adresseUtilisateur);
		
		this.idParticulier = idParticulier;
		this.nomParticulier = nomParticulier;
		this.prenomParticulier = prenomParticulier;
	}  

	@Override
	public Object[] data() {
		Object[] data = new Object[11];
		data[0] = getIdUtilisateur();
		data[1] = getMdpUtilisateur();
		data[2] = getTypeUtilisateur();
		data[3] = getMailUtilisateur();
		data[4] = getTelUtilisateur();
		data[5] = getCodePostalUtilisateur();
		data[6] = getVilleUtilisateur();
		data[7] = getAdresseUtilisateur();
		data[8] = idParticulier;
		data[9] = nomParticulier;
		data[10] = prenomParticulier;
		return data;
	}


}
