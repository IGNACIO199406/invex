package com.invex.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invex.app.entity.Bitacora;

@Repository
public interface BitacoraRepository extends CrudRepository<Bitacora, Integer>{

}
