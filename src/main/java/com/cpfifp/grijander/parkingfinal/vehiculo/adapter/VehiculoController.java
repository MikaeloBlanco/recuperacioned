package com.cpfifp.grijander.parkingfinal.vehiculo.adapter;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpfifp.core.exception.NoHayEspacioException;
import com.cpfifp.core.exception.VehiculoYaAparcadoException;
import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.ticket.service.TicketService;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.VehiculoDao;

import jakarta.validation.Valid;

@Controller
public class VehiculoController {
    private final TicketService service;

    public VehiculoController(final TicketService service) {
        this.service = service;
    }

    @GetMapping("/vehiculos")
    public String mostrarVehiculosAparcados(final Model model) {
        final List<Ticket> aparcados = service.obtenerAparcados();
        model.addAttribute("aparcados", aparcados);
        return "vehiculo/lista";
    }

    @GetMapping("/aparcar")
    public String mostrarFormularioAparcado(final Model model) {
        model.addAttribute("vehiculoDao", new VehiculoDao());
        return "vehiculo/aparcar";
    }

    @PostMapping("/aparcar")
    public String aparcarVehiculo(@Valid @ModelAttribute final VehiculoDao vehiculoDao,
            final BindingResult bindingResult, final Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDao", vehiculoDao);
            return "vehiculo/aparcar";
        }
        try {
            this.service.aparcarVehiculo(vehiculoDao);
        } catch (NoHayEspacioException ex) {
            model.addAttribute("vehiculoDao", vehiculoDao);
            bindingResult.reject("espace", "No hay espacio disponible");
            return "vehiculo/aparcar";
        } catch (VehiculoYaAparcadoException ex) {
            model.addAttribute("vehiculoDao", vehiculoDao);
            bindingResult.reject("plate", "Ya existe un vehiculo aparcado con esta matrícula");
            return "vehiculo/aparcar";
        }
        return "redirect:/vehiculos";
    }

    @GetMapping("/sacarVehiculo")
    public String sacarVehiculo(@RequestParam final String matricula){
        this.service.sacarVehiculo(matricula);
        return "redirect:/vehiculos";

    }
}
