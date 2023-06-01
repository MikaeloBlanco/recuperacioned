package com.cpfifp.grijander.parkingfinal.ticket.adapter;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;
import com.cpfifp.grijander.parkingfinal.core.service.ParkingService;
import com.cpfifp.grijander.parkingfinal.ticket.domain.*;

@Controller
public class TicketController {
    
    private ParkingService service;
    public TicketController(ParkingService service) {
        this.service = service;
    }
    @GetMapping("/tickets")
    public String mostrarTickets(final Model model) {
        model.addAttribute("vehiculos", this.service.obtenerVehiculosFinalizados());
        return "ticket/lista";
    }
    @GetMapping("/detallesTicket")
    public String mostrarDetalels(@RequestParam final String matricula,final Model model){
        List<Ticket> f = this.service.obtenerTicketsFinalizados(matricula);
        model.addAttribute("vehiculo", new Vehiculo(matricula));
        model.addAttribute("tickets",f );
        return "ticket/detalle";
    }
}
