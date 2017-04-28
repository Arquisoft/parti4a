Feature: El usuario debe poder iniciar sesion en la aplicacion 

Scenario: Iniciar sesion
	
	Given dada esta lista de usuarios:
	|	name	|	password	|
	|	pelayo@gmail.com	|		temporal	|
	|	pedro@gmail.com	|	temporal	|
	
	When introduzo pelayo@gmail.com y la contraseña temporal
	Then debo iniciar sesion