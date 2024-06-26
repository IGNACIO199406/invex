package com.invex.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invex.app.entity.Bitacora;
import com.invex.app.entity.Empleado;
import com.invex.app.excepcion.ResourceNotFoundException;
import com.invex.app.model.IdsModel;
import com.invex.app.model.ResponseGeneric;
import com.invex.app.model.ResponseMetodos;
import com.invex.app.repository.BitacoraRepository;
import com.invex.app.repository.EmpleadoRepository;
import com.invex.app.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository repository;
	
	@Autowired
	BitacoraRepository repositoryBitacora;

	@Autowired
	private ResponseMetodos responsegeneric;
	
	private final String tabla="empleado";
	
	@Override
	public ResponseGeneric getAllEmpleados() {

		List<Empleado> listEmpleados = (List<Empleado>) repository.findAll();
		ResponseGeneric response = responsegeneric.selectregistros();
		if(listEmpleados.isEmpty()) {
			throw new ResourceNotFoundException("No hay registros");
		}else{
			Bitacora bitacora = new Bitacora();
			bitacora.setAccion("SelectAll");
			bitacora.setTabla(tabla);
			repositoryBitacora.save(bitacora);
			response.setData(listEmpleados);
		}

		return response;
	}

	@Override
	public ResponseGeneric getEmpleadoById(Integer empleadoId) {
		Optional<Empleado> empleado = repository.findById(empleadoId);
		
		System.out.println(empleado);
		ResponseGeneric response = responsegeneric.selectregistro();
		if(empleado.isEmpty()) {
			throw new ResourceNotFoundException("El registro no existe");
		}else{
			System.out.println(empleado);
			Bitacora bitacora = new Bitacora();
			bitacora.setAccion("SelectById");
			bitacora.setTabla(tabla);
			bitacora.setDescripcion(empleadoId.toString());
			repositoryBitacora.save(bitacora);
			response.setData(empleado);
		}

		return response;
	}

	@Override
	public ResponseGeneric createEmpleado(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			repository.save(empleado);
		}
		Bitacora bitacora = new Bitacora();
		bitacora.setAccion("CreateMasivo");
		bitacora.setTabla(tabla);
		bitacora.setDescripcion(empleados.toString());
		repositoryBitacora.save(bitacora);
		ResponseGeneric response = responsegeneric.createregistros();
		return response;
	}

	@Override
	public ResponseGeneric updateAllEmpleado(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			repository.save(empleado);
		}
		Bitacora bitacora = new Bitacora();
		bitacora.setAccion("updateMasivo");
		bitacora.setTabla(tabla);
		bitacora.setDescripcion(empleados.toString());
		repositoryBitacora.save(bitacora);
		ResponseGeneric response = responsegeneric.updatectregistros();
		return response;
	}

	@Override
	public ResponseGeneric deleteAllEmpleado(List<IdsModel> empleados) {
		for (IdsModel empleado : empleados) {
			repository.deleteById(empleado.getId());
		}
		Bitacora bitacora = new Bitacora();
		bitacora.setAccion("DeleteMasivo");
		bitacora.setTabla(tabla);
		bitacora.setDescripcion(empleados.toString());
		repositoryBitacora.save(bitacora);
		ResponseGeneric response = responsegeneric.deleteregistros();
		return response;
	}

	@Override
	public ResponseGeneric updateEmpleado(Integer empleadoId, Empleado empleado) {
		empleado.setId(empleadoId);
		repository.save(empleado);
		Bitacora bitacora = new Bitacora();
		bitacora.setAccion("update");
		bitacora.setTabla(tabla);
		bitacora.setDescripcion(empleado.toString());
		repositoryBitacora.save(bitacora);
		ResponseGeneric response = responsegeneric.updateregistro();
		return response;
	}

	@Override
	public ResponseGeneric deleteEmpleado(Integer empleadoId) {
		repository.deleteById(empleadoId);
		Bitacora bitacora = new Bitacora();
		bitacora.setAccion("delete");
		bitacora.setTabla(tabla);
		bitacora.setDescripcion(empleadoId.toString());
		repositoryBitacora.save(bitacora);
		ResponseGeneric response = responsegeneric.deleteregistro();
		return response;
	}

}
