package com.invex.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invex.app.entity.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{

}
