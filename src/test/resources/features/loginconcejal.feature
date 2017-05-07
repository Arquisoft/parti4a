Feature: El concejal debe poder iniciar sesion en la aplicacion 

Scenario: Iniciar sesion concejal
	
	Given dado los datos del concejal:
	|	name	|	password	|
	|	concejal@gmail.com	|		temporal	|
	
	When introduzo concejal@gmail.com y la contraseña temporal
	Then debo iniciar sesion del concejal