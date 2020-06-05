package models;

import site_interface.Service;

public class ServiceArtisan implements Service {
	private int idServ;
	private String libServ;
	private double prixServ;
	private int idArti;
	
	public ServiceArtisan(int idServ, String libServ, double prixServ, int idArti) {
		this.idServ = idServ;
		this.libServ = libServ;
		this.prixServ = prixServ;
		this.idArti = idArti;
	}
	

	@Override
	public Object[] data() {
		
		Object[] data = new Object[4];
		data[0] = idServ;
		data[1] = libServ;
		data[2] = prixServ;
		data[3] = idArti;
		return data;
	}

}
