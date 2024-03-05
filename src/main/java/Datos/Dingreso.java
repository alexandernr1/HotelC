package Datos;

import java.sql.Date;

/**
 *
 * @author Alexander Nieves
 */
public class Dingreso {

    public int idingreso;
    public int idcliente;
    public int idhabitacion;
    public int idempleado;
    public Date fechaingreso;
    public String personas;
    public String tipo;
    public Double costoalojamiento;
    public String motivo_viaje;

    public Dingreso() {
    }

    public Dingreso(int idingreso, int idcliente, int idhabitacion, int idempleado, String personas, String tipo, Double costoalojamiento, String motivo_viaje, Date fechaingreso) {
        this.idingreso = idingreso;
        this.idcliente = idcliente;
        this.idhabitacion = idhabitacion;
        this.idempleado = idempleado;
        this.personas = personas;
        this.tipo = tipo;
        this.costoalojamiento = costoalojamiento;
        this.motivo_viaje = motivo_viaje;
        this.fechaingreso = fechaingreso;
    }

    public int getIdingreso() {
        return idingreso;
    }

    public void setIdingreso(int idingreso) {
        this.idingreso = idingreso;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCostoalojamiento() {
        return costoalojamiento;
    }

    public void setCostoalojamiento(Double costoalojamiento) {
        this.costoalojamiento = costoalojamiento;
    }

    public String getMotivo_viaje() {
        return motivo_viaje;
    }

    public void setMotivo_viaje(String motivo_viaje) {
        this.motivo_viaje = motivo_viaje;
    }

    

}
