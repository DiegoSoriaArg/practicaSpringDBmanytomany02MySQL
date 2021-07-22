package com.tutoria.manytomany02.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SubscripcionID implements Serializable {
	
	private int idUser;
	
	private int idCanal;

	public SubscripcionID() {
	}

	public SubscripcionID(int idUser, int idCanal) {
		this.idUser = idUser;
		this.idCanal = idCanal;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}
	

}
