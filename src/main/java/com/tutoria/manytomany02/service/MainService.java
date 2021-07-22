package com.tutoria.manytomany02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoria.manytomany02.entity.Canal;
import com.tutoria.manytomany02.entity.Subscripcion;
import com.tutoria.manytomany02.entity.SubscripcionID;
import com.tutoria.manytomany02.entity.Usuario;
import com.tutoria.manytomany02.repository.CanalRepository;
import com.tutoria.manytomany02.repository.SubscripcionRepository;
import com.tutoria.manytomany02.repository.UsuarioRepository;

@Service
@Transactional
public class MainService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	CanalRepository canalRepository;
	
	@Autowired
	SubscripcionRepository subscripcionRepository;
	
	public void createSub(int idUser, int idCanal) {
		Usuario usuario = usuarioRepository.findById(idUser).get();
		Canal canal = canalRepository.findById(idCanal).get();
		SubscripcionID id = new SubscripcionID(idUser, idCanal);
		Subscripcion subscripcion = new Subscripcion(id, usuario, canal);
		subscripcionRepository.save(subscripcion);
	}
	
	public void deleteUser(int id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.getSubs().stream().forEach(s -> subscripcionRepository.delete(s));
		usuarioRepository.delete(usuario);
	}
	
	public void deleteCanal(int id) {
		Canal canal = canalRepository.findById(id).get();
		canal.getSubs().stream().forEach(s -> subscripcionRepository.delete(s));
		canalRepository.delete(canal);
	}
	
	public boolean existUserAndCanal(int idUser, int idCanal) {
		return usuarioRepository.existsById(idUser) && canalRepository.existsById(idCanal);
	}
	
	public boolean existSub(int idUser, int idCanal) {
		Usuario usuario = usuarioRepository.findById(idUser).get();
		Canal canal = canalRepository.findById(idCanal).get();
		return subscripcionRepository.existsByUsuarioAndCanal(usuario, canal);
	}

}
