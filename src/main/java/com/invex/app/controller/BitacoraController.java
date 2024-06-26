package com.invex.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.invex.app.config.LogPattern;
import com.invex.app.entity.Empleado;
import com.invex.app.model.IdsModel;
import com.invex.app.model.SuccessResponses;
import com.invex.app.service.BitacoraService;
import com.invex.app.service.EmpleadoService;
import com.invex.app.util.Constants;

@RestController
@RequestMapping(path = "/bitacora")
public class BitacoraController implements ErrorController, WebMvcConfigurer {

	private static final Logger LOGGER = LogManager.getLogger(BitacoraController.class);
	private final LogPattern logPattern = new LogPattern(Constants.domainCode, Constants.solutioNameCode,
			Constants.platform, Constants.tower, this.getClass().getName());
	private final String lHeaders=" headers= ";
	private final String lUrl=" InfoUrl= ";
	private final String lBody=" body= ";
	@Autowired
	BitacoraService service;
	
      
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBitacoras(@RequestHeader(required = false) Map<?,?> headers) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Long startTime = System.currentTimeMillis();
		String idTransaction = String.valueOf(startTime);
        LOGGER.info(logPattern.buildPattern(methodName, idTransaction,lHeaders+headers.toString(), null,
				startTime));
        return SuccessResponses.ok(service.getAllBitacora());
    }
        
}
