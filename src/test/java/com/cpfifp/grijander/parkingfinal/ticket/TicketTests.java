package com.cpfifp.grijander.parkingfinal.ticket;

import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketTests {
    
    private Ticket ticket;
    private Vehiculo vehiculo;
    @BeforeEach
    public void init(){
        vehiculo = new Vehiculo("0493 UCS");
        ticket = new Ticket(vehiculo);
    }

    

}
