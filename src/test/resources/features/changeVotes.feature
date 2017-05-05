Feature: Ser capaz de cambiar el numero de votos minimo
  Como administrador
  quiero ser capaz de cambiar el numero de apoyos minimo para que una
  propuesta pase a fase de votación

  Scenario: Cambiar votos minimos

    Given Debe haber una configuracion
    And he iniciado sesion en la aplicacion como administrador
    When cambio el numero minimo de votos
    Then se debe mostrar el cambio