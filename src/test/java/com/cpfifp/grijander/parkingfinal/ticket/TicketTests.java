package com.cpfifp.grijander.parkingfinal.ticket;

import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Miguel Blanco Fernández
 * @since 17/06/2023
 * Tests Unitarios de los programas dentro de la Carpeta Ticket
 */
public class TicketTests {
    /**
     * @author Miguel Blanco Fernández
     * Apartados de creación de variables de uso de los Tests
     */
    private Ticket ticket;
    private Vehiculo vehiculo;
    @BeforeEach
    public void init(){
        vehiculo = new Vehiculo("0493 UCS");
        ticket = new Ticket(vehiculo);
    }
    /**
     * @author Miguel blanco Fernández
     * Test de obtención de fecha de salida previa a la salida de un vehiculo
     */
    @Test
    void testGetFechaSalida(){
        Date expected = ticket.getFechaSalida();
        Date actual = null;

        assertEquals(expected,actual);
    }

    @Test
    /**
     * @author Miguel Blanco Fernández
     * Test de obtención de fecha de entrada del ticket creado a partir de un vehiculo
     */
    void testGetFechaEntrada(){
        Date expected = ticket.getFechaEntrada();
        Date actual = ticket.getFechaEntrada();

        assertEquals(expected,actual);
    }
    /**
     * @author Miguel Blanco Fernández
     * Test de obtención de un vehiculo el cual se le ha asignado un ticket
     */
    @Test
    void testGetVehiculo(){
        Vehiculo expected = ticket.getVehiculo();
        Vehiculo actual = vehiculo;

        assertEquals(expected,actual);
    }
    /**
     * @author Miguel blanco Fernández
     * Test de establecimiento de una fecha de salida de un vehiculo a través del ticket
     */
    @Test
    void testSetFechaSalida(){
        ticket.setFechaSalida();
        Date expected = ticket.getFechaSalida();
        Date actual = ticket.getFechaSalida();

        assertEquals(expected,actual);
    }

}
