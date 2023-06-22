# language: es
Característica: Pruebas
  
  Escenario: navegación a detalles
    Dado un usuario esta en la pagina de tickets
    Cuando clica el boton de detalles
    Entonces el usuario se encuentra en la pagina de detalles de tickets 

    Escenario: comprobación de elementos
      Dado un usuario esta en la pagina de tickets
      Entonces se muestra el campo tabla
      Y se muestra el campo titulo