package com.tutoria.manytomany02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutoria.manytomany02.entity.Canal;
import com.tutoria.manytomany02.entity.Subscripcion;
import com.tutoria.manytomany02.entity.Usuario;



@Repository
public interface SubscripcionRepository extends JpaRepository<Subscripcion, Integer> {
	
	boolean existsByUsuarioAndCanal(Usuario usuario, Canal canal);

}
