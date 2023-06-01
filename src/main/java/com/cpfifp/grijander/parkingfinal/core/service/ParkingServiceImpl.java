package com.cpfifp.grijander.parkingfinal.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cpfifp.grijander.parkingfinal.core.Repository;
import com.cpfifp.grijander.parkingfinal.core.exception.NoHayEspacioException;
import com.cpfifp.grijander.parkingfinal.core.exception.VehiculoNoAparcadoException;
import com.cpfifp.grijander.parkingfinal.core.exception.VehiculoYaAparcadoException;
import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.VehiculoDao;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final Repository repositorio;


    public ParkingServiceImpl(Repository repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public void aparcarVehiculo(String matricula) throws VehiculoYaAparcadoException, NoHayEspacioException {
        aparcarVehiculo(new VehiculoDao(matricula));
    }

    @Override
    public void aparcarVehiculo(VehiculoDao vehiculoDao) throws VehiculoYaAparcadoException, NoHayEspacioException {
        Vehiculo vehiculo = new Vehiculo(vehiculoDao.getMatricula());
        if (!repositorio.tieneEspacio()) {
            throw new NoHayEspacioException();

        }
        if (repositorio.estaAparcado(vehiculo)) {
            throw new VehiculoYaAparcadoException();
        }
        Ticket ticket = new Ticket(vehiculo);
        vehiculo.setTicketActivo(ticket);
        repositorio.añadirVehiculoActivo(vehiculo);
    }

    @Override
    public Ticket sacarVehiculo(Vehiculo vehiculo) throws VehiculoNoAparcadoException {
        Ticket ticket = null; 
        Vehiculo v = null;
        if (!this.repositorio.estaAparcado(vehiculo)) {
            throw new VehiculoNoAparcadoException();
        }
 
        v = repositorio.sacarVehiculo(vehiculo);
        if (v != null) {
            ticket = v.getTicketActivo();
            ticket.setFechaSalida();
            this.repositorio.añadirTicketPasado(ticket);
            return ticket;
        }
        
        return null;
        


    }
    @Override
    public Ticket sacarVehiculo(String matricula) throws VehiculoNoAparcadoException {

        return this.sacarVehiculo(new Vehiculo(matricula));
    }
    
    





    @Override
    public List<Ticket> obtenerAparcados() {
        return this.repositorio.getTicketActivos();
    }


    @Override
    public List<Vehiculo> obtenerVehiculosFinalizados() {
        return this.repositorio.getVehiculosPasados();
    }


    @Override
    public List<Ticket> obtenerTicketsFinalizados(String matricula) {
        return this.repositorio.getTicketsPasados(matricula);
    }



}
