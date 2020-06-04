package site_interface;

import java.util.List;

public interface PersistentModel {

	Utilisateur getUser(String mail, String mdp);
	boolean existUser(String mail);
	void addUser(String type, Object...objects);
	List<Utilisateur> rechercheArti(String localisation, String search);
	List<Service> serviceArti(int idArti);
	Object[] horaireArti(int idArti);
}
   