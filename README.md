PROYECTO JAVA INVEX

Objetivo es crear servicios rest que perminar crear actualizar y eliminar empleados
ademas de registrar en bitacora los eventos el back es con java spring boot y la base es con mysql


Base de Datos
Mysql
Url Base de datos
http://127.0.0.1/phpmyadmin/index.php


Informacion de servicios
	Java 11
	Spring boot
	JPA
	Maven
Url de suagger
http://localhost:5000/swagger-ui.html#

Url de api.docs
http://localhost:5000/v2/api-docs

Url de servicios
localhost:5000/empleado

api-key para servicios
este api-key solo es para ocuparloen sel servicio de obtener todos los empleados

api-Key-invex:
	ee7b7a22-1153-49cb-9aa7-fc80aad23495

Servicios Empleado
GET
/empleado
getEmpleados

POST
/empleado
createdEmpleado

DELETE
/empleado
deleteAllEmpleado

PATCH
/empleado
updateAllEmpleado

GET
/empleado/id/{empleadoId}
getEmpleadoById

DELETE
/empleado/id/{empleadoId}
deleteEmpleado

PATCH
/empleado/id/{empleadoId}
updateEmpleado

Servicios Bitacora 
GET
/bitacora
getBitacoras