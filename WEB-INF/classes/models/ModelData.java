package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import site_interface.Model;
import site_interface.PersistentModel;
import site_interface.Service;
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
						String description = resUser.getString("Description");
						
						return new Artisan(idUtilisateur, mdpUtilisateur, typeUtilisateur, mailUtilisateur, telUtilisateur, codePostalUtilisateur,
								villeUtilisateur, adresseUtilisateur, idArtisan, denominationEntrepriseArtisan, secteurArtisan, numSiretArtisan, description);
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
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de données
			PreparedStatement stmtGetUser = conn.prepareStatement(reqExistUser);
			
			// On affecte les paramètres de la requête
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
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de données
			PreparedStatement stmtGetUser = conn.prepareStatement(reqAddUser);
			
			// On affecte les paramètres de la requête
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
	
	@Override
	public List<Utilisateur> rechercheArti(String localisation, String search) {
		List<Utilisateur> listeArti = new ArrayList<Utilisateur>();
		
		String reqRechArti = "SELECT * FROM artisan INNER JOIN utilisateur ON artisan.IdUti = utilisateur.IdUti WHERE (artisan.DenominationEntrepriseArti LIKE ? OR artisan.SecteurArti LIKE ?) AND (utilisateur.CodepostaleUti LIKE ? OR utilisateur.VilleUti LIKE ? OR utilisateur.AdresseUti LIKE ?)";

		
		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de données
			PreparedStatement stmtRechArti = conn.prepareStatement(reqRechArti);
			
			// On affecte les paramètres de la requête
			stmtRechArti.setString(1, "%" + localisation + "%");	
			stmtRechArti.setString(2, "%" + localisation + "%");
			stmtRechArti.setString(3, "%" + search + "%");
			stmtRechArti.setString(4, "%" + search + "%");
			stmtRechArti.setString(5, "%" + search + "%");
			
			ResultSet resRechArti = stmtRechArti.executeQuery();
			
			int idArti = 0;
			String denominationArti = "";
			String secteurArti = "";
			String numSiretArti = "";
			int idUti = 0;
			String mdpUti = "";
			String typeUti = "";
			String mailUti = "";
			int telUti = 0;
			int codePostalUti = 0;
			String villeUti = "";
			String adresseUti = "";
<<<<<<< HEAD
=======
			String description = "";
>>>>>>> 6715e862a4290f9a1ff25b586a21b9a6e49880f9
			
			while(resRechArti.next()) {
				idArti = resRechArti.getInt("IdArti");
				denominationArti = resRechArti.getString("DenominationEntrepriseArti");
				secteurArti = resRechArti.getString("SecteurArti");
				numSiretArti = resRechArti.getString("NumSiretArti");
				idUti = resRechArti.getInt("IdUti");
				mdpUti = resRechArti.getString("MdpUti");
				typeUti = resRechArti.getString("TypeUti");
				mailUti = resRechArti.getString("MailUti");
				telUti = resRechArti.getInt("TelUti");
				codePostalUti = resRechArti.getInt("CodepostaleUti");
				villeUti = resRechArti.getString("VilleUti");
				adresseUti = resRechArti.getString("AdresseUti");
<<<<<<< HEAD
				
				listeArti.add(new Artisan(idUti, mdpUti, typeUti, mailUti, telUti, codePostalUti, villeUti, adresseUti, idArti, denominationArti, secteurArti, numSiretArti));
=======
				description = resRechArti.getString("Description");
				
				listeArti.add(new Artisan(idUti, mdpUti, typeUti, mailUti, telUti, codePostalUti, villeUti, adresseUti, idArti, denominationArti, secteurArti, numSiretArti, description));
>>>>>>> 6715e862a4290f9a1ff25b586a21b9a6e49880f9
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeArti;
	}

	@Override
	public List<Service> serviceArti(int idArti) {
		List<Service> listeServiceArti = new ArrayList<Service>();
		
		String reqServiceArti = "SELECT * FROM service WHERE IdArti=?";
		
		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de données
			PreparedStatement stmtRechArti = conn.prepareStatement(reqServiceArti);
			
			// On affecte les paramètres de la requête
			stmtRechArti.setInt(1, idArti);	
			
			ResultSet resRechArti = stmtRechArti.executeQuery();
			
			int idServ = 0;
			String libServ = "";
			double prixServ = 0.;
			
			while(resRechArti.next()) {
				idServ = resRechArti.getInt("IdArti");
				libServ = resRechArti.getString("libServ");
				prixServ = resRechArti.getDouble("prixServ");

				listeServiceArti.add(new ServiceArtisan(idServ, libServ, prixServ, idArti));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeServiceArti;
	}

	@Override
	public Object[] horaireArti(int idArti) {
		Object[] lesHorairesArti = new Object[8];

		String reqHoraireArti = "SELECT * FROM horaire WHERE IdArti=?";
		
		try {
			Connection conn = AccesBD.connexionBD();	// Connexion a la base de données
			PreparedStatement stmtRechArti = conn.prepareStatement(reqHoraireArti);
			
			// On affecte les paramètres de la requête
			stmtRechArti.setInt(1, idArti);	

			ResultSet resRechArti = stmtRechArti.executeQuery();
			
			if(resRechArti.next()) {
				lesHorairesArti[0] = resRechArti.getString("Lundi");
				lesHorairesArti[1] = resRechArti.getString("Mardi");
				lesHorairesArti[2] = resRechArti.getString("Mercredi");
				lesHorairesArti[3] = resRechArti.getString("Jeudi");
				lesHorairesArti[4] = resRechArti.getString("Vendredi");
				lesHorairesArti[5] = resRechArti.getString("Samedi");
				lesHorairesArti[6] = resRechArti.getString("Dimanche");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lesHorairesArti;
	}


}