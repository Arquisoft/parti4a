Feature: Ser capaz de comentar una sugerencia
		Como ciudadano registrado
		quiero ser capaz de comentar con mi opinion
		una sugerencia
		
Scenario: Comentar sugerencia
	Given Inicio sesion en la aplicacion
	And Debe haber una sugerencia que comentar
	When creo un comentario
	Then la sugerencia debe tener mi comentario