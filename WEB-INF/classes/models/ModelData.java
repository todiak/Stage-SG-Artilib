package models;

import java.sql.Connection;
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
	   
	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	
	public Utilisateur getUser(String mail, String mdp) {
	
		String reqGetUser = "SELECT * FROM utilisateur WHERE MailUti = ? AND MdpUti = ? ";

		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de donn�es
			PreparedStatement stmtGetUser = conn.prepareStatement(reqGetUser);
			
			// On affecte les param�tres de la requ�te
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

	@Override
	public boolean existUser(String mail) {
		// TODO Auto-generated method stub
		String reqExistUser = "SELECT * FROM utilisateur WHERE MailUti = ?";
		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de donn�es
			PreparedStatement stmtGetUser = conn.prepareStatement(reqExistUser);
			
			// On affecte les param�tres de la requ�te
			stmtGetUser.setString(1, mail);	
			
			ResultSet resUser = stmtGetUser.executeQuery();
			
			if(resUser.next())
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void addUser(String type, Object... objects) {
		// TODO Auto-generated method stub
		String reqAddUser = "INSERT INTO utilisateur(MdpUti,TypeUti,MailUti,TelUti,CodepostaleUti,VilleUti,AdresseUti) VALUES (?,?,?,?,?,?,?)";
		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de donn�es
			PreparedStatement stmtGetUser = conn.prepareStatement(reqAddUser);
			
			// On affecte les param�tres de la requ�te
			stmtGetUser.setObject(1, objects[2]);	
			stmtGetUser.setObject(2, type);
			stmtGetUser.setObject(3, objects[3]);
			stmtGetUser.setObject(4, objects[4]);
			stmtGetUser.setObject(5, objects[5]);
			stmtGetUser.setObject(6, objects[6]);
			stmtGetUser.setObject(7, objects[7]);
			
			stmtGetUser.executeUpdate();
			
			
			
			if(type.equals("part")) {

				
				String reqIdUser = "SELECT IdUti FROM utilisateur WHERE MailUti=?";
				
				PreparedStatement stmtIdUser = conn.prepareStatement(reqIdUser);
				
				String mail = objects[3].toString();
				stmtIdUser.setString(1, mail);
				
				ResultSet resIdUser = stmtIdUser.executeQuery();
				
				if(resIdUser.next()) {
					System.out.print(objects[5]);
					
					int idUser = resIdUser.getInt("IdUti");
					
					String reqAddPart = "INSERT INTO particulier(NomPart,PrenomPart,IdUti) VALUES (?,?,?)";
					PreparedStatement stmtAddPart = conn.prepareStatement(reqAddPart);
					
					
					stmtAddPart.setString(1, objects[0].toString());
					stmtAddPart.setString(2, objects[1].toString());
					stmtAddPart.setInt(3, idUser);
					
					stmtAddPart.executeUpdate();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	


}