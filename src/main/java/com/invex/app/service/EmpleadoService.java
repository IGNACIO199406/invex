package com.invex.app.service;

import java.util.List;

import com.invex.app.entity.Empleado;
import com.invex.app.model.IdsModel;
import com.invex.app.model.ResponseGeneric;

public interface EmpleadoService {
    public ResponseGeneric getAllEmpleados();
    public ResponseGeneric getEmpleadoById(Integer empleadoId);
    public ResponseGeneric createEmpleado(List<Empleado> empleados);
    public ResponseGeneric updateAllEmpleado(List<Empleado> empleados);
    public ResponseGeneric deleteAllEmpleado(List<IdsModel> empleados);
    public ResponseGeneric updateEmpleado(Integer empleadoId, Empleado empleados);
    public ResponseGeneric deleteEmpleado(Integer empleadoId);
}
