package com.cpfifp.grijander.parkingfinal.ticket.domain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;

public class Repository {

    private final Map<Vehiculo,List<Ticket>> pasados;
    private final List<Vehiculo> activos;
    private final int capacidad;

    public Repository(int capacidad) {
        this.pasados = new HashMap<>(capacidad);
        this.activos = new ArrayList<>();
        this.capacidad = capacidad;
    }

    
    public Map<Vehiculo,List<Ticket>> getAllTicketsPasados() {
        return pasados;
    }

    public void añadirTicketPasado(Ticket ticket) {
        Vehiculo v = ticket.getVehiculo();
        if (this.pasados.containsKey(v)) {
            this.pasados.get(v).add(ticket);
        }
        else{
            List<Ticket> t = new ArrayList<>();
            t.add(ticket);
            this.pasados.put(v,t);
        }
    }
    public void añadirVehiculoActivo(Vehiculo vehiculo){

        this.activos.add(vehiculo);
     
    }

    public Vehiculo sacarVehiculo(Vehiculo vehiculo){
        Vehiculo v = this.activos.get(this.activos.indexOf(vehiculo));
        this.activos.remove(v);
        return v;
    } 
    

    public boolean estaAparcado(Vehiculo vehiculo){
        return this.activos.contains(vehiculo);
    }

    public boolean estaAparcado(String matricula) {
        return estaAparcado(new Vehiculo(matricula));
    }

    public boolean tieneEspacio() {
        
        return this.activos.size() < capacidad;
    }

    public List<Ticket> getAllTickets(Vehiculo vehiculo) {
        return this.pasados.get(vehiculo);
    }

    public List<Ticket> getAllTicket(String matricula) {
        return this.getAllTickets(new Vehiculo(matricula));
    }

    public List<Ticket> getTicketActivos() {
        List<Ticket> activos = new ArrayList<>();
        for (Vehiculo v:this.activos){
            activos.add(v.getTicketActivo());
        }
        return activos;
    }

    public List<Vehiculo> getVehiculosPasados() {
        List<Vehiculo> v = new ArrayList<>();
        v.addAll(this.pasados.keySet());
        return v;
    }
    public List<Ticket> getTicketsPasados(String matricula) {
        Vehiculo v = new Vehiculo(matricula);
        if (this.pasados.containsKey(v)){
            return this.pasados.get(v);
        }
        return null;
    }
    
}
