package site_interface;

public class Model {

	private static Model instance = new Model();
	private PersistentModel data; 
	
	public void setData(PersistentModel data) {   
		if (this.data == null) this.data = data;  
	}
	
	public Utilisateur getUser(String mail, String mdp) {
		return this.data.getUser(mail, mdp);  
	}

	public static Model getInstance() {
		return instance;
	}
}
