package com.tutoria.manytomany02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutoria.manytomany02.entity.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Integer>{

}
