package com.invex.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
class InvexControllerTests {
	 
	@Test
	void getAllEmpleado() throws Exception {
                get("/empleado")
                        .accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	void getAEmpleadoById() throws Exception {
                get("/empleado/id/3")
                        .accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	void deleteAllEmpleadoById() throws Exception {
                delete("/empleado")
                        .accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	void updateAllEmpleadoById() throws Exception {
                patch("/empleado")
                        .accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	void deleteEmpleadoById() throws Exception {
                delete("/empleado/id/3")
                        .accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	void updateEmpleadoById() throws Exception {
                patch("/empleado/id/3")
                        .accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	void postEmpleado() throws Exception {
                post("/empleado")
                        .accept(MediaType.APPLICATION_JSON);
	}

}
