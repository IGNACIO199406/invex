package com.invex.app.service;

import com.invex.app.entity.Bitacora;
import com.invex.app.model.ResponseGeneric;

public interface BitacoraService {
    public ResponseGeneric getAllBitacora();
    public ResponseGeneric createBitacora(Bitacora empleados);
}
