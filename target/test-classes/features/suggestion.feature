Feature: Ser capaz de crear una sugerencia
		Como ciudadano registrado
		quiero ser capaz de crear una sugerencia
		
Scenario: Hacer una sugerencia

	Given Inicio sesion en la aplicacion
	And Existe al menos una categoria en la que puedo meter mi sugerencia
	When Creo la sugerencia
	Then El sistema debe tener mi sugerencia