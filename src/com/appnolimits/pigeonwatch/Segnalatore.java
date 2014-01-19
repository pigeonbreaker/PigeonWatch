package com.appnolimits.pigeonwatch;

public class Segnalatore {
	private long _id;
	private String tipo;
	private String latitude;
	private String longitude;
	private byte[] image;
	
	public Segnalatore() {
	}

	public Segnalatore(String tipo1, String lat, String lng, byte[] image) {
		this.setTipo(tipo1);
		this.setLatitude(lat);
		this.setLongitude(lng);
		this.setImage(image);
		
	}
	
	public Segnalatore(long id, String tipo1, String lat, String lng, byte[] image) {
		this._id = id;
		this.setTipo(tipo1);
		this.setLatitude(lat);
		this.setLongitude(lng);
		this.setImage(image);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
