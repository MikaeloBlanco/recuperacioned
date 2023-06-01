package com.cpfifp.grijander.parkingfinal.ticket.domain;

import java.util.Date;

import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;

public class Ticket {

    private final Vehiculo vehiculo;
    private final Date fechaEntrada;
    private Date fechaSalida;
    private boolean finalizado;

    public Ticket(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = new Date();
        this.fechaSalida = null;
        this.finalizado = false;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaSalida() {
        if (!finalizado) {
            this.fechaSalida = new Date();
            this.finalizado = true;
        }
    }

}
