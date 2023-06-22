# language: es
Característica: Pruebas

    Escenario: navegación hasta Vehiculos
        Dado un usuario esta en la pagina de inicio
        Cuando clica el enlace con el nombre Vehiculos en la barra de navegación
        Entonces el usuario se encuentra en la pagina de vehiculos

    Escenario: navegación de Vehiculos a aparcar
        Dado un usuario esta en la pagina de vehiculos
        Cuando clica el boton de aparcar un vehiculo
        Entonces el usuario se encuentra en la pagina de aparcar

    Escenario: comprobación de elementos
        Dado un usuario esta en la pagina de vehiculos
        Entonces se muestra el campo titulo
        Y se muestra el campo tabla 
        Y se muestra el boton de aparcar

    Escenario: comprobacion elementos de aparcar
        Dado un usuario esta en la pagina de vehiculos
        Entonces se muestra el boton de aparcar
        Y se muestra el input de matricula


