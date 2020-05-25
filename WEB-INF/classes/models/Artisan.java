package models;

public class Artisan extends Utilisateur {

	public Artisan(int idUtilisateur, String loginUtilisateur, String mdpUtilisateur, String typeUtilisateur,
			String mailUtilisateur, int telUtilisateur, int codePostalUtilisateur, String villeUtilisateur,
			String adresseUtilisateur, int idArtisan, String denominationEntrepriseArtisan, String secteurArtian,
			String numSiretArtisan, int idUtilisateurArtisan) {
		super(idUtilisateur, loginUtilisateur, mdpUtilisateur, typeUtilisateur, mailUtilisateur, telUtilisateur,
				codePostalUtilisateur, villeUtilisateur, adresseUtilisateur);
		this.idArtisan = idArtisan;
		this.denominationEntrepriseArtisan = denominationEntrepriseArtisan;
		this.secteurArtian = secteurArtian;
		this.numSiretArtisan = numSiretArtisan;
		this.idUtilisateurArtisan = idUtilisateurArtisan;
	}
	
	private int idArtisan;
	private String denominationEntrepriseArtisan;
	private String secteurArtian;
	private String numSiretArtisan;
	private int idUtilisateurArtisan;
	
	@Override
	public Object[] data() {
		Object[] data = new Object[13];
		data[0] = getIdUtilisateur();
		data[1] = getLoginUtilisateur();
		data[2] = getMdpUtilisateur();
		data[3] = getTypeUtilisateur();
		data[4] = getMailUtilisateur();
		data[5] = getTelUtilisateur();
		data[6] = getCodePostalUtilisateur();
		data[7] = getVilleUtilisateur();
		data[8] = getAdresseUtilisateur();
		data[9] = idArtisan;
		data[10] = denominationEntrepriseArtisan;
		data[11] = secteurArtian;
		data[12] = numSiretArtisan;
		return data;
	}
	
	
	
}
