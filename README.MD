# Proyecto Recuperación ED DAM Tarde
## Introducción
El presente repositorio contiene una aplicación desarrollada en Java para la realización de la recuperación.
Se ha desarrollado una aplicación en Spring SIN base de datos que simula el funcionamiento de un parking de pago. 
La recuperación consistira en el diseño e implementación de pruebas unitarias, de comportamiento y documentación 
## Documentación
Haciendo uso de Javadoc añade documentacion para cada uno de los métodos de la aplicación
## Pruebas Unitarias
Haciendo uso de JUnity  Mockito debes probar los métodos de las siguientes clases: 
- Ticket
- Vehiculo
- VehiculoDao
- ParkingServiceImpl
- Repository
- TicketController (debes usar MockMvc)
- VehiculoController (debes usar MockMvc)

## Pruebas de Integración
Haciendo uso de Cucumber y Mockito debes diseñar e implemetar las siguientes pruebas de integración
- Navegar desde el indice a Vehiculos
- Navegar desde Vehiculos a Aparcar Vehiculo
- Navegar desde Tickets a Detalles de Ticket
- Comprobar que la pantalla de Vehiculos tiene los elementos: elemento de titulo, boton de aparcar y tabla de vehiculos
- Comprobar que  la pantalla de Tickets tienen los elementos: elemento de titulo y tabla
- Comprobar que el formulario de aparcar tienen los elementos requeridos: input para matricula y boton de aparcar
- Comprobar que la vista de detalles muestra en el h1 la matricula del vehiculo
- Comprobar que se puede aparcar un vehiculo si el parking no esta lleno y el vehiculo no esta ya aparcado
- Comprobar que NO se puede aparcar un vehiculo si el parking esta lleno
- Comprobar que NO se puede aparcar un vehiculo si ya estaba aparcado

## Entregas
URL al repositorio de GitHub PRIVADO (debes añadirme como colaborador) con las pruebas implementadas.
Report de JaCoCo con la cobertura de código alcanzada
Report de Cucumber con los escenarios ejecutados

