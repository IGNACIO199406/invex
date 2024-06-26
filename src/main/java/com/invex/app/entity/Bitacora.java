package com.invex.app.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

 
@Data
@Table("bitacora")
public class Bitacora {
	@Id
	@Column
	private Integer id;
	@Column
	private String tabla;
	@Column
	private String accion;
	@Column
	private String descripcion;
		
	
}
