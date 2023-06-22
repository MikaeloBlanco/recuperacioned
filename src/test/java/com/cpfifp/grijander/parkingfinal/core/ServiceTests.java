package com.cpfifp.grijander.parkingfinal.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cpfifp.grijander.parkingfinal.core.exception.NoHayEspacioException;
import com.cpfifp.grijander.parkingfinal.core.exception.VehiculoNoAparcadoException;
import com.cpfifp.grijander.parkingfinal.core.exception.VehiculoYaAparcadoException;
import com.cpfifp.grijander.parkingfinal.core.service.ParkingService;
import com.cpfifp.grijander.parkingfinal.core.service.ParkingServiceImpl;
import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.VehiculoDao;
/**
 * @author Miguel Blanco Fernández
 * @since 21/06/2023
 * Tests de la carpeta service Y tests del programa Repository.java
 */
public class ServiceTests {
    private Vehiculo vehiculo;
    private Vehiculo vehiculo2;
    private Vehiculo vehiculo3;
    private VehiculoDao vehiculo4;
    private Ticket ticket;
    private Repository mockedRepository;
    @BeforeEach
    public void init(){
        vehiculo = new Vehiculo("0000 AAA");
        vehiculo2 = new Vehiculo("1111 BBB"); 
        vehiculo3 = new Vehiculo("2222 CCC");
        vehiculo4 = new VehiculoDao("3333 DDD");
        ticket = new Ticket(vehiculo3);
        mockedRepository = mock(Repository.class);
    }

    /**
     * 
     */
    @Test
    void testAparcarVehiculo() {
        /*ParkingService service = new ParkingServiceImpl(mockedRepository);
        service.aparcarVehiculo(vehiculo4);
        Vehiculo vehiculoProvisional = new Vehiculo(vehiculo4.getMatricula());
        mockedRepository.añadirVehiculoActivo(vehiculoProvisional);
        Ticket ticket = new Ticket(vehiculoProvisional);
        vehiculoProvisional.setTicketActivo(ticket);
        verify(mockedRepository.estaAparcado(vehiculoProvisional));*/
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        when(mockedRepository.tieneEspacio()).thenReturn(true);
        when(mockedRepository.estaAparcado(any(Vehiculo.class))).thenReturn(false);

        service.aparcarVehiculo("1234ABC");
        Mockito.verify(mockedRepository).añadirVehiculoActivo(new Vehiculo("1234ABC"));


        
    }

    @Test
    void testVehiculoAparcado() {
        mockedRepository = new Repository(2);
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        try{
            service.aparcarVehiculo(vehiculo3.getMatricula());
        } catch (VehiculoYaAparcadoException exception){
            fail();
        } catch(NoHayEspacioException exception){
            fail();
        }
        mockedRepository.añadirVehiculoActivo(vehiculo3);
    }

    @Test
    void testVehiculoYaAparcado(){
        mockedRepository = new Repository(2);
        mockedRepository.añadirVehiculoActivo(vehiculo2);
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        assertThrows(VehiculoYaAparcadoException.class,
            () -> {
                service.aparcarVehiculo(vehiculo2.getMatricula());
            }
        );
    }

    @Test
    void testNoExisteEspacio(){
        mockedRepository = new Repository(0);
        mockedRepository.añadirVehiculoActivo(vehiculo2);
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        assertThrows(NoHayEspacioException.class,
            () -> {
                service.aparcarVehiculo(vehiculo2.getMatricula());
            }
        );
    }

    @Test
    void testObtenerAparcados() {
        final List<Ticket> expected = new ArrayList<>();
        expected.addAll(mockedRepository.getTicketActivos());
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        final List<Ticket> actual = service.obtenerAparcados();
        assertEquals(expected,actual);
    }

    @Test
    void testObtenerTicketsFinalizados() {
        mockedRepository.añadirTicketPasado(ticket);
        final List<Ticket> expected = new ArrayList<>();
        expected.addAll(mockedRepository.getTicketsPasados(vehiculo3.getMatricula()));
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        final List<Ticket> actual = service.obtenerTicketsFinalizados(vehiculo3.getMatricula());
        assertEquals(expected,actual);
    }

    @Test
    void testObtenerVehiculosFinalizados() {
        mockedRepository.añadirTicketPasado(ticket);
        final List<Vehiculo> expected = new ArrayList<>();
        expected.addAll(mockedRepository.getVehiculosPasados());
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        final List<Vehiculo> actual = service.obtenerVehiculosFinalizados();
        assertEquals(expected,actual);
    }

    @Test
    void testSacarVehiculo() {
        mockedRepository = new Repository(2);
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        service.aparcarVehiculo(vehiculo4);
        Vehiculo vehiculoProvisional = new Vehiculo(vehiculo4.getMatricula());
        try{
            service.sacarVehiculo(vehiculoProvisional);
        } catch(VehiculoNoAparcadoException exception){
            fail();
        }
    }

    @Test
    void testVehiculoNoAparcado(){
        ParkingService service = new ParkingServiceImpl(mockedRepository);
        assertThrows(VehiculoNoAparcadoException.class,
            () -> {
                service.sacarVehiculo(vehiculo);
            }
        );
    }
}
