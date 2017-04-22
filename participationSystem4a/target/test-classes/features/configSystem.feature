Feature: Como usuario administrador del sistema
	quiero poder añadir palabras prohibidas al sistema
	
Scenario: Añadir palabras prohibidas
	
	Given Inicio sesion
	And Soy un usuario administrador
	When Añado una palabrea prohida
	Then No se puede volver a utilizar esa palabra. 