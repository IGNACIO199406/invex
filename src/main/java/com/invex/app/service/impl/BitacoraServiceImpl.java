package com.invex.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invex.app.entity.Bitacora;
import com.invex.app.model.ResponseGeneric;
import com.invex.app.model.ResponseMetodos;
import com.invex.app.repository.BitacoraRepository;
import com.invex.app.service.BitacoraService;

@Service
public class BitacoraServiceImpl implements BitacoraService {

	
	@Autowired
	BitacoraRepository repository;

	@Autowired
	private ResponseMetodos responsegeneric;

	@Override
	public ResponseGeneric getAllBitacora() {

		List<Bitacora> listBitacora = (List<Bitacora>) repository.findAll();
		ResponseGeneric response = responsegeneric.selectregistros();
		response.setData(listBitacora);
		return response;
	}


	@Override
	public ResponseGeneric createBitacora(Bitacora bitacora) {
		ResponseGeneric response = responsegeneric.createregistros();
		return response;
	}

}
