package com.cpfifp.grijander.parkingfinal.core.service;

import java.util.List;

import com.cpfifp.grijander.parkingfinal.core.exception.NoHayEspacioException;
import com.cpfifp.grijander.parkingfinal.core.exception.VehiculoNoAparcadoException;
import com.cpfifp.grijander.parkingfinal.core.exception.VehiculoYaAparcadoException;
import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.VehiculoDao;

public interface ParkingService {
    void aparcarVehiculo(String string) throws VehiculoYaAparcadoException, NoHayEspacioException ;
    void aparcarVehiculo(VehiculoDao vehiculo) throws VehiculoYaAparcadoException, NoHayEspacioException ;
    Ticket sacarVehiculo(Vehiculo vehiculo) throws VehiculoNoAparcadoException;
    Ticket sacarVehiculo(String matricula) throws VehiculoNoAparcadoException;
    List<Ticket> obtenerAparcados();
    List<Vehiculo> obtenerVehiculosFinalizados();
    List<Ticket> obtenerTicketsFinalizados(String matricula);
}
