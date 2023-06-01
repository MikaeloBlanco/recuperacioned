package com.cpfifp.grijander.parkingfinal.vehiculo.domain;

import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;

/**
 * Clase que representa un vehiculo
 * @author David Hormigo Ramírez
 */
public class Vehiculo {
    
    private String matricula;
    private boolean changed;
    private Ticket ticketActivo;

    public Vehiculo(String matricula,Ticket ticketActivo) {
        this.matricula = matricula;
        this.ticketActivo = ticketActivo;
        this.changed = true; 
    }
    public Vehiculo(String matricula) {
        this(matricula,null);
        this.changed = true;
    }
    public Vehiculo() {
        this("",null);
        this.changed = false;
     
    }
    public Ticket getTicketActivo() {
        return ticketActivo;
    }
    public void setTicketActivo(Ticket ticketActivo) {
        this.ticketActivo = ticketActivo;
    }


    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        if(!changed){
            this.matricula = matricula;
            this.changed = true;
        }
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }


}
