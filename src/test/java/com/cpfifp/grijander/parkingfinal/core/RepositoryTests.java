package com.cpfifp.grijander.parkingfinal.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cpfifp.grijander.parkingfinal.core.service.ParkingService;
import com.cpfifp.grijander.parkingfinal.core.service.ParkingServiceImpl;
import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.VehiculoDao;
/**
 * @author Miguel blanco Fernández
 * @since 22/06/2023
 * Tests del repositorio
 */
public class RepositoryTests {
    /**
     * Variables de tests creadas antes de la inicialización
     */
    private Repository mockedRepository;
    private VehiculoDao vehiculo;
    private Vehiculo vehiculo2;
    private Ticket ticket;
    @BeforeEach
    public void init(){
        mockedRepository = mock(Repository.class);
        vehiculo = new VehiculoDao("3423JFC");
        vehiculo2 = new Vehiculo("5502KLD");
        ticket = new Ticket(vehiculo2);
    }
    /**
     * Test de obtención de tickets
     */
    @Test
    void testGetAllTicket() {
        mockedRepository.añadirTicketPasado(ticket);
        List<Ticket> expected = new ArrayList<>();
        expected.addAll(mockedRepository.getAllTicket(vehiculo2.getMatricula()));
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        List<Ticket> actual = service.obtenerTicketsFinalizados(vehiculo2.getMatricula());
        assertEquals(expected,actual);
    }
    /**
     * Test de obtención de tickets expirados
     */
    @Test
    void testGetAllTicketsPasados() {
        when(mockedRepository.tieneEspacio()).thenReturn(true);
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        service.aparcarVehiculo(vehiculo);
        List<Ticket> expected = new ArrayList<>();
        expected.addAll(mockedRepository.getTicketsPasados("0000AAA"));
        List<Ticket> actual = service.obtenerTicketsFinalizados("0000AAA");
        assertEquals(expected,actual);
    }

    @Test
    void testGetTicketsPasados() {

    }

    @Test
    void testSacarVehiculo() {

    }
}
