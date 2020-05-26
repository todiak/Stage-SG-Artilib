package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import site_interface.Model;
import site_interface.PersistentModel;
import site_interface.Utilisateur;

public class ModelData implements PersistentModel {

	static {
		Model.getInstance().setData(new ModelData());
		AccesBD bd = new AccesBD();
	}
	
	private ModelData() {
		
	}
	
	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	
	public Utilisateur getUser(String mail, String mdp) {
	
		String reqGetUser = "SELECT * FROM utilisateur WHERE MailUti = ? AND MdpUti = ? ";

		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de données
			PreparedStatement stmtGetUser = conn.prepareStatement(reqGetUser);
			
			// On affecte les paramètres de la requête
			stmtGetUser.setString(1, mail);	
			stmtGetUser.setString(2, mdp);
			
			ResultSet resUser = stmtGetUser.executeQuery();
			
			if(resUser.next()) {
				int idUtilisateur = resUser.getInt("IdUti");
				String mailUtilisateur = resUser.getString("MailUti");
				String mdpUtilisateur = resUser.getString("MdpUti");
				String typeUtilisateur = resUser.getString("TypeUti");
				int telUtilisateur = resUser.getInt("TelUti");
				int codePostalUtilisateur = resUser.getInt("CodepostaleUti");
				String villeUtilisateur = resUser.getString("VilleUti");
				String adresseUtilisateur = resUser.getString("AdresseUti");
				
				if(typeUtilisateur.equals("arti")) {
					String reqGetArtisan = "SELECT * FROM artisan WHERE IdUti = ? ";
					
					PreparedStatement stmtGetArtisan = conn.prepareStatement(reqGetArtisan);
					
					stmtGetArtisan.setInt(1, idUtilisateur);
					
					ResultSet resArtisan = stmtGetArtisan.executeQuery();
					
					if(resArtisan.next()) {
						int idArtisan = resArtisan.getInt("IdArti");
						String denominationEntrepriseArtisan = resArtisan.getString("DenominationEntrepriseArti");
						String secteurArtisan = resArtisan.getString("SecteurArti");
						String numSiretArtisan = resArtisan.getString("NumSiretArti");
						
						return new Artisan(idUtilisateur, mdpUtilisateur, typeUtilisateur, mailUtilisateur, telUtilisateur, codePostalUtilisateur,
								villeUtilisateur, adresseUtilisateur, idArtisan, denominationEntrepriseArtisan, secteurArtisan, numSiretArtisan);
					}
				}
				else {
					String reqGetParticulier = "SELECT * FROM particulier WHERE IdUti = ? ";
					
					PreparedStatement stmtGetParticulier = conn.prepareStatement(reqGetParticulier);
					
					stmtGetParticulier.setInt(1, idUtilisateur);
					
					ResultSet resParticulier = stmtGetParticulier.executeQuery();
					
					if(resParticulier.next()) {
						int idParticulier = resParticulier.getInt("IdPart");
						String nomParticulier = resParticulier.getString("NomPart");
						String prenomParticulier = resParticulier.getString("PrenomPart");
						
						return new Particulier(idUtilisateur, mdpUtilisateur, typeUtilisateur, mailUtilisateur, telUtilisateur, codePostalUtilisateur,
								villeUtilisateur, adresseUtilisateur, idParticulier, nomParticulier, prenomParticulier);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	


}