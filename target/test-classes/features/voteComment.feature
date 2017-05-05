Feature: Ser capaz de votar un comentario de una sugerencia
		siendo un ciudadano registrado en la aplicacion. 
		
Scenario: Votar el comentario de una sugerencia

	Given Soy un usuario registrado
	And Existe al menos una sugerencia
	And Esa sugerencia tiene al menos un comentario
	When Voto positiva o negativamente mi voto
	Then S contabiliza el voto
	But No se sabe lo que he votado