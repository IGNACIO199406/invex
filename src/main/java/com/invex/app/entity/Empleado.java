package com.invex.app.entity;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

 
@Data
@Table("empleado")
public class Empleado {
	@Id
	@Column
	private Integer id;
	@Column
	private String nombre1;
	@Column
	private String nombre2;
	@Column
	private String apellidom;
	@Column
	private String apellidop;
	@Column
	private Integer edad;
	@Column
	private Integer sexo;
	@Column
	private Integer puesto;
	@Column
	private Date fechanacimiento;
	
	
}
