Feature: Ser capaz de comentar una sugerencia
		Como ciudadano registrado
		quiero ser capaz de comentar con mi opinion
		una sugerencia
		
Scenario: Comentar sugerencia

	Given Debe haber una sugerencia que comentar
	And he iniciado sesion en la aplicacion
	When creo un comentario
	Then la sugerencia debe tener mi comentario