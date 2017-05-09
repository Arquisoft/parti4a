Feature: Ser capaz de cambiar el numero de votos minimo
  Como administrador
  quiero ser capaz de cambiar el numero de apoyos minimo para que una
  propuesta pase a fase de votación

  Scenario: Cambiar votos minimos

    Given Estoy en sesion admin
    When cambio el numero minimo de votos
    Then se debe mostrar el cambio