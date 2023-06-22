package com.cpfifp.grijander.parkingfinal.vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.VehiculoDao;
/**
 * @author Miguel blanco Fernández
 * @since 17/06/2023
 * Tests de Vehiculo de la carpeta Vehiculo
 */
public class VehiculoTests {
    
    private Vehiculo vehiculo1;
    private Vehiculo vehiculo2;
    private Ticket ticket;
    private Vehiculo vehiculo3;
    private VehiculoDao vehiculoDao;
    @BeforeEach
    public void init(){
        vehiculo1 = new Vehiculo("0346 UXC");
        vehiculo2 = new Vehiculo();
        ticket = new Ticket(vehiculo1);
        vehiculo3 = new Vehiculo("0346 UXC", ticket);
        vehiculoDao = new VehiculoDao();
    }

    @Test
    void testGetTicketActivo(){
        Ticket expected = vehiculo3.getTicketActivo();
        Ticket actual = ticket;

        assertEquals( expected,actual);
    }

    @Test
    void testSetTicketActivo(){
        vehiculo2.setTicketActivo(ticket);
        Ticket expected = vehiculo2.getTicketActivo();
        Ticket actual = ticket;

        assertEquals(expected, actual);
    }

    @Test
    void testGetMatricula(){
        String expected = vehiculo1.getMatricula();
        String actual = "0346 UXC";

        assertEquals(expected,actual);
    }

    @Test
    void testSetMatricula(){
        vehiculo2.setMatricula("0241 PME");
        String expected = vehiculo2.getMatricula();
        String actual = "0241 PME";

        assertEquals(expected,actual);
    }

    @Test
    void testSetMatriculaVD(){
        vehiculoDao.setMatricula("3472 HJC");
        String expected = vehiculoDao.getMatricula();
        String actual = "3472 HJC";

        assertEquals(expected,actual);
    }

    @Test
    void testGetMatriculaVD(){
        String expected = vehiculoDao.getMatricula();
        String actual = "";

        assertEquals(expected,actual);
    }
}
