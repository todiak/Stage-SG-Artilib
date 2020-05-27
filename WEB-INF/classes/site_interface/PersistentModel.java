package site_interface;

public interface PersistentModel {

	Utilisateur getUser(String mail, String mdp);
	boolean existUser(String mail);
	void addUser(String type, Object...objects);
}
   