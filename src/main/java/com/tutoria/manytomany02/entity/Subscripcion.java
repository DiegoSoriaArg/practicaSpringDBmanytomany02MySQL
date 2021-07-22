package com.tutoria.manytomany02.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Subscripcion {
	
	@EmbeddedId
	private SubscripcionID subscripcionid;
	
	private int likes;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@MapsId("idUser")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "canal_id")
	@MapsId("idCanal")
	private Canal canal;

	public Subscripcion() {
	}

	public Subscripcion(SubscripcionID subscripcionid, Usuario usuario, Canal canal) {
		this.subscripcionid = subscripcionid;
		this.usuario = usuario;
		this.canal = canal;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
}
